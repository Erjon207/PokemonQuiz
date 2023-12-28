package org.example.pokémon;

public class Pokémon {

    private String name;
    private int health;
    private int strenght;
    private int energy;
    private int stage;

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

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
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
                ", strenght=" + strenght +
                ", energy=" + energy +
                ", stage=" + stage +
                '}';
    }
}
