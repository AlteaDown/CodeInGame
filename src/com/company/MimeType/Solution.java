package MimeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int mimeTypeCount = in.nextInt(); // Number of elements which make up the association table.
        int fileNameCount = in.nextInt(); // Number fileNameCount of file names to be analyzed.

        HashMap<String, String> mimeTypeMap = new HashMap<>();
        for (int i = 0; i < mimeTypeCount; i++) {
            String extension = in.next().toLowerCase(); // file extension
            String mimeType = in.next(); // MIME type.
            mimeTypeMap.put(extension, mimeType);
        }

        in.nextLine();

        ArrayList<String> fileNameList = new ArrayList<>();
        for (int i = 0; i < fileNameCount; i++) {
            String fileName = in.nextLine(); // One file name per line.
            fileNameList.add(fileName);
        }

        fileNameList.stream()
                .map(fileName -> fileName.contains(".") && fileName.lastIndexOf('.') != fileName.length() ? fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase() : "")
                .forEachOrdered(extension -> {
                    System.out.println(Optional.ofNullable(mimeTypeMap.get(extension)).orElse("UNKNOWN"));
                });
    }
}