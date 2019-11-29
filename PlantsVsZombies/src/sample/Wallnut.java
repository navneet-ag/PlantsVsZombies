package sample;

import javafx.scene.image.ImageView;

public class Wallnut extends Barrier {
    public Wallnut()
    {
        Health=25;
        Myavatar=new ImageView("sample/walnut_full_life.gif");
        Myavatar.setFitHeight(56);
        Myavatar.setFitWidth(44);
        PlantCost=50;
        RegenerationTime= (float) 2.5;
        LifeStatus=true;

    }
}
