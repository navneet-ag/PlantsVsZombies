package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Potatomine extends Bomb {
    protected static float PlantCost=25;
    private static float RegenerationTime=10;
    Group root2;
    Level L1;

    public static float getRegenerationTime() {
        return RegenerationTime;
    }

    public static void setRegenerationTime(float regenerationTime) {
        RegenerationTime = regenerationTime;
    }
    public Potatomine(Level L1)
    {
        this.L1=L1;
        Health=1000;
        Myimage=new Image("sample/walnut_full_life.gif");
        PlantCost=50;
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
