package StreamsFilesAndDirectories_Lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ListFiles_07 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String pathIN = "C:\\Users\\Vasil\\Desktop\\Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        //FileInputStream inputStream = new FileInputStream(pathIN);

        Files.list(Paths.get(pathIN)).forEach(f -> {
            File file = f.toFile();
            if (file.isFile()) {
                System.out.printf("%s: [%s]%n", file.getName(), file.length());
            }
        });
    }
}
