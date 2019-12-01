package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
    private String Name;
    private int SlotsAvailable;
    private ArrayList<String> UnlockedPlants = new ArrayList<String>();
    private Long Score;
    private Game PlayerGame;
    public Player()
    {

    }

    public Player(String Name,int level)
    {
        this.Name=Name;
        this.SlotsAvailable=2;
        this.Score=0L;
        this.PlayerGame=new Game(level);
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
