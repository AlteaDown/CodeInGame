import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int originalNumber = in.nextInt();
        int lineToDisplay = in.nextInt();

        ArrayList<ArrayList<Integer>> lineList = new ArrayList<>();
        lineList.add(new ArrayList<>(Collections.singleton(originalNumber)));

        String toReturn = "";

        for (int i = 0; i < lineToDisplay - 1; i++) {
            ArrayList<Integer> previousLine = lineList.get(i);
            ArrayList<Integer> currentLine = new ArrayList<>();
            int currentInt = previousLine.get(0);
            int currentIntCount = 0;
            for (int j = 0; j < previousLine.size(); j++) {
                if (currentInt == previousLine.get(j)) {
                    currentIntCount += 1;
                }

                if (j + 1 == previousLine.size()) {
                    currentLine.add(currentIntCount);
                    currentLine.add(currentInt);
                    lineList.add(currentLine);
                } else if (j + 1 != previousLine.size() && previousLine.get(j + 1) != currentInt) {
                    currentLine.add(currentIntCount);
                    currentLine.add(currentInt);
                    currentInt = previousLine.get(j + 1);
                    currentIntCount = 0;
                }
            }
        }

        for (Integer i : lineList.get(lineList.size() - 1)) {
            toReturn += " " + i;
        }

        System.out.println(toReturn.trim());
    }
}