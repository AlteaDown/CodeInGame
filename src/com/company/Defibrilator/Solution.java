package Defibrilator;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double latitudeB = Double.parseDouble(in.nextLine().replace(',', '.'));
        double longitudeB = Double.parseDouble(in.nextLine().replace(',', '.'));
        int N = Integer.parseInt(in.nextLine());
        //in.nextLine();
        String nearestDefibrillator = null;
        double nearestDistance = -1;
        for (int i = 0; i < N; i++) {
            String[] defib = in.nextLine().split(";");
            double latitudeA = Double.parseDouble(defib[4].replace(',', '.'));
            double longitudeA = Double.parseDouble(defib[5].replace(',', '.'));

            double x = Math.toRadians(longitudeB - longitudeA) * Math.cos(Math.toRadians(latitudeA + latitudeB) / 2.0);
            double y = Math.toRadians(latitudeB - latitudeA);
            double distance = Math.sqrt(x * x + y * y) * 6371.0;
            if (nearestDefibrillator == null || distance < nearestDistance) {
                nearestDefibrillator = defib[1];
                nearestDistance = distance;
            }
        }

        System.out.println(nearestDefibrillator);
    }
}