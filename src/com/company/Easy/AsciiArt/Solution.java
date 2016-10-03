package Easy.AsciiArt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.codingame.com/training/easy/ascii-art
 *
 * The Goal
 * In stations and airports you often see this type of screen:
 * Have you ever asked yourself how it might be possible to simulate this display on a good old terminal? We have: with ASCII art!
 *
 * Rules
 * ASCII art allows you to represent forms by using characters. To be precise, in our case, these forms are words. For example, the word "MANHATTAN" could be displayed as follows in ASCII art:
 * # #  #  ### # #  #  ### ###  #  ###
 * ### # # # # # # # #  #   #  # # # #
 * ### ### # # ### ###  #   #  ### # #
 * # # # # # # # # # #  #   #  # # # #
 * # # # # # # # # # #  #   #  # # # #
 *
 * ​Your mission is to write a program that can display a line of text in ASCII art in a style you are given as input.
 *
 * Input
 * Line 1: the width L of a letter represented in ASCII art. All letters are the same width.
 * Line 2: the height H of a letter represented in ASCII art. All letters are the same height.
 * Line 3: The line of text T, composed of N ASCII characters.
 * Following lines: the string of characters ABCDEFGHIJKLMNOPQRSTUVWXYZ? Represented in ASCII art.
 *
 * Output
 * The text T in ASCII art.
 * The characters a to z are shown in ASCII art by their equivalent in upper case.
 * The characters that are not in the intervals [a-z] or [A-Z] will be shown as a question mark in ASCII art.
 *
 * Constraints
 * 0 < L < 30
 * 0 < H < 30
 * 0 < N < 200
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