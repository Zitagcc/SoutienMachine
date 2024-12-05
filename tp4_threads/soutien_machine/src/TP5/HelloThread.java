package TP5;


public class HelloThread extends Thread { 
	public void run() {
		System.out.println("Hello from a thread!");
	}


	public static void main(String args[]) {
	
		(new HelloThread()).start(); // start() calls the run() method of the thread object. 
		// If you call run() directly, it will run in the same thread as the caller.

	} 

}
