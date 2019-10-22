import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button is a parent class of all buttons used in the game. Buttons, when clicked, set the world.
 * 
 * @author (your name) 
 * @version 10.18
 */
public class Button extends Actor
{   
    /**
     * 
     */
    public void onClickSetWorld(World world) {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(world);
        }
    }
}
