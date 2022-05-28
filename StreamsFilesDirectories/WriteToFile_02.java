package StreamsFilesAndDirectories_Lab;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile_02 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Vasil\\Desktop\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathIn = "C:\\Users\\Vasil\\Documents\\Advance\\input.txt";
        String pathOut = "C:\\Users\\Vasil\\Desktop\\Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        FileInputStream inputStream = new FileInputStream(pathIn);
        FileOutputStream outputStream = new FileOutputStream(pathOut);

        //skipping any punctuation. Skip the following symbols: ",", ".", "!", "?".
        Set<Character> punctuation = Set.of(',', '.', '!', '?');

        int value = inputStream.read();

        while (value != -1) {
            char current = (char) value;

            if (!punctuation.contains(current)) {
                System.out.print(current);
            }
            value = inputStream.read();
        }
        inputStream.close();
    }
}
