package TP5;

import java.util.concurrent.Semaphore;

class ThreadC extends Thread {

    private Semaphore mutexC;

    public ThreadC(Semaphore mutexC) {
        this.mutexC = mutexC;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
				mutexC.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.print("C");
            mutexC.release();
        }
    }
}
