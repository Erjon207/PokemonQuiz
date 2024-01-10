package org.example.messages;

import org.example.player.Player;
import org.example.player.PlayerService;
import org.example.pokémon.Pokémon;

import java.util.*;

public class MessagesServiceImpl implements MessageService{

    public void endOfGameMsg(String name, double time, int points, PlayerService playerService) {
        System.out.println("Congratulations " + name + "! You got " + points + " points in " + time + " seconds.");

        System.out.println("________________________________________________________");
        System.out.println("Highscores:");

        System.out.println("________________________________________________________");
        for (Player player : playerService.getTopPlayers()) {
            System.out.println(player.getWinner() + ": " + player.getPoints() + " Points. Time:" + player.getTime() + " s");
        }
        System.out.println("________________________________________________________");
    }

    public String getAnswerToQuestion(String question, Scanner scanner) {
        System.out.println("________________________________________________________");
        System.out.println(question);
        System.out.println("________________________________________________________");

        String answer = scanner.nextLine();
        return answer;
    }

    public int getSolution(Scanner scanner, List<Pokémon> pokemons, int points) {
        String playerSolution = scanner.nextLine();
        Collections.sort(pokemons, Comparator.comparingInt(Pokémon::getPoints).reversed()); //sorts the pokémon after their difference to the solution
        Pokémon p = pokemons.get(pokemons.size() - 1); //gets the first pokémon witch is the winner
        String rightPokemon = p.getName();

        System.out.println("________________________________________________________");
        boolean equals = Objects.equals(playerSolution.toLowerCase(Locale.ROOT), rightPokemon.toLowerCase(Locale.ROOT)); //check's if the player answer matches the solution
        System.out.println(equals);
        System.out.println(" - " + rightPokemon);
        System.out.println("________________________________________________________");

        if (equals) { //adds a points if player answer is correct
            points++;
        }
        return points;
    }

    public String getCategory(Scanner scanner) {
        String category;
        do { //if the answer isn't one of the category's you have to choose again a category
            category = scanner.nextLine().toLowerCase(Locale.ROOT);
        } while (!(category.equals("health") || category.equals("strength") || category.equals("energy") || category.equals("stage")));
        return category;
    }
}
