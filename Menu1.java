import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * The world with all game objects, the player, the villains; the main playground. 
 * 
 * @author Eric Zhang
 * @version November 14, 2019
 */
public class Menu1 extends World
{
    //Initialize the variables
    private int[] defaultEntityQuantity;
    private int playerNumber;
    
    /**
     * Constructor for Menu1 world where the player plays the game
     * @param numberOfPlayers Either 1 or 2 players.
     * @param defaultQuantities An array of how many quantities of entities and villains to spawn in that differs by difficulty level.
     * @param numberOfWalls How many walls or obstacles the game will generate in this level.
     * @param wallOffset How much space should be between each wall.
     * 
     */
    public Menu1(int numberOfPlayers, int[]defaultQuantities, int numberOfWalls, int wallOffset)
    {
       super(960, 540, 1);
        
       //defaultEntityQuantity = new int[]{30, 10, 10, 2, 10, 5, 5};
       defaultEntityQuantity = defaultQuantities;
        
       //for each player in numberofPlayers, create a new Player object and spawn them to a slight offset of each other.
       for(int i=0; i<numberOfPlayers; i++)
       {
            addObject(new Player(i+1), 100+i*5, 100+i*5);
       } 
       //Add the scoreboard.
        addObject(new Scoreboard(), 0, 0);
                
        playerNumber = numberOfPlayers;
        generateWalls(numberOfWalls, wallOffset);
        spawnEntitiesAndVillains(defaultEntityQuantity);
    }
    /**
     * On every act, checks to see if the player has won.
     */
    public void act()
    {
        checkWin();
    }
     /**
     * Checks if the player has won by checking if the amount of coins in the world is zero, and then directs to a winning endcard.
     */
    public void checkWin()
    {
        if (getObjects(Coin.class).size() == 0) 
        {
           Greenfoot.setWorld(new EndCard(true));
        }
    }
    
    /**
     * Checks whether an entity will intersect an actor at a given location.
     * @param x - x-coordinate to check.
     * @param y - y-coordinate to check.
     * @return True if no actor is found within a 5 pixel box around the coordinates, false otherwise.
     */
    public boolean doesNotIntersectAnObject(int x, int y)
    {
        //Creates a 5 pixel box around the entity being spawned in.
        if (
            getObjectsAt(x, y, Actor.class).size() == 0 && 
            getObjectsAt(x+5, y, Actor.class).size() == 0 && 
            getObjectsAt(x-5, y, Actor.class).size() == 0 &&
            getObjectsAt(x, y+5, Actor.class).size() == 0 &&
            getObjectsAt(x, y-5, Actor.class).size() == 0 &&
            getObjectsAt(x+5, y+5, Actor.class).size() == 0 &&
            getObjectsAt(x-5, y+5, Actor.class).size() == 0 &&
            getObjectsAt(x+5, y-5, Actor.class).size() == 0 &&
            getObjectsAt(x-5, y-5, Actor.class).size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * Called by the Player when all lives are lost, ending the game, and directing to a losing endcard.
     */
    public void endGame() 
    {
        Greenfoot.setWorld(new EndCard(false));
    }
    /**
     * Automatically generate and space walls shaped like a sideways T.
     * @param amount Amount of walls to generate
     * @param wallOffset The amount of space between each wall.
     */
    public void generateWalls(int amount, int wallOffset)
    {
        int offsetX = 0; // The initial position of the wall to be generated. This integer increases as more walls are drawn to avoid walls overlapping.
        int wallWidth = 15;
        int wallHeight = 40;
        boolean paintFromTop = true; //Whether the walls should be painted near the top half of the screen, or near the bottom half.
        //loops until the required amount of walls is generated.
        for (int i=0; i<amount; i++) 
        {
            int randomVariation = Greenfoot.getRandomNumber(50); //Adds random variation to the height of the walls.
            int randomVariation2 = Greenfoot.getRandomNumber(8); //Adds random variation to the position of the walls.         
            
            //Checks whether to paint the wall from the top or the bottom.
            if (paintFromTop) 
            {
               addObject(new Wall(wallWidth, wallHeight+randomVariation), offsetX, (wallWidth+randomVariation)*randomVariation2); 
               //Creates the protrusion in the middle along the Y axis.
               addObject(new Wall(30+randomVariation2, wallWidth), offsetX-(40+randomVariation2)/2, (wallWidth+randomVariation)*randomVariation2); 
               paintFromTop = false; //Alternate between walls near the top and walls near the bottom.
            } 
            else {
               addObject(new Wall(wallWidth, wallHeight+randomVariation), 960-offsetX, 540-(wallWidth+randomVariation)*randomVariation2);
               //Creates the protrusion in the middle along the X axis.
               addObject(new Wall(30+randomVariation2, wallWidth), 960-offsetX+(40+randomVariation2)/2, 540-(wallWidth+randomVariation)*randomVariation2); 
               paintFromTop = true;
            }
            
            //Add the walloffset to the offsetX so that when a new wall is painted, it is offset from the previous one, preventing overlapping.
            offsetX += wallOffset;
        }
    }  
    /**
     * Generates entities and villains in the game through quantities passed in an array.
     * @param entityArray An array of integers specifying how many of each entity and villain to spawn, in this order: Coins, Energies, Glues, Healths, Ghosts, Zombies (facing up/down), Zombies (facing left/right)
     */
    
    public void spawnEntitiesAndVillains(int[] entityArray)
    {
        //Will not spawn entities or villain this many pixels to the edge.
        int border = 10;
     
        //nested for loop. Will run for any length of entities.
        for (int i=0; i<entityArray.length; i++)
        {
            for (int j=0; j<entityArray[i]; j++)
            {
                //The order in which the loop processes the numbers in the entity array.
                Actor[] entityOrder = {new Coin(), new Energy(), new Glue(), new Health(), new Ghost(), new Zombie(0), new Zombie(1)};
                
                //Random coordinates allowing for a border.
                int randomX = Greenfoot.getRandomNumber(960-border);
                int randomY = Greenfoot.getRandomNumber(540-border);
                
                //If the entity is within the border range and does not intersect an object.
                if (randomX > border && randomY > border && doesNotIntersectAnObject(randomX, randomY))
                {
                    addObject(entityOrder[i], randomX, randomY);
                } else {
                    j-=1; //Subtract 1 from j if the object fails to meet the requirements so that the precise number of entities are drawn.
                }
            }
        }
    }
}
