// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Michael Swanson /s  Andrew Fisher 
// RESOURCES: N/a

package snake;

/**
 * This class defines the Snake object for use in the Snake game.
 * @author Michael Swanson Andrew Fisher
 * 
 */
public class Snake
{
	/**
	 * Default values for X Y coordinates.
	 */
	private final int dEFVALUEXY = 20;
	/**
	 * Max snake length.
	 */
	private final int snakeLength = 5000;
	/**
	 * Sets the coordinates.
	 */
	private final int snakeCoords = 2;
	/**
	 * default starting X position.
	 */
	private int xHead = dEFVALUEXY;
    /**
     * default starting Y position.
     */
	private int yHead = dEFVALUEXY;
     /**
     * starting length. 
     */
	private int totallength = 4;
     /**
     * starting direction. 
     */
	private Direction direct = Direction.DOWN;
	 /**
     * Max size for the snake array and initial head value.  
     */
	private int[][] size = new int[snakeLength][snakeCoords];
	{	
		size[0][0] = xHead;
		size[0][1] = yHead;
	}	
	/**
	 * The default constructor for the Snake. 
	 * It should do the same as the specific constructor 
	 * except that it will use the value of 20 as the Default 
	 * value for both the X and Y values for the head as the parameters.
	 */
	public Snake()
	{
		int t = yHead - 1;
		int b = xHead;
		size[0][0] = xHead;
		size[0][1] = yHead;
		for (int n = 1; n < totallength + 1; n++)
		{
			if (t > 0 && b > 0)  //if space, grow above head
			{
				size[n][0] = xHead;
				size[n][1] = t;
				t--;
			}
			else if (t == 0 && b > 0) //else if space, grow left
			{
				size[n][1] = t;
				size[n][0] = b;
				b--;
			}
			else if (b == 0)
			{
				size[n][0] = b;
				size[n][1] = t;	
				t++;
			}
		}
		
	}
	/**
	 * The specific constructor for the Snake.
	 * @param headXIn the initial X value for the head of the Snake.
	 * @param headYIn the initial Y value for the head of the Snake.
	 */
	public Snake(int headXIn, int headYIn)
	{
		int t = headYIn - 1;
		int b = headXIn;
		xHead = headXIn;
		yHead = headYIn;
		size[0][0] = headXIn;
		size[0][1] = headYIn;			
		for (int n = 1; n < totallength + 1; n++)
		{
			if (t > 0 && b > 0)  //if space, grow above head
			{
				size[n][0] = headXIn;
				size[n][1] = t;
				t--;
			}
			else if (t == 0 && b > 0) //else if space, grow left
			{
				size[n][1] = t;
				size[n][0] = b;
				b--;
			}
			else if (b == 0)
			{
				size[n][0] = b;
				size[n][1] = t;	
				t++;
			}
		}			
	}
	/**
	 * Returns the current X value for the head of the Snake.
	 * @return the current X value for the head of the Snake.
	 */
	public int getHeadX()
	{
		return xHead;
	}
	/**
	 * Returns the current Y value for the head of the Snake.
	 * @return the current Y value for the head of the Snake.
	 */
	public int getHeadY()
	{
		return yHead;
	}
	/**
	 * he move method should move the Snake forward one 
	 * space in the current Direction.
	 */
	public void move()
	{
		if (direct == Direction.DOWN)
		{ 		
			follow();
			yHead++;
			size[0][1] = yHead;
		}
		else if (direct == Direction.UP)
		{
			
			follow();
			yHead--;
			size[0][1] = yHead;
		}
		else if (direct == Direction.LEFT)
		{
			follow();
			xHead--;
			size[0][0] = xHead;
		}
		else if (direct == Direction.RIGHT)
		{
			follow();
			xHead++;		
			size[0][0] = xHead;
		}
	}
	/**
	 * Determines if the head of the Snake has hit another part of the Snake.
	 * @return true if the Snake hit itself
	 */
	public boolean hitSelf()
	{
		Boolean result = false;
		for (int n = 1; n < totallength; n++)
		{
			if (xHead == size[n][0] && yHead == size[n][1])
			{
				result = true;
			}
		}
		return result;
	}
	/**
	 *The current Direction of the Snake.
	 * @return The current Direction of the Snake.
	 */
	public Direction getDirection()
	{
		return direct;
	}
	/**
	 * Changes the Direction of the Snake, except if the new Direction is 
	 * directly opposite of the current one.
	 * @param dirIn the Direction that the Snake is trying to change to be facing
	 */
	public void changeDir(Direction dirIn)
	{
		boolean changDir = direct != dirIn 
				&& ((direct == Direction.DOWN && dirIn != Direction.UP) 
						|| (direct == Direction.UP && dirIn != Direction.DOWN)) 
				|| ((direct == Direction.LEFT && dirIn != Direction.RIGHT)
						|| (direct == Direction.RIGHT && dirIn != Direction.LEFT));
		if (changDir)
		{
			direct = dirIn;
		}
	}
	/**
	 * The current length value of the Snake.
	 * @return The current length value of the Snake.
	 */
	public int getLength()
	{
		return totallength;
	}	
	/**
	 * Returns the current Snake 2d array.
	 * @return The current Snake 2d array.
	 */
	public int[][] getSnake()
	{
		return size;
	}
	/**
	 * Increases the current length of the Snake by 1 and grows the snake.
	 */ 
	public void increaseLength()
	{
		size[totallength][0] = size[totallength - 1][0];
		size[totallength][1] = size[totallength - 1][1];			
		totallength++;
	}
	/**
     * the loop that makes the tail follow the head.
     */
	private void follow()
	{
		int[][] precoords = new int[snakeLength][snakeCoords];
		for (int n = 1; n < totallength + 1; n++)
		{
			precoords[n][0] = size[n][0];
			precoords[n][1] = size[n][1];
		}
		for (int g = 1; g < totallength + 1; g++)
		{
			if (g == 1)
			{
				size[g][0] = size[0][0];
				size[g][1] = size[0][1];
			}
			else
			{
				size[g][0] = precoords[g - 1][0];
				size[g][1] = precoords[g - 1][1];
			}
		}
	} 	
}
