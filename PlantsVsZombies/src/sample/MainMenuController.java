package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController extends Controller{
    Image SoundButtonOn=new Image("sample/SoundOn.png");
    Image SoundButtonOff=new Image("sample/SoundOff.png");
    private static Boolean SoundOn=true;
    private static Boolean SoundOff=false;
    public void Playpressed( MouseEvent mouseEvent)
    {
        ImageView PlayButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        PlayButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void Playreleased(MouseEvent mouseEvent) throws IOException {
        ImageView PlayButton=(ImageView)mouseEvent.getSource();
        PlayButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("EnterName.fxml"));
        Scene tablescene =new Scene(tableparent);

        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();

        System.out.println("PlayReleased");

    }
    public void Resumepressed( MouseEvent mouseEvent)
    {
        ImageView ResumeButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        ResumeButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void Resumereleased(MouseEvent mouseEvent) throws IOException {
        ImageView ResumeButton=(ImageView)mouseEvent.getSource();
        ResumeButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("EnterNameResumeGame.fxml"));
        Scene tablescene =new Scene(tableparent);
        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();

        System.out.println("PlayReleased");

    }
    public void ChooseLevelpressed( MouseEvent mouseEvent)
    {
        ImageView ChooseLevelButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        ChooseLevelButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void ChooseLevelreleased(MouseEvent mouseEvent) throws IOException {
        ImageView LeaderBoardButton=(ImageView)mouseEvent.getSource();
        LeaderBoardButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("ChooseLevel.fxml"));
        Scene tablescene =new Scene(tableparent);

        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();

        System.out.println("PlayReleased");

    }
    public void LeaderBoardpressed( MouseEvent mouseEvent)
    {
        ImageView LeaderBoardButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        LeaderBoardButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void LeaderBoardreleased(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly

        ImageView LeaderBoardButton=(ImageView)mouseEvent.getSource();
        LeaderBoardButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
        Scene tablescene =new Scene(tableparent);

        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();

        System.out.println("PlayReleased");

    }
    public void Quitpressed( MouseEvent mouseEvent)
    {
        ImageView QuitButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        QuitButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void Quitreleased(MouseEvent mouseEvent)
    {
        ImageView QuitButton=(ImageView)mouseEvent.getSource();
        QuitButton.setEffect(null);
        System.out.println("PlayReleased");
        System.exit(0);

    }
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


}
