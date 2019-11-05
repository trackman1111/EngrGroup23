import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RampBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RampBall extends Actor
{
    /**
     * Act - do whatever the RampBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int angle;
    private double currentChangeX = 0;
    private double currentChangeY = 0;
    private boolean checked = false;
    private int stop;
    public RampBall(int tempAngle, int stoppingY)
    {
        angle = tempAngle;
        stop = stoppingY;
        
    }
    public void act() 
    {
        GreenfootImage image = getImage();
        if ( !checked ) 
        {
          currentChangeX = getX();
          currentChangeY = getY();
          checked = true;
        }
        if ( getY() < stop)
        {
            move(angle, 4);
        }
      // Add your action code here.
    }   
     
    
    public void move(double angle, double distance) {
       angle = Math.toRadians(angle);
       currentChangeX += Math.cos(angle) * distance;
       currentChangeY += Math.sin(angle) * distance;
       setLocation((int) (currentChangeX), (int) (currentChangeY));
   
    }
}
