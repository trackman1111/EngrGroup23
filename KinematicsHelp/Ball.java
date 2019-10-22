import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean xChecked = false;
    private boolean yChecked = false;
    private String inputXValue;
    private String inputYValue;
    public void act() 
    {
        if ( !xChecked )
        {
            inputXValue = JOptionPane.showInputDialog("Please input an x value");
            xChecked = true;
        }
        if ( !yChecked )
        {
            inputYValue = JOptionPane.showInputDialog("Please input an y value");
            yChecked = true;
        }
        setLocation(Integer.parseInt(inputXValue), Integer.parseInt(inputYValue));
    }    
}
