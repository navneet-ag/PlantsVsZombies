package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Wallnut extends Barrier {
    protected static float PlantCost=50;
    private transient Group root2;
    private Level L1;
    private static final float RegenerationTime=10;

    public Wallnut(Level L1)
    {
        this.L1=L1;
        Health=1000;
        Myimage=new Image("sample/walnut_full_life.gif");
        PlantCost=50;
    }

    public Wallnut()
    {
        Health=25;
        Myavatar=new ImageView("sample/walnut_full_life.gif");
        Myavatar.setFitHeight(56);
        Myavatar.setFitWidth(44);
        LifeStatus=true;

    }

    public static float getPlantCost() {
        return PlantCost;
    }

    public static float getRegenerationTime() {
        return RegenerationTime;
    }

    public void setrootxy(Group root,double x,double y)
    {
        this.root2=root;
        System.out.println(root2);
        this.setX((float) x);
        this.setY((float) y);
    }
    public void sethalflife()
    {
        if(this.getHealth()<500) {
            Image halflife = new Image("sample/walnut_half_life.gif");
            this.getMyavatar().setImage(halflife);
        }
    }





}
