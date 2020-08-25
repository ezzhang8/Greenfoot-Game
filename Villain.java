import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent class for all Villains in the game: Ghosts and Zombies. Allows villains to share and reuse code common to each other.
 * 
 * @author Eric Zhang
 * @version November 17, 2019
 */
public class Villain extends Actor
{
    /**
     * Empty constructor.
     */
    public Villain()
    {
    }
    /**
     * Checks if either player has pressed a key. 
     * @return True if a player has pressed a key, false otherwise.
     */
    public boolean aPlayerIsReady()
    {
        if (getWorld().getObjects(Player.class).size() == 1) 
        {
            if (getWorld().getObjects(Player.class).get(0).isReady())
            {
                return true;
            }
        }
        else if (getWorld().getObjects(Player.class).size() == 2) 
        {
            if (getWorld().getObjects(Player.class).get(0).isReady() || getWorld().getObjects(Player.class).get(1).isReady())
            {
                return true;
            }
        } 
        
        return false;
    }
    /**
     * Moves the villain that accounts for direction and walk speed. Shares similarities with the method of the same name found in the Player class.
     * @param object The villain that will be moved.
     * @param vector1 Either 1 for a positive direction (north or east), or -1 for a negative direction (south or west)
     * @param vector2 Integer used to represent the cardinal points. 1 is used to represent north, 2 is used to represent east, 3 is used to represent south, 4 is used to represent west.
     * @param walkSpeed The amount of pixels to move the villain each time this method is called.
     */
    public void smartMove(Villain object, int vector1, int vector2, int walkSpeed) 
    {
        if (vector2 == 1 || vector2 == 3) 
        {
            object.setLocation(object.getX(), object.getY()-(vector1*walkSpeed));
        }
        else if (vector2 == 2 || vector2 == 4) 
        {
            object.setLocation(object.getX()+(vector1*walkSpeed), object.getY());
        }               
    }
}
