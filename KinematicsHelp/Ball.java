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
    private String inputVelocity;
    private String inputAngle;
    
    public void act() 
    {
        if ( !xChecked )
        {
            inputXValue = JOptionPane.showInputDialog("Please input an x value");
            xChecked = true;
        }
        if ( !yChecked )
        {
            inputYValue = JOptionPane.showInputDialog("Please input a y value");
            yChecked = true;
        }
        if (inputVelocity == null) {
            inputVelocity = JOptionPane.showInputDialog("Please input an initial velocity");
        }
        if (inputAngle == null) {
            inputAngle = JOptionPane.showInputDialog("Please input a launch angle");
        }
        setLocation(Integer.parseInt(inputXValue), Integer.parseInt(inputYValue));
        calculate();
    }    
    
    public String calculate() {
        double xVel;
        double yVel;
        double finalVel;
        double acc;
        double time;
        double distance;
        //x = (vInitial)(time) + .5(acc)((time * time));
        xVel = Double.parseDouble(inputVelocity) * Math.cos(Double.parseDouble(inputAngle));
        yVel = Double.parseDouble(inputVelocity) * Math.sin(Double.parseDouble(inputAngle));

        // Solve for time
        time = (yVel) / (9.8);
        time *= 2;
        
        // Solve for distance traveled.
        distance = xVel * time;
        
        // Solve for acceleration in x-direction.
        acc = 2 * (distance - (xVel * time)) / (time * time);
        
        // Solve for final velocity
        double finalVelY = -9.8 * time;
        finalVel = Math.sqrt(Math.pow(xVel, 2) + Math.pow(finalVelY, 2));
        
        String str = "Velocity: " + inputVelocity 
            + "\nAngle: " + inputAngle 
            + "\nFinal Velocity: " + finalVel
            + "\nDistance: " + distance
            + "\nAcceleration: " + acc
            + "\nTime: " + time;
        
        getWorld().showText(str, 475, 50);
        
        return str;

        
    }
}
