package StreamsFilesAndDirectories_Exercises;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //finds the count of vowels, consonants, and punctuation marks.

        String pathIN =
                "C:\\Users\\Vasil\\Documents\\Advance\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(pathIN);

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Character> punctuations = Arrays.asList('!', ',', '.', '?');

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        int byteData = fileInputStream.read();

        while (byteData >= 0) {
            if ((char) byteData == ' ' || (char) byteData == '\n' || (char) byteData == '\r') {
                byteData = fileInputStream.read();
                continue;
            }
            if (vowels.contains((char) byteData)) {
                vowelsCount++;
            } else if (punctuations.contains((char) byteData)) {
                punctuationCount++;
            } else {
                consonantsCount++;
            }
            byteData = fileInputStream.read();
        }
        System.out.printf("Vowels: %s%n", vowelsCount);
        System.out.printf("Consonants: %s%n", consonantsCount);
        System.out.printf("Punctuation: %s%n", punctuationCount);
    }
}
