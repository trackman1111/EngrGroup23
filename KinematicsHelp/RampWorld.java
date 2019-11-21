import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RampWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RampWorld extends World
{

    /**
     * Constructor for objects of class RampWorld.
     * 
     */
    public RampWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        Ramp ramp = new Ramp();
        addObject(ramp, 300, 300);
        
        ExitButton eB = new ExitButton();
        GreenfootImage image = new GreenfootImage("BackButton2.png");
        image.scale(50, 50);
        eB.setImage(image);
        addObject(eB, 45, 45);
    }
}
