package TP5;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String args[]) throws InterruptedException {
	Semaphore mutexA = new Semaphore(1);
	Semaphore mutexB = new Semaphore(1);
	Semaphore mutexC = new Semaphore(1);
	
	ThreadA threadA = new ThreadA(mutexA);
	ThreadB threadB = new ThreadB(mutexB);
	ThreadC threadC = new ThreadC(mutexC);
	
	threadA.start();
	threadB.start();
	threadC.start();
	
	threadA.join();
	threadB.join();
	threadC.join();

	}
}
