import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarWorld extends World
{

    /**
     * Constructor for objects of class CarWorld.
     * 
     */
    public CarWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(1000, 600, 1);
        setPaintOrder(Car.class, RandomCars.class);
        GreenfootImage image = new GreenfootImage("road.jpg");
        image.scale(1000,600);
        setBackground(image);
        addObject(new Car(),100,450);
        ExitButton eB = new ExitButton();
        GreenfootImage image1 = new GreenfootImage("BackButton2.png");
        image1.scale(50, 50);
        eB.setImage(image1);
        addObject(eB, 955, 45);
        for ( int i = 0; i < 5; i++)
        {
            addObject( new RandomCars(), Greenfoot.getRandomNumber(1000), 
                                         Greenfoot.getRandomNumber(100) + 400); 
        }
    }
}
