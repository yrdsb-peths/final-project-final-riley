import greenfoot.*;
/**
 * Write a description of class EndScreen here.
 * 
 * @author (Riley) 
 * @version (May 2025)
 */
public class EndScreen extends World {
    public EndScreen() {
        super(600, 400, 1);
        setBackground("end_background.jpg");
        showText("GAME OVER", 300, 180);
        showText("Press R to Restart", 300, 220);
    }

    public void act() {
        if (Greenfoot.isKeyDown("r")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
