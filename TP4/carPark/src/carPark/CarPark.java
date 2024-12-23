package carPark;

import java.util.Random;

public class CarPark {
	private int capacity;
	
	public CarPark(int capacity) {
		this.capacity = capacity;
	}
	
	public synchronized void arrive() {
		System.out.println(Thread.currentThread().getName() + " arrive");
		if (capacity == 0) {
			System.out.println(Thread.currentThread().getName() + " is waiting");
		} else {
			capacity--;
			System.out.println(Thread.currentThread().getName() + " park");
		}
		
	}
	
	public synchronized void depart() {
		System.out.println(Thread.currentThread().getName() + " depart");
		capacity++;
	}
	
	public static void main(String args[]) {
		CarPark carpark = new CarPark(4); // 
		System.out.println("Car park has 4 spaces");
		
		Random r = new Random(); // Random number generator
		int nbrCars = 50;	// Number of cars  to create.
		System.out.println("number of cars:" + nbrCars);
		
		for(int i=0; i<nbrCars; i++) {
			try {
				Thread.sleep(r.nextInt(10) * 1000); // Random sleep between 0 and 9 seconds
			} catch (InterruptedException e) {
				return;
			}
			new Thread(new Cars("Car " + i, carpark)).start(); // Create a new thread for each car and start it 
		}
		
		
	}

}
