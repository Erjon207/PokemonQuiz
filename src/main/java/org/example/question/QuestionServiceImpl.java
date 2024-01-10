package org.example.question;

import org.example.pokémon.Pokémon;
import org.example.pokémon.PokémonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class QuestionServiceImpl implements QuestionService {
    public void makeQuestion() {
        System.out.println("________________________________________________________");
        System.out.println("Chose a Category:");
        System.out.println("- Health");
        System.out.println("- Strength");
        System.out.println("- Energy");
        System.out.println("- Stage");
        System.out.println("________________________________________________________");
    }

    public List<Pokémon> getQuizQuestion(Question randomQuestion, PokémonService pokémonService){
        System.out.println("________________________________________________________");
        System.out.println(randomQuestion.getQuestion());

        List<Pokémon> pokémons = pokémonService.getAllPokemons(randomQuestion.getResult(), randomQuestion.getCategory()); //takes 3 random pokémon from the DB

        for (Pokémon pokémon : pokémons) {
            System.out.println(" - " + pokémon.getName());
        }
        System.out.println("________________________________________________________");
        return pokémons;
    }

    public List<Question> getPokemonQuestion(String category) {
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

    public List<Question> getStageQuestion() {
        List<Question> list = new ArrayList();
        list.add(new Question("Which Pokémon's evolution stage is the highest?", 3, "Stage"));
        list.add(new Question("Which Pokémon's evolution stage is the lowest?", 1, "Stage"));
        return list;
    }

    public  List<Question> getEnergyQuestion() {
        List<Question> list = new ArrayList();
        list.add(new Question("Which Pokémon needs the most amount of Energy?", 4, "Energy"));
        list.add(new Question("Which Pokémon needs the least amount of Energy?", 0, "Energy"));
        return list;
    }

    public  List<Question> getStrengthQuestion() {
        List<Question> list = new ArrayList();
        list.add(new Question("Which Pokémon has the strongest Attack?", 200, "Strength"));
        list.add(new Question("Which Pokémon's strength is closest to 100?", 100, "Strength"));
        list.add(new Question("Which Pokémon's strength is closest to 60?", 60, "Strength"));
        list.add(new Question("Which Pokémon's strength is closest to 30?", 30, "Strength"));
        list.add(new Question("Which Pokémon has the weakest Attack?", 0, "Strength"));
        return list;
    }

    public List<Question> getHealthQuestion() {
        List<Question> list = new ArrayList<>();
        list.add(new Question("Which Pokémon has the most health?", 200, "Health"));
        list.add(new Question("Which Pokémon's health is closest to 30?", 30, "Health"));
        list.add(new Question("Which Pokémon's health is closest to 60?", 60, "Health"));
        list.add(new Question("Which Pokémon's health is closest to 100?", 100, "Health"));
        list.add(new Question("Which Pokémon has the least health?", 0, "Health"));
        return list;
    }
}
