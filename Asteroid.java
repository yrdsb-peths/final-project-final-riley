import greenfoot.*;
/**
 * Write a description of class Asteroid here.
 * 
 * @author (Riley) 
 * @version (May 2025)
 */
public class Asteroid extends Actor {
    private int speed;

    public Asteroid(int difficulty) {
        speed = 1 + difficulty;
        setImage("asteroid.png");
    }

    public void act() {
        MyWorld world = (MyWorld) getWorld();
        if (world != null && world.isFrozen()) return;

        setLocation(getX(), getY() + speed);

        if (getY() > getWorld().getHeight()) {
            getWorld().removeObject(this);
        }
    }
}

