import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
import java.text.DecimalFormat;
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
    private double xVel;
    private double yVel;
    private double finalVel;
    private double acc;
    private double time;
    private double distance;
    
    private boolean checked = false;
    private String inputVelocity;
    private String inputAngle;
    
    public void act() 
    {
        if ( !checked )
        {
            inputVelocity = JOptionPane.showInputDialog("Please input an initial velocity");
            inputAngle = JOptionPane.showInputDialog("Please input a launch angle");
            checked = true;
            calculate();
        }
        setLocation(getX() + (int) xVel, getY() - (int) yVel);
        yVel--;
    }    
    
    public String calculate() {
        DecimalFormat df = new DecimalFormat("##.###");
        //x = (vInitial)(time) + .5(acc)((time * time));
        xVel = Double.parseDouble(inputVelocity) * Math.cos(Double.parseDouble(inputAngle) * (3.14 / 180));
        yVel = Double.parseDouble(inputVelocity) * Math.sin(Double.parseDouble(inputAngle) * (3.14 / 180));

        // Solve for time
        time = (yVel) / (9.8);
        time *= 2;
        time = Math.abs(time);
        
        // Solve for distance traveled.
        distance = xVel * time;
        
        // Solve for acceleration in x-direction.
        acc = 2 * (distance - ((xVel * time) / (time * time)));
        
        // Solve for final velocity
        double finalVelY = -9.8 * time;
        finalVel = Math.sqrt(Math.pow(xVel, 2) + Math.pow(finalVelY, 2));
        
        String str = "Velocity: " + inputVelocity 
            + " m/s\nAngle: " + inputAngle 
            + " degrees\nFinal Velocity: " + df.format(finalVel)
            + " m/s\nDistance: " + df.format(distance)
            + " m\nAcceleration: " + df.format(acc)
            + " m/s^2\nTime: " + df.format(time) + " seconds"
            + " \nxVel: " + xVel + "\nyVel: " + yVel;
        
            GreenfootImage image = new GreenfootImage(str, 16, Color.BLACK, null);
            getWorld().getBackground().drawImage(image, 410, 5);
        
        return str;
    }
    
    public void moveOnPath() {
        
    }
}
