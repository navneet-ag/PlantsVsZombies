package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Avatar implements Serializable {
    protected float x;
    protected float y;
    protected float Health;
    protected Boolean LifeStatus;
    protected ImageView Myavatar;

    protected Image Myimage;

    public Image getMyimage() {
        return Myimage;
    }

    public void setMyimage(Image myimage) {
        Myimage = myimage;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void reduceHealth(float health) {
        Health -= health;
    }

    public void setLifeStatus(Boolean lifeStatus) {
        LifeStatus = lifeStatus;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getHealth() {
        return Health;
    }

    public void setHealth(float health) {
        Health = health;
    }

    public Boolean getLifeStatus() {
        return LifeStatus;
    }

    public void setMyavatar(ImageView myavatar) {
        Myavatar = myavatar;
    }

    public ImageView getMyavatar() {
        return Myavatar;
    }

    protected void Die()
    {

    }
}
