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
    private double speed;
    private int stop;
    private boolean hasMadeSound;
    private Ramp ramp;
    public RampBall(int tempAngle, int stoppingY, Ramp ramp)
    {
        angle = tempAngle;
        stop = stoppingY;
        speed = 0;
        hasMadeSound = false;
        this.ramp = ramp;
    }
    public void act() 
    {
        if ( getX() < ramp.getX() && getY() <ramp.getY())
            turnTowards(ramp.getX() + ramp.getImage().getWidth()/2,
                        ramp.getY() + ramp.getImage().getHeight()/2);
        GreenfootImage image = getImage();
        if ( !checked ) 
        {
          currentChangeX = getX();
          currentChangeY = getY();
          checked = true;
        }
        if ( !isAtEdge())
        {
            move((int)speed);
            if ( !hasMadeSound)
            {
                Greenfoot.playSound("bowling1.wav");
                hasMadeSound = true;
            }
        }
        else
        {
            getWorld().addObject(new Button2(2), 400, 100);
        }
        
        
        speed += .1;

        // Add your action code here.
    }   
     
   
}
