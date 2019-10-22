import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu1 extends World
{

    /**
     * Constructor for objects of class Menu1.
     * 
     */
    public Menu1()
    {
        super(960, 540, 1); 
        addObject(new Player(1), 100, 100);
    }
}
