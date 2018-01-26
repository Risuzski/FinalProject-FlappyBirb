import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BottomPipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BottomPipe extends Actor
{
    
    /**
     * Act - do whatever the BottomPipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        movement();
    } 
    
    /**
     * movement of the BottomPipe
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void movement()
    {
        MyWorld world = (MyWorld)getWorld();
        
        if ( world.getStarted() == true )
        {
            setLocation(getX() - 3, getY());
        }
        
        if ( getX() <= 0)
        {
            getWorld().removeObject(this);
        }
        
    } 
    
}
