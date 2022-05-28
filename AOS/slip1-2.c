#include<stdio.h>
#include<signal.h>

static void sig_quit(int signo)
{
	printf("\nCaught SIG_QUIT");
	if(signal(SIGQUIT,SIG_DFL)==SIG_ERR)
		printf("\ncan't reset SIGQUIT");
}

int main()
{
	sigset_t newmask, oldmask, pendmask;
	
	if(signal(SIGQUIT,sig_quit)==SIG_ERR)
		printf("\ncant catch sigquit");
	sigemptyset(&newmask);
	sigaddset(&newmask, SIGQUIT);

	if(sigprocmask(SIG_BLOCK, &newmask, &oldmask)<0)
		printf("\nsigblock error");
	sleep(5);

	printf("old signal set : %8.8ld.\n",oldmask);

	if(sigpending(&pendmask)<0)
		printf("\nsig-pending error");
	printf("pending signal set : %8.8ld.\n",pendmask);
	
	if(sigismember(&pendmask,SIGQUIT))
		printf("\nSIGQUIT pending");
	
	if(sigprocmask(SIG_SETMASK, &oldmask, NULL)<0)
		printf("\nsig_setmask error");
	

	printf("\nSIGQUIT unblocked");
	printf("\nhello\n");
	sleep(10);
	printf("\nhello\n");
 
	return 0;
}
