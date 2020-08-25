import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The final screen of the game, determines whether the player has won or lost, and directs them to the Main Menu again.
 * 
 * @author Eric Zhang
 * @version November 15, 2019
 */
public class EndCard extends World
{

    /**
     * Constructor for objects of class EndCard.
     * 
     * @param win True if the player has won when the EndCard is displayed. False if the player has lost.
     */
    public EndCard(boolean win)
    {    
       // Create a new world 960x540, with cell size 1
       super(960, 540, 1); 
       
       if (win)
       {
           showText("You won!", 480, 270);
       }
       else 
       {
           showText("You lost!", 480, 270);
       }
       addObject(new Button("Return to Main Menu", 100, 100, new Menu()), 480, 290);
    }
}
