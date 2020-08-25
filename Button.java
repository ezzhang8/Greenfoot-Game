import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Button is the class for buttons in the world.
 * 
 * @author Eric Zhang
 * @version November 15, 2019
 */
public class Button extends UserInterface
{   
    //Initial variable declarations
    private GreenfootImage img;
    private World worldToSet;
    /**
     * Constructs a button able to set the World when clicked.
     * @param text The text to be shown on the button.
     * @param sizeX The width of the button in pixels.
     * @param sizeY The height of the button in pixels.
     * @param world The world that is set by the Button when clicked.
     */
    public Button(String text, int sizeX, int sizeY, World world)
    {
        //Initialize variables.
        GreenfootImage img = new GreenfootImage (text.length()*12,20);
        super.initializeText(img, text);
        worldToSet = world;
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        onClickSetWorld();
    }
    /**
     * Checks if the button is clicked and a world is available to set, then sets the world when clicked.
     */
    public void onClickSetWorld() 
    {
        //If the button has been clicked and a worldToSet has been declared.
        if (Greenfoot.mouseClicked(this) && worldToSet !=null) 
        {
            Greenfoot.setWorld(worldToSet);
        }
    }
  
}
