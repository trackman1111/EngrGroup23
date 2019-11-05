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
    
    public Ramp() {
       setImage(new GreenfootImage("ramp.jpg"));
       GreenfootImage image = getImage();
       image.scale(image.getWidth() - 700, image.getHeight() - 700);
       setImage(image);
      
      
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
      newImage.scale(newImage.getWidth() - (int)(300 * Math.cos((90 - inputRampAngle) * (3.14 / 180))) 
       + 100, (newImage.getHeight() - (int)(300 * Math.sin((90 - inputRampAngle) * (3.14 / 180)))) + 100);
       
       
        getWorld().addObject(new RampBall(inputRampAngle, getY() + newImage.getHeight()/2),
        getX() - newImage.getWidth()/2 , 
        getY() - newImage.getHeight() / 2 - 2);
     }

        
    public double findAcceleration() {
      return (9.8 * Math.sin((90 - inputRampAngle) * (3.14 / 180)));    
        }
        
    public double findFinalVelocity() {
      return (Math.sqrt(2 * findAcceleration() * 300));    
        }
}

       

