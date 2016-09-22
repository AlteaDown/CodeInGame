package ChuckNorris;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
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