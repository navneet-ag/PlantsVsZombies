package sample;

import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {
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

}
