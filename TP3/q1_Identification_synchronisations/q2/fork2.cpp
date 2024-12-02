// sleep est une commande ou une fonction qui est utilisée pour mettre 
// en pause l'exécution d'un programme pour une période spécifiée.
// ------------------------------------------------------------------
// Avec sleep, retarder la fin de l'exécution du processus fils au 
// lieu du père pour inverser l'ordre de fin des deux processus. 
// Qui devient le père du processus fils lorsque son père « naturel » 
// se termine avant lui ? Pour le savoir, faites afficher la 
// liste des processus avec la commande : ps -ef | more
#include <iostream>
#include <unistd.h>


using namespace std;

int main(){
    pid_t child_pid;

    child_pid = fork();

    if (child_pid == 0) {
        std::cout << "Je suis le processus fils. Mon PID : " << getpid() << std::endl;

    } else if (child_pid > 0) {
        // Code du processus père
        std::cout << "Je suis le processus père. Mon PID : " << getpid() << std::endl;
    } 
    else {
        std::cerr << "Erreur lors du fork." << std::endl;
        return 1;
    }
    
    if (child_pid == 0) {
        // le processus fils
        cout << "sleep fils" << endl;
        sleep(10); 
        cout << "processus fils. Mon PID est " << getpid() << endl;
    } 
    if (child_pid > 0) {
        // le processus père
        // cout << "sleep père" << endl;
        // sleep(10); 
        cout << "processus père. Mon PID est:" << getpid() << endl;
    }

    return 0;
}