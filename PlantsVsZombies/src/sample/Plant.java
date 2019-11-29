package sample;

public class Plant extends Avatar {
    protected float RegenerationTime;
    protected float PlantCost;

    public float getRegenerationTime() {
        return RegenerationTime;
    }

    public void setRegenerationTime(float regenerationTime) {
        RegenerationTime = regenerationTime;
    }

    public float getPlantCost() {
        return PlantCost;
    }

    public void setPlantCost(float plantCost) {
        PlantCost = plantCost;
    }


    protected void Die()
    {

    }

}
