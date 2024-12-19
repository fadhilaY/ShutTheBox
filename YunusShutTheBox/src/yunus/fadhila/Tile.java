package yunus.fadhila;
/**
 * Purpose: Creating tiles
 * Author: Fadhila Yunus
 * Date: December 19, 2024
 */
public class Tile {
	private int value;
	private boolean isUp;
	
	/**
	 * Purpose: creating the tiles
	 * @param n: the value of tiles
	 */
	Tile(int n){
		value = n;
		isUp = true;
		
	}
	/**
	 * Purpose: receive the value of tile
	 * @return: the tiles
	 */
	public int getValue() {
		return value;
		
	}
	/**
	 * Purpose: Determine the state of tiles
	 * @return: if not selected tile, leave it up
	 */
	public boolean isUp() {
		return isUp;
		
	}
	/**
	 * Purpose: Determine the state of tiles
	 */
	public void putDown() {
		isUp = false;
		
	}
	/**
	 * Purpose: Return statements for word version of game
	 */
	@Override
	public String toString() {
		String response = "";
		if (isUp) {
			response = "Value " + value + " : UP ";
		}
		else {
			response = "Value " + value + " : DOWN ";
		}
		return "Value " + value + " ";
		
		
	}
}
