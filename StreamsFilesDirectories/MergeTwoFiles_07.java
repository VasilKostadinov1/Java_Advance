package StreamsFilesAndDirectories_Exercises;

import java.io.*;
import java.util.Scanner;

public class MergeTwoFiles_07 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader reader = new BufferedReader( new FileReader(
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        PrintStream printer = new PrintStream(
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\outputOne.txt");

        String line;
        while ((line = reader.readLine()) != null) {
            printer.println(line);
        }
        reader = new BufferedReader(new FileReader(
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
        while ((line = reader.readLine()) != null) {
            printer.println(line);
        }
    }
}
