package simulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer; 
import java.util.ArrayList;

public class Utilities{

	/* class static methods */
	public static void checkArgs(String[] args){

		if(args.length != 3){
         		System.out.println("\nWrong input.");
                	System.out.println("Make sure that your input has the following format :");
	                System.out.println("[n : number of elevators] [f : number of floors] [file : text file with people's behavior]\n");
	                System.exit(1);
	        }
	        else{
			try{
				Simulation.elevators = Integer.parseInt(args[0]);
				Simulation.floors = Integer.parseInt(args[1]);
			}
			catch(NumberFormatException e){
				System.out.println("Exception NumberFormatException caught\nSystem exits");
				System.exit(1);
			}
			Simulation.testfile = args[2];
	     	        System.out.println("Elevators : " + args[0]);
                	System.out.println("Floors : " + args[1]);
	                System.out.println("Testfile name : " + args[2]);

        	}

		return;
	}

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
	                                System.exit(1);
				}
				Simulation.people.add(person);
			}
			
			fileReader.close();
			//System.out.println("In file : \n" + stringBuffer.toString()); //DEBUG ONLY

		}
		catch(IOException e){
			System.out.println("Exception IOException caught\nSystem exits");
			System.exit(1);
		}

		return;
	}

}

