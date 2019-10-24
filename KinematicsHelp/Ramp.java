import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ramp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ramp extends Actor
{
    
    public Ramp() {
        setImage(new GreenfootImage("ramp.jpg"));
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 700, image.getHeight() - 900);
        setImage(image);
      
    }
    
    /**
     * Act - do whatever the Ramp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
