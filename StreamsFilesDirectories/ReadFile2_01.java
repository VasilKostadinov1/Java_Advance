package StreamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile2_01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        String path2 = "C:\\Users\\Vasil\\Desktop\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path2);

        Scanner sc = new Scanner(inputStream);    // 0/100

        String line = sc.nextLine();
        while (sc.hasNextLine()){
            System.out.println(line);
            line = sc.nextLine();
        }
    }
}
