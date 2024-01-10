package org.example.pokémon;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokémonServiceImpl implements PokémonService {

    public List<Pokémon> getAllPokemons(int value, String category) {

        List<Pokémon> pokemons = new ArrayList<>(); // All Pokémons in list

        String connectionString = "mongodb+srv://root:1234@pokemonquiz.amd9zke.mongodb.net/?retryWrites=true&w=majority"; // Connection String

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("Pokémons");
            MongoCollection<Document> collection = database.getCollection("pokemons");

            for (int x = 0; x < 3;) { // loops 3x

                var aggregation = Arrays.asList(Aggregates.sample(1)); // One random pokemon
                var cursor = collection.aggregate(aggregation).iterator();

                while (cursor.hasNext() && x < 3) { // Check x < 3 here

                    Document pokemonDocument = cursor.next();
                    Pokémon currentPokemon = documentToPokemon(pokemonDocument); // Convert BSON to java object

                    currentPokemon.setWinningCondition(Math.abs(value - getPokemonValue(currentPokemon, category))); // Sets winning condition to pokemon Object

                    boolean isUnique = pokemons.stream().noneMatch(p -> p.getWinningCondition() == currentPokemon.getWinningCondition()); // Check if pokemons have same winning condition

                    if (isUnique) {
                        pokemons.add(currentPokemon);
                        x++;
                    }
                }
            }
        }
        return pokemons;
    }

    public Pokémon documentToPokemon(Document document) {
        Pokémon pokemon = new Pokémon();
        pokemon.setName(document.getString("name"));
        pokemon.setHealth(document.getInteger("health"));
        pokemon.setStrength(document.getInteger("strength"));
        pokemon.setEnergy(document.getInteger("energy"));
        pokemon.setStage(document.getInteger("stage"));
        return pokemon;
    }

    public int getPokemonValue(Pokémon currentPokemon, String category) {
        if ("Health".equals(category)) {
            return currentPokemon.getHealth();
        } else if ("Strength".equals(category)) {
            return currentPokemon.getStrength();
        } else if ("Energy".equals(category)) {
            return currentPokemon.getEnergy();
        } else {
            return currentPokemon.getStage();
        }
    }
}
