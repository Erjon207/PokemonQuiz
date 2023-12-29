package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;
import org.example.pokémon.Pokémon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public List<Pokémon> getAllPokemons() {
        // Alle pokemons werden in eine Liste hinzugefügt
        List<Pokémon> pokemons = new ArrayList<>();

        // Connection String
        String connectionString = "mongodb://root:1234@localhost:27017/?authSource=admin";

        // Connecting to database & get collection
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("mongodb");
            MongoCollection<Document> collection = database.getCollection("pokemons");

            // Drei random Pokemons werden aus der collection gewählt.
            var aggregation = Arrays.asList(Aggregates.sample(3));
            var cursor = collection.aggregate(aggregation).iterator();

            // Solange Pokemons in "pokemons" collection vorzufinden sind werden diese in ein Document(Json ähnliche Struktur) hinzugefügt.
            while (cursor.hasNext()) {
                Document document = cursor.next();
                pokemons.add(documentToPokemon(document));
            }
        }
        return pokemons;
    }

    // Die Werte vom document werden in ein Pokémon Object umgewandelt
    private Pokémon documentToPokemon(Document document) {
        Pokémon pokemon = new Pokémon();
        pokemon.setName(document.getString("name"));
        pokemon.setHealth(document.getInteger("health"));
        pokemon.setStrenght(document.getInteger("strenght"));
        pokemon.setEnergy(document.getInteger("energy"));
        pokemon.setStage(document.getInteger("stage"));
        return pokemon;
    }

    public static void main(String[] args) {

        Main main = new Main();
        List<Pokémon> pokemons = main.getAllPokemons();

        for (Pokémon pokemon : pokemons) {
            System.out.println(pokemon);
        }

        //System.out.println("Chose your Category: ");
        //System.out.println("Health ,Strength ,Evolution & Energy");

    }
}