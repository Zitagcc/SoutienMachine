// Affichage du PID et du PPID pour le père et le fils

// 1.1. Programmez pour chacun des processus père et fils 
// l'affichage de son PID et du PID de son père (fonctions getpid() 
// et getppid() qui renvoient un entier). Qui est le créateur (père) 
// du processus père ? Pour le savoir, affichez la liste de vos 
// processus avec : ps -l 

#include <iostream>
#include <unistd.h>

using namespace std;

int main(){
    pid_t child_Pid = fork();

    if (child_Pid == 0) {
        std::cout << "Je suis le processus fils. Mon PID : " << getpid() << ", PID de mon père : " << getppid() << std::endl;

    } else if (child_Pid > 0) {
        // Code du processus père
        std::cout << "Je suis le processus père. Mon PID : " << getpid()
                  << ", PID de mon père : " << getppid() << std::endl;

    } 
    else {
        std::cerr << "Erreur lors du fork." << std::endl;
        return 1;
    }

    return EXIT_SUCCESS;
}