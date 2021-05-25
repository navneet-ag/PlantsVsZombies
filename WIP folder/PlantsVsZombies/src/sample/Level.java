package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable {
    transient ProgressBar progressBar = new ProgressBar(0);
    double progress=.1;

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    private int LevelNumber;
    private String PlanttobeUnLocked;
    private int GridSize;
    private float SunValue=400;
    private ArrayList<LawnMover> LawnMoversList = new ArrayList<LawnMover>();
    private ArrayList<Zombie> ZombiesList = new ArrayList<Zombie>();
    private ArrayList<Plant> PlantsList = new ArrayList<Plant>();
    private transient  Group root;

    private static int ZombiePass=0;
    public int getLevelNumber() {
        return LevelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        LevelNumber = levelNumber;
    }

    public String getPlanttobeUnLocked() {
        return PlanttobeUnLocked;
    }

    public ArrayList<Plant> getPlantsList() {
        return PlantsList;
    }

    public void setPlantsList(ArrayList<Plant> plantsList) {
        PlantsList = plantsList;
    }



    public Level( int LevelNumber)
    {
        this.setLevelNumber(LevelNumber);
//        progressBar.setProgress(100);
        progressBar.relocate(409,432);
        progressBar.setBlendMode(BlendMode.EXCLUSION);
        progressBar.setPrefWidth(200);
//        progressBar.setLayoutX(400);
//        progressBar.setLayoutY(200);


    }




    public void RemoveZombie(Zombie Z)
    {
        ZombiesList.remove(Z);
    }

//    public Level(Group root2)
//    {
//
//        NormalZombie NZ01= new NormalZombie(600,95, root2,this);
//        NormalZombie NZ02= new NormalZombie(650,215, root2,this);
//        NormalZombie NZ1= new NormalZombie(900,95, root2,this);
//        NormalZombie NZ2= new NormalZombie(900,150, root2,this);
//        NormalZombie NZ3= new NormalZombie(900,215, root2,this);
//        NormalZombie NZ4= new NormalZombie(900,275, root2,this);
//        NormalZombie NZ5= new NormalZombie(900,340, root2,this);
//        ZombiesList.add(NZ01);
//        ZombiesList.add(NZ02);
//        ZombiesList.add(NZ1);
//        ZombiesList.add(NZ2);
//        ZombiesList.add(NZ3);
//        ZombiesList.add(NZ4);
//        ZombiesList.add(NZ5);
//    }

//
//    private class ZombiePassHandler implements EventHandler<ActionEvent>
//    {
//
//
//        @Override
//        public void handle(ActionEvent actionEvent) {
//
//
//
//
//        }
//    }

    public void CreateZombieL1P0(Group root2)
    {
        NormalZombie NZ01= new NormalZombie(600,95, root2,this);
        NormalZombie NZ02= new NormalZombie(650,215, root2,this);


        ZombiesList.add(NZ01);
        ZombiesList.add(NZ02);
    }


    public void CreateZombieL1P1(Group root2)
    {

        NormalZombie NZ1= new NormalZombie(1900,95, root2,this);
        NormalZombie NZ2= new NormalZombie(1900,150, root2,this);
        NormalZombie NZ3= new NormalZombie(1900,215, root2,this);
        NormalZombie NZ4= new NormalZombie(1900,275, root2,this);
        NormalZombie NZ5= new NormalZombie(1900,340, root2,this);


        ZombiesList.add(NZ1);
        ZombiesList.add(NZ2);
        ZombiesList.add(NZ3);
        ZombiesList.add(NZ4);
        ZombiesList.add(NZ5);

    }

    public void CreateZombieL2P0(Group root2)
    {
        NormalZombie NZ1= new NormalZombie(700,95, root2,this);
        NormalZombie NZ2= new NormalZombie(700,150, root2,this);
        NormalZombie NZ3= new NormalZombie(700,215, root2,this);
        NormalZombie NZ4= new NormalZombie(700,275, root2,this);
        NormalZombie NZ5= new NormalZombie(700,340, root2,this);


        ZombiesList.add(NZ1);
        ZombiesList.add(NZ2);
        ZombiesList.add(NZ3);
        ZombiesList.add(NZ4);
        ZombiesList.add(NZ5);
    }
    public void CreateZombieL2P1(Group root2)
    {
        NormalZombie NZ1= new NormalZombie(1600,95, root2,this);
        NormalZombie NZ2= new NormalZombie(1600,150, root2,this);
        NormalZombie NZ3= new NormalZombie(1600,215, root2,this);
        NormalZombie NZ4= new NormalZombie(1600,275, root2,this);
        NormalZombie NZ5= new NormalZombie(1600,340, root2,this);


        ZombiesList.add(NZ1);
        ZombiesList.add(NZ2);
        ZombiesList.add(NZ3);
        ZombiesList.add(NZ4);
        ZombiesList.add(NZ5);
    }


    public void CreateZombieL3P0(Group root2)
    {
        AthleteZombie NZ01= new AthleteZombie(600,95, root2,this);
        AthleteZombie NZ02= new AthleteZombie(650,215, root2,this);


        ZombiesList.add(NZ01);
        ZombiesList.add(NZ02);
    }

    public void CreateZombieL3P1(Group root2)
    {

        NormalZombie NZ1= new NormalZombie(1900,95, root2,this);
        AthleteZombie NZ2= new AthleteZombie(1900,150, root2,this);
        NormalZombie NZ3= new NormalZombie(1900,215, root2,this);
        AthleteZombie NZ4= new AthleteZombie(1900,275, root2,this);
        NormalZombie NZ5= new NormalZombie(1900,340, root2,this);


        ZombiesList.add(NZ1);
        ZombiesList.add(NZ2);
        ZombiesList.add(NZ3);
        ZombiesList.add(NZ4);
        ZombiesList.add(NZ5);

    }


    public void CreateZombieL4P0(Group root2)
    {
        CreateZombieL3P1(root2);
    }

    public void CreateZombieL4P1(Group root2)
    {

        AthleteZombie NZ1= new AthleteZombie(1900,95, root2,this);
        AthleteZombie NZ2= new AthleteZombie(1900,150, root2,this);
        AthleteZombie NZ3= new AthleteZombie(1900,215, root2,this);
        AthleteZombie NZ4= new AthleteZombie(1900,275, root2,this);
        AthleteZombie NZ5= new AthleteZombie(1900,340, root2,this);


        ZombiesList.add(NZ1);
        ZombiesList.add(NZ2);
        ZombiesList.add(NZ3);
        ZombiesList.add(NZ4);
        ZombiesList.add(NZ5);

    }

    public void CreateZombieL5P0(Group root2)
    {
        CreateZombieL1P1(root2);
    }
    public void CreateZombieL5P1(Group root2)
    {
        CreateZombieL4P1(root2);
    }
    public void CreateZombieL5P2(Group root2)
    {
        AthleteZombie NZ1= new AthleteZombie(2400,95, root2,this);
        AthleteZombie NZ2= new AthleteZombie(2400,150, root2,this);
        AthleteZombie NZ3= new AthleteZombie(2400,215, root2,this);
        AthleteZombie NZ4= new AthleteZombie(2400,275, root2,this);
        AthleteZombie NZ5= new AthleteZombie(2400,340, root2,this);


        ZombiesList.add(NZ1);
        ZombiesList.add(NZ2);
        ZombiesList.add(NZ3);
        ZombiesList.add(NZ4);
        ZombiesList.add(NZ5);
    }





    public void setRootforLevel1(Group root2)

    {



        this.root=root2;

//        NormalZombie NZ1= new NormalZombie(900,95, root2,this);
//        NormalZombie NZ2= new NormalZombie(900,150, root2,this);
//        NormalZombie NZ3= new NormalZombie(900,215, root2,this);
//        NormalZombie NZ4= new NormalZombie(900,275, root2,this);
//        NormalZombie NZ5= new NormalZombie(900,340, root2,this);

//        ZombiesList.add(NZ1);
//        ZombiesList.add(NZ2);
//        ZombiesList.add(NZ3);
//        ZombiesList.add(NZ4);
//        ZombiesList.add(NZ5);

//        root.getChildren().add(progressBar);

        LawnMover M1 = new LawnMover(115, 110,root2,this);
        LawnMover M2 = new LawnMover(115, 165,root2,this);
        LawnMover M3 = new LawnMover(115, 230,root2,this);
        LawnMover M4 = new LawnMover(115, 290,root2,this);
        LawnMover M5 = new LawnMover(110, 355,root2,this);


        LawnMoversList.add(M1);
        LawnMoversList.add(M2);
        LawnMoversList.add(M3);
        LawnMoversList.add(M4);
        LawnMoversList.add(M5);

        KeyFrame kf2 = new KeyFrame(Duration.seconds(5), event -> {


            progress= (float) (progress+0.005);
            progressBar.setProgress(progress);

            if (LevelNumber==1) {
                if (ZombiePass == 0) {
                    CreateZombieL1P0(root);

                    ZombiePass++;
                } else if (ZombiePass == 1) {
                    CreateZombieL1P1(root);
                    ZombiePass++;
                }
            }
            else if (LevelNumber==2) {
                if (ZombiePass == 0) {
                    System.out.println("wave1");
                    CreateZombieL2P0(root);
                    ZombiePass++;
                } else if (ZombiePass == 1) {
                    System.out.println("wave2");
                    CreateZombieL2P1(root);
                    ZombiePass++;
                }
            }
            else if (LevelNumber==3) {
                if (ZombiePass == 0) {
                    CreateZombieL3P0(root);
                    ZombiePass++;
                } else if (ZombiePass == 1) {
                    CreateZombieL3P1(root);
                    ZombiePass++;
                }
            }
            else if (LevelNumber==4) {
                if (ZombiePass == 0) {
                    CreateZombieL4P0(root);
                    ZombiePass++;
                } else if (ZombiePass == 1) {
                    CreateZombieL4P1(root);
                    ZombiePass++;
                }
            }
            else if (LevelNumber==5) {

                if (ZombiePass == 0) {

                    System.out.println(getZombiesList().size());

//                    progressBar.setProgress(.10);
                    System.out.println("wave1");
                    CreateZombieL5P0(root);
                    ZombiePass++;



                } else if (ZombiePass == 1) {


                    System.out.println(getZombiesList().size());


//                    progressBar.setProgress(.60);
                    System.out.println("wave2");
                    CreateZombieL5P1(root);
                    ZombiePass++;


                }
                else if (ZombiePass == 2) {


                    System.out.println(getZombiesList().size());
//                    progressBar.setProgress(.90);
                    System.out.println("wave3");
                    CreateZombieL5P2(root);
                    ZombiePass++;


//                    if (getZombiesList().get(1).getX()<600)
//                    {
//                        progressBar.setProgress(.3);
//                    }
//                    if (getZombiesList().get(6).getX()<600)
//                    {
//                        progressBar.setProgress(.6);
//                    }
//                    if (getZombiesList().get(11).getX()<600)
//                    {
//                        progressBar.setProgress(.9);
//                    }



                }

            }




        });

        Timeline timeline2 = new Timeline(kf2);
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();

//        KeyFrame kf4 = new KeyFrame(Duration.millis(500), event -> {
//
//            System.out.println("Pass" + ZombiePass);
//            System.out.println("elements" + getZombiesList().size());
//
//            if (ZombiePass>2) {
//
//                System.out.println("jhv");
//
//                if (getZombiesList().get(1).getX() < 600) {
//                    progressBar.setProgress(.3);
//                }
//                if (getZombiesList().get(5).getX() < 600) {
//                    progressBar.setProgress(.6);
//                }
//                if (getZombiesList().get(10).getX() < 600) {
//                    progressBar.setProgress(.9);
//                }
//            }
//
//        });
//
//        Timeline timeline4 = new Timeline(kf4);
//        timeline4.setCycleCount(Animation.INDEFINITE);
//        timeline4.play();



    }

    public Group getRoot() {
        return root;
    }
    //    private void AddZombies(int x, int y, Group root2)
//    {
//
//        final ImageView SelectedZombie = new ImageView();
//        Image Zombie = new Image("sample/zombie_normal.gif");
//        SelectedZombie.setImage(Zombie);
//        SelectedZombie.setFitHeight(70);
//        SelectedZombie.setFitWidth(46.6);
////        SelectedZombie.relocate(560, 240);
//        SelectedZombie.relocate(x,y);
////        KeyFrame kf1 = new KeyFrame(Duration.millis(50), new SelectedZombieCollisionHandler());
//        KeyFrame kf3 = new KeyFrame(Duration.millis(50), event ->{
//            SelectedZombie.setLayoutX(SelectedZombie.getLayoutX()-1);
//
//        });
//        Timeline timeline = new Timeline(kf3);
////        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(35), new KeyValue(SelectedZombie.layoutXProperty(),200)));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
//        root2.getChildren().add(SelectedZombie);
//    }


    public String getPlanttobeLocked() {
        return PlanttobeUnLocked;
    }

    public void setPlanttobeUnLocked(String PlanttobeUnLocked) {
        this.PlanttobeUnLocked = PlanttobeUnLocked;
    }

    public int getGridSize() {
        return GridSize;
    }

    public void setGridSize(int gridSize) {
        GridSize = gridSize;
    }

    public float getSunValue() {
        return SunValue;
    }

    public void setSunValue(float sunValue) {
        SunValue = sunValue;
    }

    public ArrayList<LawnMover> getLawnMoversList() {
        return LawnMoversList;
    }

    public void setLawnMoversList(ArrayList<LawnMover> lawnMoversList) {
        LawnMoversList = lawnMoversList;
    }

    public ArrayList<Zombie> getZombiesList() {
        return ZombiesList;
    }

    public void setZombiesList(ArrayList<Zombie> zombiesList) {
        ZombiesList = zombiesList;
    }
}
