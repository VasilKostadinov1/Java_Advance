package StreamsFilesAndDirectories_Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //String pathWords = "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        //String pathText = "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        Map<String, Integer> map = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String s : words) {
                map.put(s, 0);
            }
        }

        reader = new BufferedReader(new FileReader(
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String s : words) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                }
            }
        }
        reader.close();
        PrintStream printer = new PrintStream(
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt");
        map.forEach((key, value) -> printer.println(key + " - " + value));
        printer.close();
    }
}
