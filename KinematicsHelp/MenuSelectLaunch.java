import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuSelectLaunch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuSelectLaunch extends Actor
{
    /**
     * Act - do whatever the MenuSelectLaunch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld());
        }
    }    
}
