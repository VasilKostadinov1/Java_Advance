package StreamsFilesAndDirectories_Exercises;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineNumbers2_05 {
    public static int countRow = 1;
    public static void main(String[] args) throws IOException {

        String pathIN =
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "outputLine.txt";
        PrintWriter writer = new PrintWriter(outputPath);

        Files.readAllLines(Path.of(pathIN))
                .forEach(line ->
                        writer.println(countRow++ + ". " + line));

        writer.close();
    }
}
