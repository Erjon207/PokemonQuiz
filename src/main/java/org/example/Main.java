package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.example.players.Player;
import org.example.pokémon.Pokémon;

import java.io.File;
import java.util.*;

public class Main {

    static File coconut = new File("src/main/resources/img.png");
    static int points;

    public static void main(String[] args) {
        if (!coconut.exists()) {
            while(true) {
                System.out.println("WHERE COCONUT !!!!!!!!??????????????????");
            }
        }
        Scanner scanner = new Scanner(System.in);
        StatisticsDBConnector sdb = new StatisticsDBConnector();

        System.out.println("___________________________________________");
        System.out.println("Type in your username");
        System.out.println("___________________________________________");

        String name = scanner.nextLine();
        long start = System.currentTimeMillis();

        for (int x = 0; x < 5; x++) {
            makeQuestion();

            String category = getAnswer(scanner);
            List question = getPokemonQuestion(category);

            //Collections.shuffle(question);
            Question randomQuestion = question.isEmpty() ? null : (Question) question.get(new Random().nextInt(question.size()));
            System.out.println("___________________________________________");
            System.out.println(randomQuestion.getQuestion());

            Main main = new Main();
            List<Pokémon> pokemons = main.getAllPokemons(randomQuestion.getResult(), randomQuestion.getCategory());

            for (Pokémon pokemon : pokemons) {
                System.out.println(" - " + pokemon.getName());
            }
            System.out.println("___________________________________________");

            String playerSolution = scanner.nextLine();
            getSolution(playerSolution, pokemons);

            if (x != 4){
                System.out.println("___________________________________________");
                System.out.println("Do you want to stop?");
                System.out.println("___________________________________________");

                String userInput = scanner.nextLine();

                if (userInput.equals("yes")) {
                    System.out.println("Breaking the loop!");
                    break;
                }
            }
        }
        long finish = System.currentTimeMillis();
        double time = (double) (finish - start) / 1000;
        sdb.saveWinLog(name, points, time);

        System.out.println("Gratulations " + name + "! You got " + points + " points in " + time + " seconds.");

        System.out.println("___________________________________________");
        System.out.println("Highscore:");

        System.out.println("___________________________________________");
        for (Player player : getTopPlayers()) {
            System.out.println(player.getWinner() + ": " + player.getPoints() + " Points. Time:" + player.getTime() + " s");
        }
        System.out.println("___________________________________________");

    }

    public static void getSolution(String playerSolution, List<Pokémon> pokemons) {
        Collections.sort(pokemons, Comparator.comparingInt(Pokémon::getPoints).reversed());
        Pokémon p = pokemons.get(pokemons.size() - 1);
        String rightPokemon = p.getName();

        System.out.println("___________________________________________");
        System.out.println(Objects.equals(playerSolution, rightPokemon));
        System.out.println(" - " + rightPokemon);
        System.out.println("___________________________________________");

        if (Objects.equals(playerSolution, rightPokemon)) {
            points++;
        }
    }

    public static List<Player> getTopPlayers() {
        List<Player> players = new ArrayList<>();
        String connectionString = "mongodb://root:1234@localhost:27017/?authSource=admin";

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("statistics");
            MongoCollection<Document> collection = database.getCollection("statistics");

            var aggregation = Arrays.asList(
                    Aggregates.sort(Sorts.descending("points", String.valueOf(Sorts.ascending("time")))),
                Aggregates.limit(5)
            );

            var cursor = collection.aggregate(aggregation).iterator();

            while (cursor.hasNext()) {
                Document playerDocument = cursor.next();

                players.add(documentToPlayer(playerDocument));
            }
        }
        return players;
    }

    public List<Pokémon> getAllPokemons(int value, String category) {
        // Alle pokemons werden in eine Liste hinzugefügt
        List<Pokémon> pokemons = new ArrayList<>();

        // Connection String
        String connectionString = "mongodb://root:1234@localhost:27017/?authSource=admin";

        // Verbindung zur DB und dass abgreifen von der Collection
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("Pokémons");
            MongoCollection<Document> collection = database.getCollection("pokemons");

            for (int x = 0; x < 3;) { // Change the loop condition to x < 3

                // Drei random Pokemons werden aus der collection gewählt.
                var aggregation = Arrays.asList(Aggregates.sample(1));
                var cursor = collection.aggregate(aggregation).iterator();

                // Solange Pokemons in "pokemons" collection vorzufinden sind werden diese in ein Document(Json ähnliche Struktur) hinzugefügt.
                while (cursor.hasNext() && x < 3) { // Check x < 3 here

                    Document pokemonDocument = cursor.next();
                    Pokémon currentPokemon = documentToPokemon(pokemonDocument);

                    currentPokemon.setPoints(Math.abs(value - getPokemonPoints(currentPokemon, category)));

                    boolean isUnique = pokemons.stream().noneMatch(p -> p.getPoints() == currentPokemon.getPoints());

                    if (isUnique) {
                        pokemons.add(currentPokemon);
                        x++;
                    }
                }
            }
        }
        return pokemons;
    }

    private static int getPokemonPoints(Pokémon currentPokemon, String category) {
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

    private static Player documentToPlayer(Document document) {
        Player player = new Player();
        player.setWinner(document.getString("winner"));
        player.setPoints(document.getInteger("points"));
        player.setTime(document.getDouble("time"));
        return player;
    }

    private static String getAnswer(Scanner scanner) {
        String category;
        do {
            category = scanner.nextLine().toLowerCase(Locale.ROOT);
        } while (!(category.equals("health") || category.equals("strength") || category.equals("energy") || category.equals("stage")));
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

    private static List<Question> getPokemonQuestion(String category) {
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

    private static List getStageQuestion() {
        ArrayList list = new ArrayList();
        list.add(new Question("Which Pokémon's evolution stage is the highest?", 3, "Stage"));
        list.add(new Question("Which Pokémon's evolution stage is the lowest?", 1, "Stage"));
        return list;
    }

    private static List getEnergyQuestion() {
        List list = new ArrayList();
        list.add(new Question("Which Pokémon needs the most amount of Energy?", 4, "Energy"));
        list.add(new Question("Which Pokémon needs the least amount of Energy?", 0, "Energy"));
        return list;
    }

    private static List getStrengthQuestion() {
        List list = new ArrayList();
        list.add(new Question("Which Pokémon has the strongest Attack?", 200, "Strength"));
        list.add(new Question("Which Pokémon's strength is closest to 100?", 100, "Strength"));
        list.add(new Question("Which Pokémon's strength is closest to 60?", 60, "Strength"));
        list.add(new Question("Which Pokémon's strength is closest to 30?", 30, "Strength"));
        list.add(new Question("Which Pokémon has the weakest Attack?", 0, "Strength"));
        return list;
    }

    private static List getHealthQuestion() {
        List list = new ArrayList();
        list.add(new Question("Which Pokémon has the most health?", 200, "Health"));
        list.add(new Question("Which Pokémon's health is closest to 30?", 30, "Health"));
        list.add(new Question("Which Pokémon's health is closest to 60?", 60, "Health"));
        list.add(new Question("Which Pokémon's health is closest to 100?", 100, "Health"));
        list.add(new Question("Which Pokémon has the least health?", 0, "Health"));
        return list;
    }
}