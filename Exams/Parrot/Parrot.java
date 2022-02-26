package EXAMs.Parrot_03;

public class Parrot {
    private String name;
    private String species;
    private boolean available;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean bool) {
        this.available = bool;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrot (").append(this.species).append("): ").append(this.name);
        return sb.toString();
    }
}
