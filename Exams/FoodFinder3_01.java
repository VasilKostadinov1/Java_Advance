package EXAMs;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FoodFinder3_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowelsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<String> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consonantsStack::push);

        List<String> wordsToMatch = new ArrayList<>();
        wordsToMatch.add("pear");
        wordsToMatch.add("flour");
        wordsToMatch.add("pork");
        wordsToMatch.add("olive");

        while (!consonantsStack.isEmpty()) {
            char vowel = vowelsQueue.poll().charAt(0);
            char constant = consonantsStack.pop().charAt(0);

            for (int i = 0; i < wordsToMatch.size(); i++) {
                String word = wordsToMatch.get(i);

                for (int j = 0; j < word.length(); j++) {
                    char currentChar = word.charAt(j);

                    if (currentChar == vowel || currentChar == constant) {
                        word = word.replace(currentChar, '-');
                    }
                }
                wordsToMatch.remove(i);
                wordsToMatch.add(i, word);
            }
            vowelsQueue.offer(String.valueOf(vowel));
        }
        List<String> foundWords = new ArrayList<>();
        int count = 0;

        int index = 0;
        for (String word : wordsToMatch) {
            if (Pattern.matches("^[-]+$", word)) {

                if (index == 0) {
                    foundWords.add("pear");
                } else if (index == 1) {
                    foundWords.add("flour");
                } else if (index == 2) {
                    foundWords.add("pork");
                } else if (index == 3) {
                    foundWords.add("olive");
                }
                count++;
            }
            index++;
        }
        System.out.println("Words found: " + count);
        for (String word : foundWords) {
            System.out.println(word);
        }
    }
}
