import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author Eric Zhang
 * @version 0.01 10/18/2019 9:26AM
 */
public class Player1 extends Button
{
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.onClickSetWorld(new Menu1());
    }    
}
