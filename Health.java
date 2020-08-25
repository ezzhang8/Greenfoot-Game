import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Health entity which adds one to the player's lives stat. Handling interactions with this class is done in the Player class.
 * 
 * @author Eric Zhang
 * @version November 17, 2019
 */
public class Health extends Entity
{
    /**
     * Sets the image to a heart upon creation.
     */
    public Health()
    {
        setImage("heart.png");
    } 
}
