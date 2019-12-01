package sample;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainMenuController extends Controller{
    private static Label SunAvailableLabel=new Label();
    private static int SunAvailbleValue=0;

    final ImageView SelectedZombie = new ImageView();
    final ImageView ShootPea = new ImageView();
    Group root2=new Group();
    Random Ran = new Random();

    private static int numberofplants=0;
    private static  Boolean PeaShooterOn=true;
    private static Boolean PotatoMineOn=true;
    Image SunflowerButtonOn=new Image("sample/SunflowerSelected.png");
    Image SunflowerButtonOff=new Image("sample/Sunflower.png");
    Image WallNutButtonOn=new Image("sample/WallNutSelected.png" );
    Image WallNutButtonOff=new Image("sample/Wall-nut.png");
    Image PotatoMineButtonOn=new Image("sample/PotatoMineSelected.png" );
    Image PotatoMineButtonOff=new Image("sample/Potato_Mine.png");

    private static Boolean SunflowerOn=true;
    private static Boolean WallNutOn=true;
    private static ImageView WallNutView= new ImageView("sample/Wall-nut1.png");
    private static ImageView PotatoMineView= new ImageView("sample/Potato_Mine1.png");
    private static ImageView PeaShooterView=new ImageView("sample/Peashooter1.png") ;
    private static ImageView SunFLowerView=  new ImageView("sample/Sunflower1.png");
    private static ImageView RepeaterView= new ImageView("sample/Repeater1.png");
    private static ImageView TallNutView= new ImageView("sample/Tall-nut1.png");
    private static ImageView TwinSunFlowerView= new ImageView("sample/Twin_Sunflower1.png");
    private static ImageView CherryBombView= new ImageView("sample/Cherry_Bomb1.png");
    private static ImageView SnowPeaView= new ImageView("sample/Snow_Pea1.png");
    private static ImageView ChomperView= new ImageView("sample/Chomper1.png");
    private static ArrayList<String> SelectedPlants=null;

    Image SoundButtonOn=new Image("sample/SoundOn.png");
    Image SoundButtonOff=new Image("sample/SoundOff.png");
    private static Boolean SoundOn=true;
    private static Boolean SoundOff=false;
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

        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(15), new MainMenuController.SunHandler()));
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
        TextField name =new TextField();
        name.setPrefWidth(209);
        name.setPrefHeight(45);
        name.setLayoutX(66+166);
        name.setLayoutY(73+113);
        name.setBlendMode(BlendMode.COLOR_BURN);
        ImageView okButton= new ImageView("sample/OK.png");
        okButton.setFitWidth(96);
        okButton.setFitHeight(71);
        okButton.setLayoutX(292);
        okButton.setLayoutY(344);
        okButton.setOnMouseReleased(e ->
        {
            {
                if (name.getText().equals("")) {
                    //Display some message name cant be empty
                } else {
                    //Check condition for player not already exiting
                    Player temp = new Player(name.getText(),1);
                    Main.setCurrentPlayer(temp);
                    SunAvailbleValue= (int) Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().getSunValue();
                    Main.getListofPlayers().add(temp);
                    ImageView OkButton = (ImageView) mouseEvent.getSource();
                    OkButton.setEffect(null);
                    Parent tableparent = null;
//                    Image WallNut = new Image("sample/Wall-nut.png");//check
//                    Image PotatoMine = new Image("sample/Potato_Mine.png");
//                    Image PeaShooter = new Image("sample/Peashooter.png");
//                    Image SunFlower = new Image("sample/Sunflower.png");
//                    Image Repeater = new Image("sample/Repeater.png");
//                    Image TallNut = new Image("sample/Tall-nut.png");
//                    Image TwinSunflower = new Image("sample/Twin_Sunflower.png");
//                    Image CherryBomb = new Image("sample/Cherry_Bomb.png");
//                    Image SnowPea = new Image("sample/Snow_Pea.png");
//                    Image Chomper = new Image("sample/Chomper.png");
                    numberofplants=temp.getSlotsAvailable();
                    SelectedPlants=temp.getPlayerGame().getSelectedPlants();

                    //Check can use design attern here

                    for(int i=0;i<temp.getUnlockedPlants().size();i++)
                    {
                        switch(temp.getUnlockedPlants().get(i))
                        {
                            case "PeaShooter": PeaShooterView=new ImageView("sample/Peashooter.png") ;
                                                PeaShooterView.setOnMouseEntered(new MouseEnter());
                                                PeaShooterView.setOnMouseExited(new MouseExit());
                                                Image PeaShooterButtonOn=new Image("sample/PeaShooterSelected.png");
                                                Image PeaShooterButtonOff=new Image("sample/Peashooter.png");
                                                PeaShooterView.setOnMouseReleased(event ->
                                                {
                                                    ImageView PeaShooterButton=(ImageView)mouseEvent.getSource();
                                                    PeaShooterButton.setEffect(null);
                                                    if(!PeaShooterOn )
                                                    {
                                                        SelectedPlants.remove("PeaShooter");
                                                        PeaShooterView.setImage(PeaShooterButtonOff);
                                                        PeaShooterOn=true;
                                                        numberofplants++;
                                                    }
                                                    else if(numberofplants>0)
                                                    {
                                                        SelectedPlants.add("PeaShooter");

                                                        PeaShooterView.setImage(PeaShooterButtonOn);
                                                        PeaShooterOn=false;
                                                        numberofplants--;
                                                    }
                                                    System.out.println("Numberofplants "+numberofplants);
                                                    System.out.println(SelectedPlants);

                                                });

                                break;
                            case "SunFlower":   SunFLowerView=  new ImageView("sample/Sunflower.png");
                                                SunFLowerView.setOnMouseEntered(new MouseEnter());
                                                SunFLowerView.setOnMouseClicked(new MouseExit());
                                                SunFLowerView.setOnMouseReleased(f ->
                                                {
                                                    ImageView SunflowerButton=(ImageView)mouseEvent.getSource();
                                                    SunflowerButton.setEffect(null);
                                                    if(!SunflowerOn )
                                                    {
                                                        SelectedPlants.remove("Sunflower");
                                                        SunFLowerView.setImage(SunflowerButtonOff);
                                                        SunflowerOn=true;
                                                        numberofplants++;
                                                    }
                                                    else if(numberofplants>0)
                                                    {
                                                        SelectedPlants.add("Sunflower");
                                                        SunFLowerView.setImage(SunflowerButtonOn);
                                                        SunflowerOn=false;
                                                        numberofplants--;
                                                    }
                                                    System.out.println("Numberofplants "+numberofplants);

                                                    System.out.println(SelectedPlants);
                                                });
                                                                break;
                            case "WallNut":    WallNutView= new ImageView("sample/Wall-nut.png");
                                            WallNutView.setOnMouseEntered(new MouseEnter());
                                            WallNutView.setOnMouseClicked(new MouseExit());
                                            WallNutView.setOnMouseReleased(f ->
                                            {
                                                ImageView SunflowerButton=(ImageView)mouseEvent.getSource();
                                                SunflowerButton.setEffect(null);
                                                if(!WallNutOn )
                                                {
                                                    SelectedPlants.remove("WallNut");

                                                    WallNutView.setImage(WallNutButtonOff);

                                                    WallNutOn=true;
                                                    numberofplants++;
                                                }
                                                else if(numberofplants>0)
                                                {
                                                    SelectedPlants.add("WallNut");

                                                    WallNutView.setImage(WallNutButtonOn);

                                                    WallNutOn=false;
                                                    numberofplants--;
                                                }
                                                System.out.println("Numberofplants "+numberofplants);
                                                System.out.println(SelectedPlants);

                                            });

                                                                        break;
                            case "Chomper":ChomperView= new ImageView("sample/Chomper.png");
                                            ChomperView.setOnMouseEntered(new MouseEnter());
                                            ChomperView.setOnMouseClicked(new MouseExit());

                                            break;
                            case "SnowPea":SnowPeaView= new ImageView("sample/Snow_Pea.png");
                                            SnowPeaView.setOnMouseEntered(new MouseEnter());
                                            SnowPeaView.setOnMouseClicked(new MouseExit());

                                            break;
                            case "CherryBomb":CherryBombView= new ImageView("sample/Cherry_Bomb.png");
                                                CherryBombView.setOnMouseEntered(new MouseEnter());
                                                CherryBombView.setOnMouseClicked(new MouseExit());

                                                break;
                            case  "TwinSunflower" : TwinSunFlowerView= new ImageView("sample/Twin_Sunflower.png");
                                                    TwinSunFlowerView.setOnMouseEntered(new MouseEnter());
                                                    TwinSunFlowerView.setOnMouseClicked(new MouseExit());

                                                    break;
                            case "PotatoMine" : PotatoMineView= new ImageView("sample/Potato_Mine.png");
                                                PotatoMineView.setOnMouseEntered(new MouseEnter());
                                                PotatoMineView.setOnMouseClicked(new MouseExit());
                                PotatoMineView.setOnMouseReleased(f ->
                                {
                                    ImageView SunflowerButton=(ImageView)mouseEvent.getSource();
                                    SunflowerButton.setEffect(null);
                                    if(!PotatoMineOn )
                                    {
                                        SelectedPlants.remove("PotatoMine");

                                        PotatoMineView.setImage(PotatoMineButtonOff);

                                        PotatoMineOn=true;
                                        numberofplants++;
                                    }
                                    else if(numberofplants>0)
                                    {
                                        SelectedPlants.add("PotatoMine");
                                        PotatoMineView.setImage(PotatoMineButtonOn);

                                        PotatoMineOn=false;
                                        numberofplants--;
                                    }
                                    System.out.println("Numberofplants "+numberofplants);
                                    System.out.println(SelectedPlants);

                                });




                                break;
                            case "Repeater":RepeaterView= new ImageView("sample/Repeater.png");
                                            RepeaterView.setOnMouseEntered(new MouseEnter());
                                            RepeaterView.setOnMouseClicked(new MouseExit());

                                            break;
                            case "TallNut":TallNutView= new ImageView("sample/Tall-nut.png");
                                            TallNutView.setOnMouseEntered(new MouseEnter());
                                            TallNutView.setOnMouseClicked(new MouseExit());
                                            break;

                        }
                    }

                    WallNutView.setLayoutY(9 + 142);
                    WallNutView.setLayoutX(8 + 180 + 101);
                    WallNutView.setFitHeight(62);
                    WallNutView.setFitWidth(63);
                    PotatoMineView.setLayoutY(9 + 142);
                    PotatoMineView.setLayoutX(8 + 270 + 101);
                    PotatoMineView.setFitHeight(62);
                    PotatoMineView.setFitWidth(63);
                    RepeaterView.setLayoutY(9 + 142);
                    RepeaterView.setLayoutX(8 + 360 + 101);
                    RepeaterView.setFitHeight(62);
                    RepeaterView.setFitWidth(63);
                    SunFLowerView.setLayoutY(9 + 142);
                    SunFLowerView.setLayoutX(8 + 91 + 101);
                    SunFLowerView.setFitHeight(62);
                    SunFLowerView.setFitWidth(63);
                    PeaShooterView.setLayoutY(9 + 142);
                    PeaShooterView.setLayoutX(8 + 2 + 101);
                    PeaShooterView.setFitHeight(62);
                    PeaShooterView.setFitWidth(63);
                    ChomperView.setLayoutY(9 + 102+142);
                    ChomperView.setLayoutX(8 + 360 + 101);
                    ChomperView.setFitHeight(62);
                    ChomperView.setFitWidth(63);
                    SnowPeaView.setLayoutY(9 + 102+142);
                    SnowPeaView.setLayoutX(8 + 270 + 101);
                    SnowPeaView.setFitHeight(62);
                    SnowPeaView.setFitWidth(63);
                    CherryBombView.setLayoutY(9 + 102 +142);
                    CherryBombView.setLayoutX(8 + 180 + 101);
                    CherryBombView.setFitHeight(62);
                    CherryBombView.setFitWidth(63);
                    TwinSunFlowerView.setLayoutY(9 + 102 +142);
                    TwinSunFlowerView.setLayoutX(8  + 101);
                    TwinSunFlowerView.setFitHeight(62);
                    TwinSunFlowerView.setFitWidth(63);
                    TallNutView.setLayoutY(9 + 102 +142);
                    TallNutView.setLayoutX(8 + 91 + 101);
                    TallNutView.setFitHeight(62);
                    TallNutView.setFitWidth(63);



                    Player current=Main.getCurrentPlayer();
                    try {
                        tableparent = FXMLLoader.load(getClass().getResource("SelectPlants.fxml"));
                    } catch (IOException ex) {
                        System.out.println("NUll is here");
                        ex.printStackTrace();
                    }
                    Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    System.out.println(window == null);

                    Group wall = new Group(tableparent, WallNutView,PeaShooterView,SunFLowerView,PotatoMineView,ChomperView,CherryBombView,TallNutView,TwinSunFlowerView,SnowPeaView,RepeaterView);
                    Scene tablescene = new Scene(wall);

                    window.setScene(tablescene);
                    window.show();
                    System.out.println("12312312");

                }
            }});

        okButton.setOnMousePressed(e->{
            ImageView OkButton=(ImageView)mouseEvent.getSource();
            Shadow shadow=new Shadow();
            shadow.setBlurType(BlurType.THREE_PASS_BOX);
            shadow.setColor(Color.rgb(14, 176, 52));
            okButton.setEffect(shadow);
        });
        okButton.setOnMouseEntered(e-> {
                String musicFile = "MouseEnter.wav";
                Media sound = new Media(new File(musicFile).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                ImageView OptionSelected=(ImageView)mouseEvent.getSource();
                Bloom bloom = new Bloom();
                bloom.setThreshold(.4);
                okButton.setEffect(bloom);

                System.out.println("MouseEntered123213213");

            });
            okButton.setOnMouseExited(e -> {
                ImageView OptionSelected=(ImageView)mouseEvent.getSource();
                okButton.setEffect(null);
                System.out.println("MouseExited");
            });


            Parent tableparent = null;
            try {
                tableparent = FXMLLoader.load(getClass().getResource("EnterName.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Group namegroup=new Group(tableparent,name,okButton);
            Scene namescene =new Scene(namegroup);
            Stage window=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            window.setScene(namescene);
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
        TextField name =new TextField();
        name.setPrefWidth(209);
        name.setPrefHeight(45);
        name.setLayoutX(66+166);
        name.setLayoutY(73+113);
        name.setBlendMode(BlendMode.COLOR_BURN);
        ImageView okButton= new ImageView("sample/OK.png");
        okButton.setFitWidth(96);
        okButton.setFitHeight(71);
        okButton.setLayoutX(292);
        okButton.setLayoutY(344);
        okButton.setOnMouseClicked(f -> {
            String name1=name.getText();
            Boolean foundstatus=false;
            for(int z=0;z<Main.getListofPlayers().size();z++)
            {
//                System.out.println(Main.getListofPlayers().get(i).getName());
                if(name.getText().equals(Main.getListofPlayers().get(z).getName()))
                {
                    System.out.println("Found");
                    Player CurrentPlayer=Main.getListofPlayers().get(z);
                    Main.setCurrentPlayer(CurrentPlayer);
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
                    System.out.println(Main.getCurrentPlayer().getPlayerGame());
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
                    SunAvailableLabel.setText(String.valueOf(Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().getSunValue()));
//                    SunAvailbleValue=500;
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
                    Parent tableparent = null;
                    try {
                        tableparent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

//        tableparent = (Group) tableparent;
//        ((Group) tableparent).getChildren().add()
//        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(2), new KeyValue(Sun.layoutYProperty(),400)));

                    root2.getChildren().add(tableparent);
                    Level L1 = Main.getCurrentPlayer().getPlayerGame().getCurrentLevel();
//        Level L1 = new Level(root2);
//                    L1.setRootforLevel1(root2);
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
//                    for(int plant=0;plant<Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().getPlantsList().size();plant++)
//
//                    {
//                        Plant p=Main.getCurrentPlayer().getPlayerGame().getCurrentLevel().getPlantsList().get(plant);
//                        if(p instanceof PeaShooter)
//                            p.get
//
//                    }

                    Scene tablescene =new Scene(root2);
                    Stage window=(Stage)((Node)f.getSource()).getScene().getWindow();
//        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tablescene);
                    window.show();

                    foundstatus=true;
                    break;
                }
            }
            if(!foundstatus)
            System.out.println("Notfound");
        });

        ImageView ResumeButton=(ImageView)mouseEvent.getSource();
        ResumeButton.setEffect(null);
        Parent tableparent = FXMLLoader.load(getClass().getResource("EnterName.fxml"));
        Group gp=new Group(tableparent,okButton,name);


        Scene tablescene =new Scene(gp);
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


    private class MouseEnter implements EventHandler< MouseEvent > {
        @Override
        public void handle(MouseEvent mouseEvent) {
            String musicFile = "MouseEnter.wav";
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            ImageView OptionSelected=(ImageView)mouseEvent.getSource();
            Bloom bloom = new Bloom();
            bloom.setThreshold(1);
            OptionSelected.setEffect(bloom);

            System.out.println("MouseEntered123213213");

        }
    }

    private class MouseExit implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            ImageView OptionSelected=(ImageView)mouseEvent.getSource();
            OptionSelected.setEffect(null);
            System.out.println("MouseExited");

        }
    }
}
