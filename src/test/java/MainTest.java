import org.example.Main;
import org.example.pokémon.Pokémon;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Mock
    Main main;

    @Test
    void getPokemonHealthValue() {
        final Pokémon pokemon = new Pokémon();
        pokemon.setHealth(100);

        assertEquals(100, main.getPokemonValue(pokemon, "Health"));
    }

    @Test
    void getPokemonStrengthValue() {
        final Pokémon pokemon = new Pokémon();
        pokemon.setStrength(100);

        assertEquals(100, main.getPokemonValue(pokemon, "Strength"));
    }

    @Test
    void getPokemonEnergyValue() {
        final Pokémon pokemon = new Pokémon();
        pokemon.setEnergy(100);

        assertEquals(100, main.getPokemonValue(pokemon, "Energy"));
    }
    @Test
    void getPokemonStageValue() {
        final Pokémon pokemon = new Pokémon();
        pokemon.setStage(100);

        assertEquals(100, main.getPokemonValue(pokemon, ""));
    }


}
