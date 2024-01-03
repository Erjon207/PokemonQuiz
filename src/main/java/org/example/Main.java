package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;
import org.example.pokémon.Pokémon;


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        makeQuestion();

        String category = getAnswer(scanner);

        List question = getQuestion(category);

        //Collections.shuffle(question);
        Question randomQuestion = question.isEmpty() ? null : (Question) question.get(new Random().nextInt(question.size()));
        System.out.println(randomQuestion.getQuestion());

        Main main = new Main();
        List<Pokémon> pokemons = main.getAllPokemons();

        for (Pokémon pokemon : pokemons) {
            System.out.println(pokemon);
        }
    }

    public List<Pokémon> getAllPokemons() {
        // Alle pokemons werden in eine Liste hinzugefügt
        List<Pokémon> pokemons = new ArrayList<>();

        // Connection String
        String connectionString = "mongodb://root:1234@localhost:27017/?authSource=admin";

        // Verbindung zur DB und dass abgreifen von der Collection
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
        pokemon.setStrength(document.getInteger("strength"));
        pokemon.setEnergy(document.getInteger("energy"));
        pokemon.setStage(document.getInteger("stage"));
        return pokemon;
    }

    private static String getAnswer(Scanner scanner) {
        String category;
        do {
            category = scanner.nextLine();
        } while (!(category.equals("Health") || category.equals("Strength") || category.equals("Energy") || category.equals("Stage")));
        return category;
    }

    private static void makeQuestion() {
        System.out.println("___________________________________________");
        System.out.println("Chose a Category:");
        System.out.println("- Health");
        System.out.println("- Strength");
        System.out.println("- Energy");
        System.out.println("- Stage");
        System.out.println("___________________________________________");
    }

    private static List<Question> getQuestion(String category) {
        if ("Health".equals(category)) {
            return getHealthQuestion();
        } else if ("Strength".equals(category)) {
            return getStrengthQuestion();
        } else if ("Energy".equals(category)) {
            return getEnergyQuestion();
        } else {
            return getStageQuestion();
        }
    }

    private static List getStageQuestion() {
        ArrayList list = new ArrayList();
        list.add(new Question("Which Pokémon's evolution stage is the highest?", 3));
        list.add(new Question("Which Pokémon's evolution stage is the lowest?", 1));
        return list;
    }

    private static List getEnergyQuestion() {
        List list = new ArrayList();
        list.add(new Question("Which Pokémon needs the most amount of Energy?", 4));
        list.add(new Question("Which Pokémon needs the least amount of Energy?", 0));
        return list;
    }

    private static List getStrengthQuestion() {
        List list = new ArrayList();
        list.add(new Question("Which Pokémon has the strongest Attack?", 200));
        list.add(new Question("Which Pokémon's strength is closest to 100?", 100));
        list.add(new Question("Which Pokémon's strength is closest to 60?", 60));
        list.add(new Question("Which Pokémon's strength is closest to 30?", 30));
        list.add(new Question("Which Pokémon has the weakest Attack?", 0));
        return list;
    }

    private static List getHealthQuestion() {
        List list = new ArrayList();
        list.add(new Question("Which Pokémon has the most health?", 200));
        list.add(new Question("Which Pokémon's health is closest to 30?", 30));
        list.add(new Question("Which Pokémon's health is closest to 60?", 60));
        list.add(new Question("Which Pokémon's health is closest to 100?", 100));
        list.add(new Question("Which Pokémon has the least health?", 0));
        return list;
    }
}