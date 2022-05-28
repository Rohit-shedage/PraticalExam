#include<stdio.h>
#include<sys/wait.h>
#include<stdlib.h>
#include<sys/types.h>
#include<unistd.h>

void pr_exit(int status)
{
	if(WIFEXITED(status))
		printf("\nnormal termination\nexit status = %d\n",WEXITSTATUS(status));
	else if(WIFSIGNALED(status))
		printf("\nabnormal termination\nsignal number = %d%s\n",WTERMSIG(status),
		
#ifdef WCOREDUMP
		WCOREDUMP(status)? "(Core file generated)":"");
#else
		"");
#endif
	else if(WIFSTOPPED(status))
		printf("\nchild stopped \nsignal number = %d\n",WSTOPSIG(status));
	 
}

int main()
{
	pid_t pid;
	int status;
	
	if((pid=fork())<0)
		printf("fork error");
	else if(pid==0)		//child
		exit(7);
	
	if(wait(&status) != pid)	//wait for child
		printf("wait error");
	pr_exit(status);			// & print its status
	
	if((pid=fork())<0)
		printf("fork error");
	else if(pid==0)		//child
		abort();		// generates SIGABRT
	
	if(wait(&status) != pid)	//wait for child
		printf("wait error");
	pr_exit(status);

	if((pid=fork())<0)
		printf("fork error");
	else if(pid==0)		//child
		status/=0;		// divide by 0 generates SIGFPE
	
	if(wait(&status) != pid)	//wait for child
		printf("wait error");
	pr_exit(status);
	
	return 0;
}
