package Easy.HorseRacingDuals;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.codingame.com/training/easy/horse-racing-duals
 *
 * The Goal
 * Casablanca’s hippodrome is organizing a new type of horse racing: duals. During a dual, only two horses will participate in the race. In order for the race to be interesting, it is necessary to try to select two horses with similar strength.
 * Write a program which, using a given number of strengths, identifies the two closest strengths and shows their difference with an integer (≥ 0).
 *
 * Input
 * Line 1: Number N of horses
 * The N following lines: the strength Pi of each horse. Pi is an integer.
 *
 * Output
 * The difference D between the two closest strengths. D is an integer greater than or equal to 0.
 *
 * Constraints
 * 1 < N  < 100000
 * 0 < Pi ≤ 10000000
 **/
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> horseList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            horseList.add(in.nextInt());
        }

        final int[] difference = {-1};

        horseList.stream()
            .sorted()
            .reduce((left, right) -> {
                if (difference[0] == -1 || difference[0] > (right - left)) {
                    difference[0] = right-left;
                }
                return right;
            });

        System.out.println(difference[0]);
    }
}