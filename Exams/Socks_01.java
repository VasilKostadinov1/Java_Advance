package EXAMs;

import java.util.*;

public class Socks_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();           // stack
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();          // queue

        Arrays.stream(scanner.nextLine().split(" "))             // stack
                .map(Integer::parseInt).forEach(leftSocks::push);

        Arrays.stream(scanner.nextLine().split(" "))              // queue
                .map(Integer::parseInt).forEach(rightSocks::offer);

        List<Integer> pairs = new ArrayList<>();
        while (leftSocks.size() > 0 && rightSocks.size() > 0) {
            //int leftSock = leftSocks.peek();
            int leftSock = leftSocks.pop();
            int rightSock = rightSocks.peek();

            if (leftSock > rightSock) {   // create a pair; remove both socks
                //leftSocks.pop();
                rightSocks.poll();
                pairs.add(leftSock + rightSock);  // add the value
            } else if (rightSock > leftSock) {   // remove left one
                //leftSocks.pop();
            } else {
                rightSocks.poll();               // remove right
                //leftSocks.pop();
                leftSocks.push(leftSock + 1);  // increment left with 1
            }
        }
        int maxPair = pairs.stream().max(Comparator.comparing(t -> t)).get();
        //int max1 = pairs.stream().max(Integer::compare).get();
        System.out.println(maxPair);

        pairs.forEach(p -> System.out.print(p + " "));


    }
}
