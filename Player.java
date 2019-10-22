import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private int playerNumber;
    private GreenfootImage[] playerImageArray= new GreenfootImage[4];
    public Player(int playerAmount) {
        for (int i=0; i<=3; i++) {
            playerImageArray[i] = new GreenfootImage(playerAmount+"-"+(i+1)+".png");
        }
        setImage(playerImageArray[0]);
        playerNumber = playerAmount;
    }
    
    public void act() 
    {
        movementHandler(playerNumber);
    }
    public void movementHandler(int playernumbers) {
        String[][] keyPressSet = {{"up", "W"}, {"right", "D"}, {"down", "S"}, {"left", "A"}};
        for(int i=0; i<keyPressSet.length; i++) {
            for(int j=0; j<=(playernumbers-1); j++)
                if(Greenfoot.isKeyDown(keyPressSet[i][j])) {
                    move(3);
                }
            }
        }
    }
