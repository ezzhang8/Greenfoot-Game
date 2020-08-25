import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world that appears after the player has chosen either 1 player or 2 player mode.
 * 
 * @author Eric Zhang
 * @version November 17, 2019
 */
public class LevelSelect extends World
{
    //World size static variables
    private static int worldSizeX = 960;
    private static int worldSizeY = 540;
    private int playerNumber;
    /**
     * Constructs the LevelSelect world.
     * @param players The number of players depending on what the player chose on the previous screen.
     */
    public LevelSelect(int players)
    {    
       super(worldSizeX, worldSizeY, 1); 
       //Make scope accessable to other methods.
       playerNumber = players;
       initUI();
    }
    /**
     * Initialize UI found on the Level select screen.
     */
    public void initUI() 
    {
        //Each button creates a new Menu1 world with parameters for how many players to spawn in, entities, walls, and villains.
        addObject(new Button("Easy", 10, 10, new Menu1(playerNumber, new int[]{20, 10, 10, 2, 5, 3, 3}, 5, 60)), 480, 250);
        addObject(new Button("Medium", 10, 10, new Menu1(playerNumber, new int[]{35, 8, 15, 1, 10, 5, 5}, 10, 50)), 480, 290);
        addObject(new Button("Hard", 10, 10, new Menu1(playerNumber, new int[]{50, 3, 25, 0, 15, 7, 7}, 15, 30)), 480, 330);
    }
}
