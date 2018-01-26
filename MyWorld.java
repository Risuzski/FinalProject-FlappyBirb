import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * The world in which the birb is in
 * 
 *
 * Wyan Gregorio  \______/ ~\(*^*\)
 * FlappyBirb
 * Version 3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706.....
 * 1/26/18 12:35 Am
 * 
 */
public class MyWorld extends World
{
    private boolean nameAsked = false;
    private boolean startGame = false;
    private boolean gameOver = false;
    
    private int pipeDelay = 0;
    
    private static Score playerScore;
    
    private String playerName;
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 450, 1); 
        
        prepare();
        setPaintOrder (GameOver.class,Birb.class,Score.class,TopPipe.class,Ground.class,BottomPipe.class);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {     
        playerScore = new Score("");
        Birb birb = new Birb();
        Ground ground = new Ground();
        
        addObject(ground,193,432);
        
        addObject(birb,85,180);
        
        addObject(playerScore, 200, 25 );
        
        ground.setLocation(201,426);
        
        for(int i = 0; i < 2; i++)
        {
            TopPipe topPipe = new TopPipe();
            BottomPipe bottomPipe = new BottomPipe();
            
            addObject(topPipe,357 - 150*i,3);
            addObject(bottomPipe,357 - 150*i,382);
        }
        
    }
    
    public void act()
    {
        int randomPipeY;
        
        if( nameAsked == false )
        {
            playerName = JOptionPane.showInputDialog("Please enter your name:",null);
            playerScore.changeName(playerName);
            
            nameAsked = true;
        }
        else if( startGame == false )
        {
            showText ("Press the enter key to begin game!", getWidth()/2,getHeight()/2);
            
            checkKeyPress();
        }

        if( pipeDelay >= 120 )
        {
            randomPipeY =  Greenfoot.getRandomNumber(71);
            
            addObject(new TopPipe(),getWidth(),randomPipeY);
            addObject( new BottomPipe(),getWidth(),randomPipeY + 379);
            
            pipeDelay = 0;
        }
        
        pipeDelay++;
        
        addObject(playerScore, 200, 50 );
    }
    
    /**
     * checkKeyPress checks if the the key is down
     * 
     * @param there are no parameters
     * @return there is no return
     */
    private void checkKeyPress()
    {
        GreenfootSound sound = new GreenfootSound("Earth.wav");
        
        if( Greenfoot.isKeyDown( "enter" ))
        {
            startGame = true;
            
            showText ("", getWidth()/2,getHeight()/2);
        }
        
    }
    
    /**
     * getStarted checks if game has started
     * 
     * @param there are no parameters
     * @return a boolean representing if the game has started
     */
    public boolean getStarted()
    {
        return startGame;
    }
    
}