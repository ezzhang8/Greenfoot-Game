import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Ghosts will seek a target and move towards that target, removing any obstacles in their way.
 * 
 * @author Eric Zhang
 * @version November 17, 2019
 */
public class Ghost extends Villain
{
    
    //The target the ghost will follow, which will be either player1 or player2.
    private Actor target;
    
    public Ghost()
    {
        setImage("ghost.png");
    }
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Only do ghost things once a player is ready.
        if (super.aPlayerIsReady())
        {
            seek();
            haunt();
            deleteWalls();
            playSound();
        }
    }    
    /**
     * Deletes walls and obstacles when the ghost touches them.
     */
    public void deleteWalls() 
    {
        if (isTouching(Obstacle.class)) {
            removeTouching(Obstacle.class);
        }
    }
    /**
     * Haunts a target by changing the position of this Ghost to match the position of the target.
     */
    public void haunt() 
    {
        // Gives a bouncing effect to the Ghost when homing in on the player.
        int randomVariation = Greenfoot.getRandomNumber(50);
        
        //Make sure the target Player has been found before homing in.
        if (target != null)
        {
            //A random variation is subtracted for the effect of the ghost's bounciness and erratic movement.
           if(getX() < target.getX()-randomVariation) //if I'm to the left of the player
            {
                //Pass in this object, positive/negative, cardinal direction, and a walkSpeed to the parent class.
                super.smartMove(this, 1, 2, 1);
            }   
           else if(getX() > target.getX()-randomVariation) //if I'm to the right of the player
            {   
                super.smartMove(this, -1, 4, 1);
            }
           //Not an else if to allow the Ghost to travel diagonally.
           if(getY() < target.getY()-randomVariation) 
            {
                super.smartMove(this, -1, 3, 1);
            }
           else if(getY() > target.getY()-randomVariation)
            {
                super.smartMove(this, 1, 1, 1);
            }
        }
    }
    /**
     * Plays a ghost sound for around each 500 executions of the act method.
     */
    public void playSound() 
    {
        //Random integer between 0 and 500.
        int chance = Greenfoot.getRandomNumber(500);
        //Play a sound 1 out of every 500 times, as long as the Ghost is not idle and has found a target.
        if (chance == 1 && target !=null)
        {
            Greenfoot.playSound("ghost.mp3");
        }
    }
    /**
     * Looks for a Player within 200 pixels of this Ghost, then sets the target to that Player.
     */
    public void seek() 
    {
        if (getObjectsInRange(200, Player.class).size() > 0) {
            target = getObjectsInRange(200, Player.class).get(0);
        } 
    }
    
    
}
