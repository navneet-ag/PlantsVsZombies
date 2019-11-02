package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
        Parent tableparent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        Scene tablescene =new Scene(tableparent);
        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();
        System.out.println("PlayReleased");

    }

}
