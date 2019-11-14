import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuSelectRamp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuSelectRamp extends Actor
{
    /**
     * Act - do whatever the MenuSelectRamp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MenuSelectRamp() {
        GreenfootImage image = getImage();
        image.scale(30, 30);
        setImage(image);
    }
    
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new RampWorld());
        }
    }    
}
