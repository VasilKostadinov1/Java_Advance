package EXAMs.EasterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {  //adds an entity to the data if there is room for it
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        //removes an egg by given color, if such exists, and returns boolean
        return this.data.removeIf(e -> e.getColor().equals(color));
    }

    public Egg getStrongestEgg() {  // returns the strongest egg
        return this.data.stream().max(Comparator.comparing(Egg::getStrength)).get();
        //return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
        //return this.data.stream().min((e1,e2)->Integer.compare(e2.getStrength(), e1.getStrength())).get();
    }

    public Egg getEgg(String color) { // returns the egg with the given color
        return this.data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public String report() {
//        "{material} basket contains:
//        {Egg1}
//        {Egg2}

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:", this.material)).append(System.lineSeparator());
        data.forEach(egg -> sb.append(egg.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    public int getCount() {
        return this.data.size();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Egg> getData() {
        return data;
    }

    public void setData(List<Egg> data) {
        this.data = data;
    }
}
