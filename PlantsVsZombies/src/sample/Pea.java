package sample;

import java.io.Serializable;

public class Pea implements Serializable {

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

    public float getPeaPower() {
        return PeaPower;
    }

    public void setPeaPower(float peaPower) {
        PeaPower = peaPower;
    }

    public Boolean getHitStatus() {
        return HitStatus;
    }

    public void setHitStatus(Boolean hitStatus) {
        HitStatus = hitStatus;
    }

    protected float x;
    protected float y;
    protected float PeaPower;
    protected Boolean HitStatus;


    public void RemovePea()
    {

    }
}
