package TP5Part2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CarPark {

private int capacity;
private int available;

public CarPark(int capacity) {
    this.capacity = capacity;
    this.available = capacity;
}

public synchronized void arrive() {
    while (available <= 0) {
        try {
            wait();
        } catch (InterruptedException e) {
            return;
        }
    }

    available--;
    System.out.println(Thread.currentThread().getName() + " arrive [il reste " + available + " place (s)]");
}

public synchronized void depart() {
    available++;
    notifyAll();
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