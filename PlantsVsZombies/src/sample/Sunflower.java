package sample;

import javafx.scene.image.ImageView;

public class Sunflower extends Suntoken {

    public Sunflower()
    {
        Health=100;
        Myavatar=new ImageView("sample/sun_flower.gif");
        Myavatar.setFitHeight(56);
        Myavatar.setFitWidth(44);
        SunValue=25;
        PlantCost=50;
        RegenerationTime= (float) 2.5;
        LifeStatus=true;

    }
    public void GiveSun()
    {


    }
}
