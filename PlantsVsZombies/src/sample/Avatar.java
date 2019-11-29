package sample;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Avatar implements Serializable {
    protected float x;
    protected float y;
    protected float Health;
    protected Boolean LifeStatus;
    protected ImageView Myavatar;
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setHealth(float health) {
        Health = health;
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

    public Boolean getLifeStatus() {
        return LifeStatus;
    }

    protected void Die()
    {

    }
}
