import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 780 x 600 cells with a cell size of 1x1 pixels.
        super(780, 600, 1); 
        addObject(new MenuSelectCar(), 400 , 400);
        showText("Braking Distance", 400, 450);
        addObject(new MenuSelectLaunch(), 600 , 400);
        showText("Launch Distance", 600, 450);
        addObject(new MenuSelectRamp(), 200 , 400);
        showText("Ramp Velocity", 200, 450);
    }
}
