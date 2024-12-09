package synchronisation;

public class ThreadB extends Thread {
	Semaphore mutexA;
	Semaphore mutexB;
	Semaphore mutexC;

	public ThreadB(Semaphore mutexA, Semaphore mutexB, Semaphore mutexC) {
		this.mutexA = mutexA;
		this.mutexB = mutexB;
		this.mutexC = mutexC;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			mutexB.acquire();
			System.out.println("B");
			mutexC.release();
			//mutexA.release();

		}
	}

}