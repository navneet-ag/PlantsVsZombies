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

public class Sunflower extends Suntoken {
    protected static float PlantCost=50;
    private static final float RegenerationTime=5;
    private transient Group root2;
    private Level L1;
    public Sunflower(Level L1)
    {
        this.L1=L1;
        Health=60;
        Myimage=new Image("sample/sun_flower.gif");
        PlantCost=50;
    }

    public static float getRegenerationTime() {
        return RegenerationTime;
    }

    public static float getPlantCost() {
        return PlantCost;
    }

    public Sunflower()
    {
        Health=100;
        Myavatar=new ImageView("sample/sun_flower.gif");
        Myavatar.setFitHeight(56);
        Myavatar.setFitWidth(44);
        SunValue=25;
        LifeStatus=true;

    }
    private class SunHandler implements EventHandler<ActionEvent>
    {


        @Override
        public void handle(ActionEvent actionEvent) {

            GiveSun(root2, L1);

        }
    }

    public void setrootxy(Group root,double x,double y)
    {
        this.root2=root;
        System.out.println(root2);
        this.setX((float) x);
        this.setY((float) y);
        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(Sunflower.getRegenerationTime()),new Sunflower.SunHandler()));
        timeline3.setCycleCount(Animation.INDEFINITE);
        timeline3.play();
    }


    protected void GiveSun(Group root2, Level L1)
    {
        try{
            if(this!=null && !this.getLifeStatus())
                return;
        }
        catch(NullPointerException e)
        {
//            System.out.println(this);
        }

        final ImageView Suntoken = new ImageView();
        Image Sun = new Image("sample/sun.gif");
        Suntoken.setImage(Sun);
        Suntoken.setFitHeight(40);
        Suntoken.setFitWidth(40);
        Suntoken.relocate(this.getX()+15, this.getY()+15);
        Suntoken.setOnMouseClicked( e ->
        {
            Suntoken.setImage(null);
            SelectPlantsController.setSunAvailbleValue(SelectPlantsController.getSunAvailbleValue()+25);

            SelectPlantsController.getSunAvailableLabel().setText(String.valueOf(SelectPlantsController.getSunAvailbleValue()));
        });
        root2.getChildren().add(Suntoken);
    }

}
