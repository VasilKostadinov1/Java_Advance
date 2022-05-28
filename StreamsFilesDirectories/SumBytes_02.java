package StreamsFilesAndDirectories_Exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //and prints on the console the sum of the ASCII symbols of all characters inside the file
        String pathIN = "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathIN));

        String line = bufferedReader.readLine();

        int sum = 0;
        while (line != null) {
            sum += getLineSum(line);

            line = bufferedReader.readLine();
        }
        System.out.println(sum);
    }

    private static Integer getLineSum(String txt) {
        int sum = 0;
        for (int i = 0; i < txt.length(); i++) {
            sum += txt.charAt(i);
        }
        return sum;
    }
}
