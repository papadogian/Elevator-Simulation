package simulation;

import java.lang.Thread;

public class PersonThread extends Thread{


	private String name = null;
        private int endfloor = 0;
        private int startfloor = 0;

        public PersonThread(String name, int sf, int ef){
                this.name = name;
		this.startfloor = sf;
		this.endfloor = ef;
        }

        public void run(){
                System.out.println("" + name + " waiting on " + startfloor + " for floor " + endfloor);
                Utilities.flush();
        }
}

