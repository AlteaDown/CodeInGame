package com.company.AsciiArt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Solution {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int charWidth = in.nextInt();
        int charHeight = in.nextInt();
        in.nextLine();
        String stringToPrint = in.nextLine().toLowerCase();

        HashMap<Character, ArrayList<String>> characterMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            characterMap.put(c, new ArrayList<>());
        }
        characterMap.put('?', new ArrayList<>());

        for (int i = 0; i < charHeight; i++) {
            String row = in.nextLine().toLowerCase();
            for (char c = 'a'; c <= 'z'; c++) {
                characterMap.get(c).add(row.substring((c - 'a') * charWidth, (c - 'a') * charWidth + charWidth));
            }
            characterMap.get('?').add(row.substring(('z' - 'a' + 1) * charWidth, ('z' - 'a' + 1) * charWidth + charWidth));
        }

        for (int i = 0; i < charHeight; i++) {
            for (int j = 0; j < stringToPrint.length(); j++) {
                ArrayList<String> characterRow = characterMap.get(stringToPrint.charAt(j));
                if (characterRow == null) {
                    characterRow = characterMap.get('?');
                }
                System.out.print(characterRow.get(i));
            }
            System.out.println();
        }
    }
}