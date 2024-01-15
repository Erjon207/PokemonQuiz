package org.example;

import org.example.messages.MessagesService;
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
        MessagesService messagesService = new MessagesServiceImpl();
        Scanner scanner = new Scanner(System.in);

        checkIfNut();
        messagesService.getLogo();
        String name = messagesService.getAnswerToQuestion("Type in your username", scanner); //gets your name for the Score log

        long start = System.currentTimeMillis(); //starts timer
        playthrough(questionService, scanner, pokémonService, messagesService); //goes through the quiz

        long finish = System.currentTimeMillis(); //stops timer
        double time = (double) (finish - start) / 1000;
        sdb.saveWinLog(name, points, time); //logs your result for the scoreboard

        messagesService.endOfGameMsg(name, time, points, playerService); //shows current result of the quiz to the player
    }

    private static void playthrough(QuestionService questionService, Scanner scanner, PokémonService pokémonService, MessagesService messagesService) {
        for (int x = 0; x < 5; x++) {
            questionService.makeQuestion(); //aks which Category we want to choose

            String category = messagesService.getCategory(scanner); //loops for the answer until the input is one of the category's

            List<Question> question = questionService.getPokemonQuestion(category); //gets a list of question's for the chosen category
            Question randomQuestion = question.isEmpty() ? null : question.get(new Random().nextInt(question.size())); //gets one question randomly

            List<Pokémon> pokémons = questionService.getQuizQuestion(randomQuestion, pokémonService); //shows the question in the Terminal and 3 pokémon

            points = messagesService.getSolution(scanner, pokémons, points); //checks if the chosen pokémon is the right answer and adds points

            if (stopQuiz(scanner, messagesService, x)) break; //stops the quiz if the player chooses to
        }
    }

    private static boolean stopQuiz(Scanner scanner, MessagesService messagesService, int x) {
        if (x != 4){ // if it's the 5th time the game doesn't ask
            String userInput = messagesService.getAnswerToQuestion("Do you want to stop?", scanner);

            if (userInput.equals("yes")) {
                System.out.println("Breaking the loop!");
                return true;
            }
        }
        return false;
    }

    private static void checkIfNut() {
        if (!coconut.exists()) {
            while(true) {
                System.out.println("WHERE COCONUT !!!!!!!!??????????????????");
            }
        }
    }
}