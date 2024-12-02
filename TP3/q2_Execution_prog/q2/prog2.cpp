// 2.2. Modifiez le programme du 1.3 pour que chaque fils lance un 
// processus xterm qui ouvre une fenêtre shell, (ou xeyes ou xclock). 
// Puis observez le comportement du père quand vous fermez les 
// fenêtres (chaque fermeture de fenêtre doit provoquer 
// l’affichage d’un message par le père).

#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t firstChild_pid = fork();

    if (firstChild_pid == 0) {
        std::cout << "Je suis le premier processus fils. Mon PID : " << getpid() << std::endl;

        // xterm dans le premier fils
        execlp("xterm", "xterm", "-e", "echo Premier fils; sleep 5", NULL);

        // Si OK skip le code suivant 
        std::cerr << "Erreur lors de l'exécution de execlp." << std::endl;
        exit(1);
    } else if (firstChild_pid > 0) {
        std::cout << "Je suis le processus père. Mon PID : " << getpid() << std::endl;

        pid_t secondChildPid = fork();

        if (secondChildPid == 0) {
            std::cout << "Je suis le deuxième processus fils. Mon PID : " << getpid() << std::endl;

            // xterm dans le deuxième fils
            execlp("xterm", "xterm", "-e", "echo Deuxième fils; sleep 5", NULL);

            // Si OK, skip le reste
            std::cerr << "Erreur lors de l'exécution de execlp." << std::endl;
            exit(2);
        } else if (secondChildPid > 0) {
            // Code du processus père
            // Attente de la fin des deux fils
            int status;
            pid_t terminatedChildPid;

            while ((terminatedChildPid = wait(&status)) != -1) {
                std::cout << "Le fils avec PID " << terminatedChildPid << " s'est terminé." << std::endl;
            }
        } else {
            std::cerr << "Erreur lors du fork du deuxième fils." << std::endl;
            return 1;
        }
    } else {
        std::cerr << "Erreur lors du fork du premier fils." << std::endl;
        return 1;
    }

    return 0;
}
