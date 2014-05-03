package simulation;

import java.util.ArrayList;

/**
 *
 * @author evouta
 */

public class Simulation {

	public static int elevators = 0;
	public static int floors = 0;
	public static String testfile = null;
	public static ArrayList<Person> people = null;
	public static int maxCapacity = 3;

	public static void main(String[] args) {

		Utilities.checkArgs(args);

		people = new ArrayList<Person>();
		Utilities.tokenizeInputFile(testfile);	   

		
		return; 
    	}
    
}

