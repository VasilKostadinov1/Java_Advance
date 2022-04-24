package EXAMs;

import java.util.*;

public class MakeASalad2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vegetablesStack=new ArrayDeque<>();    // S. Delev
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(x -> x.matches("(tomato|carrot|lettuce|potato)")).forEach(vegetablesStack::offer);

        ArrayDeque<Integer> saladsQueues=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(saladsQueues::push);

        Map<String,Integer> vegetableCalories=new LinkedHashMap<String,Integer>(){{
            put("tomato",80);
            put("carrot",136);
            put("lettuce",109);
            put("potato",215);
        }};

        while (!vegetablesStack.isEmpty() && !saladsQueues.isEmpty()) {
            int currentSalad = saladsQueues.peek();

            while (currentSalad > 0 && !vegetablesStack.isEmpty()) {
                currentSalad -= vegetableCalories.get(vegetablesStack.poll());
            }
            System.out.print(saladsQueues.pop() + " ");
        }
        //System.out.println();

        if(!saladsQueues.isEmpty()){
            System.out.println(saladsQueues.toString().replaceAll("[\\[\\],]",""));
        }
        if(!vegetablesStack.isEmpty()){
            System.out.println(vegetablesStack.toString().replaceAll("[\\[\\],]",""));
        }
    }
}
