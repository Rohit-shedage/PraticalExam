#include<stdio.h>
#include<unistd.h>
#include<signal.h>

static void sig_handler(int signo)
{
	if(signo == SIGINT)
		printf("\nCaught SIG_INT");
	if(signo == SIGQUIT)
		printf("\nCaught SIG_INT");

	if(signal(SIGINT,SIG_DFL)==SIG_ERR)
		printf("\ncan't reset SIGINT");
	if(signal(SIGQUIT,SIG_DFL)==SIG_ERR)
		printf("\ncan't reset SIGQUIT");

}

int main()
{
	sigset_t newmask, oldmask, pendmask;
	
	if(signal(SIGINT,sig_handler)==SIG_ERR)
		printf("\ncant catch sigint");
	if(signal(SIGQUIT,sig_handler)==SIG_ERR)
		printf("\ncant catch sigquit");

	sigemptyset(&newmask);
	sigaddset(&newmask, SIGINT);
	sigaddset(&newmask, SIGQUIT);


	int pipefd[2],retstatus,pid;
	
	retstatus = pipe(pipefd);
	if(retstatus==-1)
	{
		printf("\nfailed to create pipe\n");
		return 1;
	}
	pid=fork();
	if(pid<0)
	{
		printf("\nfailed to create child\n");
		return 2;	
	}
	else if(pid==0)	//child process
	{
		close(pipefd[0]);	//close read end of pipe
		close(1);		// close std.output
		dup(pipefd[1]);
		execlp("ls","ls","-l",(char *)0);

	}
	else			// parent process
	{
		close(pipefd[1]);	// close write end of pipe
		close(0);	// close std. input
		dup(pipefd[0]);
		if(sigprocmask(SIG_BLOCK, &newmask, &oldmask)<0)
			printf("\nsigblock error");
		sleep(5);

		if(sigpending(&pendmask)<0)
			printf("\nsig-pending error");
		
		if(sigismember(&pendmask,SIGINT))
			printf("\nSIGINT pending");
	
		if(sigismember(&pendmask,SIGQUIT))
			printf("\nSIGQUIT pending");

		if(sigprocmask(SIG_SETMASK, &oldmask, NULL)<0)
			printf("\nsig_setmask error");

	printf("\nSIGINT unblocked");
	printf("\nSIGQUT unblocked");
	sleep(10);	
		execlp("wc","wc","-l",(char *)0);



	}
	return 0;
}
