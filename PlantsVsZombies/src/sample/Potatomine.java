package sample;

import javafx.scene.image.ImageView;

public class Potatomine extends Bomb {

    public Potatomine()
    {
        Health=25;
        Myavatar=new ImageView("sample/sun_flower.gif");
        Myavatar.setFitHeight(56);
        Myavatar.setFitWidth(44);
        Impact=25;
        ExplodeTime= (float) 7.5;
        PlantCost=50;
        RegenerationTime= (float) 2.5;
        LifeStatus=true;

    }
    protected void Potatomine()
    {


    }
}
