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

public class Potatomine extends Bomb {
    protected static float PlantCost = 25;
    private static final float RegenerationTime = 4;
    transient Group root2;
    Level L1;
    public boolean canbeusedstatus = false;

    public static float getRegenerationTime() {
        return RegenerationTime;
    }

    public Potatomine(Level L1) {
        this.L1 = L1;
        Health = 30;
        Myimage = new Image("sample/UnarmedPotatoMine.png");
        PlantCost = 50;
        LifeStatus=true;
    }

    public static float getPlantCost() {
        return PlantCost;
    }

    public Potatomine() {
        Health = 25;
        Myavatar = new ImageView("sample/sun_flower.gif");
        Myavatar.setFitHeight(56);
        Myavatar.setFitWidth(44);
        Impact = 25;
        ExplodeTime = (float) 7.5;
        LifeStatus = true;

    }

    public void setrootxy(Group root, double x, double y) {
        this.root2 = root;
        System.out.println(root2);
        this.setX((float) x);
        this.setY((float) y);
        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(Potatomine.getRegenerationTime() ), new Potatomine.MineHandler()));
        timeline3.setCycleCount(1);
        timeline3.play();
    }

    private class MineHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Mineready();
        }
    }

    protected void Mineready() {
        try {
            if (this.getLifeStatus()) {
                canbeusedstatus = true;
                Image usemine = new Image("sample/Potato_Mine.png");
                this.getMyavatar().setImage(usemine);

            }
        }
        catch (NullPointerException e)
        {

        }
    }
}