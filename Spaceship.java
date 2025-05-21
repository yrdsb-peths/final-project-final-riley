import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spaceship extends Actor {
    public void act() {
        if (Greenfoot.isKeyDown("left")) move(-5);
        if (Greenfoot.isKeyDown("right")) move(5);
        checkCollision();
    }

    public void checkCollision() {
        if (isTouching(Asteroid.class)) {
            Greenfoot.setWorld(new EndScreen());
        }
    }
}
