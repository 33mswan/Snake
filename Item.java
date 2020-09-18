// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Michael Swanson /s Andrew Fisher
// RESOURCES: N/a

package snake;

/**
 * This class defines the Item object for use in the Snake game.
 * @author Michael Swanson Andrew Fisher 
 *
 */
public class Item
{
	/**
	 * Used to set default X axis value.
	 */
	private final int defX = 25;
	/**
	 * Used to set default Y axis value.
	 */
	private final int defY = 25;
	/**
	 * Default X coordinate.
	 */
	private int xAxis = defX; 
	/**
	 * Default Y coordinate.
	 */
	private int  yAxis = defY;	
	/**
	 * Used to set Item position as a negative 1.
	 */
	public Item()
	{
		//position[xAxis][yAxis] = -1;
	}
	/**
	 * Used to set specific Item positions.
	 * @param itemXIn
	 * Specific Item X position.
	 * @param itemYIn
	 * Specific Item Y position.
	 */
	public Item(int itemXIn, int itemYIn)
	{
		setXY(itemXIn, itemYIn);
	}
	/**
	 * Used to return xAxis variable.
	 * @return xAxis
	 */
	public int getX()
	{
		return xAxis;
	}
	/**
	 * Used to return yAxis variable.
	 * @return yAxis
	 */
	public int getY()
	{
		return yAxis;
	}
	/**
	 * Used to set a new Item location.
	 * @param itemXIn
	 * Specific X position.
	 * @param itemYIn
	 * Specific Y position.
	 */
	public void setNewLocation(int itemXIn, int itemYIn)
	{
		setXY(itemXIn, itemYIn);
	}
	/**
	 * Used to create Item Array for positioning.
	 * @param xIn
	 * Sets X values for Item position.
	 * @param yIn
	 * Sets Y values for Item position.
	 */
	private void setXY(int xIn, int yIn)
	{
		if (xIn >= 0 && yIn >= 0)
		{
			xAxis = xIn;
			yAxis = yIn;
		}
	}
	/**
	 * Override method for toString.
	 */
	@Override
	public String toString()
	{
		String result = String.format("The item is located at position (%d, %d)", xAxis, yAxis);
		return result;
	}
}
