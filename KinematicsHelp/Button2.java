import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button2 extends Actor
{
    /**
     * Act - do whatever the Button2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int worldNumber;
    public Button2(int worldNumber)
    {
           this.worldNumber = worldNumber; 
    }
    public void act() 
    {
           
        if (Greenfoot.mouseClicked(this) && worldNumber == 1) {
            Greenfoot.setWorld(new MyWorld());
        }
        if (Greenfoot.mouseClicked(this) && worldNumber == 2) {
            Greenfoot.setWorld(new RampWorld());
        }
        if (Greenfoot.mouseClicked(this) && worldNumber == 3) {
            Greenfoot.setWorld(new CarWorld());
        }
    }
}
