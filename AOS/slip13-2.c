#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>
#include<sys/wait.h>
#include<dirent.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>


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

void typeline(char *fileName,char* count)
{
	int handle,n,i=0,cnt=0;
	char ch;
	
	if((handle=open(fileName,O_RDONLY))==-1)
	{
		printf("\n\file  %s notfound\n",fileName);
		return;
	}
	if(strcmp(count,"a")==0)
	{
		while((read(handle,&ch,1)!=0))
			printf("%c",ch);
		close(handle);
		return;
	}
	n=atoi(count);
	if(n>0)
	{
		while((read(handle,&ch,1)!=0))
		{
			if(ch=='\n') i++;
			if(i==n) break;
			printf("%c",ch);
		}
		printf("\n");
		close(handle);
		return;
	}
	if(n<0)
	{
		while((read(handle,&ch,1)!=0))
			if(ch=='\n') cnt++;
		lseek(handle,0,SEEK_SET);
		while((read(handle,&ch,1)!=0))
		{
			if(ch=='\n') i++;
			if(i==(cnt+n))
				break;
		}
		while((read(handle,&ch,1)!=0))
			printf("%c",ch);

		printf("\n");
		close(handle);
		return;
		
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

		if(strcmp(args[0],"typeline")==0)
			typeline(args[2],args[1]);
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
