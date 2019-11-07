import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * Write a description of class Ramp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ramp extends Actor
{
    
    private boolean checked = false;
    private int inputRampAngle;
    private int screenSize;
    public Ramp() {
       setImage(new GreenfootImage("ramp.jpg"));
       GreenfootImage image = getImage();
       screenSize = 600;
       image.scale(screenSize, screenSize);
      
      
    }
    
    /**
     * Act - do whatever the Ramp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if ( !checked )
        {
            inputRampAngle = checkAngle();
          getWorld().showText(inputRampAngle + "", 100, 100);
          resizeRamp();
          checked = true;
        }
      findAcceleration();
      findFinalVelocity();
      getWorld().showText("The Length of the Ramp is:\n" + 300 + " meters", 425, 50);
      getWorld().showText("The Acceleration is:\n" + findAcceleration() + " m/s/s", 425, 125);
      getWorld().showText("The Final Velocity is:\n" + findFinalVelocity() + " m/s", 425, 200);
    }
    public int checkAngle() {
        return Integer.parseInt(JOptionPane.showInputDialog("Please input an angle in degrees between 20 & 70"));    
    }
    
    public void resizeRamp() {
        GreenfootImage newImage = getImage();
        if ( inputRampAngle >= 45 )
        {
            newImage.scale(screenSize - (int) (screenSize * Math.sin(Math.toRadians((inputRampAngle-45) * 2 ))), screenSize);
            setLocation(newImage.getWidth()/2, newImage.getHeight()/2);
        }
        if ( inputRampAngle < 45 )
        {
            newImage.scale(screenSize, screenSize - (int) (screenSize * Math.cos(Math.toRadians(inputRampAngle * 2 ))));
            setLocation(screenSize - newImage.getWidth()/2, screenSize - newImage.getHeight()/2);
        }
       
       
        getWorld().addObject(new RampBall(inputRampAngle, getY() + newImage.getHeight()/2),
        getX() - newImage.getWidth()/2 + 1, 
        getY() - newImage.getHeight() / 2 + 1);
     }

        
    public double findAcceleration() {
      return (9.8 * Math.sin((inputRampAngle) * (3.14 / 180)));    
        }
        
    public double findFinalVelocity() {
      return (Math.sqrt(2 * findAcceleration() * 300));    
        }
}

       

