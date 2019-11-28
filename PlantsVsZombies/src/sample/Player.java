package sample;

import java.util.ArrayList;

public class Player {
    private String Name;
    private int SlotsAvailable;
    private ArrayList<String> UnlockedPlants = new ArrayList<String>();
    private Long Score;
    private Game PlayerGame;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSlotsAvailable() {
        return SlotsAvailable;
    }

    public void setSlotsAvailable(int slotsAvailable) {
        SlotsAvailable = slotsAvailable;
    }

    public ArrayList<String> getUnlockedPlants() {
        return UnlockedPlants;
    }

    public void setUnlockedPlants(ArrayList<String> unlockedPlants) {
        UnlockedPlants = unlockedPlants;
    }

    public Long getScore() {
        return Score;
    }

    public void setScore(Long score) {
        Score = score;
    }

    public Game getPlayerGame() {
        return PlayerGame;
    }

    public void setPlayerGame(Game playerGame) {
        PlayerGame = playerGame;
    }
}
