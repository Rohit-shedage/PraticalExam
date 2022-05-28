#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include<sys/wait.h>

void separate_tokens(char *cmd,char *tok[])
{
	int i=0;
	char *p;
	
	p=strtok(cmd," ");
	puts(p);
	while(p!=NULL)
	{
		tok[i++]=p;
		p=strtok(NULL," ");
	}
	tok[i]=NULL;
}

void count(char *fileName,char param)
{
	printf("\ninside count\n");
}

int main()
{
	char cmd[80],*args[10];
	int pid;
	
	do
	{
		printf("\nNewShell$ ");
		fgets(cmd,80,stdin);
		cmd[strlen(cmd)-1]='\0';
		separate_tokens(cmd,args);

		if(strcmp(args[0],"count")==0)
			count(args[2],args[1][0]);
		else 
		{
			pid = fork();
			if(pid > 0)
				wait(0);
			else if(execvp(args[0],args)==-1)
				printf("\n Command %s not found\n",args[0]);
		}
	}while(1);
	return 0;
}
