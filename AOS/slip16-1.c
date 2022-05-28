#include<stdio.h>
#include<signal.h>

void handle_sigint(int sig)
{
	printf("\ncaught signal %d\n",sig);
	signal(SIGINT, SIG_DFL);
}

int main()
{
	signal(SIGINT,handle_sigint);
	while(1)
	{
		printf("hello world\n");
		sleep(1);
	}
	return 0;
}
