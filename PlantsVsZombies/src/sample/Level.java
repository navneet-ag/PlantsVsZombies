package sample;

import java.util.ArrayList;

public class Level {

    public String getPlantLocked() {
        return PlantLocked;
    }

    public void setPlantLocked(String plantLocked) {
        PlantLocked = plantLocked;
    }

    public int getGridSize() {
        return GridSize;
    }

    public void setGridSize(int gridSize) {
        GridSize = gridSize;
    }

    public float getSunValue() {
        return SunValue;
    }

    public void setSunValue(float sunValue) {
        SunValue = sunValue;
    }

    public ArrayList<LawnMover> getLawnMoversList() {
        return LawnMoversList;
    }

    public void setLawnMoversList(ArrayList<LawnMover> lawnMoversList) {
        LawnMoversList = lawnMoversList;
    }

    public ArrayList<Zombie> getZombiesList() {
        return ZombiesList;
    }

    public void setZombiesList(ArrayList<Zombie> zombiesList) {
        ZombiesList = zombiesList;
    }

    private String PlantLocked;
    private int GridSize;
    private float SunValue;
    private ArrayList<LawnMover> LawnMoversList = new ArrayList<LawnMover>();
    private ArrayList<Zombie> ZombiesList = new ArrayList<Zombie>();
}
