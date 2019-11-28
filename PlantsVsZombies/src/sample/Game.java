package sample;

import java.util.ArrayList;

public class Game {

    private Level CurrentLevel;
    private ArrayList<Plant> SelectedPlants = new ArrayList<Plant>();
    private ArrayList<Zombie> ZombiesInGrid = new ArrayList<Zombie>();
    private ArrayList<Sun> SunInGrid = new ArrayList<Sun>();


    public Level getCurrentLevel() {
        return CurrentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        CurrentLevel = currentLevel;
    }

    public ArrayList<Plant> getSelectedPlants() {
        return SelectedPlants;
    }

    public void setSelectedPlants(ArrayList<Plant> selectedPlants) {
        SelectedPlants = selectedPlants;
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
