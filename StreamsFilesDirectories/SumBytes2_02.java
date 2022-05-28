package StreamsFilesAndDirectories_Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;

public class SumBytes2_02 {
    private static long sum=0;
    public static void main(String[] args) throws IOException {

        List<String> input = Files.readAllLines(Path.of(
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        input.stream().mapToLong(line -> IntStream.range(0, line.length()).map(line::charAt).sum())
                .forEach(e -> sum += e);

        System.out.println(sum);
    }
}
