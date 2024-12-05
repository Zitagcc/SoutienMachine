package tp4q2;

class Cat extends Animal implements Runnable {
    public Cat(String name) {
        super(name);
    }

    // Méthode run pour définir la tâche du thread
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " is meowing!");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
            }
        }
    }
}
