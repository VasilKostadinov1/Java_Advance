package EXAMs.Rabbits_03_Parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private List<Rabbit> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    //removes a rabbit by given name, if such exists, and returns boolean
    public boolean removeRabbit(String name) {
        return this.data.removeIf(r -> r.getName().equals(name));
    }

    //removes all rabbits by given species
    public void removeSpecies(String species) {
        this.data.removeIf(r -> r.getSpecies().equals(species));
        //this.data = this.data.stream().filter(e -> !e.getSpecies().equals(species)).collect(Collectors.toList());
    }

    public int count() {
        return this.data.size();
    }

    //sell (set its available property to false without removing it from the collection)
    //the first rabbit with the given name, also return the rabbit
    public Rabbit sellRabbit(String name) {
        this.data.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst().ifPresent(v -> v.setAvailable(false));
        return this.data.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst().orElse(null);
    }

    //sells and returns all rabbits from that species as a List
    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> soldRabbits = data.stream()
                .filter(r -> r.getSpecies().equals(species)).collect(Collectors.toList());
        data.removeIf(x -> x.getSpecies().equals(species));
        return soldRabbits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rabbits available at ");
        sb.append(getName()).append(":").append(System.lineSeparator());
        this.data.stream()
                .filter(Rabbit::isAvailable)
                .forEach(r -> sb.append(r).append(System.lineSeparator()));

//        for (Rabbit r : data) {
//            if(r.isAvailable()) sb.append(r.toString()).append(System.lineSeparator());
//        }
        return sb.toString().trim();
    }
}
