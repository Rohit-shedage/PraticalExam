#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>
#include<sys/wait.h>
#include<dirent.h>

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

void list(char *dirName,char param)
{
	DIR *dir;
	int count=0;
	struct dirent *entry;
//	struct stat buff;
	
	if((dir=opendir(dirName))==NULL)
	{
		printf("\n\tDirectory %s notfound\n",dirName);
		return;
	}
	switch(param)
	{
		case 'f':	while((entry=readdir(dir))!=NULL)
						printf("\n%s",entry->d_name);
					break;
		case 'n':	while((entry=readdir(dir))!=NULL)
						count++;
					printf("\nTotal number of entries = %d\n",count);
					break;	
		case 'i':	while((entry=readdir(dir))!=NULL)
						printf("\n%ld:%s",entry->d_ino,entry->d_name);
					break;	
	}
}

int main()
{
	char cmd[80],*args[10];
	int pid;
	
	system("clear");	
	do
	{
		printf("\nNewShell$ ");
		fgets(cmd,80,stdin);
		cmd[strlen(cmd)-1]='\0';
		separate_tokens(cmd,args);

		if(strcmp(args[0],"list")==0)
			list(args[2],args[1][0]);
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
