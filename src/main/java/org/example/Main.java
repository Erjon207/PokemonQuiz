package org.example;

import org.example.messages.MessageService;
import org.example.messages.MessagesServiceImpl;
import org.example.player.PlayerService;
import org.example.player.PlayerServiceImpl;
import org.example.pokémon.Pokémon;
import org.example.pokémon.PokémonServiceImpl;
import org.example.pokémon.PokémonService;
import org.example.question.Question;
import org.example.question.QuestionService;
import org.example.question.QuestionServiceImpl;

import java.io.File;
import java.util.*;

public class Main {

    static File coconut = new File("src/main/resources/img.png");
    static int points;
    public static void main(String[] args) {
        QuestionService questionService = new QuestionServiceImpl();
        PokémonService pokémonService = new PokémonServiceImpl();
        StatisticsDBConnector sdb = new StatisticsDBConnector();
        PlayerService playerService = new PlayerServiceImpl();
        MessageService messageService = new MessagesServiceImpl();
        Scanner scanner = new Scanner(System.in);

        checkIfNut();
        String name = messageService.getAnswerToQuestion("Type in your username", scanner);

        long start = System.currentTimeMillis();

        playthrough(questionService, scanner, pokémonService, messageService);

        long finish = System.currentTimeMillis();
        double time = (double) (finish - start) / 1000;
        sdb.saveWinLog(name, points, time);

        messageService.endOfGameMsg(name, time, points, playerService);
    }

    private static void checkIfNut() {
        if (!coconut.exists()) {
            while(true) {
                System.out.println("WHERE COCONUT !!!!!!!!??????????????????");
            }
        }
    }
    private static void playthrough(QuestionService questionService, Scanner scanner, PokémonService pokémonService, MessageService messageService) {
        for (int x = 0; x < 5; x++) {
            questionService.makeQuestion();

            String category = messageService.getCategory(scanner);
            List<Question> question = questionService.getPokemonQuestion(category);

            //Collections.shuffle(question);
            Question randomQuestion = question.isEmpty() ? null : (Question) question.get(new Random().nextInt(question.size()));
            System.out.println("________________________________________________________");
            System.out.println(randomQuestion.getQuestion());

            List<Pokémon> pokemons = pokémonService.getAllPokemons(randomQuestion.getResult(), randomQuestion.getCategory());

            for (Pokémon pokemon : pokemons) {
                System.out.println(" - " + pokemon.getName());
            }
            System.out.println("________________________________________________________");

            String playerSolution = scanner.nextLine();
            points = messageService.getSolution(playerSolution, pokemons, points);

            if (x != 4){
                String userInput = messageService.getAnswerToQuestion("Do you want to stop?", scanner);

                if (userInput.equals("yes")) {
                    System.out.println("Breaking the loop!");
                    break;
                }
            }
        }
    }
}