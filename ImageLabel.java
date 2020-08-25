import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ImageLabels display a GreenfootImage as a user interface element.
 * 
 * @author Eric Zhang
 * @version November 15, 2019
 */
public class ImageLabel extends UserInterface
{
    /**
     * Construct an ImageLabel with background image img, width sizeX, and height sizeY.
     * @param img Image to set the label to.
     * @param sizeX Width of the ImageLabel.
     * @param sizeY Height of the ImageLabel.
     */
    public ImageLabel(GreenfootImage img, int sizeX, int sizeY)
    {
        img.scale(sizeX, sizeY);
        setImage(img);
    }  
}
