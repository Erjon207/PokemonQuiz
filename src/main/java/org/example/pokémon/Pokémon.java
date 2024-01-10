package org.example.pokémon;

public class Pokémon {

    private String name;
    private int health;
    private int strength;
    private int energy;
    private int stage;
    private int winningCondition;

    public int getWinningCondition() {
        return winningCondition;
    }

    public void setWinningCondition(int winningCondition) {
        this.winningCondition = winningCondition;
    }

    public Pokémon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "Pokémon{" +
                "name=" + name +
                ", health=" + health +
                ", strength=" + strength +
                ", energy=" + energy +
                ", stage=" + stage +
                '}';
    }
}
