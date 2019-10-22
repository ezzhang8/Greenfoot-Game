import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @Eric Zhang
 * @0.1
 */
public class Menu extends World
{
    private static int worldSizeX = 960;
    private static int worldSizeY = 540;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Menu()
    {    
       super(worldSizeX, worldSizeY, 1); 
       // Greenfoot.setWorld(new Menu1());
       initializeUI();
       Greenfoot.setWorld(new Menu1());
    }
    
    public void initializeUI() {
       addObject(new Player1(), 480, 270);
       addObject(new Player2(), 480, 340);
    }
}
