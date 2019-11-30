package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public class Level {
    private int LevelNumber;
    private String PlanttobeUnLocked;
    private int GridSize;
    private float SunValue;
    private ArrayList<LawnMover> LawnMoversList = new ArrayList<LawnMover>();
    private ArrayList<Zombie> ZombiesList = new ArrayList<Zombie>();
    private ArrayList<Plant> PlantsList = new ArrayList<Plant>();
    private Group root;
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



    public Level()
    {

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
    public void setRootforLevel1(Group root2)
    {
        this.root=root2;
        NormalZombie NZ01= new NormalZombie(600,95, root2,this);
        NormalZombie NZ02= new NormalZombie(650,215, root2,this);
        NormalZombie NZ1= new NormalZombie(900,95, root2,this);
        NormalZombie NZ2= new NormalZombie(900,150, root2,this);
        NormalZombie NZ3= new NormalZombie(900,215, root2,this);
        NormalZombie NZ4= new NormalZombie(900,275, root2,this);
        NormalZombie NZ5= new NormalZombie(900,340, root2,this);
        ZombiesList.add(NZ01);
        ZombiesList.add(NZ02);
        ZombiesList.add(NZ1);
        ZombiesList.add(NZ2);
        ZombiesList.add(NZ3);
        ZombiesList.add(NZ4);
        ZombiesList.add(NZ5);

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
