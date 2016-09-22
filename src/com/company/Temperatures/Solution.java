package com.company.Temperatures;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int temperatureCount = in.nextInt();
        in.nextLine();

        // the n temperatures expressed as integers ranging from -273 to 5526
        System.out.println("" + (temperatureCount == 0 ? 0 : Arrays.stream(in.nextLine().split(" "))
            .map(Integer::parseInt)
            .reduce((left, right) -> {
                if (Math.abs(left) < Math.abs(right)) {
                    return left;
                } else if (Math.abs(left) > Math.abs(right)) {
                    return right;
                } else {
                    return (left > right) ? left : right;
                }
            })
            .orElse(0)));
    }
}