package StreamsFilesAndDirectories_Exercises;

import java.io.File;

public class GetFolderSize_08 {
    public static void main(String[] args) {

        File file = new File(
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        System.out.println(getDirectorySizeIncludingSubfolders(file));


    }

    private static int getDirectorySizeIncludingSubfolders(File file) {
        int sum = 0;
        File[] files = file.listFiles();
        if (files == null) {
            sum += file.length();
        } else {
            for (File file1 : files) {
                sum += getDirectorySizeIncludingSubfolders(file1);
            }
        }
        return sum;
    }
}
