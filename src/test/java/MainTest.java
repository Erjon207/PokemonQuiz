import org.example.pokémon.Pokémon;
import org.example.pokémon.PokémonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Mock
    PokémonService pokémonService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPokemonHealthValue() {
        final Pokémon pokemon = new Pokémon();
        pokemon.setHealth(100);

        assertEquals(100, pokémonService.getPokemonValue(pokemon, "Health"));
    }

    @Test
    void getPokemonStrengthValue() {
        final Pokémon pokemon = new Pokémon();
        pokemon.setStrength(100);

        assertEquals(100, pokémonService.getPokemonValue(pokemon, "Strength"));
    }
    @Test
    void getPokemonEnergyValue() {
        final Pokémon pokemon = new Pokémon();
        pokemon.setEnergy(100);

        assertEquals(100, pokémonService.getPokemonValue(pokemon, "Energy"));
    }
    @Test
    void getPokemonStageValue() {
        final Pokémon pokemon = new Pokémon();
        pokemon.setStage(100);

        assertEquals(100, pokémonService.getPokemonValue(pokemon, ""));
    }
}
