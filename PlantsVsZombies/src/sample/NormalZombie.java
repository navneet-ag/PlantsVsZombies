package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class NormalZombie extends Zombie{

    NormalZombie(int x, int y, Group root2, Level L1)
    {
        Health=100;
        AddNormalZombie(x,y,root2,L1);
        setX(x);
        setY(y);
    }
    private void AddNormalZombie(int x, int y, Group root2, Level L1)
    {

        final ImageView SelectedZombie = new ImageView();
        Image Zombie = new Image("sample/zombie_normal.gif");
        SelectedZombie.setImage(Zombie);
        SelectedZombie.setFitHeight(70);
        SelectedZombie.setFitWidth(46.6);
//        SelectedZombie.relocate(560, 240);
        SelectedZombie.relocate(x,y);
//        KeyFrame kf1 = new KeyFrame(Duration.millis(50), new SelectedZombieCollisionHandler());
        KeyFrame kf3 = new KeyFrame(Duration.millis(70), event ->{


            if(Health<=0)
            {
                root2.getChildren().remove(SelectedZombie);
            }

            else if (SelectedZombie.getLayoutX()>160)
            {
                int i=0;
                Boolean PlantFlag=false;
//                System.out.println(L1.getPlantsList());
                while (i<L1.getPlantsList().size())
                {
                    float range= (float) (this.getY()+30-L1.getPlantsList().get(i).getY());
                    System.out.println(range);
                    if ( range>=-5 &&(range<=5))
//                        System.out.println(range);
//                        if(this.getY()==215)
//                        System.out.println("2345678234567234567234567234567823456734567");
//                    System.out.print("insdq2eqweqw      "  );
//                    System.out.println(this.getY()+"    "+L1.getPlantsList().get(i).getY());
//                    if (L1.getPlantsList().get(i).getY()==this.getY()+30 )
                    {
//                        System.out.println(this.getX()-L1.getPlantsList().get(i).getX()+" "+this.getX()+" "+L1.getPlantsList().get(i).getX());
                        if ( this.getX()-L1.getPlantsList().get(i).getX()<10 && this.getX()-L1.getPlantsList().get(i).getX()>0)
                        {
                            PlantFlag=true;
                            L1.getPlantsList().get(i).reduceHealth(10);
                            System.out.println(L1.getPlantsList().get(i).getHealth()+" "+L1.getPlantsList());

                            if(L1.getPlantsList().get(i) instanceof Wallnut )
                            {
//                                L1.getPlantsList().get(i).getMyavatar().setImage(halflife);
                                ((Wallnut) L1.getPlantsList().get(i)).sethalflife();
                            }
                            if(L1.getPlantsList().get(i).getHealth()<0)
                            {
                                L1.getPlantsList().get(i).getMyavatar().setImage(null);
//                                System.out.println(L1.getPlantsList().get(i).getMyavatar());
////                                System.out.println(root2.);
//                                System.out.println(root2.getChildren());
                                L1.getPlantsList().get(i).setLifeStatus(false);
                                L1.getPlantsList().remove(L1.getPlantsList().get(i));
                                i--;

                            }
                            break;
                        }

                        else
                        {
                            PlantFlag=false;
                        }
                    }
                    i++;
                }
                if (!PlantFlag) {
                    SelectedZombie.setLayoutX(SelectedZombie.getLayoutX()-1);
                    setX((float) SelectedZombie.getLayoutX());
                }
                else{

                }
            }

        });
        Timeline timeline = new Timeline(kf3);
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(35), new KeyValue(SelectedZombie.layoutXProperty(),200)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        root2.getChildren().add(SelectedZombie);
    }


    protected float Attack()
    {
        return 0;
    }
}
