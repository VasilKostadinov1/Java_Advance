package DefiningClasses.PokemonTrainer_06;

import java.util.List;

public class Trainer {
    //Trainer has a name, number of badges and a collection of pokemon.

    private  String name;
    private int countBadges;
    private List<Pokemon> pokemonList;

    public Trainer(String name, List<Pokemon> pokemonList,int defaultCount) {
        this.name = name;
        this.pokemonList = pokemonList;
        this.countBadges = defaultCount;   // Every Trainer starts with 0 badges.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountBadges() {
        return countBadges;
    }

    public void setCountBadges(int countBadges) {
        this.countBadges = countBadges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
