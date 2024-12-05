package TP5;

import java.util.concurrent.Semaphore;

public class ThreadA extends Thread {
    private Semaphore mutexA;
		
    // ...

    public ThreadA(Semaphore mutexA) { 
 	   this.mutexA = mutexA;

 	   //...

    }
    
    @Override
    public void run() {
		
 	   for (int i = 0; i < 5; i++) {
 		   try {
			mutexA.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
 		   System.out.print("A");
 		   mutexA.release();
 	   }
    }
}
