package sample;

public class SpecialZombie extends Zombie implements Cloneable
{

    private Boolean CloneStatus;

    public Boolean getCloneStatus() {
        return CloneStatus;
    }

    public void setCloneStatus(Boolean cloneStatus) {
        CloneStatus = cloneStatus;
    }

    protected float Attack()
    {
        return 0;
    }
    public SpecialZombie Clone()
    {
        SpecialZombie S = null;
        return S;
    }
    private void UseClone()
    {

    }
}
