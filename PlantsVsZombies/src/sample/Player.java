package sample;

import java.util.ArrayList;

public class Player {
    private String Name;
    private int SlotsAvailable;
    private ArrayList<String> UnlockedPlants = new ArrayList<String>();
    private Long Score;
    private Game PlayerGame;

    public Player(String Name)
    {
        this.Name=Name;
        this.SlotsAvailable=2;
        this.Score=0L;
        this.PlayerGame=new Game();
        this.UnlockedPlants.add("PeaShooter");
        this.UnlockedPlants.add("SunFlower");
        this.UnlockedPlants.add("WallNut");
        this.UnlockedPlants.add("PotatoMine");

    }
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

    public Game  getPlayerGame() {
        return PlayerGame;
    }

    public void setPlayerGame(Game playerGame) {
        PlayerGame = playerGame;
    }
    public void addPlant(String name)
    {
        UnlockedPlants.add(name);
    }

}
