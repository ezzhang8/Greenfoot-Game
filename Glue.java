import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Glue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Glue extends Obstacle
{
    /**
     * Act - do whatever the Glue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Glue() 
    {
        setImage("glue.png");
    }
    
    public void act() 
    {
        glue();
    }    
    
    public void glue() 
    {
        for (int i=1; i<=(super.checkPlayerTouch().size()); i++) {
            getWorld().getObjects(Player.class).get((int)(super.checkPlayerTouch().size())-1).affectSpeed(5);
        }
    }
}
