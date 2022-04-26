package EXAMs;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory_01_2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack  = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(materialsStack ::push);

        ArrayDeque<Integer> magicLevelQueue  =Arrays.stream(scanner.nextLine().split("\\s+"))
                       .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> presents = new TreeMap<>();
        int dolls = 0;
        int trains = 0;
        int bears = 0;
        int bicycles = 0;

        while (materialsStack.size() > 0 || magicLevelQueue.size() > 0) {
            if (magicLevelQueue.isEmpty() || materialsStack.isEmpty()) {
                break;
            }

            //The total magic level is calculated by their multiplication.
            int values = magicLevelQueue.peek();
            int boxes = materialsStack.peek();
            int product = values * boxes;   // multiplication.

            if (product < 0) {  // •	If the product of the operation is a negative number
                int result = values + boxes;  // then you have to sum the values together,
                //remove them both from their positions and the result should be added to the materials.
                magicLevelQueue.poll();
                materialsStack.pop();
                materialsStack.push(result);

                //•	If the magic or material (or both) equals 0, remove it (or both)
            } else if (boxes == 0 || values == 0) {
                if (boxes == 0) {
                    materialsStack.pop();
                }
                if (values == 0) {
                    magicLevelQueue.poll();
                }

            } else if (product == 150 || product == 250 || product == 300 || product == 400) {
                String gift;
                if (product == 150) {
                    dolls++;
                    gift = "Doll";
                    magicLevelQueue.poll();
                    materialsStack.pop();

                    presents.putIfAbsent(gift, 0);
                    presents.put(gift, presents.get(gift) + 1);

                } else if (product == 250) {
                    trains++;
                    gift = "Wooden train";
                    magicLevelQueue.poll();
                    materialsStack.pop();

                    presents.putIfAbsent(gift, 0);
                    presents.put(gift, presents.get(gift) + 1);

                } else if (product == 300) {
                    bears++;
                    gift = "Teddy bear";
                    magicLevelQueue.poll();
                    materialsStack.pop();

                    presents.putIfAbsent(gift, 0);
                    presents.put(gift, presents.get(gift) + 1);

                } else {
                    bicycles++;
                    gift = "Bicycle";
                    magicLevelQueue.poll();
                    materialsStack.pop();

                    presents.putIfAbsent(gift, 0);
                    presents.put(gift, presents.get(gift) + 1);
                }
            }
            //•	If the product doesn’t equal one of the magic levels in the table and is a positive number,
            //remove only the magic value and increase the material value with 15.
            else if (product > 0) {
                magicLevelQueue.poll();
                boxes += 15;
                materialsStack.pop();
                materialsStack.push(boxes);
            }
        }

        boolean craftedPresents = (dolls >= 1 && trains >= 1) ||
                (bears >= 1 && bicycles >= 1);

        if (craftedPresents) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(String.join(", ", materialsStack.toString()
                    .replaceAll("[\\[\\]]", "")));
        }

        if (!magicLevelQueue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(String.join(", ", magicLevelQueue.toString()
                    .replaceAll("[\\[\\]]", "")));
        }

        presents.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
