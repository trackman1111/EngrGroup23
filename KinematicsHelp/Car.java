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
    private double inputVelocity;
    private double displayVelocity = 12;
    private double deccelerationValue;
    private int initialX = 100;
    private boolean hasMadeSound;
    
    public Car()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() * 2, image.getHeight() * 2);
        hasMadeSound = false;
    }
    public void act() 
    {
        checkVelocity();
        if ( displayVelocity > 0 )
        {
            move((int)displayVelocity);
            displayVelocity -= .1 + (deccelerationValue/inputVelocity);
            if ( !hasMadeSound && (deccelerationValue/inputVelocity) > .2 )
            {
                Greenfoot.playSound("cars046.wav");
                hasMadeSound = true;
            }
            else if( !hasMadeSound )
            {
                Greenfoot.playSound("cars047.wav");
                hasMadeSound = true;
            }
        }
        else
        {
           calculateBrakingDistance(inputVelocity, deccelerationValue);
           getWorld().addObject(new Button2(3), 300, 200);
        }
    }
    public double checkVelocity()
    {
        if ( !checked )
        {
            inputVelocity = Double.parseDouble(JOptionPane.showInputDialog("Please input a velocity in meters per second"));
            deccelerationValue = Double.parseDouble(JOptionPane.showInputDialog("Please input a decceleration value in meters per second"));
            checked = true;
        }
        return inputVelocity;
    }
    public void calculateBrakingDistance(double velocity, double decceleration)
    {
        double time = velocity / decceleration;
        double distance = (.5 * velocity * time );
        getWorld().showText("Time to stop: " + time + " seconds \nDistance traveled: " + distance + " meters", 300, 300);
        
    }
}
