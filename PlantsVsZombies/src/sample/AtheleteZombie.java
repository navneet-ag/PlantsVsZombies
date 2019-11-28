package sample;

public class AtheleteZombie extends Zombie{

    private Boolean JumpStatus;

    public Boolean getJumpStatus() {
        return JumpStatus;
    }

    public void setJumpStatus(Boolean jumpStatus) {
        JumpStatus = jumpStatus;
    }

    protected float Attack()
    {
        return 0;
    }

    public void Jump()
    {

    }
}
