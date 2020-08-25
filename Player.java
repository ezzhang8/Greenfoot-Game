import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * The player class. Each player (1 or 2) is a member of this class. This class handles interactions between the player and other objects in the game. Players can move, run into walls, 
 * speed up, slow down, and change image depending on the direction they are facing.
 * 
 * @author Eric Zhang
 * @version November 17, 2019
 */
public class Player extends Actor
{
    /*
     * Private variables for the player class
     */
    //Array of images for the player
    private GreenfootImage[] playerImageArray;
    
    //Player stats
    private int coinsCollected;
    private int lives;
    private int playerNumber;
    private int walkSpeed;
    
    //Whether the player is "ready" and has moved using the keyboard.
    private boolean ready;
    /**
     * Constructor
     * @param playerId Determines whether the player is player 1 or player 2.
     */
    public Player(int playerId) 
    {
       coinsCollected = 0; // Default coins collected.
       lives = 3; // Default lives
       walkSpeed = 5; // Default walkSpeed
       
       playerNumber = playerId; //Sets the scope of playerId to the whole class so methods can read it.

       playerImageArray = new GreenfootImage[4]; //new empty GreenfootImage array of length 4
       
       for (int i=1; i<=4; i++) // Finds the four images and adds them to array.
       {
          playerImageArray[i-1] = new GreenfootImage(playerId+"-"+i+".png");
       }
       //Sets the player image to face up.
       setImage(playerImageArray[0]);
       
       //Sets ready to false as the player has not inputted anything yet.
       ready = false;
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeyPress(playerNumber);
        collisionCheck();
        entityCheck();
        villainDamage();
    }
    /**
     * Checks for user input.
     */
    public void checkKeyPress(int playerId) 
    {
        //Matrix that has the control set for player 1 in index 0, and player 2 in index 1. 
        String[][] keyPressSet = {
            {"w", "a", "s", "d"},
            {"up", "left", "down", "right"}
        };
        //Controls are designed to be able to be easily changed at any time by referring to the matrix.
        if (Greenfoot.isKeyDown(keyPressSet[playerId-1][0])) 
        {
           smartMove(1,1, false); //Moves in the appropriate direction
           ready = true; //Sets player ready status to true, so that villans can move.
        } 
        else if (Greenfoot.isKeyDown(keyPressSet[playerId-1][1]))
        {
           smartMove(-1,4, false);
           ready = true;
        } 
        else if (Greenfoot.isKeyDown(keyPressSet[playerId-1][2])) 
        {
           smartMove(-1,3, false);  
           ready = true;
        } 
        else if (Greenfoot.isKeyDown(keyPressSet[playerId-1][3])) 
        {
           smartMove(1,2, false);
           ready = true;
        }
      
    }
    /**
     * Checks if the player is touching an obstacle and which direction the player is facing, then moves the player in the opposite direction. The opposite direction movement cancels out any keyboard entries, so the player does not move.
     */
    public void collisionCheck() {
        if (this.isTouching(Obstacle.class) && getImage() == playerImageArray[0]) 
        {
            smartMove(-1, 3, true);
        }
        else if (this.isTouching(Obstacle.class) && getImage() == playerImageArray[1]) 
        {
            smartMove(-1, 4, true);
        }
        else if (this.isTouching(Obstacle.class) && getImage() == playerImageArray[2]) 
        {
            smartMove(1, 1, true);
        }
        else if (this.isTouching(Obstacle.class) && getImage() == playerImageArray[3]) 
        {
            smartMove(1, 2, true);
        } 
    }
    /**
     * Checks for touching entities. If an Entity is being touched, the method will play the corresponding sound and adjust the correct stat, before removing the Entity from the world.
     */
    public void entityCheck() 
    {
        if (isTouching(Entity.class)) {
           if (isTouching(Coin.class))
           {
               Greenfoot.playSound("coin.mp3");
               coinsCollected +=1;
           }
           else if (isTouching(Energy.class))
           {
               Greenfoot.playSound("energy.mp3");
               walkSpeed = 5;
           }
           else if (isTouching(Glue.class))
           {
               Greenfoot.playSound("glue.mp3");
               walkSpeed = 3; 
           }
           else if (isTouching (Health.class))
           {
               Greenfoot.playSound("health.mp3");
               lives +=1;
           }
           removeTouching(Entity.class);
        }
    }
    /**
     * Called to check if the player has inputted on their keyboard. Villains will not attack until this method returns true.
     * @return Whether the player is ready.
     */
    public boolean isReady()
    {
        return ready;
    }
    /**
     * Reports a specific player stat.
     * @param stat The name of the variable to be returned in the method.
     * @return An integer stat of the player specified in the parameter 'stat'. 
     */
    public int reportStats(String stat) 
    {
        if (stat == "walkSpeed")
        {
            return walkSpeed;
        }
        else if (stat == "coinsCollected")
        {
            return coinsCollected;
        }
        else if (stat == "health")
        {
            return lives;
        }
        else
        {
            return -1;
        }
    }
    /**
     * Takes two values to...
     * @param vector1 Either 1 for a positive direction (north or east), or -1 for a negative direction (south or west)
     * @param vector2 Integer used to represent the cardinal points. 1 is used to represent north, 2 is used to represent east, 3 is used to represent south, 4 is used to represent west.
     * @param bounce Whether the image of the player should be changed. True will not change the image, false will change the image.
     */
    public void smartMove(int vector1, int vector2, boolean bounce) 
    {
        if (vector2 == 1 || vector2 == 3) 
        {
            this.setLocation(this.getX(), this.getY()-(vector1*walkSpeed));
        }
        else if (vector2 == 2 || vector2 == 4) 
        {
            this.setLocation(this.getX()+(vector1*walkSpeed), this.getY());
        }
        
        if (bounce == false){
            setImage(playerImageArray[vector2-1]);
        }
    }
    /**
     * Checks if the player is touching a villain, subtracts a life, then if all lives are gone, the endGame method is called in the world.
     */
    public void villainDamage() 
    {
        //endGame is only found in the Menu1 subclass of world, so this declaration is required.
        Menu1 world = getWorldOfType(Menu1.class);
        if (isTouching(Villain.class)) {
            removeTouching(Villain.class);
            lives -=1;
        }
        if (lives == 0)
        {
            world.endGame();
        }
    }
    
}