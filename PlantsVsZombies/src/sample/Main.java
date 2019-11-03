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

        String musicFile = "background.wav";
        Media sound = new Media(new File("background.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setScene(new Scene(root, 623, 456));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
