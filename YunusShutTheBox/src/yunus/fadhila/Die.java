package yunus.fadhila;
import java.util.Random;
/**
 * Purpose: Creating the Dices
 * Author: Fadhila Yunus
 * Date: December 19, 2024
 */
public class Die {

	private int value;
	private int numSides;
	private static Random rand = new Random();
	
	/**
	 * Purpose: constructing the dices
	 * 
	 */
	public Die(){
		numSides = 6;
		value = roll();
		
	}
	
	/**
	 * Purpose: constructing the dices
	 * @param n: the variable that sets the num of sides
	 */
	public Die(int n){
	numSides = n;
	value = roll();
	
	}
	
	/**
	 * Purpose: Roll the dices
	 * @return: the rolled dices number
	 */
	public int roll(){
		value = rand.nextInt(numSides) + 1; //: 1 to numSides
		return value;
	}
	/**
	 * Purpose: set the sides on dices
	 * @param n: number of sides
	 * @return: the set side of dice
	 */
	public int setSides(int n){
		return numSides;
		
	}
	/**
	 * Purpose: Getting the value of rolled dice
	 * @return: returning the value of rolled
	 */
	public int getValue() {
		return value;
	}
}
