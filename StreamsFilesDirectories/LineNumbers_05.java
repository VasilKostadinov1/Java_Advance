package StreamsFilesAndDirectories_Exercises;

import java.io.*;
import java.util.Scanner;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //inserts line numbers in front of each of its lines.
        String pathIN =
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathIN));

        String line = bufferedReader.readLine();
        int lineCounter = 1;

        while (line != null) {
            String text = lineCounter + ". " + line;
            System.out.println(text);
            lineCounter++;
            line = bufferedReader.readLine();
        }
    }
}
