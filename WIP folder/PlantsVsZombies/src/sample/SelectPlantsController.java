package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import static sample.GamePlayController.Tile00;

public class SelectPlantsController extends Controller{
    private static Label SunAvailableLabel=new Label();
    private static int SunAvailbleValue=0;

    final ImageView SelectedZombie = new ImageView();
    final ImageView ShootPea = new ImageView();
    Group root2=new Group();
    Random Ran = new Random();


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
        Parent tableparent = FXMLLoader.load(getClass().getResource("EnterName.fxml"));
        Scene tablescene =new Scene(tableparent);
        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();
        System.out.println("PlayReleased");

    }

    public void OkPressed( MouseEvent mouseEvent)
    {
        ImageView OkButton=(ImageView)mouseEvent.getSource();
        Shadow shadow=new Shadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(14, 176, 52));
        OkButton.setEffect(shadow);
        System.out.println("PlayPressed");
    }

    private class SelectedZombieCollisionHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent) {


            SelectedZombie.setLayoutX(SelectedZombie.getLayoutX()-1);

        }
    }

    private class ShootPeaCollisionHandler implements EventHandler<ActionEvent>
    {


        @Override
        public void handle(ActionEvent actionEvent) {


            System.out.println(ShootPea.getLayoutX() + " Pea");
            ShootPea.setLayoutX(ShootPea.getLayoutX()+5);
            System.out.println(ShootPea.getLayoutX() + " Pea");
            System.out.println(SelectedZombie.getLayoutX() + "ZOM");
            if (ShootPea.getLayoutX()>SelectedZombie.getLayoutX())
            {
//                System.out.println("collllision");
            }
        }
    }


    public void SunCreation()
    {
//        System.out.println("insideeeeeeee");
        final ImageView Sun = new ImageView();
        Image suntoken = new Image("sample/sun.gif");
        Sun.setImage(suntoken);
        Sun.setFitHeight(40);
        Sun.setFitWidth(40);
//            Sun.relocate(, 100);
        int x=Ran.nextInt(300)+200;
        Line linesun=new Line(x,100,x,400);

        PathTransition transtionsun=new PathTransition();
        transtionsun.setDelay(Duration.seconds(5));
        transtionsun.setDuration(Duration.seconds(5));
        transtionsun.setPath(linesun);
        transtionsun.setCycleCount(1);
        transtionsun.setNode(Sun);
        transtionsun.play();
        root2.getChildren().add(Sun);
        Sun.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                SunAvailbleValue+=25;
                Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().setSunValue(SunAvailbleValue);

                SunAvailableLabel.setText(String.valueOf(SunAvailbleValue));
                Sun.setImage(null);
            }
        });

        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(15), new SunHandler()));
        timeline3.setCycleCount(1);
        timeline3.play();

    }


    private class SunHandler implements EventHandler<ActionEvent>
    {


        @Override
        public void handle(ActionEvent actionEvent) {

            SunCreation();

        }
    }



    public void OkReleased(MouseEvent mouseEvent) throws IOException {
        //Handle IOException
        //If Exception set an image game closed abruptly

        Player CurrentPlayer=Main.getCurrentPlayer();
        System.out.println(CurrentPlayer.getPlayerGame().getSelectedPlants()+" 312321321321");
        ImageView PeaShooterCard=new ImageView("sample/PeashooterSeedPacket.png");
        Boolean PeaShooterSelectionStatus=false;
        Boolean SunFLowerSelectionStatus=false;
        Boolean PotatoMineSelectionStatus=false;
        Boolean WallNutSelectionStatus=false;

        ArrayList<String> SelectedPlantsList=  CurrentPlayer.getPlayerGame().getSelectedPlants();
        for(int i=0;i<SelectedPlantsList.size();i++)
        {
            switch(SelectedPlantsList.get(i))
            {
                case "PeaShooter":PeaShooterSelectionStatus=true;
                                    break;
                case "Sunflower":SunFLowerSelectionStatus=true;
                                    break;
                case "WallNut":WallNutSelectionStatus=true;
                                    break;
                case "PotatoMine":PotatoMineSelectionStatus=true;
                                    break;
            }
        }
        PeaShooterCard.setFitWidth(45);
        PeaShooterCard.setFitHeight(62);
        PeaShooterCard.setLayoutX(131);
        PeaShooterCard.setLayoutY(1);

        ImageView SunFlowerCard=new ImageView("sample/SunflowerSeedPacket.png");
        SunFlowerCard.setFitWidth(45);
        SunFlowerCard.setFitHeight(62);
        SunFlowerCard.setLayoutX(176);
        SunFlowerCard.setLayoutY(1);


        ImageView WallNutCard=new ImageView("sample/Wall-nutSeedPacket.png");
        WallNutCard.setFitWidth(45);
        WallNutCard.setFitHeight(62);
        WallNutCard.setLayoutX(221);
        WallNutCard.setLayoutY(1);

        ImageView PotatoMineCard=new ImageView("sample/PotatoMineSeedPacket.png");
        PotatoMineCard.setFitWidth(45);
        PotatoMineCard.setFitHeight(62);
        PotatoMineCard.setLayoutX(265);
        PotatoMineCard.setLayoutY(1);

        FadeTransition fadepeashooter = new FadeTransition();
        fadepeashooter.setDuration(Duration.seconds(PeaShooter.getRegenerationTime()));
        fadepeashooter.setFromValue(.1);
        fadepeashooter.setToValue(1);
        fadepeashooter.setCycleCount(1);
        fadepeashooter.setAutoReverse(true);
        fadepeashooter.setOnFinished((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FadeTransition a=(FadeTransition)actionEvent.getSource();
                a.setNode(null);
            }
        }));

        FadeTransition fadesunflower = new FadeTransition();
        fadesunflower.setDuration(Duration.seconds(Sunflower.getRegenerationTime()));
        fadesunflower.setFromValue(.1);
        fadesunflower.setToValue(1);
        fadesunflower.setCycleCount(1);
        fadesunflower.setAutoReverse(true);
        fadesunflower.setOnFinished((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FadeTransition a=(FadeTransition)actionEvent.getSource();
                a.setNode(null);
            }
        }));
        FadeTransition fadepotatomine = new FadeTransition();
        fadepotatomine.setDuration(Duration.seconds(Potatomine.getRegenerationTime()));
        fadepotatomine.setFromValue(.1);
        fadepotatomine.setToValue(1);
        fadepotatomine.setCycleCount(1);
        fadepotatomine.setAutoReverse(true);
        fadepotatomine.setOnFinished((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FadeTransition a=(FadeTransition)actionEvent.getSource();
                a.setNode(null);
            }
        }));
        FadeTransition fadewallnut = new FadeTransition();
        fadewallnut.setDuration(Duration.seconds(Wallnut.getRegenerationTime()));
        fadewallnut.setFromValue(.1);
        fadewallnut.setToValue(1);
        fadewallnut.setCycleCount(1);
        fadewallnut.setAutoReverse(true);
        fadewallnut.setOnFinished((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FadeTransition a=(FadeTransition)actionEvent.getSource();
                a.setNode(null);
            }
        }));
        ArrayList<Plant> PlantsPlaced=Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().getPlantsList();
        PeaShooterCard.setOnDragDetected(e ->
        {
            System.out.println(fadepeashooter.getNode());
            if(SunAvailbleValue>=PeaShooter.getPlantCost() && fadepeashooter.getNode()==null)
            {
            Dragboard dragboard= ((Node)e.getSource()).startDragAndDrop(TransferMode.ANY);
            ClipboardContent clipboard=new ClipboardContent();
            PeaShooter peashooterplant=new PeaShooter(Main.getCurrentPlayer().getPlayerGame().getCurrentLevel());
            Image peashootergif=peashooterplant.getMyimage();
            clipboard.putImage(peashootergif);
            dragboard.setContent(clipboard);
                PlantsPlaced.add(peashooterplant);
                ImageView PlantButton=(ImageView)e.getSource();
                PlantButton.setEffect(null);
                fadepeashooter.setNode(PlantButton);
                fadepeashooter.play();
            e.consume();
                SunAvailbleValue-=PeaShooter.getPlantCost();
                SunAvailableLabel.setText(String.valueOf(SunAvailbleValue));
                Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().setSunValue(SunAvailbleValue);


            }
        });

        SunFlowerCard.setOnDragDetected(e ->
        {
            if(SunAvailbleValue>=Sunflower.getPlantCost() && fadesunflower.getNode()==null) {
                Dragboard dragboard = ((Node) e.getSource()).startDragAndDrop(TransferMode.ANY);
                ClipboardContent clipboard = new ClipboardContent();
                Sunflower sunflowerplant=new Sunflower(Main.getCurrentPlayer().getPlayerGame().getCurrentLevel());
                Image peashootergif = sunflowerplant.getMyimage();
                clipboard.putImage(peashootergif);
                dragboard.setContent(clipboard);
                PlantsPlaced.add(sunflowerplant);
                ImageView PlantButton=(ImageView)e.getSource();
                PlantButton.setEffect(null);
                fadesunflower.setNode(PlantButton);
                fadesunflower.play();
                e.consume();
                SunAvailbleValue-=Sunflower.getPlantCost();
                SunAvailableLabel.setText(String.valueOf(SunAvailbleValue));
                Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().setSunValue(SunAvailbleValue);


            }
        });

        WallNutCard.setOnDragDetected(e ->
        {
            if(SunAvailbleValue>=Wallnut.getPlantCost() && fadewallnut.getNode()==null) {
                Dragboard dragboard = ((Node) e.getSource()).startDragAndDrop(TransferMode.ANY);
                ClipboardContent clipboard = new ClipboardContent();
                Wallnut wallnutplant=new Wallnut(Main.getCurrentPlayer().getPlayerGame().getCurrentLevel());
                Image wallnutgif = wallnutplant.getMyimage();
                clipboard.putImage(wallnutgif);
                dragboard.setContent(clipboard);
                PlantsPlaced.add(wallnutplant);
                ImageView PlantButton=(ImageView)e.getSource();
                PlantButton.setEffect(null);
                fadewallnut.setNode(PlantButton);
                fadewallnut.play();
                e.consume();
                SunAvailbleValue-=Wallnut.getPlantCost();
                SunAvailableLabel.setText(String.valueOf(SunAvailbleValue));
                Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().setSunValue(SunAvailbleValue);

            }
        });
        PotatoMineCard.setOnDragDetected(e ->
        {
            if(SunAvailbleValue>=Potatomine.getPlantCost() && fadepotatomine.getNode()==null) {
                Dragboard dragboard = ((Node) e.getSource()).startDragAndDrop(TransferMode.ANY);
                ClipboardContent clipboard = new ClipboardContent();
                Potatomine potatomineplant=new Potatomine(Main.getCurrentPlayer().getPlayerGame().getCurrentLevel());
                Image peashootergif = potatomineplant.getMyimage();
                clipboard.putImage(peashootergif);
                dragboard.setContent(clipboard);
                PlantsPlaced.add(potatomineplant);
                ImageView PlantButton=(ImageView)e.getSource();
                PlantButton.setEffect(null);
                e.consume();
                fadepotatomine.setNode(PlantButton);
                fadepotatomine.play();
                SunAvailbleValue-=Potatomine.getPlantCost();
                SunAvailableLabel.setText(String.valueOf(SunAvailbleValue));
                Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().setSunValue(SunAvailbleValue);

            }
        });

        Label NameLabel=new Label();
        NameLabel.setPrefWidth(71);
        NameLabel.setPrefHeight(33);
        NameLabel.setLayoutX(64);
        NameLabel.setLayoutY(27);
        NameLabel.setText(CurrentPlayer.getName());
        NameLabel.setBlendMode(BlendMode.MULTIPLY);

//        GridPane Tile1=new GridPane();
////        Tile1.
        SunAvailableLabel.setPrefWidth(38);
        SunAvailableLabel.setPrefHeight(26);
        SunAvailableLabel.setLayoutX(23);
        SunAvailableLabel.setLayoutY(62);
        SunAvailableLabel.setText( String.valueOf(Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().getSunValue()));
        SunAvailbleValue= (int) Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().getSunValue();
//        SunAvailbleValue=500;
//        Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().setSunValue(SunAvailbleValue);

        SunAvailableLabel.setBlendMode(BlendMode.DARKEN);

//        Image Zombie = new Image("sample/zombie_normal.gif");
//        SelectedZombie.setImage(Zombie);
//        SelectedZombie.setFitHeight(70);
//        SelectedZombie.setFitWidth(46.6);
//        SelectedZombie.relocate(560, 240);
//        KeyFrame kf1 = new KeyFrame(Duration.millis(50), new SelectedZombieCollisionHandler());
//        Timeline timeline = new Timeline(kf1);
////        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(35), new KeyValue(SelectedZombie.layoutXProperty(),200)));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
//
//
//        Image Pea = new Image("sample/Pea.png");
//        ShootPea.setImage(Pea);
//        ShootPea.setFitHeight(15);
//        ShootPea.setFitWidth(15);
//        ShootPea.relocate(200, 260);
//        KeyFrame kf2 = new KeyFrame(Duration.millis(10), event ->{
//            ShootPea.setLayoutX(ShootPea.getLayoutX()+1);
//            if (ShootPea.getLayoutX()>SelectedZombie.getLayoutX())
//            {
//                ShootPea.setImage(null);
////                System.out.println("collllision");
//            }
//        });
//
//
////        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(5), new KeyValue(ShootPea.layoutXProperty(),600)));
//        Timeline timeline2 = new Timeline(kf2);
//        timeline2.setCycleCount(Animation.INDEFINITE);
//        timeline2.play();
//
//        final ImageView SelectedPlant = new ImageView();
//        Image PeaShooter = new Image("sample/pea_shooter.gif");
//        SelectedPlant.setImage(PeaShooter);
//        SelectedPlant.setFitHeight(50);
//        SelectedPlant.setFitWidth(40);
//        SelectedPlant.setX(165);
//        SelectedPlant.setY(245);


//        final ImageView Sun = new ImageView();
//        Image suntoken = new Image("sample/sun.gif");
//        Sun.setImage(suntoken);
//        Sun.setFitHeight(45);
//        Sun.setFitWidth(45);
//        Line linesun=new Line(100,100,100,400);
//
//        PathTransition transtionsun=new PathTransition();
//        transtionsun.setNode(Sun);
////        transtion.setDelay(Duration.seconds(20));
//        transtionsun.setDuration(Duration.seconds(10));
//        transtionsun.setPath(linesun);
//        transtionsun.setCycleCount(1);
//        transtionsun.play();
//        Sun.setOnMouseClicked(new EventHandler<MouseEvent>(){
//
//            @Override
//            public void handle(MouseEvent event) {
//                Sun.setImage(null);
//            }
//        });




        ImageView OkButton=(ImageView)mouseEvent.getSource();
        OkButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));

//        tableparent = (Group) tableparent;
//        ((Group) tableparent).getChildren().add()
//        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(2), new KeyValue(Sun.layoutYProperty(),400)));

        root2.getChildren().add(tableparent);
        Level L1 = Main.getCurrentPlayer().getPlayerGame().getCurrentLevel();
//        Level L1 = new Level(root2);
        L1.setRootforLevel1(root2);
        L1.setRootforLevel1(root2);
        SunCreation();

//        PeaShooter P1 = new PeaShooter(root2,L1);

        //        root2.getChildren().add(Sun);
        if(PeaShooterSelectionStatus)
            root2.getChildren().add(PeaShooterCard);
        if(SunFLowerSelectionStatus)
            root2.getChildren().add(SunFlowerCard);
        if(PotatoMineSelectionStatus)
            root2.getChildren().add(PotatoMineCard);
        if(WallNutSelectionStatus)
            root2.getChildren().add(WallNutCard);
        root2.getChildren().add(SunAvailableLabel);
        root2.getChildren().add(NameLabel);

        Scene tablescene =new Scene(root2);
        Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tablescene);
        window.show();

        System.out.println("PlayReleased");

    }

    public static Label getSunAvailableLabel() {
        return SunAvailableLabel;
    }

    public static int getSunAvailbleValue() {
        return SunAvailbleValue;
    }

    public static void setSunAvailbleValue(int sunAvailbleValue) {
        SunAvailbleValue = sunAvailbleValue;
    }
}