package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class GamePlayController extends Controller {
    public static Level L1=Main.getCurrentPlayer().getPlayerGame().getCurrentLevel();
    @FXML
    public static ImageView Tile00;
    @FXML
    public ImageView Tile01;
    @FXML
    public ImageView Tile02;
    @FXML
    public ImageView Tile03;
    @FXML
    public ImageView Tile04;
    @FXML
    public ImageView Tile05;
    @FXML
    public ImageView Tile06;
    @FXML
    public ImageView Tile07;
    @FXML
    public static ImageView Tile08;
    @FXML
    public ImageView Tile10;
    @FXML
    public ImageView Tile11;
    @FXML
    public ImageView Tile12;
    @FXML
    public ImageView Tile13;
    @FXML
    public ImageView Tile14;
    @FXML
    public ImageView Tile15;
    @FXML
    public ImageView Tile16;
    @FXML
    public ImageView Tile17;
    @FXML
    public ImageView Tile18;
    @FXML
    public ImageView Tile20;
    @FXML
    public ImageView Tile21;
    @FXML
    public ImageView Tile22;
    @FXML
    public ImageView Tile23;
    @FXML
    public ImageView Tile24;
    @FXML
    public ImageView Tile25;
    @FXML
    public ImageView Tile26;
    @FXML
    public ImageView Tile27;
    @FXML
    public ImageView Tile28;
    @FXML
    public ImageView Tile30;
    @FXML
    public ImageView Tile31;
    @FXML
    public ImageView Tile32;
    @FXML
    public ImageView Tile33;
    @FXML
    public ImageView Tile34;
    @FXML
    public ImageView Tile35;
    @FXML
    public ImageView Tile36;
    @FXML
    public ImageView Tile37;
    @FXML
    public ImageView Tile38;
    @FXML
    public ImageView Tile40;
    @FXML
    public ImageView Tile41;
    @FXML
    public ImageView Tile42;
    @FXML
    public ImageView Tile43;
    @FXML
    public ImageView Tile44;
    @FXML
    public ImageView Tile45;
    @FXML
    public ImageView Tile46;
    @FXML
    public ImageView Tile47;
    @FXML
    public ImageView Tile48;


    public void MenuPressed( MouseEvent mouseEvent)
    {    Image SoundButtonOn=new Image("sample/SoundOn.png");
        ImageView MenuButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        MenuButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void MenuReleased(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly

        ImageView MenuButton=(ImageView)mouseEvent.getSource();
        MenuButton.setEffect(null);
        Parent ingamemenu = FXMLLoader.load(getClass().getResource("InGameMenu.fxml"));

        Parent currentscene =((Node)mouseEvent.getSource()).getScene().getRoot();
        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Scene InGameMenu =new Scene(ingamemenu);
        Group newscene=new Group(currentscene,ingamemenu);
        Scene newscene2=new Scene(newscene);
        window.setScene(newscene2);
        window.show();

        System.out.println("PlayReleased");

    }
    public void PlantPressed( MouseEvent mouseEvent)
    {
        ImageView PlantButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        PlantButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void PlantReleased(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly

        ImageView PlantButton=(ImageView)mouseEvent.getSource();
        PlantButton.setEffect(null);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.seconds(15));
        fade.setFromValue(.1);
        fade.setToValue(1);
        fade.setCycleCount(1);
        fade.setAutoReverse(true);
        fade.setNode(PlantButton);
        fade.play();

        System.out.println("PlayReleased");
    }
    public void PlacePlant(DragEvent dragEvent) throws IOException
    {
        Image img=  dragEvent.getDragboard().getImage();
        Node asd= (Node) dragEvent.getSource();
        ImageView current=(ImageView)dragEvent.getSource();
        if(current.getImage() == null) {
            if(    L1.getPlantsList().get(L1.getPlantsList().size()-1) instanceof PeaShooter)
            {
//                System.out.println("uiuoiu");
//                System.out.println(Tile08);
//                System.out.println("uiasboasbdoas");
                current.setImage(img);

                PeaShooter peashooterplant= (PeaShooter) L1.getPlantsList().get(L1.getPlantsList().size()-1);
                peashooterplant.setMyavatar(current);
                peashooterplant.setrootxy(L1.getRoot(),asd.getLayoutX()+asd.getParent().getLayoutX() +asd.getParent().getParent().getLayoutX(),asd.getLayoutY()+asd.getParent().getLayoutY() +asd.getParent().getParent().getLayoutY());
//                current.get
                System.out.println(asd.getLayoutX()+"  "+asd.getParent().getLayoutX()+" " +asd.getParent().getParent().getLayoutX());
                System.out.println(asd.getLayoutY()+"  "+asd.getParent().getLayoutY()+" " +asd.getParent().getParent().getLayoutY());
            }
        }System.out.println(current.getX());
    }
    public void IsTileFree(DragEvent dragEvent) throws IOException
    {
        ImageView current=(ImageView)dragEvent.getSource();
        if(dragEvent.getDragboard().hasImage() && current.getImage()==null){
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }
}
