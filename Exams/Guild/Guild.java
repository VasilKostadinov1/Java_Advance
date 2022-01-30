package EXAMs.Guild_03;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>(); // initialize the roster with a new instance of the collection
    }

    public void addPlayer(Player player) {  // adds an entity to the roster if there is room for it
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {  // removes a player by given name, if such exists
        return this.roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {  // promote (set his rank to "Member") the first player with the given name.
        // If the player is already a "Member", do nothing.
        this.roster.stream().filter(player -> player.getName().equals(name))
                .findFirst().ifPresent(player -> player.setRank("Member"));
    }
    public void demotePlayer(String name){
        this.roster.stream().filter(player->player.getName().equals(name))
                .findFirst().ifPresent(player->player.setRank("Trial"));
    }
    public Player[] kickPlayersByClass(String clazz){
        // removes all the players by the given class and returns all removed players from that class as an array
        Player[] removed = roster.stream().filter(player->player.getClazz().equals(clazz)).toArray(Player[]::new);
        for (Player player : removed) {
            roster.remove(player);
        }
        //setRoster(roster.stream().filter(player->!player.getClazz().equals(clazz)).collect(Collectors.toList())); // Petrov !
        return removed;
    }
    public int count(){
        return this.roster.size();
    }

   public String report(){
        StringBuilder sb = new StringBuilder("Players in the guild: ");
        sb.append(getName()).append(":").append(System.lineSeparator());
        getRoster().forEach(e->sb.append(e).append(System.lineSeparator()));
        return sb.toString();
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }
}

