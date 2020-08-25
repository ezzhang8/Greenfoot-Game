import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author Eric Zhang
 * @version November 15, 2019
 */
public class Zombie extends Villain
{
    //Set of four images for the Zombie.
    private GreenfootImage[] zombieImageArray;
    
    //Walk speed, set to 1 and does not change. The variable exists to help future modifications.
    private int walkSpeed;
    
    //Which direction the Zombie travels. Zombies travel only either left and right or up and down.
    private int zombieDirection;
    
    //The Zombie's targetX coordinate and targetY coordinate.
    private int targetX, targetY;
    /**
     * Creates a new Zombie and handles its initial direction.
     * @param direction 0 for a Zombie that travels up and down, 1 for a Zombie that travels left and right.
     */
    public Zombie(int direction) 
    {
        //Set the walk speed.
        walkSpeed = 1;
        //create a new image array
        zombieImageArray = new GreenfootImage[4];
       
        //Browse files for the four zombie images.
        for (int i=1; i<=4; i++) 
        {
            zombieImageArray[i-1] = new GreenfootImage("z"+"-"+i+".png");
        }
       
        //Set initial targets to 0  
        targetX = 0;
        targetY = 0;
        
        //Set image to correspond to direction. Index 0 in the array is the "up" picture, and index 1 in the array is the "right" picture.
        setImage(zombieImageArray[direction]);
        //Make constructor parameter have class-wide scope.
        zombieDirection = direction;
    }
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Only act once a player is ready to avoid hasty death.
        if (super.aPlayerIsReady())
        {
             autoMove();
             collisionCheck();
             playSound();
        }
    }
    /**
     * Checks the direction of Zombie and calls the appropriate method to handle one direction of movement.
     */
    public void autoMove()
    {
        if (zombieDirection == 0)
        {
            autoMoveY();
        }
        else if (zombieDirection == 1)
        {
            autoMoveX();
        }        
    }
    /**
     * Allows the zombie to move along the X axis.
     */
    public void autoMoveX() 
    {
        if(this.getX() < targetX) //if I'm to the left of the target
        {
            super.smartMove(this, 1, 2, 1);
            setImage(zombieImageArray[1]);
        }   
        else if(this.getX() > targetX) //if I'm to the right of the target
        {   
            super.smartMove(this, -1, 4, 1);
            setImage(zombieImageArray[3]);
        }
    
    }
    /**
     * Allows the zombie to move along the Y axis.
     */
    public void autoMoveY()
    {
        if(this.getY() < targetY) 
        {
            super.smartMove(this, -1, 3, 1);
            setImage(zombieImageArray[2]);
        }
        else if(this.getY() > targetY)
        {
            super.smartMove(this, 1, 1, 1);
            setImage(zombieImageArray[0]);
        }
    }
    /**
     * Checks if the zombie is intersecting an Obstacle or the edge of the world, and changes the zombie's target so that it moves in the opposite direction.
     */
    public void collisionCheck() 
    {
        if (getOneIntersectingObject(Obstacle.class) != null || isAtEdge()) 
        {
           if (getImage() == zombieImageArray[0]) 
           {
               targetX = this.getX();
               targetY = 540; 
           }
           else if (getImage() == zombieImageArray[1])
           {    
               targetX = 0;
               targetY = this.getY();
           }
           else if (getImage() == zombieImageArray[2])
           { 
               targetX = this.getX();
               targetY = 0;
           }
           else if (getImage() == zombieImageArray[3])
           {
               targetX = 960;
               targetY = this.getY();
           }
        }  
    }
    /**
     * Plays a ghost sound for around each 500 executions of the act method.
     */
    public void playSound() 
    {
        int chance = Greenfoot.getRandomNumber(500);
        if (chance == 1)
        {
            Greenfoot.playSound("zombie.mp3");
        }
    }
}
