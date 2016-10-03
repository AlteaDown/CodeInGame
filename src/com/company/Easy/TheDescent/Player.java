package Easy.TheDescent;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.codingame.com/training/easy/the-descent
 * <p>
 * The Goal
 * Destroy the mountains before your starship collides with one of them. For that, shoot the highest mountain on your path.
 * <p>
 * Rules
 * At the start of each game turn, you are given the height of the 8 mountains from left to right.\
 * By the end of the game turn, you must fire on the highest mountain by outputting its index (from 0 to 7).
 * Firing on a mountain will only destroy part of it, reducing its height. Your ship descends after each pass.
 * <p>
 * Game Input
 * Within an infinite loop, read the heights of the mountains from the standard input and print to the standard output the index of the mountain to shoot.
 * <p>
 * Input for one game turn
 * 8 lines: one integer mountainH per line. Each represents the height of one mountain given in the order of their index (from 0 to 7).
 * <p>
 * Output for one game turn
 * A single line with one integer for the index of which mountain to shoot.
 * <p>
 * Constraints
 * 0 ≤ mountainH ≤ 9
 * Response time per turn ≤ 100ms
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            ArrayList<Integer> mountainList = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                mountainList.add(in.nextInt());
            }
            IntStream.range(0, mountainList.size())
                    .reduce((a, b) -> mountainList.get(a) > mountainList.get(b) ? a : b)
                    .ifPresent(index -> System.out.println(index));
        }
    }
}
