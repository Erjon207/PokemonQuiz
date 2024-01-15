package org.example.question;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.example.pokémon.Pokémon;
import org.example.pokémon.PokémonService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class QuestionServiceImpl implements QuestionService {
    public void makeQuestion() {
        System.out.println("___________________________________________________________________");
        System.out.println("Chose a Category:");
        System.out.println("- Health");
        System.out.println("- Strength");
        System.out.println("- Energy");
        System.out.println("- Stage");
        System.out.println("___________________________________________________________________");
    }

    public List<Pokémon> getQuizQuestion(Question randomQuestion, PokémonService pokémonService){
        System.out.println("___________________________________________________________________");
        System.out.println(randomQuestion.getQuestion());

        List<Pokémon> pokémons = pokémonService.getAllPokemons(randomQuestion.getResult(), randomQuestion.getCategory()); //takes 3 random pokémon from the DB

        for (Pokémon pokémon : pokémons) {
            System.out.println(" - " + pokémon.getName());
        }
        System.out.println("___________________________________________________________________");
        return pokémons;
    }

    public List<Question> getPokemonQuestion(String category) {
        category.toLowerCase(Locale.ROOT);
        if ("health".equals(category)) {
            return getHealthQuestion();
        } else if ("strength".equals(category)) {
            return getStrengthQuestion();
        } else if ("energy".equals(category)) {
            return getEnergyQuestion();
        } else {
            return getStageQuestion();
        }
    }

    public List<Question> getStageQuestion() {
        List<Question> list = new ArrayList();
        list.add(new Question("Which Pokémon's evolution stage is the highest?", getStageHighestValue(), "Stage"));
        list.add(new Question("Which Pokémon's evolution stage is the lowest?", 0, "Stage"));
        return list;
    }

    public int getStageHighestValue(){
        String connectionString = "mongodb+srv://root:1234@pokemonquiz.amd9zke.mongodb.net/?retryWrites=true&w=majority";
        int value = 0;

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("Pokémons");
            MongoCollection<Document> collection = database.getCollection("pokemons");

            var aggregation = Arrays.asList(
                    Aggregates.sort(Sorts.orderBy(Sorts.descending("stage"))),
                    Aggregates.limit(1)
            );

            var cursor = collection.aggregate(aggregation);

            if (cursor.iterator().hasNext()) {
                Document resultDocument = cursor.first();
                value = resultDocument.getInteger("stage");
            }
        }
        return value;
    }

    public  List<Question> getEnergyQuestion() {
        List<Question> list = new ArrayList();
        list.add(new Question("Which Pokémon needs the most amount of Energy?", getEnergyHighestValue(), "Energy"));
        list.add(new Question("Which Pokémon needs the least amount of Energy?", 0, "Energy"));
        return list;
    }

    public int getEnergyHighestValue(){
        String connectionString = "mongodb+srv://root:1234@pokemonquiz.amd9zke.mongodb.net/?retryWrites=true&w=majority";
        int value = 0;

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("Pokémons");
            MongoCollection<Document> collection = database.getCollection("pokemons");

            var aggregation = Arrays.asList(
                    Aggregates.sort(Sorts.orderBy(Sorts.descending("energy"))),
                    Aggregates.limit(1)
            );

            var cursor = collection.aggregate(aggregation);

            if (cursor.iterator().hasNext()) {
                Document resultDocument = cursor.first();
                value = resultDocument.getInteger("energy");
            }
        }
        return value;
    }

    public  List<Question> getStrengthQuestion() {
        List<Question> list = new ArrayList();
        list.add(new Question("Which Pokémon has the strongest Attack?", getStrengthHighestValue(), "Strength"));
        list.add(new Question("Which Pokémon's strength is closest to 100?", 100, "Strength"));
        list.add(new Question("Which Pokémon's strength is closest to 60?", 60, "Strength"));
        list.add(new Question("Which Pokémon's strength is closest to 30?", 30, "Strength"));
        list.add(new Question("Which Pokémon has the weakest Attack?", 0, "Strength"));
        return list;
    }

    public int getStrengthHighestValue(){
        String connectionString = "mongodb+srv://root:1234@pokemonquiz.amd9zke.mongodb.net/?retryWrites=true&w=majority";
        int value = 0;

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("Pokémons");
            MongoCollection<Document> collection = database.getCollection("pokemons");

            var aggregation = Arrays.asList(
                    Aggregates.sort(Sorts.orderBy(Sorts.descending("strength"))),
                    Aggregates.limit(1)
            );

            var cursor = collection.aggregate(aggregation);

            if (cursor.iterator().hasNext()) {
                Document resultDocument = cursor.first();
                value = resultDocument.getInteger("strength");
            }
        }
        return value;
    }

    public List<Question> getHealthQuestion() {
        List<Question> list = new ArrayList<>();
        list.add(new Question("Which Pokémon has the most health?", getHealthHighestValue(), "Health"));
        list.add(new Question("Which Pokémon's health is closest to 30?", 30, "Health"));
        list.add(new Question("Which Pokémon's health is closest to 60?", 60, "Health"));
        list.add(new Question("Which Pokémon's health is closest to 100?", 100, "Health"));
        list.add(new Question("Which Pokémon has the least health?", 0, "Health"));
        return list;
    }

    public int getHealthHighestValue(){
        String connectionString = "mongodb+srv://root:1234@pokemonquiz.amd9zke.mongodb.net/?retryWrites=true&w=majority";
        int value = 0;

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("Pokémons");
            MongoCollection<Document> collection = database.getCollection("pokemons");

            var aggregation = Arrays.asList(
                    Aggregates.sort(Sorts.orderBy(Sorts.descending("health"))),
                    Aggregates.limit(1)
            );

            var cursor = collection.aggregate(aggregation);

            if (cursor.iterator().hasNext()) {
                Document resultDocument = cursor.first();
                value = resultDocument.getInteger("health");
            }
        }
        return value;
    }
}
