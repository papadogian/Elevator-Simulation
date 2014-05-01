package simulation;

import java.util.ArrayList;

public class Person{

	private String name;
	private ArrayList<Integer> floorsToVisit;
	private int secondsToStay;
	private int startFloor;


	/* Constructor */
	public Person(){
		this.name = null;
		this.floorsToVisit = null;
		this.secondsToStay = 0;
		this.startFloor = 0;
	}

	/* Attributes' setters */
	public void setName(String name){
		this.name = name;
		return;
	}

	public void setFloorsToVisit(ArrayList<Integer> floors){
                this.floorsToVisit = floors;
                return;
        }

	public void setSecondsToStay(int secs){
                this.secondsToStay = secs;
                return;
        }

	public void setStartFloor(int start){
                this.startFloor = start;
                return;
        }

	
	/* Attributes' getters */
	public String getName(){
		return this.name;
	}

	public ArrayList<Integer> getFloorsToVisit(){
                return this.floorsToVisit;
        }

	public int getSecondsToStay(){
                return this.secondsToStay;
        }

	public int getStartFloor(){
                return this.startFloor;
        }

	/* Override toString() method */
	public String toString(){
		return "\nPerson's Name [" + this.name + "] Floors to visit [" + this.floorsToVisit.toString() + "] Seconds to Stay [" + this.secondsToStay + "] Start Floor [" + this.startFloor + "]";
	}

}


