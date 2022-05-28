package StreamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Vasil\\Desktop\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathIn = "C:\\Users\\Vasil\\Documents\\Advance\\input.txt";
        FileInputStream inputStream = new FileInputStream(pathIn);

        int value = inputStream.read();

        while (value != -1) {
            if (value != 10 && value != 32) {
                System.out.print(value);
            } else {
                System.out.print((char) value);
            }
            value = inputStream.read();
        }
        inputStream.close();
    }
}
