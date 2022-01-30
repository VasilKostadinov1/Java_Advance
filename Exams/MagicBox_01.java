package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stack::push);

        int itemsWorth = 0;  //collection of claimed items

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int firstItem = queue.peek();
            int secondItem = stack.peek();

            int sum = firstItem + secondItem;
            if (sum % 2 == 0) {        //if sum of their values is an even number
                itemsWorth += sum;    // add the summed item to your collection of claimed items
                queue.poll();         // remove them both
                stack.pop();

            } else {  //Otherwise remove the last item from the second box and add it at the last position in the first box
                queue.offer(secondItem);  // !!! secondItem
                stack.pop();
            }
        }
        String emptyBoxOutput = queue.isEmpty() ? "First magic box is empty." : "Second magic box is empty.";
        System.out.println(emptyBoxOutput);

        String itemsValueOutput = itemsWorth >= 90 ? "Wow, your prey was epic! Value: "
                : "Poor prey... Value: ";
        System.out.println(itemsValueOutput + itemsWorth);


    }
}
