import greenfoot.*;

public class Spaceship extends Actor {
    private boolean isFrozenLook = false;

    public Spaceship(){
    GreenfootImage image = new GreenfootImage("spaceship.png");
    image.scale(image.getWidth() / 2, image.getHeight() / 2); // scale to 50%
    setImage(image);
    }
    public void act() {
        handleMovement();
        updateAppearance();
        checkCollision();
    }

    private void handleMovement() {
        if (Greenfoot.isKeyDown("left")) move(-3);
        if (Greenfoot.isKeyDown("right")) move(3);
    }

    private void updateAppearance() {
        MyWorld world = (MyWorld) getWorld();
        if (world.isFrozen() && !isFrozenLook) {
        GreenfootImage frozenImage = new GreenfootImage("spaceship_frozen.png");
        frozenImage.scale(frozenImage.getWidth() / 2, frozenImage.getHeight() / 2);
        setImage(frozenImage);
        isFrozenLook = true;
    } 
    else if (!world.isFrozen() && isFrozenLook) {
        GreenfootImage normalImage = new GreenfootImage("spaceship.png");
        normalImage.scale(normalImage.getWidth() / 2, normalImage.getHeight() / 2);
        setImage(normalImage);
        isFrozenLook = false;
    }

    }

    private void checkCollision() {
        if (isTouching(Asteroid.class)) {
            Greenfoot.setWorld(new EndScreen());
        }
    }
}
