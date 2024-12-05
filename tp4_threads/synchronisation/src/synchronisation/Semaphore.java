package synchronisation;

public class Semaphore {
	private int permits;
	
	public Semaphore(int initailPermits) {
		permits = initailPermits;
	}
	
	public synchronized void acquire() {
		permits--;
		if (permits < 0) { // if no permits available
			try { // wait until a permit is released
				wait();
			} catch (InterruptedException e) { // if interrupted
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void release() {
		permits++;
		if (permits <= 0) { // if there are threads waiting
			notify(); // notify one thread to acquire a permit
		}
	}

}
