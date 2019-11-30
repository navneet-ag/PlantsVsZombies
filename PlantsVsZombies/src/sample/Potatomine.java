package sample;

import javafx.scene.image.ImageView;

public class Potatomine extends Bomb {
    protected static float PlantCost=25;
    private static float RegenerationTime;

    public static float getRegenerationTime() {
        return RegenerationTime;
    }

    public static void setRegenerationTime(float regenerationTime) {
        RegenerationTime = regenerationTime;
    }

    public static float getPlantCost() {
        return PlantCost;
    }

    public Potatomine()
    {
        Health=25;
        Myavatar=new ImageView("sample/sun_flower.gif");
        Myavatar.setFitHeight(56);
        Myavatar.setFitWidth(44);
        Impact=25;
        ExplodeTime= (float) 7.5;
        RegenerationTime= (float) 2.5;
        LifeStatus=true;

    }
    protected void Potatomine()
    {


    }
}
