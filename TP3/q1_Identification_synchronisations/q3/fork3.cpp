// wait est utilisée dans les systèmes basés sur Unix pour 
// attendre la fin d'un processus enfant.
// ----------------------------------------------------------------
// 1.3. La primitive wait, exécutée par un processus, bloque ce 
// dernier jusqu’à la fin d’un de ses fils. Si le processus 
// n’a pas de fils actif, wait renvoie -1, dans le cas contraire, 
// elle renvoie le numéro (PID) du fils mort. Modifiez le 
// schéma de création de façon à créer deux fils et à faire en sorte 
// que le père les attende grâce à wait(NULL)et affiche 
// pour chacun son identification (valeur retournée par wait). 
// Les fils se contenteront d’afficher leur PID.

#include <iostream>
#include <unistd.h>

using namespace std;


int main() {
    pid_t child_pid1, child_pid2;
    int status;

    child_pid1 = fork();

    if (child_pid1 == 0) {
        // Code du premier processus fils
    cout << "Premier processus fils. Mon PID est " << getpid() << endl;
        exit(0);
    }

    child_pid2 = fork();

    if (child_pid2 == 0) {
        // Code du deuxième processus fils
    cout << "Deuxième processus fils. Mon PID est "<< getpid() << endl;
        exit(0);
    }

    // Code du processus père
    cout << "Processus père. Mon PID est "<< getpid()<< endl;

    // Attendez que les deux fils se terminent
    wait(&status);
    cout << "Le premier fils (PID " << child_pid1 << ") s'est terminé avec le statut " << WEXITSTATUS(status) << endl;
    wait(&status);
    cout << "Le deuxième fils (PID " << child_pid2 << ") s'est terminé avec le statut " << WEXITSTATUS(status) << endl;

    return 0;
}
