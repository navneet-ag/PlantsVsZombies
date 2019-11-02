package sample;

import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainMenuController {
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
        shadow.setColor(Color.rgb(36, 51, 77));
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
        shadow.setColor(Color.rgb(36, 51, 77));
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
        shadow.setColor(Color.rgb(36, 51, 77));
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
        shadow.setColor(Color.rgb(36, 51, 77));
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
        shadow.setColor(Color.rgb(36, 51, 77));
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
        shadow.setColor(Color.rgb(36, 51, 77));
        SoundButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void Soundreleased(MouseEvent mouseEvent)
    {
        ImageView SoundButton=(ImageView)mouseEvent.getSource();
        SoundButton.setEffect(null);
        System.out.println("PlayReleased");
    }


}
