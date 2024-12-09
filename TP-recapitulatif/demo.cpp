#include <iostream>
#include <unistd.h>

using namespace std;

int main(){

    int child_pid = fork();

    if (child_pid ==0){ // child process

        cout << "Je suis le processus fils. Mon PID : " << getpid() << ", PID de mon père : " << getppid() << endl;
    }
    else if (child_pid > 0){ // parent process
   
        cout << "Je suis le processus père. Mon PID : " << getpid() << ", PID de mon père : " << getppid() << endl;
    }
    else {
        cerr << "Erreur lors du fork." << endl;
        return 1;
    }


    return 0;
}