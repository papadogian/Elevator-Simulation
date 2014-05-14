package simulation;

import java.lang.Thread;
import java.util.ArrayList;

public class ElevatorThread extends Thread{

	private int elevator = 0;
	private int timeout = 0;
	private int startfloor = 0;
	private int capacity = 3;
	private ArrayList<Person> peoplein;	

	public ElevatorThread(int e, int timeout){
		this.elevator = e;
		this.timeout = timeout;
		if(Simulation.floors > 0) this.startfloor = e % Simulation.floors;
		else this.startfloor = 0;
	}

	public void run(){
		try{
			Thread.sleep(timeout * 1000);
		}
		catch(InterruptedException e){
			System.out.println("InterruptedException caught");
			Utilities.flush();
			System.exit(1);
		}
		System.out.println("Elevator " + elevator + " arrived after " + timeout + " secs from floor " + startfloor);
		Utilities.flush();
	}

}

