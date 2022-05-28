package StreamsFilesAndDirectories_Lab;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {

        //Scanner scanner = new Scanner(System.in);

        //write to another file all lines whose number is divisible by 3

        String pathIn = "C:\\Users\\Vasil\\Documents\\Advance\\input.txt";
        FileInputStream inputStream = new FileInputStream(pathIn);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = reader.readLine();

        int count = 1;
        while (line != null) {
            if (count % 3 == 0) {
                System.out.println(line);
            }
            line = reader.readLine();
            count++;
        }
    }
}
