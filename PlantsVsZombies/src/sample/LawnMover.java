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

public class LawnMover {


    private class CheckZombieHandler implements EventHandler<ActionEvent>
    {


        @Override
        public void handle(ActionEvent actionEvent) {

            CheckZombie(root2, L1);

        }
    }

    Group root2;
    Level L1;


    private float x;
    private float y;
    private float Speed;
    private Boolean UseStatus;
    final ImageView LawnMoverView = new ImageView();
    public LawnMover(int x, int y,Group root2, Level L1)
    {
        Speed=5;
        UseStatus=false;


        Image LawnMoverImg = new Image("sample/lawn_mover.gif");
        LawnMoverView.setImage(LawnMoverImg);
        LawnMoverView.setFitHeight(50);
        LawnMoverView.setFitWidth(40);
        LawnMoverView.setX(x);
        LawnMoverView.setY(y);
        this.setX(x);
        this.setY(y);
        this.L1=L1;
        this.root2=root2;


        root2.getChildren().add(LawnMoverView);


        Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(1),new LawnMover.CheckZombieHandler()));
        timeline3.setCycleCount(Animation.INDEFINITE);

        timeline3.play();



    }

    protected void CheckZombie(Group root2, Level L1)
    {

//        System.out.println("chvcjbx");
        int i=0;
        while (i<L1.getZombiesList().size() && !UseStatus)
        {

//            System.out.println("inside");
            if (this.getY()-L1.getZombiesList().get(i).getY() ==15 )
            {

//                System.out.println(L1.getZombiesList().get(i).getX() + "       "+ this.getX());
                if(L1.getZombiesList().get(i).getX()-this.getX()<51)
                {


                    System.out.println("inside if");
                    KeyFrame kf2 = new KeyFrame(Duration.millis(25), event ->{
                        LawnMoverView.setLayoutX(LawnMoverView.getLayoutX()+1);

                        if(LawnMoverView.getLayoutX()>500)
                        {
                            LawnMoverView.setVisible(false);
                            this.UseStatus=false;

//                System.out.println("yes");
                        }

                        int j=0;
                        while (j<L1.getZombiesList().size() )
                        {
                            if (this.getY()-L1.getZombiesList().get(j).getY() ==15 ) {
                                if (L1.getZombiesList().get(j).getX()-this.getX()<51) {

                                    L1.getZombiesList().get(j).setHealth(0);
                                    if(L1.getZombiesList().get(j).getHealth()<=0)
                                    {
                                        L1.RemoveZombie(L1.getZombiesList().get(j));
                                        j--;
                                    }

                                }
                            }
                            j++;
                        }





                    });


                    Timeline timeline2 = new Timeline(kf2);
                    timeline2.setCycleCount(Animation.INDEFINITE);
                    timeline2.play();
                }

            }

            i++;
//        KeyFrame kf2 = new KeyFrame(Duration.millis(25), event ->{
//            });
//
//        Timeline timeline2 = new Timeline(kf2);
//        timeline2.setCycleCount(Animation.INDEFINITE);
//        timeline2.play();
//
        }







    }



    public Group getRoot2() {
        return root2;
    }

    public void setRoot2(Group root2) {
        this.root2 = root2;
    }

    public Level getL1() {
        return L1;
    }

    public void setL1(Level l1) {
        L1 = l1;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return Speed;
    }

    public void setSpeed(float speed) {
        Speed = speed;
    }

    public Boolean getUseStatus() {
        return UseStatus;
    }

    public void setUseStatus(Boolean useStatus) {
        UseStatus = useStatus;
    }

    public ImageView getLawnMoverView() {
        return LawnMoverView;
    }
}

