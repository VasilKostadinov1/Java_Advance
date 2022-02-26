package EXAMs.Parrot_03;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot toReturn = null;
        for (Parrot r : this.data) {
            if (r.getName().equals(name)) {
                r.setAvailable(false);
                toReturn = r;
            }
        }
        return toReturn;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> toReturn = new ArrayList<>();
        this.data.forEach(i -> {
            if (i.getSpecies().equals(species)) {
                i.setAvailable(false);
                toReturn.add(i);
            }
        });
        return toReturn;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());
        for (Parrot r : this.data) {
            if (r.isAvailable()) {
                sb.append(r.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
