// 2.1. Lancez dans le fils, au moyen de la primitive execlp (voirci-dessous),
// l’exécutiondelacommande ps -l et complétez de traces adéquates de 
// manière à vérifier que le fils que vous avez créé et la commandeps 
// ontbienlemêmePID (et donc qu’il s’agit bien du même processus).

#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t firstChildPid = fork();

    if (firstChildPid == 0) {
        std::cout << "Je suis le premier processus fils. Mon PID : " << getpid() << std::endl;

        // Exécution de la commande ps -l
        execlp("ps", "ps", "-l", NULL);

        std::cerr << "Erreur lors de l'exécution de execlp." << std::endl;
        exit(1);
    } else if (firstChildPid > 0) {
        std::cout << "Je suis le processus père. Mon PID : " << getpid() << std::endl;

    } else {
        std::cerr << "Erreur lors du fork du premier fils." << std::endl;
        return 1;
    }

    return 0;
}
