import greenfoot.*;
import greenfoot.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (Riley) 
 * @version (May 2025)
 */
public class MyWorld extends World {
    private int score = 0;
    private int difficulty = 0;
    private int timeCounter = 0;

    private boolean freezeActive = false;
    private int freezeTimer = 0;
    private int freezeCooldown = 0;

    public MyWorld() {
        super(600, 400, 1);
        setBackground("space_background.jpg");
        addObject(new Spaceship(), getWidth() / 2, getHeight() - 50);
    }

    public void act() {
        handleFreezeCheat();

        if (Greenfoot.getRandomNumber(100) < 4) {
            addObject(new Asteroid(difficulty), Greenfoot.getRandomNumber(getWidth()), 0);
        }

        timeCounter++;
        if (timeCounter % 60 == 0) {
            score++;
            if (score % 10 == 0) difficulty++;
        }

        showText("Score: " + score, 70, 20);
        showText("C to Freeze (" + (freezeCooldown / 60) + "s)", 500, 20);
    }

    private void handleFreezeCheat() {
        if (freezeCooldown > 0) freezeCooldown--;

        if (!freezeActive && freezeCooldown <= 0 && Greenfoot.isKeyDown("c")) {
            freezeActive = true;
            freezeTimer = 120; // 2 seconds
            freezeCooldown = 600; // 10 seconds
        }

        if (freezeActive) {
            freezeTimer--;
            if (freezeTimer <= 0) freezeActive = false;
        }
    }

    public boolean isFrozen() {
        return freezeActive;
    }
}
