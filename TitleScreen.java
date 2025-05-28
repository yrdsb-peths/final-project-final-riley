import greenfoot.*;
/**
 * Write a description of class TitleScreen here.
 * 
 * @author (Riley) 
 * @version (May 2025)
 */
public class TitleScreen extends World {
    public TitleScreen() {
        super(600, 400, 1);
        setBackground("title_background.jpg");
        showText("ASTEROID DODGER", 300, 150);
        showText("Press SPACE to start", 300, 200);
        showText("Use ← → to move, C to Freeze", 300, 250);
    }

    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}

