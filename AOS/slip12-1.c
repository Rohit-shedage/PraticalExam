#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<signal.h>
#include<string.h>
#include<sys/wait.h>

static void my_alarm(int signo)
{
	printf("\n in signal handler");
//	alarm(1);	
}

int main()
{
	int i;
	pid_t pid;
	signal(SIGALRM,my_alarm);

	if((pid=fork())<0)
		printf("\nfork error");
	if(pid==0)
	{
		printf("\n child");
		alarm(2);
		kill(getppid(),SIGALRM);
	}
//	alarm(2);
	else
	{
		printf("\nparent");
		for(i=1;;i++)
		{
			printf("\n inside main");
			sleep(1);
		}
	}
	return 0;

}
