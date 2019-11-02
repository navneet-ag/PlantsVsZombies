package sample;

import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainMenuController {

    public ImageView SoundImageView;
    Image SoundButtonOn=new Image("sample/SoundOn.png");
    Image SoundButtonOff=new Image("sample/SoundOff.png");
    private static Boolean SoundOn=true;
    private static Boolean SoundOff=false;
    public void MouseEntered( MouseEvent mouseEvent)
    {
        ImageView OptionSelected=(ImageView)mouseEvent.getSource();
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.40);
        OptionSelected.setEffect(bloom);
        System.out.println("MouseEntered");
    }

    public void MouseExited(MouseEvent mouseEvent)
    {
        ImageView OptionSelected=(ImageView)mouseEvent.getSource();
        OptionSelected.setEffect(null);
        System.out.println("MouseExited");

    }
    public void Playpressed( MouseEvent mouseEvent)
    {
        ImageView PlayButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        PlayButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void Playreleased(MouseEvent mouseEvent)
    {
        ImageView PlayButton=(ImageView)mouseEvent.getSource();
        PlayButton.setEffect(null);
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

    public void Resumereleased(MouseEvent mouseEvent)
    {
        ImageView ResumeButton=(ImageView)mouseEvent.getSource();
        ResumeButton.setEffect(null);
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

    public void ChooseLevelreleased(MouseEvent mouseEvent)
    {
        ImageView ChooseLevelButton=(ImageView)mouseEvent.getSource();
        ChooseLevelButton.setEffect(null);
        System.out.println("PlayReleased");

    }
    public void LeadBoarderpressed( MouseEvent mouseEvent)
    {
        ImageView LeadBoarderButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        LeadBoarderButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void LeadBoarderreleased(MouseEvent mouseEvent)
    {
        ImageView LeadBoarderButton=(ImageView)mouseEvent.getSource();
        LeadBoarderButton.setEffect(null);
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
