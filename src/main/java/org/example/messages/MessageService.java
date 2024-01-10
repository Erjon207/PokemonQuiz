package org.example.messages;

import org.example.player.PlayerService;
import org.example.pokémon.Pokémon;

import java.util.List;
import java.util.Scanner;

public interface MessageService {

    void endOfGameMsg(String name, double time, int points, PlayerService playerService);

    String getAnswerToQuestion(String question, Scanner scanner);

    int getSolution(String playerSolution, List<Pokémon> pokemons, int points);

    String getCategory(Scanner scanner);
}
