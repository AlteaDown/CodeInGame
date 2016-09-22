package com.company.HorseRacingDuals;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
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