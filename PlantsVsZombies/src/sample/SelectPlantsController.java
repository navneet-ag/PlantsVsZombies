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

public class SelectPlantsController extends Controller{

//    Image PeaShooterButtonOn=new Image("sample/PeaShooterSelected.png");
//    Image PeaShooterButtonOff=new Image("sample/Peashooter1.png");
//    private static Boolean PeaShooterOn=true;
//    private static Boolean PeaShooterOff=false;
//    Image SunflowerButtonOn=new Image("sample/SunflowerSelected.png");
//    Image SunflowerButtonOff=new Image("sample/Sunflower1.png");
//    private static Boolean SunflowerOn=true;
//    private static Boolean SunflowerOff=false;
//
//    public void PeaShooterpressed( MouseEvent mouseEvent)
//    {
//        ImageView PeaShooterButton=(ImageView)mouseEvent.getSource();
//        Shadow shadow=new Shadow();
//        shadow.setBlurType(BlurType.THREE_PASS_BOX);
//        shadow.setColor(Color.rgb(14, 176, 52));
//        PeaShooterButton.setEffect(shadow);
//        System.out.println("PlayPressed");
//    }
//
//    public void Sunflowerpressed( MouseEvent mouseEvent)
//    {
//        ImageView SunflowerButton=(ImageView)mouseEvent.getSource();
//        Shadow shadow=new Shadow();
//        shadow.setBlurType(BlurType.THREE_PASS_BOX);
//        shadow.setColor(Color.rgb(14, 176, 52));
//        SunflowerButton.setEffect(shadow);
//        System.out.println("PlayPressed");
//    }
//
//
//    public void Sunflowerreleased(MouseEvent mouseEvent)
//    {
//        ImageView SunflowerButton=(ImageView)mouseEvent.getSource();
//        SunflowerButton.setEffect(null);
//        if(!SunflowerOn)
//        {
//            SunflowerButton.setImage(SunflowerButtonOff);
//            SunflowerOff=false;
//            SunflowerOn=true;
//        }
//        else
//        {
//            SunflowerButton.setImage(SunflowerButtonOn);
//            SunflowerOff=true;
//            SunflowerOn=false;
//        }
//
//        System.out.println("PlayReleased");
//    }
//
//    public void PeaShooterreleased(MouseEvent mouseEvent)
//    {
//        ImageView PeaShooterButton=(ImageView)mouseEvent.getSource();
//        PeaShooterButton.setEffect(null);
//        if(!PeaShooterOn)
//        {
//            PeaShooterButton.setImage(PeaShooterButtonOff);
//            PeaShooterOff=false;
//            PeaShooterOn=true;
//        }
//        else
//        {
//            PeaShooterButton.setImage(PeaShooterButtonOn);
//            PeaShooterOff=true;
//            PeaShooterOn=false;
//        }
//
//        System.out.println("PlayReleased");
//    }

    public void Backpressed( MouseEvent mouseEvent)
    {
        ImageView BackButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        BackButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void Backreleased(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly

        ImageView BackButton=(ImageView)mouseEvent.getSource();
        BackButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("EnterName.fxml"));
        Scene tablescene =new Scene(tableparent);
        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();
        System.out.println("PlayReleased");

    }
    public void OkPressed( MouseEvent mouseEvent)
    {
        ImageView OkButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        OkButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    private class SelectedZombieCollisionHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent) {


            SelectedZombie.setLayoutX(SelectedZombie.getLayoutX()-1);

        }
    }

    private class ShootPeaCollisionHandler implements EventHandler<ActionEvent>
    {


        @Override
        public void handle(ActionEvent actionEvent) {


            System.out.println(ShootPea.getLayoutX() + " Pea");
            ShootPea.setLayoutX(ShootPea.getLayoutX()+5);
            System.out.println(ShootPea.getLayoutX() + " Pea");
            System.out.println(SelectedZombie.getLayoutX() + "ZOM");
            if (ShootPea.getLayoutX()>SelectedZombie.getLayoutX())
            {
//                System.out.println("collllision");
            }
        }
    }


    public void SunCreation()
    {
        System.out.println("insideeeeeeee");





        final ImageView Sun = new ImageView();
        Image suntoken = new Image("sample/sun.gif");
        Sun.setImage(suntoken);
        Sun.setFitHeight(40);
        Sun.setFitWidth(40);
//            Sun.relocate(, 100);
        int x=Ran.nextInt(300)+200;
        Line linesun=new Line(x,100,x,400);

        PathTransition transtionsun=new PathTransition();
        transtionsun.setNode(Sun);
        transtionsun.setDelay(Duration.seconds(5));
        transtionsun.setDuration(Duration.seconds(5));
        transtionsun.setPath(linesun);
        transtionsun.setCycleCount(1);
        transtionsun.play();
        root2.getChildren().add(Sun);
        Sun.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                Sun.setImage(null);
            }
        });


        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(15), new SunHandler()));
        timeline3.setCycleCount(1);

        timeline3.play();



    }


    private class SunHandler implements EventHandler<ActionEvent>
    {


        @Override
        public void handle(ActionEvent actionEvent) {

            SunCreation();

        }
    }

    final ImageView SelectedZombie = new ImageView();
    final ImageView ShootPea = new ImageView();
    Group root2=new Group();
    Random Ran = new Random();

    public void OkReleased(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly


        System.out.println(Main.getCurrentPlayer().getPlayerGame().getSelectedPlants());
        Image Zombie = new Image("sample/zombie_normal.gif");
        SelectedZombie.setImage(Zombie);
        SelectedZombie.setFitHeight(70);
        SelectedZombie.setFitWidth(46.6);
        SelectedZombie.relocate(560, 240);
        KeyFrame kf1 = new KeyFrame(Duration.millis(50), new SelectedZombieCollisionHandler());
        Timeline timeline = new Timeline(kf1);
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(35), new KeyValue(SelectedZombie.layoutXProperty(),200)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();



        Image Pea = new Image("sample/Pea.png");
        ShootPea.setImage(Pea);
        ShootPea.setFitHeight(15);
        ShootPea.setFitWidth(15);
        ShootPea.relocate(200, 260);
        KeyFrame kf2 = new KeyFrame(Duration.millis(10), event ->{
            ShootPea.setLayoutX(ShootPea.getLayoutX()+1);
            if (ShootPea.getLayoutX()>SelectedZombie.getLayoutX())
            {

                ShootPea.setImage(null);
//                System.out.println("collllision");
            }
        });


//        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(5), new KeyValue(ShootPea.layoutXProperty(),600)));
        Timeline timeline2 = new Timeline(kf2);
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();

        final ImageView SelectedPlant = new ImageView();
        Image PeaShooter = new Image("sample/pea_shooter.gif");
        SelectedPlant.setImage(PeaShooter);
        SelectedPlant.setFitHeight(50);
        SelectedPlant.setFitWidth(40);
        SelectedPlant.setX(165);
        SelectedPlant.setY(245);



        SunCreation();
//        final ImageView Sun = new ImageView();
//        Image suntoken = new Image("sample/sun.gif");
//        Sun.setImage(suntoken);
//        Sun.setFitHeight(45);
//        Sun.setFitWidth(45);
//        Line linesun=new Line(100,100,100,400);
//
//        PathTransition transtionsun=new PathTransition();
//        transtionsun.setNode(Sun);
////        transtion.setDelay(Duration.seconds(20));
//        transtionsun.setDuration(Duration.seconds(10));
//        transtionsun.setPath(linesun);
//        transtionsun.setCycleCount(1);
//        transtionsun.play();
//        Sun.setOnMouseClicked(new EventHandler<MouseEvent>(){
//
//            @Override
//            public void handle(MouseEvent event) {
//                Sun.setImage(null);
//            }
//        });




        ImageView OkButton=(ImageView)mouseEvent.getSource();
        OkButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));

//        tableparent = (Group) tableparent;
//        ((Group) tableparent).getChildren().add()
//        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(2), new KeyValue(Sun.layoutYProperty(),400)));



        root2.getChildren().add(tableparent);
//        root2.getChildren().add(Sun);
        root2.getChildren().add(SelectedPlant);
        root2.getChildren().add(SelectedZombie);
        root2.getChildren().add(ShootPea);
        Scene tablescene =new Scene(root2);
        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();

        System.out.println("PlayReleased");

    }


}