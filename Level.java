// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Michael Swanson Andrew Fisher 
// RESOURCES: N/a

package snake;

import java.util.Random;

//import testing.GameState;
//import testing.Item;
//import testing.Snake;

/**
 * Creates a default level with a given dimension.
 * @author 33
 *
 */
public class Level
{	
	/**
	 * Creates a Random modifier.
	 */
	private Random getRand = new Random();
	/**
	 * Creates a new Item.
	 */
	private Item currentItem;
	/**
	 * Creates a snake.
	 */
	private Snake currentSnake;
	/**
	 * Creates the current map Array.
	 */
	private int[][] currentMap;
	/**
	 * Sets the game state to playing.
	 */
	private GameState currentGameState = GameState.PLAYING;
	/**
	 * Creates a default level with a given dimension.
	 * @param widthIn The logical width of the new level.
	 * @param heightIn The logical height of the new level.
	 * @param randIn The Random object that will be used to generate new Item locations.
	 */
	public Level(int widthIn, int heightIn, Random randIn)
	{
		currentMap = new int[heightIn][widthIn];
		currentSnake = new Snake();
		currentItem = new Item();
		getRand = randIn;
	}
	/**
	 * Updates a single step.
	 */
	public void updateOneStep()
	{	
		generateMap();
		currentSnake.move();
		if (currentSnake.getHeadX() < 0 || currentSnake.getHeadX() > currentMap[0].length - 1)
		{
			currentGameState =  GameState.LOST;
		}
		else if (currentSnake.getHeadY() < 0 || currentSnake.getHeadY() > currentMap.length - 1)
		{
			currentGameState =  GameState.LOST;
		}
		else if (currentSnake.hitSelf())
		{
			currentGameState =  GameState.LOST;
		}
		else if (currentSnake.getHeadX() == currentItem.getX() 
				&& currentSnake.getHeadY() == currentItem.getY())
		{
			currentItem.setNewLocation(getRand.nextInt(currentMap[0].length), 
					getRand.nextInt(currentMap.length));
			while (currentMap[currentItem.getY()][currentItem.getX()] == 1 
					|| currentMap[currentItem.getY()][currentItem.getX()] == -1)
			{
				currentItem.setNewLocation(getRand.nextInt(currentMap[0].length), 
						getRand.nextInt(currentMap.length));
			}
			currentSnake.increaseLength();
		}
	}
	/**
	 *Generates the 2-dimensional map of the game area.
	 */
	public void generateMap()
	{
		for (int r = 0;  r < currentMap.length; r++)
		{
			for (int c = 0; c < currentMap[r].length; c++)
			{
				currentMap[r][c] = 0;
			}
		}
		currentMap[currentItem.getY()][currentItem.getX()] = -1;
		boolean snakeHeadPos = currentSnake.getHeadX() >= 0 && currentSnake.getHeadY() >= 0 
				&& currentSnake.getHeadX() < currentMap[0].length
				&& currentSnake.getHeadY() < currentMap.length;
		if (snakeHeadPos)
		{
			currentMap[currentSnake.getHeadY()][currentSnake.getHeadX()] = 1;
		}
		for (int n = 0; n < currentSnake.getLength(); n++)
		{
			currentMap[currentSnake.getSnake()[n][1]][currentSnake.getSnake()[n][0]] = 1;
		} 
	}
	/**
	 * Returns currentItem.
	 * @return The current Item.
	 */
	public Item getItem()
	{
		return currentItem;
	}
	/**
	 * Returns currentSnake.
	 * @return  The current Snake.
	 */
	public Snake getSnake()
	{
		return currentSnake;
	}
	/**
	 * Returns currentMap.
	 * @return The current 2d array map.
	 */
	public int[][] getMap()
	{
		return currentMap;
	}
	/**
	 * Returns currentGameState.
	 * @return The current GameState.
	 */
	public GameState getGameState()
	{
		return currentGameState;
	}
}
