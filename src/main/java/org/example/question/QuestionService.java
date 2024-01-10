package org.example.question;

import org.example.pokémon.Pokémon;
import org.example.pokémon.PokémonService;

import java.util.List;


public interface QuestionService {
    void makeQuestion();

    List<Pokémon> getQuizQuestion(Question randomQuestion, PokémonService pokémonService);

    List<Question> getPokemonQuestion(String category);

    List<Question> getStageQuestion();

    List<Question> getEnergyQuestion();

    List<Question> getStrengthQuestion();

    List<Question> getHealthQuestion();
}
