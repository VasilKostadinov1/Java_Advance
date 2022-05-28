package StreamsFilesAndDirectories_Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class NestedFolders_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pathIN = "C:\\Users\\Vasil\\Desktop\\Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File folder = new File(pathIN);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.addFirst(folder);

        int folderCount = 0;
        while (!queue.isEmpty()) {
            File currentFile = queue.poll();

            if (currentFile.isDirectory()) {
                System.out.println(currentFile.getName());
                queue.addAll(Arrays.asList(Objects.requireNonNull(currentFile.listFiles())));
                folderCount++;
            }
        }
        System.out.printf("%s folders", folderCount);
    }
}
