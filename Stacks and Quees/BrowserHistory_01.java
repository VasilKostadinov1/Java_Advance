package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nextURL = scanner.nextLine();
        String currentURL = "blank";

        ArrayDeque<String> history = new ArrayDeque<>();

        while (!nextURL.equals("Home")) {
            if (nextURL.equals("back")) {
                if (!history.isEmpty()) {    // !!! remove only if stack is not empty !!!
                    currentURL = history.pop();
                } else {
                    System.out.println("no previous URLs");
                    nextURL = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentURL.equals("blank")) {
                    history.push(currentURL);     // add current
                }
                currentURL = nextURL;         // update current
            }
            System.out.println(currentURL);
            nextURL = scanner.nextLine();
        }

    }
}
