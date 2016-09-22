

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double longitudeB = Math.toRadians(Double.parseDouble(in.nextLine().replace(',', '.')));
        double latitudeB = Math.toRadians(Double.parseDouble(in.nextLine().replace(',', '.')));
        int N = Integer.parseInt(in.nextLine());
        //in.nextLine();
        String nearestDefibrillator = null;
        double nearestDistance = -1;
        for (int i = 0; i < N; i++) {
            String[] defib = in.nextLine().split(";");
            double latitudeA = Math.toRadians(Double.parseDouble(defib[4].replace(',', '.')));
            double longitudeA = Math.toRadians(Double.parseDouble(defib[5].replace(',', '.')));

            double x = (longitudeB - longitudeA) * Math.cos((latitudeA + latitudeB) / 2);
            double y = latitudeB - latitudeA;
            double distance = Math.sqrt(x*x + y*y) * 6371;
            if (nearestDefibrillator == null || distance < nearestDistance) {
                nearestDefibrillator = defib[1];
                nearestDistance = distance;
            }
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(nearestDefibrillator);
    }
}