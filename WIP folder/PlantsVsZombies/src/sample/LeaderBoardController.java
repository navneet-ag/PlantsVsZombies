package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LeaderBoardController extends Controller{

    @FXML
    public Label label00;
    @FXML
    public Label label02;
    @FXML
    public Label label03;
    @FXML
    public Label label04;

    public void update(MouseEvent mouseEvent)
    {
        ArrayList<Player> asl=Main.getListofPlayers();
        ArrayList<String> lead=new ArrayList<>();
        for(int i=0;i<asl.size();i++)
        {
            int max=0;
            int maxin=0;
            for(int j=0;j<asl.size();j++)
            {
                if(max<asl.get(j).getPlayerGame().getCurrentLevel().getSunValue())
                    max= (int) asl.get(j).getPlayerGame().getCurrentLevel().getSunValue();
                    maxin=j;

            }
            lead.add(asl.get(maxin).getName());
        }
        label00.setText(lead.get(0));
        label02.setText(lead.get(1));
        label03.setText(lead.get(2));
        label04.setText(lead.get(3));

    }
    public void Backpressed( MouseEvent mouseEvent)
    {
        ImageView BackButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        BackButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void Backreleased(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly

        ImageView BackButton=(ImageView)mouseEvent.getSource();
        BackButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene tablescene =new Scene(tableparent);

        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();

        System.out.println("PlayReleased");

    }



    public void Nextpressed( MouseEvent mouseEvent)
    {
        ImageView BackButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        BackButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    public void Nextreleased(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly

        ImageView BackButton=(ImageView)mouseEvent.getSource();
        BackButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("Alamnac2.fxml"));
        Scene tablescene =new Scene(tableparent);

        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();

        System.out.println("PlayReleased");

    }


    public void Backreleased2(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly

        ImageView BackButton=(ImageView)mouseEvent.getSource();
        BackButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("Alamnac1.fxml"));
        Scene tablescene =new Scene(tableparent);

        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();

        System.out.println("PlayReleased");

    }

}
