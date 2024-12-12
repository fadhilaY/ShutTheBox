package yunus.fadhila;
import java.util.Random;
public class Die {

	private int value;
	private int numSides;
	private static Random rand = new Random();
	
	
	public Die(){
		numSides = 6;
		value = roll();
		
	}
	
	public Die(int n){
	numSides = n;
	value = roll();
	
	}
	
	public int roll(){
		value = rand.nextInt(numSides) + 1; //: 1 to numSides
		return value;
	}
	
	public int setSides(int n){
		return numSides;
		
	}
}
