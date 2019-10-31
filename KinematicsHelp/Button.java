import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int num;
    public Button(int worldNum)
    {
        num = worldNum;
        if ( num == 0 )
            setImage(new GreenfootImage(" Ramp Problem ", 20, Color.BLACK, Color.WHITE));
        if ( num == 1 )
            setImage(new GreenfootImage(" Launch Problem ", 20, Color.BLACK, Color.WHITE));
        if ( num == 2 )
            setImage(new GreenfootImage(" Brake Problem ", 20, Color.BLACK, Color.WHITE));
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            if ( num == 0 )
                Greenfoot.setWorld(new RampWorld());
            if ( num == 1 )
                Greenfoot.setWorld(new MyWorld());
            if ( num == 2 )
                Greenfoot.setWorld(new CarWorld());
        }
        
    }    
}
