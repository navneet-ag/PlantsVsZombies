package sample;

import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SelectPlantsController extends Controller{
    private static int numberofplants=1;


    Image PeaShooterButtonOn=new Image("sample/PeaShooterSelected.png");
    Image PeaShooterButtonOff=new Image("sample/Peashooter1.png");
    private static Boolean PeaShooterOn=true;
    private static Boolean PeaShooterOff=false;
    Image SunflowerButtonOn=new Image("sample/SunflowerSelected.png");
    Image SunflowerButtonOff=new Image("sample/Sunflower1.png");
    private static Boolean SunflowerOn=true;
    private static Boolean SunflowerOff=false;
    public void PeaShooterpressed( MouseEvent mouseEvent)
    {
        ImageView PeaShooterButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        PeaShooterButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void Sunflowerpressed( MouseEvent mouseEvent)
    {
        ImageView SunflowerButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        SunflowerButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }


    public void Sunflowerreleased(MouseEvent mouseEvent)
    {
        ImageView SunflowerButton=(ImageView)mouseEvent.getSource();
        SunflowerButton.setEffect(null);
        if(!SunflowerOn )
        {
            SunflowerButton.setImage(SunflowerButtonOff);
            SunflowerOff=false;
            SunflowerOn=true;
            numberofplants++;
        }
        else if(numberofplants>0)
        {
            SunflowerButton.setImage(SunflowerButtonOn);
            SunflowerOff=true;
            SunflowerOn=false;
            numberofplants--;
        }
        System.out.println("Numberofplants "+numberofplants);
    }

    public void PeaShooterreleased(MouseEvent mouseEvent)
    {
        ImageView PeaShooterButton=(ImageView)mouseEvent.getSource();
        PeaShooterButton.setEffect(null);
        if(!PeaShooterOn )
        {
            PeaShooterButton.setImage(PeaShooterButtonOff);
            PeaShooterOff=false;
            PeaShooterOn=true;
            numberofplants++;
        }
        else if(numberofplants>0)
        {
            PeaShooterButton.setImage(PeaShooterButtonOn);
            PeaShooterOff=true;
            PeaShooterOn=false;
            numberofplants--;
        }
        System.out.println("Numberofplants "+numberofplants);
    }

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

    public void OkReleased(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly
        Player current=Main.getCurrentPlayer();
        System.out.println(current.getPlayerGame().getSelectedPlants()+" 312321321321");
        final ImageView SelectedZombie = new ImageView();
        Image Zombie = new Image("sample/zombie_normal.gif");
        SelectedZombie.setImage(Zombie);
        SelectedZombie.setFitHeight(70);
        SelectedZombie.setFitWidth(46.6);
        Line line=new Line(625,125,160,125);

        PathTransition transtion=new PathTransition();
        transtion.setNode(SelectedZombie);
        transtion.setDuration(Duration.seconds(30));
        transtion.setPath(line);
        transtion.setCycleCount(1);
        transtion.play();
        final ImageView ShootPea = new ImageView();
        Image Pea = new Image("sample/Pea.png");
        ShootPea.setImage(Pea);
        ShootPea.setFitHeight(15);
        ShootPea.setFitWidth(15);

        PathTransition transtionpea=new PathTransition();
        transtionpea.setNode(ShootPea);
        transtionpea.setDuration(Duration.seconds(8));
        Line linepea=new Line(200,260,625,260);
        transtionpea.setPath(linepea);
        transtionpea.setCycleCount(10);
        transtionpea.play();


        final ImageView SelectedPlant = new ImageView();
        Image PeaShooter = new Image("sample/pea_shooter.gif");
        SelectedPlant.setImage(PeaShooter);
        SelectedPlant.setFitHeight(50);
        SelectedPlant.setFitWidth(40);
        SelectedPlant.setX(165);
        SelectedPlant.setY(245);

        ImageView OkButton=(ImageView)mouseEvent.getSource();
        OkButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));

        final ImageView Sun = new ImageView();
        Image suntoken = new Image("sample/sun.gif");
        Sun.setImage(suntoken);
        Sun.setFitHeight(45);
        Sun.setFitWidth(45);
        Line linesun=new Line(100,100,100,400);

        PathTransition transtionsun=new PathTransition();
        transtionsun.setNode(Sun);
        transtion.setDelay(Duration.seconds(20));
        transtionsun.setDuration(Duration.seconds(10));
        transtionsun.setPath(linesun);
        transtionsun.setCycleCount(1);
        transtionsun.play();
        Sun.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                Sun.setImage(null);
            }
        });
        Group root2=new Group(tableparent,SelectedZombie,SelectedPlant,ShootPea,Sun);
        Scene tablescene =new Scene(root2);
        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();
        System.out.println("PlayReleased");
    }


}