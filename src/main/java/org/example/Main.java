package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import org.example.pokémon.Pokémon;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Datenbank-name
    private static final String DATABASE_NAME = "mongodb";
    // Collection-name
    private static final String COLLECTION_NAME = "pokemons";


    public List<Pokémon> getAllPokemons() {
        // Alle pokemons werden in eine Liste hinzugefügt
        List<Pokémon> pokemons = new ArrayList<>();

        // Connection String
        String connectionString = "mongodb://root:1234@localhost:27017/?authSource=admin";

        // Connecting to database
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

                // In der collection wird ein cursor erstellt welcher die collection durchläuft.
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                // Solange Pokemons in "pokemons" collection vorzufinden sind werden diese in ein Document(Json ähnliche Struktur) hinzugefügt.
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    pokemons.add(documentToPokemon(document));
                }
            }
        }
        return pokemons;
    }

    // Die Werte vom document werden in ein Pokémon Object umgewandelt
    private Pokémon documentToPokemon(Document document) {
        Pokémon pokemon = new Pokémon();
        pokemon.setName(document.getString("name"));
        pokemon.setHealth(document.getInteger("health"));
        pokemon.setStrength(document.getInteger("strength"));
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


    }
}