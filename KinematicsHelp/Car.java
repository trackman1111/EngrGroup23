import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean checked = false;
    private int inputVelocity;
    private int initialX = 100;
    
    public void act() 
    {
        checkVelocity();
        move(inputVelocity);
        if ( inputVelocity > 0 )
        {
            inputVelocity--;
        }
        else
        {
            getWorld().showText("Your car traveled " + (getX() - initialX) + " meters", 300, 100 );
        }
    }
    public int checkVelocity()
    {
        if ( !checked )
        {
            inputVelocity = Integer.parseInt(JOptionPane.showInputDialog("Please input a velocity in meters per second"));
            checked = true;
        }
        return inputVelocity;
    }
}
