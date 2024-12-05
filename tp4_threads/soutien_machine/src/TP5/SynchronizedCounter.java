package TP5;

public class SynchronizedCounter { 
	private int c = 0;
	public synchronized void increment() {
		c++;	
	}
	
	public synchronized void decrement() {
		c--;
	}

	public synchronized int value() {

		return c;

	} 
	
	public static void main(String args[]) {
		
		(new HelloThread()).start();	

	} 
	
}
