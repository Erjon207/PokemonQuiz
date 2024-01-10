package org.example.player;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerServiceImpl implements PlayerService {

    public Player documentToPlayer(Document document) {
        Player player = new Player();
        player.setPlayerName(document.getString("name"));
        player.setPoints(document.getInteger("points"));
        player.setTime(document.getDouble("time"));
        return player;
    }

    public List<Player> getTopPlayers() {
        List<Player> players = new ArrayList<>();
        String connectionString = "mongodb+srv://root:1234@pokemonquiz.amd9zke.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("statistics");
            MongoCollection<Document> collection = database.getCollection("statistics");

            var aggregation = Arrays.asList(
                    Aggregates.sort(
                            Sorts.orderBy(
                                    Sorts.descending("points"),
                                    Sorts.ascending("time"))),
                    Aggregates.limit(5)
            );

            var cursor = collection.aggregate(aggregation).iterator();

            while (cursor.hasNext()) {
                Document playerDocument = cursor.next();

                players.add(documentToPlayer(playerDocument)); // Converts BSON player to java
            }
        }
        return players;
    }
}
