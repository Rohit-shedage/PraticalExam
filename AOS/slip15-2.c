#include<stdio.h>
#include<signal.h>
#include<unistd.h>
#include<stdlib.h>

void sighup(int signo)
{
	signal(SIGHUP,sighup);
	printf("\nCHILD : I have received SIGHUP");
}

void sigint(int signo)
{
	signal(SIGINT,sigint);
	printf("\nCHILD : I have received SIGINT");
}

void sigquit(int signo)
{
//	signal(SIGQUIT,sigquit);
	printf("\nCHILD : My daddy has killed me");
	exit(0);
}

int main()
{
	int pid;
	struct sigaction sigact;
	sigact.sa_flags=0;
	sigemptyset(&sigact.sa_mask);
	
	sigact.sa_handler = sighup;
	if(sigaction(SIGHUP,&sigact,NULL)<0)
	{
		printf("\nsigaction error");
		exit(1);
	}

	sigact.sa_handler = sigint;
	if(sigaction(SIGINT,&sigact,NULL)<0)
	{
		printf("\nsigaction error");
		exit(1);
	}

	sigact.sa_handler = sigquit;
	if(sigaction(SIGQUIT,&sigact,NULL)<0)
	{
		printf("\nsigaction error");
		exit(1);
	}

	if((pid=fork()) < 0)
	{
		printf("\nfork error");
		exit(1);
	}
	if(pid == 0)	//child
	{
		for(;;)	;
	}
	else			//parent
	{
		sigact.sa_handler = SIG_DFL;
		
		sigaction(SIGHUP,&sigact,NULL);
		sigaction(SIGINT,&sigact,NULL);
		sigaction(SIGQUIT,&sigact,NULL);
	
		printf("\nparent sending SIGHUP");
		kill(pid,SIGHUP);
		sleep(3);
		printf("\nparent sending SIGINT");
		kill(pid,SIGINT);
		sleep(3);

		printf("\nparent sending SIGHUP");
		kill(pid,SIGHUP);
		sleep(3);
		printf("\nparent sending SIGINT");
		kill(pid,SIGINT);
		sleep(3);

		printf("\nparent sending SIGINT");
		kill(pid,SIGINT);
		sleep(3);

		printf("\nparent sending SIGQUIT");
		kill(pid,SIGQUIT);
		sleep(3);
	}
	return 0;
}
