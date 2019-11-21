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
    private double time;
    private double distance;
    private double maxHeight;
    private double xVelDisplay = 15;
    private double yVelDisplay = 15;
    
    private boolean hasMadeSoundLand = false;
    private boolean hasMadeSoundLaunch = false;
    private boolean checked = false;
    private String inputVelocity;
    private String inputAngle;
    
    public void act() 
    {
        if ( !checked )
        {
            try
            {
                inputVelocity = JOptionPane.showInputDialog("Please input a valid positive initial velocity");
                inputAngle = JOptionPane.showInputDialog("Please input a valid launch angle between 5 and 90 degrees");
                checked = true;
                calculate();
            } 
            catch(Exception e)
            {
                checked = false;
                JOptionPane.showMessageDialog(null, "Please input valid inputs");
            }
            
        }
        else
        {
            if (!hasMadeSoundLaunch) {
                Greenfoot.playSound("LaunchSound.wav");
                hasMadeSoundLaunch = true;
            }
            setLocation(getX() + (int) (xVelDisplay * Math.cos(Math.toRadians(Double.parseDouble(inputAngle)))),
                getY() - (int) (yVelDisplay * Math.sin(Math.toRadians(Double.parseDouble(inputAngle)))));
            yVelDisplay--;
            getWorld().addObject(new Dot(), getX(), getY());
            if (getY() >= 371) {
                if (!hasMadeSoundLand) {
                    Greenfoot.playSound("BounceSound.wav");
                    hasMadeSoundLand = true;
                }
                xVelDisplay = 0;
                yVelDisplay = 0;
                getWorld().addObject(new Button2(1), 300, 200);
            }
        }
    }    
    
    public String calculate() {
        DecimalFormat df = new DecimalFormat("##.###");
        double inputVel = Double.parseDouble(inputVelocity);
        if (inputVel < 0) {
            inputVel = Math.abs(inputVel);
        }
        xVel = inputVel * Math.cos(Double.parseDouble(inputAngle) * (3.14 / 180));
        yVel = inputVel * Math.sin(Double.parseDouble(inputAngle) * (3.14 / 180));

        // Solve for time
        time = (yVel) / (9.8);
        time *= 2;
        time = Math.abs(time);
        
        // Solve for distance traveled.
        distance = xVel * time;
        
        // Solve for maximum height
        maxHeight = yVel * time;
        // Solve for final velocity
        double finalVelY = -9.8 * time;
        
        String str = "Velocity: " + inputVel 
            + " m/s\nAngle: " + inputAngle 
            + " m/s\nDistance: " + df.format(distance)
            + " m\nMaximum Height: " + df.format(maxHeight)
            + " m\nGravity: " + "-9.8"
            + " m/s^2\nTime: " + df.format(time) + " seconds";
        
            GreenfootImage image = new GreenfootImage(str, 16, Color.BLACK, null);
            getWorld().getBackground().drawImage(image, 25, 5);
        
        return str;
    }
}
