import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Walls will block the player and zombies from getting past. Interaction events are handled in their respective classes.
 * 
 * @author Eric Zhang
 * @version November 17, 2019
 */
public class Wall extends Obstacle
{
    //image of the wall (one black pixel)
    private GreenfootImage image;
    /**
     * Scales the wall image (a black pixel) to a size.
     * @param sizeX size along X axis in pixels
     * @param sizeY size along Y axis in pixels
     */
    public Wall(int sizeX, int sizeY)
    {
        image = getImage();
        //scale the image.
        image.scale(sizeX, sizeY);
    }
}
