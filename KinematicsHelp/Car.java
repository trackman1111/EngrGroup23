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
    private GreenfootSound fastBrakeSound;
    private GreenfootSound slowBrakeSound;
    
    public Car()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() * 2, image.getHeight() * 2);
        hasMadeSound = false;
        fastBrakeSound = new GreenfootSound("cars046.wav");
        slowBrakeSound = new GreenfootSound("cars047.wav");
    }
    public void act() 
    {   if (!checked)
        {
            checkVelocity();
        }
        else
        {
            if ( displayVelocity > 0 )
            {
                move((int)displayVelocity);
                displayVelocity -= .1 + (deccelerationValue/inputVelocity);
                if ( !hasMadeSound && (deccelerationValue/inputVelocity) > .2 )
                {
                    fastBrakeSound.play();
                    hasMadeSound = true;
                }
                else if( !hasMadeSound )
                {
                    slowBrakeSound.play();
                    hasMadeSound = true;
                }
            }
            else
            {
               calculateBrakingDistance(inputVelocity, deccelerationValue);
               getWorld().addObject(new Button2(3), 300, 200);
               fastBrakeSound.stop();
               slowBrakeSound.stop();
            }
        }
    }
    public double checkVelocity()
    {
        try
        {
            inputVelocity = Double.parseDouble(JOptionPane.showInputDialog("Please input a velocity in meters per second"));
            deccelerationValue = Double.parseDouble(JOptionPane.showInputDialog("Please input a decceleration value in meters per second"));
            checked = true;
        }
        catch(Exception e)
        {
            checked = false;
            JOptionPane.showMessageDialog(null, "Please Enter Valid Input");
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
