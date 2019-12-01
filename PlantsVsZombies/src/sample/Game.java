package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {

    private Level CurrentLevel;
    private ArrayList<String> SelectedPlants = new ArrayList<String>();
    private ArrayList<Zombie> ZombiesInGrid = new ArrayList<Zombie>();
    private ArrayList<Sun> SunInGrid = new ArrayList<Sun>();
    public Game(int level)
    {
        CurrentLevel=new Level(level);
    }
    public Level getCurrentLevel() {
        return CurrentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        CurrentLevel = currentLevel;
    }

    public void setSelectedPlants(ArrayList<String> selectedPlants) {
        SelectedPlants = selectedPlants;
    }

    public ArrayList<String> getSelectedPlants() {
        return SelectedPlants;
    }

    public ArrayList<Zombie> getZombiesInGrid() {
        return ZombiesInGrid;
    }


    public void setZombiesInGrid(ArrayList<Zombie> zombiesInGrid) {
        ZombiesInGrid = zombiesInGrid;
    }

    public ArrayList<Sun> getSunInGrid() {
        return SunInGrid;
    }

    public void setSunInGrid(ArrayList<Sun> sunInGrid) {
        SunInGrid = sunInGrid;
    }

    public void Play()
    {

    }

    public void AddLevel(Level L)
    {

    }
}
