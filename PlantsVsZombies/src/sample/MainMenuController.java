package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainMenuController extends Controller{
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
                    Player temp = new Player(name.getText());
                    Main.setCurrentPlayer(temp);

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
