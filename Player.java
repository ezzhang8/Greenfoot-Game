import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Player here.
 * 
 * @Eric Zhang
 * @18 October 2019
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int coinsCollected;
    private int playerNumber;
    private int walkSpeed;
    private GreenfootImage[] playerImageArray;
    
    public Player(int playerId) 
    {
       coinsCollected = 0;
       playerImageArray = new GreenfootImage[4];
       
       for (int i=1; i<=4; i++) 
       {
          playerImageArray[i-1] = new GreenfootImage(playerId+"-"+i+".png");
       }
        
       setImage(playerImageArray[0]);
       playerNumber = playerId;
       walkSpeed = 10;
    }
    /**
     * Act method is called a lot.
     */
    public void act() 
    {
        checkKeyPress(playerNumber);
        collisionCheck();
    }
    /**
     * Checks for user input.
     * 
     */
    public void checkKeyPress(int playerId) {
        String[][] keyPressSet = {
            {"w", "a", "s", "d"},
            {"up", "left", "down", "right"}
        };
        if (Greenfoot.isKeyDown(keyPressSet[playerId-1][0])) 
        {
           smartMove(1,1);
        } 
        else if (Greenfoot.isKeyDown(keyPressSet[playerId-1][1])) //A
        {
           smartMove(-1,4);
        } 
        else if (Greenfoot.isKeyDown(keyPressSet[playerId-1][2])) 
        {
           smartMove(-1,3);  
        } 
        else if (Greenfoot.isKeyDown(keyPressSet[playerId-1][3])) 
        {
           smartMove(1,2);
        }
      
    }    
    public void collisionCheck() {
        if (this.isTouching(Wall.class) && getImage() == playerImageArray[0]) 
        {
            bounce(-1, 3);
        }
        else if (this.isTouching(Wall.class) && getImage() == playerImageArray[1]) 
        {
            bounce(-1, 4);
        }
        else if (this.isTouching(Wall.class) && getImage() == playerImageArray[2]) 
        {
            bounce(1, 1);
        }
        else if (this.isTouching(Wall.class) && getImage() == playerImageArray[3]) 
        {
            bounce(1, 2);
        } 
        else if (this.isTouching(Glue.class))
        {
            walkSpeed = 5;
        }
    }
   
    /**
     * vector1: 1 = forward, -1 = backwards
     * vector2: 1 = north 2 = east, 3 = south, 4 = west
     */
    public void smartMove(int vector1, int vector2) 
    {
        if (vector2 == 1 || vector2 == 3) 
        {
            this.setLocation(this.getX(), this.getY()-(vector1*walkSpeed));
            setImage(playerImageArray[vector2-1]);
        }
        else if (vector2 == 2 || vector2 == 4) 
        {
            this.setLocation(this.getX()+(vector1*walkSpeed), this.getY());
            setImage(playerImageArray[vector2-1]);
        }
    }
    
    public void bounce(int vector1, int vector2) 
    {
        if (vector2 == 1 || vector2 == 3) 
        {
            this.setLocation(this.getX(), this.getY()-(vector1*walkSpeed));
        }
        else if (vector2 == 2 || vector2 == 4) 
        {
            this.setLocation(this.getX()+(vector1*walkSpeed), this.getY());
        }
    }
    
    /**
     * Mutator method: change WalkSpeed
     */
    public void affectSpeed(int newWalkSpeed) 
    {
        walkSpeed = newWalkSpeed;
    }
}