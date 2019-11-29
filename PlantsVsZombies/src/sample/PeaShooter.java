package sample;

import javafx.scene.image.ImageView;

public class PeaShooter extends Shooter {


    public void PeaShooter()
    {
        Health=100;
        Myavatar=new ImageView("sample/pea_shooter.gif");
        Myavatar.setFitHeight(50);
        Myavatar.setFitWidth(40);
        ShootingPower=20;
        PlantCost=100;
        RegenerationTime=5;
        LifeStatus=true;
    }

    protected void Shoot()
    {


    }
}
