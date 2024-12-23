package synchronisation;

public class Main {
	public static void main(String args[]) {
		Semaphore mutexA = new Semaphore(1); // 1 means the semaphore is available for use by a thread 
		Semaphore mutexB = new Semaphore(0);
		Semaphore mutexC = new Semaphore(0);
		
		new ThreadA(mutexA, mutexB, mutexC).start();
		new ThreadB(mutexA, mutexB, mutexC).start();
		new ThreadC(mutexA, mutexB, mutexC).start();
			
	}

}
