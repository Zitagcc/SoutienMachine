package TP5;

//Permet à une classe d'hériter d'autres classes tout en pouvant être utilisée pour créer des threads.
//Permet à une classe de définir son propre comportement, indépendamment de la classe Thread.
//Permet à une classe de réutiliser le code de la classe Thread sans avoir à l'hériter.


public class HelloRunnable implements Runnable { 
	public void run() {      
		System.out.println("Hello from a runnable thread!"); // This is the code that will be executed
		// when the thread is started.
	}


	public static void main(String args[]) {
	
		(new Thread(new HelloRunnable())).start();
	
	} 

}
