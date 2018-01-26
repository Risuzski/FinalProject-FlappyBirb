import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * The birb, a majestic creature that can't support it's weight
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Birb extends Actor
{
    static final int CHG_RATE = 10;
    
    int chgImgIn = 1; 
    int imgNum = 1;
    
    String[] images = { "flappybird4.png", "flappybird5.png", "flappybird6.png" };

    private int scoreDelay = 120;
    private boolean crash = false;
    
    private static Score playerScore;
    
    private GameOver go = new GameOver();

    /**
     * Act - do whatever the Bird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        Score player = getWorld().getObjects(Score.class).get(0);
        chgImgIn--;
        movement();
        checkCollision();
        
        if (chgImgIn == 0)
        {
            chgImgIn = CHG_RATE; // reset countdown
            imgNum = (imgNum + 1) % 3; // this will alternate {0, 1, 2, 0,...}
            setImage(images[imgNum]);
        } 
        
        if(scoreDelay >= 100)
        {   
            
            if( getObjectsInRange( 189, TopPipe.class ).size() > 0)
            {
                player.countScore();
                scoreDelay = 0;
            }
            
        }
        
        if( Greenfoot.mouseClicked( this ) )
        {   
            System.out.println( toString() );
        }
        
        scoreDelay ++;
    }    
    
    /**
     * checkCollison checks for collison into objects
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void checkCollision()
    {
        Actor bottomPipe = getOneIntersectingObject(BottomPipe.class);
        Actor topPipe = getOneIntersectingObject(TopPipe.class);
        Actor ground = getOneIntersectingObject(Ground.class);
        
        if( bottomPipe != null )
        {
            crash = true;
        }
        else if( topPipe != null )
        {
            crash = true;
        }
        else if( ground != null )
        {
            crash = true;
        }
        
    }
    
    /**
     * movement of the Birb
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void movement()
    {
        MyWorld world = (MyWorld)getWorld();
        GreenfootSound sound = new GreenfootSound("Earth.wav");

        if ( world.getStarted() == true )
        {
            setLocation(getX(), getY() + 3);
        }   
        else
        {
            sound.play();
        }
        
        if( crash == false )
        {
            
            if( Greenfoot.isKeyDown("space"))
            {
                setLocation(getX(), getY() - 5);
            }
            
        }
        else
        {
            getWorld().addObject(go,getWorld().getWidth()/2, getWorld().getHeight()/2);
            
            Greenfoot.stop();
        }
        
    }
    
}