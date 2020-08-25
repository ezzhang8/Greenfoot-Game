import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A glue entity which reduces the player's walkSpeed stat. Handling interactions with this class is done in the Player class.

 * 
 * @author Eric Zhang
 * @version November 17, 2019
 */
public class Glue extends Entity
{
    /**
     * Sets the glue image upon creation. Also sets the image transparency to 125/255.
     */
    public Glue() 
    {
        setImage("goo.png");
        getImage().setTransparency(125);
    }   
}
