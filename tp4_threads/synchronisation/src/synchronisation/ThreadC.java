package synchronisation;

public class ThreadC extends Thread {
	Semaphore mutexA;
	Semaphore mutexB;
	Semaphore mutexC;

	public ThreadC(Semaphore mutexA, Semaphore mutexB, Semaphore mutexC) {
		this.mutexA = mutexA;
		this.mutexB = mutexB;
		this.mutexC = mutexC;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			mutexC.acquire();
			System.out.println("C");
			mutexA.release();
			//mutexB.release();

		}
	}

}
