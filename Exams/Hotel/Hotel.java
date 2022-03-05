package EXAMs.Hotel_03;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        return this.roster.removeIf(person -> person.getName().contains(name));
    }

    public Person getPerson(String name, String hometown) {
        return this.roster.stream().filter(person -> person.getName().equals(name)
                && person.getHometown().equals(hometown)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder(String.format("The people in the hotel %s are:%n", this.name));
        this.roster.forEach(person -> builder.append(person).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
