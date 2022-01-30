package EXAMs.AquariumAdventure_03;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishInPool; // collection of object of type Fish
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>(); // initialize it, create instance
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        boolean isUnique = true;
        if (this.fishInPool.size() < this.getCapacity()) {
            for (Fish fishFromPool : this.fishInPool) {
                if (fishFromPool.getName().equals(fish.getName())) {
                    isUnique = false;
                    break;
                }
            }
        } else {
            isUnique = false;
        }
        if (isUnique) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }
    public Fish findFish(String name){
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)){
                return fish;
            }
        }
        return null;
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", this.getName(),this.getSize()));
        sb.append(System.lineSeparator());
        for (Fish fish : this.fishInPool) {
            sb.append(fish.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
