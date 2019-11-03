package sample;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.media.*;
import javafx.util.Duration;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        final ImageView selectedImage = new ImageView();
//        Image image1 = new Image("sample/zombie_normal.gif");
//        selectedImage.setImage(image1);
//        selectedImage.setFitHeight(70);
//        selectedImage.setFitWidth(46.6);
//        Line line=new Line(400,125,160,125);
//
//        final ImageView SelectedPlant = new ImageView();
//        Image PeaShooter = new Image("sample/pea_shooter.gif");
//        SelectedPlant.setImage(PeaShooter);
//        SelectedPlant.setFitHeight(50);
//        SelectedPlant.setFitWidth(35);
//        SelectedPlant.setX(165);
//        SelectedPlant.setY(245);
//
//        PathTransition transtion=new PathTransition();
//        transtion.setNode(selectedImage);
//        transtion.setDuration(Duration.seconds(100));
//        transtion.setPath(line);
//        transtion.setCycleCount(1);
//        transtion.play();
//
//        final ImageView ShootPea = new ImageView();
//        Image Pea = new Image("sample/Pea.png");
//        ShootPea.setImage(Pea);
//        ShootPea.setFitHeight(15);
//        ShootPea.setFitWidth(15);
//
//        PathTransition transtionpea=new PathTransition();
//        transtionpea.setNode(ShootPea);
//        transtionpea.setDuration(Duration.seconds(8));
//        Line linepea=new Line(200,260,800,260);
//        transtionpea.setPath(linepea);
//        transtionpea.setCycleCount(10);
//        transtionpea.play();

        String musicFile = "background.wav";
        Media sound = new Media(new File("background.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("Menu.fxml"));
//        root3.setScaleX(0.100);
//        root3.setScaleY(0.100);
//        primaryStage.setTitle("PlantsVsZombies");

//        Group root2=new Group(root,SelectedPlant,selectedImage,ShootPea);

        primaryStage.setScene(new Scene(root, 623, 456));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
