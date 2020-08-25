import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The default World class, which is the menu screen the user initialy sees. Instantiate this world to begin the game.
 * 
 * @author Eric Zhang
 * @version November 15, 2019
 */
public class Menu extends World
{
    //Static variables for adjustable world size.
    private static int worldSizeX = 960;
    private static int worldSizeY = 540;
    /**
     * Constructor for the main title screen.
     */
    public Menu()
    {    
       super(worldSizeX, worldSizeY, 1);  //Sets the world to the X and Y integers stored above, with a cell size of 1.
       initUI();
    }
    /**
     * Intiialize the UI elements found on the main title screen.
     */
    public void initUI() {
        addObject(new ImageLabel(new GreenfootImage("logo.png"), 256, 96), 356, 100);
        addObject(new ImageLabel(new GreenfootImage("ui/infodialog.png"), 300, 250), 480, 300);
        addObject(new Button("1 Player", 10, 10, new LevelSelect(1)), 420, 500);
        addObject(new Button("2 Players", 10, 10, new LevelSelect(2)), 540, 500);
    }
}
