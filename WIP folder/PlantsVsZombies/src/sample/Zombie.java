package sample;

import javafx.scene.image.ImageView;

public class Zombie extends Avatar {

    protected float AttackPower;
    protected int Speed;
    protected int Level;
    protected Boolean MoveStatus;
    protected float DefensePower;

    public  ImageView getSelectedZombie() {
        return SelectedZombie;
    }

    public void setSelectedZombie(ImageView selectedZombie) {
        SelectedZombie = selectedZombie;
    }

    protected  transient ImageView SelectedZombie = new ImageView();
    public float getAttackPower() {
        return AttackPower;
    }

    public void setAttackPower(float attackPower) {
        AttackPower = attackPower;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public Boolean getMoveStatus() {
        return MoveStatus;
    }

    public void setMoveStatus(Boolean moveStatus) {
        MoveStatus = moveStatus;
    }

    public float getDefensePower() {
        return DefensePower;
    }

    public void setDefensePower(float defensePower) {
        DefensePower = defensePower;
    }




    protected float Attack()
    {
        return 0;
    }
    protected void Die()
    {

    }


}
