package Easy.ChuckNorris;

import java.util.Scanner;

/**
 * https://www.codingame.com/training/easy/chuck-norris
 *
 * The Goal
 * Binary with 0 and 1 is good, but binary with only 0, or almost, is even better! Originally, this is a concept designed by Chuck Norris to send so called unary messages.
 * Write a program that takes an incoming message as input and displays as output the message encoded using Chuck Norris’ method.
 *
 * Rules
 * Here is the encoding principle:
 *
 * The input message consists of ASCII characters (7-bit)
 * The encoded output message consists of blocks of 0
 * A block is separated from another block by a space
 * Two consecutive blocks are used to produce a series of same value bits (only 1 or 0 values):
 * - First block: it is always 0 or 00. If it is 0, then the series contains 1, if not, it contains 0
 * - Second block: the number of 0 in this block is the number of bits in the series
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        for (char c : in.nextLine().toCharArray()) {
            String cBinaryString = Integer.toBinaryString((int) c);
            if (cBinaryString.length() != 7) {
                for (int i = 0; i < 7 - cBinaryString.length(); i++) {
                    sb.append("0");
                }
            }
            sb.append(cBinaryString);
        }

        String binary = sb.toString();
        
        for (int firstRunningBitPos = 0; firstRunningBitPos < binary.length(); ) {
            int consecutiveBits = 1;
            if (binary.charAt(firstRunningBitPos) == '0') {
                System.out.print("00 0");
                while (firstRunningBitPos + consecutiveBits < binary.length() && binary.charAt(firstRunningBitPos + consecutiveBits) == '0') {
                    System.out.print("0");
                    consecutiveBits++;
                }
                if (firstRunningBitPos + consecutiveBits < binary.length()) {
                    System.out.print(" ");
                }
            } else {
                System.out.print("0 0");
                while (firstRunningBitPos + consecutiveBits < binary.length() && binary.charAt(firstRunningBitPos + consecutiveBits) == '1') {
                    System.out.print("0");
                    consecutiveBits++;
                }
                if (firstRunningBitPos + consecutiveBits < binary.length()) {
                    System.out.print(" ");
                }
            }
            firstRunningBitPos += consecutiveBits;
        }
    }

}