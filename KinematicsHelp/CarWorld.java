import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarWorld extends World
{

    /**
     * Constructor for objects of class CarWorld.
     * 
     */
    public CarWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        addObject(new Car(),100,400);
    }
}
