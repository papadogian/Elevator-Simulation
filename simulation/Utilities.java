package simulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer; 
import java.util.ArrayList;

public class Utilities{

	/* class private methods */
	public static void flush(){
		System.out.flush();
		return;
	}

	/* class static methods */

	/* Checks the arguments that are being passed from the command line */

	public static void checkArgs(String[] args){

		if(args.length != 3){
         		System.out.println("\nWrong input.");
			flush();
                	System.out.println("Make sure that your input has the following format :");
			flush();
	                System.out.println("[n : number of elevators] [f : number of floors] [file : text file with people's behavior]\n");
			flush();
	                System.exit(1);
	        }
	        else{
			try{
				Simulation.elevators = Integer.parseInt(args[0]);
				Simulation.floors = Integer.parseInt(args[1]);
			}
			catch(NumberFormatException e){
				System.out.println("Exception NumberFormatException caught\nSystem exits");
				flush();
				System.exit(1);
			}
			Simulation.testfile = args[2];
	     	        System.out.println("Elevators : " + args[0]);
			flush();
                	System.out.println("Floors : " + args[1]);
			flush();
	                System.out.println("Testfile name : " + args[2]);
			flush();

        	}

		return;
	}

	/* Tokenizes the file (passed as argument from the command line) and stores it in the structure people (ArrayList<Person>) */

	public static void tokenizeInputFile(String filename){

		try{
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//StringBuffer stringBuffer = new StringBuffer(); //DEBUG ONLY
			StringTokenizer st1 = null;
			StringTokenizer st2 = null;
			String delimeter1 = " ";
			String delimeter2 = "[];";
			String line = null;
			Person person = null;
			ArrayList<Integer> floors = null;

			while((line = bufferedReader.readLine()) != null){
				//stringBuffer.append(line); //DEBUG ONLY
				st1 = new StringTokenizer(line, delimeter1);
				person = new Person();
				floors = new ArrayList<Integer>();
				person.setName(st1.nextToken());
				//System.out.println("token for person name : " + person.getName()); //DEBUG ONLY
				st2 = new StringTokenizer(st1.nextToken(), delimeter2);

				try{
					while(st2.hasMoreTokens()){
						floors.add(Integer.parseInt(st2.nextToken()));
					}
					person.setFloorsToVisit(floors);
					person.setSecondsToStay((int) Integer.parseInt(st1.nextToken()));
					person.setStartFloor((int) Integer.parseInt(st1.nextToken()));
				}
				catch(NumberFormatException e){
					System.out.println("Exception NumberFormatException caught\nSystem exits");
					flush();
	                                System.exit(1);
				}
				Simulation.people.add(person);
			}
			
			fileReader.close();
			//System.out.println("In file : \n" + stringBuffer.toString()); //DEBUG ONLY

		}
		catch(IOException e){
			System.out.println("Exception IOException caught\nSystem exits");
			flush();
			System.exit(1);
		}

		return;
	}

	/* Simulation 's messages */

	public static void printWaitMsg(String name, int start, int end){

		System.out.println(name + " waiting on " + start + " for floor " + end);
		flush();
		return;

	}

	public static void printTakeMsg(String name, int elevator){

		System.out.println(name + " taking elevator " + elevator);
		flush();
		return;

	}

	public static void printArriveMsg(String name, int floor){

		System.out.println(name + " arrived at floor " + floor);
		flush();
		return;

	}

	public static void printElevatorState(int elevator, int floor, String state){

		if(state.compareTo("arrived at") == 0 || state.compareTo("serviced") == 0){
			System.out.println("Elevator " + elevator + " " + state + " floor " + floor);
			flush();
		}

		return;
	}

}

