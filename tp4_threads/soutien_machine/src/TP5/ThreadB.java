package TP5;

import java.util.concurrent.Semaphore;

public class ThreadB extends Thread {

	private Semaphore mutexB; 

	public ThreadB(Semaphore mutexB) {
		this.mutexB = mutexB;
	}
	
	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			try {
				mutexB.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("B");
			mutexB.release();
		}
	}
}