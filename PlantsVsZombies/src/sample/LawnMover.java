package sample;

import javafx.scene.image.ImageView;

public class LawnMover {


    private float x;
    private float y;
    private float Speed;
    private Boolean UseStatus;
    private ImageView Lawn;
    public LawnMover()
    {
        Lawn=new ImageView("sample/lawn_mover.gif");
        Speed=5;
        UseStatus=false;
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










    public void Die(){

    }
}
