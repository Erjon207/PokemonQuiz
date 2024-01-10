package org.example.pokémon;

import org.bson.Document;

import java.util.List;

public interface PokémonService {

    List<Pokémon> getAllPokemons(int value, String category);

    Pokémon documentToPokemon(Document document);

    int getPokemonValue(Pokémon currentPokemon, String category);
}
