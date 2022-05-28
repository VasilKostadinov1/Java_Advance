package StreamsFilesAndDirectories_Exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AllCapitals_03 {
    public static void main(String[] args) throws IOException {

        //changes the casing of all letters to the upper

        String pathIN = "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathIN));

        String line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line.toUpperCase());
            line = bufferedReader.readLine();
        }
    }
}
