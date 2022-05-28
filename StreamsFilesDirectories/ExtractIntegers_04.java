package StreamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Vasil\\Desktop\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathIn = "C:\\Users\\Vasil\\Documents\\Advance\\input.txt";
        FileInputStream inputStream = new FileInputStream(pathIn);

        // Wrap a FileInputStream in a Scanner and use the methods, hasNext(), hasNextInt() and nextInt().
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.println(number);
            }
            scanner.next();
        }
        inputStream.close();
    }
}
