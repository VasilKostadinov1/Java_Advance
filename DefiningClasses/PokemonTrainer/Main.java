package DefiningClasses.PokemonTrainer_06;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainerInfo = new LinkedHashMap<>();
        // Map<Trainer name; All Trainer info>
        String input;

        while (!"Tournament".equals(input = scanner.nextLine())) {
            //"<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>"
            String[] inputData = input.split("\\s+");
            String trainerName = inputData[0];
            String pokemonName = inputData[1];
            String pokemonElement = inputData[2];
            int pokemonHealth = Integer.parseInt(inputData[3].trim());
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainerInfo.putIfAbsent(
                    trainerName, new Trainer(trainerName, new ArrayList<>(), 0));
            trainerInfo.get(trainerName).getPokemonList().add(pokemon);
        }

        //an unknown number of lines containing one of three elements "Fire", "Water", "Electricity" will follow until the command "End"
        while (!"End".equals(input = scanner.nextLine())) {
            for (Trainer value : trainerInfo.values()) {
                String finalInput = input;
                boolean isFound = value.getPokemonList().stream()
                        .anyMatch(e -> e.getElement().equals(finalInput));
                if (isFound) {
                    //if a trainer has at least 1 pokemon with the given element, if he does he receives 1 badge
                    value.setCountBadges(value.getCountBadges() + 1);
                } else {
                    //otherwise all his pokemon lose 10 health
                    value.getPokemonList().forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
                    value.setPokemonList(value.getPokemonList().stream().filter(e->e.getHealth()>0)
                            .collect(Collectors.toList()));
                }
            }
        }
        trainerInfo.entrySet().stream()
                .sorted(Map.Entry.<String, Trainer>
                        comparingByValue(Comparator.comparing(Trainer::getCountBadges)).reversed())
                .forEach(e -> System.out.printf("%s %d %d%n"
                        , e.getValue().getName()
                        , e.getValue().getCountBadges()
                        , e.getValue().getPokemonList().size()));
    }
}
