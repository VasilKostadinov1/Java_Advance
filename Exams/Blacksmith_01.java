package EXAMs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Blacksmith_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueSteel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackCarbon = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stackCarbon::push);

        int countGladius = 0, countShamshir = 0, countKatana = 0, countSabre = 0, countBroadsword = 0;
        int totalCount=0;

        //If the sum of their values is equal to any of the swords in the table below
        while (!queueSteel.isEmpty() && !stackCarbon.isEmpty()) {  //and remove both the steel and the carbon
            int valueSteel = queueSteel.poll();       // remove
            int valueCarbon = stackCarbon.pop();   // remove first
            if (valueSteel + valueCarbon == 70) {
                countGladius++;
                totalCount++;
            } else if (valueSteel + valueCarbon == 80) {
                countShamshir++;
                totalCount++;
            } else if (valueSteel + valueCarbon == 90) {
                countKatana++;
                totalCount++;
            } else if (valueSteel + valueCarbon == 110) {
                countSabre++;
                totalCount++;
            } else if (valueSteel + valueCarbon == 150) {
                countBroadsword++;
                totalCount++;
            } else { // Otherwise, remove only the steel, increase the value of the carbon by 5 and insert it back into the collection
                stackCarbon.push(valueCarbon + 5);
            }
        }
        if (countGladius != 0 || countShamshir != 0 || countKatana != 0 || countSabre != 0 || countBroadsword != 0) {
            System.out.printf("You have forged %d swords.%n",totalCount);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (queueSteel.isEmpty()) {  // print all steel you have left:
            System.out.println("Steel left: none");
        } else {     // Steel left: {steel1}, {steel2}, {steel3}, (…
            System.out.printf("Steel left: %s%n", queueSteel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (stackCarbon.isEmpty()){
            System.out.println("Carbon left: none");
        }else {
            System.out.printf("Carbon left: %s%n",stackCarbon.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (countBroadsword>0){
            System.out.printf("Broadsword: %d%n",countBroadsword);
        }if (countGladius>0){
            System.out.printf("Gladius: %d%n",countGladius);
        }if (countKatana>0){
            System.out.printf("Katana: %d%n",countKatana);
        }if (countSabre>0){
            System.out.printf("Sabre: %d%n",countSabre);
        }if (countShamshir>0){
            System.out.printf("Shamshir: %d%n",countShamshir);
        }




    }
}
