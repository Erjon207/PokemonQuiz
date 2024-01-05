package org.example.players;

public class Player {
    String winner;
    int points;
    double time;

    public Player(String name, int points, double time) {
        this.winner = name;
        this.points = points;
        this.time = time;
    }

    public Player() {}

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + winner + '\'' +
                ", points=" + points +
                ", time=" + time +
                '}';
    }
}