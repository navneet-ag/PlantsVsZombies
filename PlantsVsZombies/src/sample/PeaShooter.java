
package sample;

        import javafx.animation.Animation;
        import javafx.animation.KeyFrame;
        import javafx.animation.Timeline;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Group;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.util.Duration;



public class PeaShooter extends Shooter {
    protected static float PlantCost=100;

    public static float getPlantCost() {
        return PlantCost;
    }

    private class ShootHandler implements EventHandler<ActionEvent>
    {


        @Override
        public void handle(ActionEvent actionEvent) {

            Shoot(root2, L1);

        }
    }

    Group root2;
    Level L1;
    public PeaShooter(Level L1)
    {

        this.L1=L1;
        Health=100;
        Myimage=new Image("sample/pea_shooter.gif");
        ShootingPower=20;
        PlantCost=100;
        RegenerationTime=5;

    }

    public PeaShooter(Group root2, Level L1)
    {
        this.L1=L1;
        this.root2=root2;
        Health=100;
        Myavatar=new ImageView("sample/pea_shooter.gif");
        Myavatar.setFitHeight(50);
        Myavatar.setFitWidth(40);
        ShootingPower=20;
        PlantCost=100;
        RegenerationTime=5;


        final ImageView SelectedPlant = new ImageView();
        Image PeaShooter = new Image("sample/pea_shooter.gif");
        SelectedPlant.setImage(PeaShooter);
        SelectedPlant.setFitHeight(50);
        SelectedPlant.setFitWidth(40);
        SelectedPlant.setX(405);
        SelectedPlant.setY(245);
        this.setX(405);
        this.setY(245);


        root2.getChildren().add(SelectedPlant);

        L1.getPlantsList().add(this);

        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(3),new ShootHandler()));
        timeline3.setCycleCount(Animation.INDEFINITE);

        timeline3.play();
//        Shoot(root2, L1);
    }
    public void setrootxy(Group root,double x,double y)
    {
        this.root2=root;
        System.out.println(root2);
        this.setX((float) x);
        this.setY((float) y);
        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(1),new ShootHandler()));
        timeline3.setCycleCount(Animation.INDEFINITE);
        timeline3.play();
    }
    protected void Shoot(Group root2, Level L1)
    {
        try{
            if(this!=null && !this.getLifeStatus())
                return;
        }
        catch(NullPointerException e)
        {
//            System.out.println(this);

        }

        final ImageView ShootPea = new ImageView();
        Image Pea = new Image("sample/Pea.png");
        ShootPea.setImage(Pea);
        ShootPea.setFitHeight(15);
        ShootPea.setFitWidth(15);
        ShootPea.relocate(this.getX()+30, this.getY()+15);
        KeyFrame kf2 = new KeyFrame(Duration.millis(25), event ->{

            ShootPea.setLayoutX(ShootPea.getLayoutX()+1);
            if(ShootPea.getLayoutX()>640)
            {
                ShootPea.setVisible(false);
//                System.out.println("yes");
            }
            int i=0;
            while (i<L1.getZombiesList().size())
            {
//                System.out.println("yscg");
//                System.out.println(ShootPea.getLayoutX()+"  "+ShootPea.getLayoutY());

                float range= (float) (L1.getZombiesList().get(i).getY()+45-ShootPea.getLayoutY());
                if ( range>=-5 &&(range<=5))
                {

//                    System.out.println("entered");
//                    System.out.println(ShootPea.getLayoutX());

                    if ((this.getX()<L1.getZombiesList().get(i).getX())&&ShootPea.getLayoutX() > L1.getZombiesList().get(i).getX() && ShootPea.visibleProperty().getValue() )
                    {
//                        System.out.println("jsbjbsjb");
                        ShootPea.setVisible(false);
                        L1.getZombiesList().get(i).reduceHealth(20);
                        if(L1.getZombiesList().get(i).getHealth()<=0)
                        {
                            L1.RemoveZombie(L1.getZombiesList().get(i));
                            i--;
                        }
//                      System.out.println("collllision");
                    }
                }
                i++;
            }
        });

        Timeline timeline2 = new Timeline(kf2);
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
//        System.out.println((root2));
        root2.getChildren().add(ShootPea);
    }

}