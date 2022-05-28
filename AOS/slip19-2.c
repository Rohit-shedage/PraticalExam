#include<stdio.h>
#include<unistd.h>
#include<sys/wait.h>
#include<signal.h>

pid_t pid;

static void sig_handler(int signo)
{
//	if(signo==SIG_ERR)
//		printf("\n sig err");
	if(signo == SIGCHLD)
		printf("\nchild signal");
	if(signo == SIGALRM)
	{
		printf("\n alarm signal");
		kill(pid,SIGKILL);
	}
}

int main()
{
	signal(SIGCHLD,sig_handler);
	signal(SIGALRM,sig_handler);
	if((pid=fork())<0)
		printf("\nfork error");
	if(pid==0)
	{
//		sleep(5);
		execlp("ls","ls","-l",NULL);
	}
	alarm(5);
	wait(NULL);
	return 0;
}
