package StreamsFilesAndDirectories_Exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {

        /*List<String> input = Files.readAllLines(Path.of(
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        input.stream().mapToLong(line -> IntStream.range(0, line.length()).map(line::charAt).sum())
                .forEach(System.out::println);*/

        String pathIN = "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        //prints on the console the sum of the ASCII symbols of each of its lines.
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathIN));

        String line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(getLineSum(line));

            line = bufferedReader.readLine();
        }
    }

    private static Integer getLineSum(String txt) {
        int sum = 0;
        for (int i = 0; i < txt.length(); i++) {
            sum += txt.charAt(i);
        }
        return sum;
    }
}
