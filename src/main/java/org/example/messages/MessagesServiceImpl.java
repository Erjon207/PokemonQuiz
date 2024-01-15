package org.example.messages;

import org.example.player.Player;
import org.example.player.PlayerService;
import org.example.pokémon.Pokémon;

import java.util.*;

public class MessagesServiceImpl implements MessagesService {

    public void endOfGameMsg(String name, double time, int points, PlayerService playerService) {
        System.out.println("Congratulations " + name + "! You got " + points + " points in " + time + " seconds.");

        System.out.println("___________________________________________________________________");
        System.out.println("Highscores:");

        System.out.println("___________________________________________________________________");
        for (Player player : playerService.getTopPlayers()) {
            System.out.println(player.getPlayerName() + ": " + player.getPoints() + " Points. Time:" + player.getTime() + " s");
        }
        System.out.println("___________________________________________________________________");
    }

    public String getAnswerToQuestion(String question, Scanner scanner) {
        System.out.println("___________________________________________________________________");
        System.out.println(question);
        System.out.println("___________________________________________________________________");

        String answer = scanner.nextLine();
        return answer;
    }

    public int getSolution(Scanner scanner, List<Pokémon> pokemons, int points) {
        String playerSolution = getPlayerSolution(scanner, pokemons);
        Collections.sort(pokemons, Comparator.comparingInt(Pokémon::getWinningCondition).reversed()); //sorts the pokémon after their difference to the solution
        Pokémon p = pokemons.get(pokemons.size() - 1); //gets the first pokémon witch is the winner
        String rightPokemon = p.getName();

        System.out.println("___________________________________________________________________");
        boolean equals = Objects.equals(playerSolution.toLowerCase(Locale.ROOT), rightPokemon.toLowerCase(Locale.ROOT)); //check's if the player answer matches the solution
        System.out.println(equals);
        System.out.println(" - " + rightPokemon);
        System.out.println("___________________________________________________________________");

        if (equals) { //adds a points if player answer is correct
            points++;
        }
        return points;
    }

    public String getPlayerSolution(Scanner scanner, List<Pokémon> pokémons) {
        String pokemon;
        boolean check;
        do {
            check = false;
            pokemon = scanner.nextLine().toLowerCase(Locale.ROOT);

            for (Pokémon p : pokémons) {
                if (pokemon.equals(p.getName().toLowerCase(Locale.ROOT))) {
                    check = true;
                    break;
                }
            }
        } while (!check);
        return pokemon;
    }

    public String getCategory(Scanner scanner) {
        String category;
        do { //if the answer isn't one of the category's you have to choose again a category
            category = scanner.nextLine().toLowerCase(Locale.ROOT);
        } while (!(category.equals("health") || category.equals("strength") || category.equals("energy") || category.equals("stage")));
        return category;
    }

    public void getLogo() {
        System.out.println("                                  ,'\\");
        System.out.println("    _.----.        ____         ,'  _\\   ___    ___     ____");
        System.out.println("_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.");
        System.out.println("\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |");
        System.out.println(" \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |");
        System.out.println("   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |");
        System.out.println("    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |");
        System.out.println("     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |");
        System.out.println("      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |");
        System.out.println("       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |");
        System.out.println("        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |");
        System.out.println("                                `'                            '-._|");
    }
}
