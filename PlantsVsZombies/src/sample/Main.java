package sample;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.media.*;
import javafx.util.Duration;

import java.io.File;

public class Main extends Application {
    private static Player CurrentPlayer=null;

    @Override
    public void start(Stage primaryStage) throws Exception{

        String musicFile = "background.wav";
        Media sound = new Media(new File("background.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
//        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
//        TextField name =new TextField();
//        name.setPrefWidth(209);
//        name.setPrefHeight(45);
//        name.setLayoutX(66+166);
//        name.setLayoutY(73+113);
//        name.setBlendMode(BlendMode.COLOR_BURN);
//
//        ImageView okButton= new ImageView("sample/OK.png");
//        okButton.setFitWidth(96);
//        okButton.setFitHeight(71);
//        okButton.setLayoutX(292);
//        okButton.setLayoutY(344);
//        Group b=new Group(root,name,okButton);
        primaryStage.setScene(new Scene(root, 623, 456));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        CurrentPlayer = currentPlayer;
    }

    public static Player getCurrentPlayer() {
        return CurrentPlayer;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
