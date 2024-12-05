package TP5Part2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CarParkBonus {

private int capacity;
private Semaphore available;

public CarParkBonus(int capacity) {
    this.capacity = capacity;
    this.available = new Semaphore(capacity);
}

public synchronized void arrive() {
    try {
		available.acquire();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(Thread.currentThread().getName() + " arrive [il reste " + available.availablePermits() + " place (s)]");
}

public synchronized void depart() {
    available.release();
    System.out.println(Thread.currentThread().getName() + " repart");
}

public static void main(String[] args) {
    CarPark carpark = new CarPark(4);

    Random r = new Random();

    for (int i = 0; i < 100; i++) {
        try {
            Thread.sleep(r.nextInt(5) * 1000);
        } catch (InterruptedException e) {
            return;
        }

        new Thread(new Cars("voiture" + i, carpark)).start();
    }
}
}
