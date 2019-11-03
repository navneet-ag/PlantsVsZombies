package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GamePlayController extends Controller {
    public void MenuPressed( MouseEvent mouseEvent)
    {
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


}
