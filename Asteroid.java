import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor {
    private int speed;

    public Asteroid(int difficulty) {
        this.speed = 2 + difficulty;
    }

    public void act() {
        setLocation(getX(), getY() + speed);
        if (getY() > getWorld().getHeight()) {
            getWorld().removeObject(this);
        }
    }
}
