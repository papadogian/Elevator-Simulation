package simulation;

import java.util.ArrayList;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

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
		
		ElevatorThread e = null;
		PersonThread p = null;
		Integer i = 0;

		Utilities.checkArgs(args);

		people = new ArrayList<Person>();
		Utilities.tokenizeInputFile(testfile);	   

		for(i = 0 ; i < elevators ; i++){
			e = new ElevatorThread(i, 2);
			e.start();		
		}
		for(i = 0 ; i < people.size() ; i++){
			int end = people.get(i).getFloorsToVisit().size() - 1; 
			p = new PersonThread(people.get(i).getName(), people.get(i).getStartFloor(), people.get(i).getFloorsToVisit().get(end));
			p.start();
		}

		return; 
    	}
    
}

