package org.example.player;

import org.bson.Document;

import java.util.List;

public interface PlayerService {

    Player documentToPlayer(Document document);

    List<Player> getTopPlayers();
}
