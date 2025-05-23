import greenfoot.*;

public class Spaceship extends Actor {
    private boolean isFrozenLook = false;

    public Spaceship() {
        setImage("spaceship.png");
    }

    public void act() {
        handleMovement();
        updateAppearance();
        checkCollision();
    }

    private void handleMovement() {
        if (Greenfoot.isKeyDown("left")) move(-5);
        if (Greenfoot.isKeyDown("right")) move(5);
    }

    private void updateAppearance() {
        MyWorld world = (MyWorld) getWorld();
        if (world.isFrozen() && !isFrozenLook) {
            setImage("spaceship_frozen.png");
            isFrozenLook = true;
        } else if (!world.isFrozen() && isFrozenLook) {
            setImage("spaceship.png");
            isFrozenLook = false;
        }
    }

    private void checkCollision() {
        if (isTouching(Asteroid.class)) {
            Greenfoot.setWorld(new EndScreen());
        }
    }
}
