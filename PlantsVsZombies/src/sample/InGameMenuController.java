package sample;

import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class InGameMenuController extends Controller {



    Image SoundButtonOn=new Image("sample/SoundOn.png");
    Image SoundButtonOff=new Image("sample/SoundOff.png");
    private static Boolean SoundOn=true;
    private static Boolean SoundOff=false;

    public void Soundpressed( MouseEvent mouseEvent)
    {
        ImageView SoundButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        SoundButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void Soundreleased(MouseEvent mouseEvent)
    {
        ImageView SoundButton=(ImageView)mouseEvent.getSource();
        SoundButton.setEffect(null);
        if(SoundOn)
        {
            SoundButton.setImage(SoundButtonOff);
            SoundOff=true;
            SoundOn=false;
        }
        else
        {
            SoundButton.setImage(SoundButtonOn);
            SoundOff=false;
            SoundOn=true;
        }

        System.out.println("PlayReleased");
    }


    public void Exitpressed( MouseEvent mouseEvent)
    {
        ImageView QuitButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        QuitButton.setEffect(shadow);
        System.out.println("PlayPressed");

    }

    public void Exitreleased(MouseEvent mouseEvent) throws IOException {
        ImageView QuitButton=(ImageView)mouseEvent.getSource();
        QuitButton.setEffect(null);

        Main.serialize();
        System.out.println("exitreleased");
        System.exit(0);

    }

    public void ResumePressed( MouseEvent mouseEvent)
    {
        ImageView QuitButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        QuitButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void ResumeReleased(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly
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


        ImageView OkButton=(ImageView)mouseEvent.getSource();
        OkButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        Group root2=new Group(tableparent,SelectedZombie,SelectedPlant,ShootPea,Sun);
        Scene tablescene =new Scene(root2);
        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();
        System.out.println("PlayReleased");
    }


}