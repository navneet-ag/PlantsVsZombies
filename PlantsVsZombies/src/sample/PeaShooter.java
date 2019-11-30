package sample;

import javafx.scene.image.ImageView;

public class PeaShooter extends Shooter {
    protected static float PlantCost=100;

    public static float getPlantCost() {
        return PlantCost;
    }


    public void PeaShooter()
    {
        Health=100;
        Myavatar=new ImageView("sample/pea_shooter.gif");
        Myavatar.setFitHeight(50);
        Myavatar.setFitWidth(40);
        ShootingPower=20;
        RegenerationTime=5;
        LifeStatus=true;
    }

    protected void Shoot()
    {


    }
}
