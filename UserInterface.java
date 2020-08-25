import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contains methods accessable to UI object subclasses, and used to identify subclasses as UI objects. This class is not used on its own; ts methods are inherited by its subclasses.
 * 
 * @author Eric Zhang
 * @version November 15, 2019
 */
public class UserInterface extends Actor
{
    /**
     * Empty constructor.
     */
    public UserInterface()
    {
    }
    /**
     * Initialize default font settings. Called from a subclass.
     * @param img A GreenfootImage for the subclass.
     * @param text The text to be shown on the UI object.
     */
    public void initializeText(GreenfootImage img, String text) 
    {
        img.setColor(new Color(0, 0, 0));
        //Set a bold font
        img.setFont(new Font(true, false, 15));
        //Fill a rectangle
        img.fillRect(0, 0, text.length()*13, 20);
        //Make text white
        img.setColor(new Color(255, 255, 255));
        //Plaster that text on the rectangle
        img.drawString(text, 5, 15);        
        //Finally set the image
        setImage(img);
    }
}
