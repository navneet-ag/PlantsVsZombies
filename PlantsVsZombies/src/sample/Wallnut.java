package sample;

import javafx.scene.image.ImageView;

public class Wallnut extends Barrier {
    protected static float PlantCost=50;

    public static float getPlantCost() {
        return PlantCost;
    }

    public Wallnut()
    {
        Health=25;
        Myavatar=new ImageView("sample/walnut_full_life.gif");
        Myavatar.setFitHeight(56);
        Myavatar.setFitWidth(44);
        RegenerationTime= (float) 2.5;
        LifeStatus=true;

    }
}
