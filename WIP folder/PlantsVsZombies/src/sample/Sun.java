package sample;

import java.io.Serializable;

public class Sun implements Serializable {


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

    public float getxFinal() {
        return xFinal;
    }

    public void setxFinal(float xFinal) {
        this.xFinal = xFinal;
    }

    public float getyFinal() {
        return yFinal;
    }

    public void setyFinal(float yFinal) {
        this.yFinal = yFinal;
    }

    public float getSunValue() {
        return SunValue;
    }

    public void setSunValue(float sunValue) {
        SunValue = sunValue;
    }

    public Boolean getCollectStatus() {
        return CollectStatus;
    }

    public void setCollectStatus(Boolean collectStatus) {
        CollectStatus = collectStatus;
    }

    protected float x;
    protected float y;
    protected float xFinal;
    protected float yFinal;
    protected float SunValue;
    protected Boolean CollectStatus;

    public void Sun()
    {

    }

}
