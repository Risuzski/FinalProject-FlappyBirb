import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private String playerName;
    private int playerScore;
    private boolean scoreChanged;
    
    public Score(String name)
    {
        playerScore = 0;
        playerName = name;
        displayScore();
    }
    
    /**
     * displayScore sets the score image
     * 
     *@param there are no parameters
     *@return there is no return 
     */
    private void displayScore()
    {
        GreenfootImage display;
        display = new GreenfootImage( Integer.toString( playerScore ), 55, Color.WHITE ,null);
        display = new GreenfootImage( String.format("Name: %3s%3d", playerName,playerScore), 55, Color.WHITE ,null);
        
        setImage(display);
        scoreChanged = false;
    }
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        if( scoreChanged == true)
        {
            displayScore();
        }
        
    }    
    
    /**
     * countScore adds 1 to playerScore
     * 
     *@param there are no parameters
     *@return there is no return
     */
    public void countScore()
    {
        playerScore ++; //adds one to the player score
        scoreChanged = true;
    }
    
    /**
     * getScore returns the new playerScore
     * 
     *@param there are no parameters
     *@return the new playerScore
     */
    public int getScore()
    {
        return playerScore;
    }
    
    /**
     * changeName changes the name slot to the name entered by the player
     * 
     *@param name representing the players name
     *@return there is no return 
     */
    public void changeName(String name)
    {
        playerName = name;
    }
     
}