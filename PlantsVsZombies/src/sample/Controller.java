package sample;

import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.Serializable;

public class Controller  {
    public void MouseEntered( MouseEvent mouseEvent)
    {
        String musicFile = "MouseEnter.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
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

}
