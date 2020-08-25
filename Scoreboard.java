import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the amount of coins collected and lives for each player in the game.
 * 
 * @author Eric Zhang
 * @version November 17, 2019
 */
public class Scoreboard extends UserInterface
{
    /**
     * Empty constructor.
     */
    public Scoreboard()
    {
    }
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        displayScores();
    }
    /**
     * First checks for the number of players, then displays the amount of coins collected and lives for each one.
     */
    public void displayScores()
    {
        //String manipulation by adding integers to String.
        if(getWorld().getObjects(Player.class).size() ==1) 
        {
            getWorld().showText("Player 1: "+getWorld().getObjects(Player.class).get(0).reportStats("coinsCollected"), 120, 50);
            getWorld().showText(getWorld().getObjects(Player.class).get(0).reportStats("health")+" Lives", 120, 75);
            
        }
        
        else if(getWorld().getObjects(Player.class).size() == 2)
        {
            getWorld().showText("Player 1: "+getWorld().getObjects(Player.class).get(0).reportStats("coinsCollected"), 120, 50);
            getWorld().showText(getWorld().getObjects(Player.class).get(0).reportStats("health")+" Lives", 120, 75);

            getWorld().showText("Player 2: "+getWorld().getObjects(Player.class).get(1).reportStats("coinsCollected"), 840, 50);
            getWorld().showText(getWorld().getObjects(Player.class).get(1).reportStats("health")+" Lives", 840, 75);
    
        }    
    }

}
