package ThereIsNoSpoon;

import java.util.Scanner;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        char[][] cellList = new char[height][width];
        in.nextLine();
        for (int y = 0; y < height; y++) {
            //System.err.print(in.nextLine());
            cellList[y] = in.nextLine().toCharArray(); // width characters, each either 0 or .
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (cellList[y][x] == '0') {
                    System.out.print(x + " " + y);

                    if (x + 1 == width) {
                        System.out.print(" -1 -1");
                    } else {
                        for (int right = x + 1; right < width; right++) {
                            if (cellList[y][right] == '0') {
                                System.out.print(" " + (right) + " " + y);
                                break;
                            } else if (right + 1 == width) {
                                System.out.print(" -1 -1");
                            }
                        }
                    }

                    if (y + 1 == height) {
                        System.out.print(" -1 -1");
                    } else {
                        for (int bottom = y + 1; bottom < height; bottom++) {
                            if (cellList[bottom][x] == '0') {
                                System.out.print(" " + x + " " + bottom);
                                break;
                            } else if (bottom + 1 == height) {
                                System.out.print(" -1 -1");
                            }
                        }
                    }

                    System.out.println();
                }
            }
        }
    }
}