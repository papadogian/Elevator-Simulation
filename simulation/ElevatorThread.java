package simulation;

import java.lang.Thread;

public class ElevatorThread extends Thread{

	private String msg = null;
	private int timeout = 0;
	
	public ElevatorThread(String msg, int timeout){
		this.msg = msg;
		this.timeout = timeout;
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
		System.out.println("Elevator " + msg + " arrived after " + timeout + " secs");
		Utilities.flush();
	}

}

