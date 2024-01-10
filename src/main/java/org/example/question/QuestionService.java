package org.example.question;

import java.util.List;


public interface QuestionService {
    void makeQuestion();

    List<Question> getPokemonQuestion(String category);

    List<Question> getStageQuestion();

    List<Question> getEnergyQuestion();

    List<Question> getStrengthQuestion();

    List<Question> getHealthQuestion();
}
