
import java.awt.*;
import java.util.Scanner;

/**
 * https://www.codingame.com/training/medium/shadows-of-the-knight-episode-1
 * <p>
 * The Goal
 * Batman will look for the hostages on a given building by jumping from one window to another using his grapnel gun. Batman's goal is to jump to the window where the hostages are located in order to disarm the bombs. Unfortunately he has a limited number of jumps before the bombs go off...
 * <p>
 * Rules
 * Before each jump, the heat-signature device will provide Batman with the direction of the bombs based on Batman current position:
 * U (Up)
 * UR (Up-Right)
 * R (Right)
 * DR (Down-Right)
 * D (Down)
 * DL (Down-Left)
 * L (Left)
 * UL (Up-Left)
 * <p>
 * Your mission is to program the device so that it indicates the location of the next window Batman should jump to in order to reach the bombs' room as soon as possible.
 * Buildings are represented as a rectangular array of windows, the window in the top left corner of the building is at index (0,0).
 * <p>
 * Note
 * For some tests, the bombs' location may change from one execution to the other: the goal is to help you find the best algorithm in all cases.
 * The tests provided are similar to the validation tests used to compute the final score but remain different.
 * <p>
 * Game Input
 * The program must first read the initialization data from standard input. Then, within an infinite loop, read the device data from the standard input and provide to the standard output the next movement instruction.
 * <p>
 * Initialization input
 * Line 1 : 2 integers W H. The (W, H) couple represents the width and height of the building as a number of windows.
 * Line 2 : 1 integer N, which represents the number of jumps Batman can make before the bombs go off.
 * Line 3 : 2 integers X0 Y0, representing the starting position of Batman.
 * <p>
 * Input for one game turn
 * The direction indicating where the bomb is.
 * <p>
 * Output for one game turn
 * A single line with 2 integers X Y separated by a space character. (X, Y) represents the location of the next window Batman should jump to. X represents the index along the horizontal axis, Y represents the index along the vertical axis. (0,0) is located in the top-left corner of the building.
 * <p>
 * Constraints
 * 1 ≤ W ≤ 10000
 * 1 ≤ H ≤ 10000
 * 2 ≤ N ≤ 100
 * 0 ≤ X, X0 < W
 * 0 ≤ Y, Y0 < H
 * Response time per turn ≤ 150ms
 * Response time per turn ≤ 150ms
 **/
class Player {

    private static Point batmanLocation;
    private static Point topLeft;
    private static Point bottomRight;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        topLeft = new Point(0, 0);
        bottomRight = new Point(in.nextInt() - 1, in.nextInt() - 1);

        int maxTurns = in.nextInt();

        batmanLocation = new Point(in.nextInt(), in.nextInt());

        // game loop
        while (true) {
            runLogic(in);
        }
    }

    private static void runLogic(Scanner in) {
        BombDirection bombDir = BombDirection.getBombDirection(in.next()); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
        setNewBounds(bombDir);

        // the location of the next window Batman should jump to.
        int nextPointX;
        if (topLeft.x == bottomRight.x) {
            nextPointX = topLeft.x;
            System.err.println("x is Equal");
        } else {
            nextPointX = topLeft.x + ((bottomRight.x - topLeft.x) / 2);
            System.err.println("nextPointX:" + nextPointX);
        }
        int nextPointY;
        if (topLeft.y == bottomRight.y) {
            nextPointY = topLeft.y;
            System.err.println("y is Equal");
        } else {
            nextPointY = topLeft.y + ((bottomRight.y - topLeft.y) / 2);
            System.err.println("nextPointY:" + nextPointY);
        }
        batmanLocation.x = nextPointX;
        batmanLocation.y = nextPointY;

        System.out.println(nextPointX + " " + nextPointY);
    }

    private static void setNewBounds(BombDirection bombDir) {
        switch (bombDir) {
            case UP:
                topLeft.x = batmanLocation.x;

                bottomRight.x = batmanLocation.x;
                bottomRight.y = batmanLocation.y - 1;
                break;
            case UP_RIGHT:
                topLeft.x = batmanLocation.x + 1;
                bottomRight.y = batmanLocation.y - 1;
                break;
            case RIGHT:
                topLeft.x = batmanLocation.x + 1;
                topLeft.y = batmanLocation.y;

                bottomRight.y = batmanLocation.y;
                break;
            case DOWN_RIGHT:
                topLeft.x = batmanLocation.x + 1;
                topLeft.y = batmanLocation.y + 1;
                break;
            case DOWN:
                topLeft.x = batmanLocation.x;
                topLeft.y = batmanLocation.y + 1;

                bottomRight.x = batmanLocation.x;
                break;
            case DOWN_LEFT:
                topLeft.y = batmanLocation.y + 1;

                bottomRight.x = batmanLocation.x - 1;
                break;
            case LEFT:
                topLeft.y = batmanLocation.y;

                bottomRight.x = batmanLocation.x - 1;
                bottomRight.y = batmanLocation.y;
                break;
            case UP_LEFT:
                bottomRight.x = batmanLocation.x - 1;
                bottomRight.y = batmanLocation.y - 1;
                break;
        }
    }

    enum BombDirection {
        UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT, UP_LEFT;

        static BombDirection getBombDirection(String direction) {
            switch (direction) {
                case "U":
                    return UP;
                case "UR":
                    return UP_RIGHT;
                case "R":
                    return RIGHT;
                case "DR":
                    return DOWN_RIGHT;
                case "D":
                    return DOWN;
                case "DL":
                    return DOWN_LEFT;
                case "L":
                    return LEFT;
                case "UL":
                    return UP_LEFT;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}