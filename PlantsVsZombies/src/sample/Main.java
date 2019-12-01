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

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {

    private static Player CurrentPlayer=null;
    public static ArrayList<Player> ListofPlayers=new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        deserialize();

        if(ListofPlayers==null)
            ListofPlayers=new ArrayList<>();
        System.out.println(ListofPlayers.get(1).getName());
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

    public  static ArrayList<Player> getListofPlayers() {
        return ListofPlayers;
    }

    public static void serialize() throws IOException {
        ObjectOutputStream out = null;
        try {
            System.out.println("serialize ho raha hai bhaiyaaaa 11111111111111");
            out = new ObjectOutputStream (new FileOutputStream("out.txt"));
            if(out==null)
            {
                System.out.println("serialize ho raha hai bhaiyaaaa ji");
            }
            System.out.println("serialize ho raha hai bhaiyaaaa ji2222222222222222");
            System.out.println(ListofPlayers.size());
//            out.writeObject(ListofPlayers.get(ListofPlayers.size()-1));
            out.writeObject(ListofPlayers);
            System.out.println("hogya bhaiya");
        } finally {
            out.close();
        }
    }
    public static void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
         try {
             in = new ObjectInputStream (new FileInputStream("out.txt"));
             ListofPlayers = (ArrayList<Player>) in.readObject();
            }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         finally {
             in.close();
             }
         }
}
