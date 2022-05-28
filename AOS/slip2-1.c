#include<stdio.h>
#include<dirent.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>

int startsWith(char *fileName, char *start)
{
	int i,len = strlen(start);
	for(i=0;i<len;i++)
	{
		if(fileName[i]==start[i])
			continue;
		break;
	}
	if(i==len)
		return 0;
	return 1;
}

int main(int argc,char *argv[])
{
	DIR *dirptr;
	struct dirent *entry;
	char curDir[20];

	getcwd(curDir,20);
	if(argc<2)
	{
		printf("\n Insufficient arguments\n");
		exit(1);
	}	
	dirptr = opendir(curDir);
	while((entry = readdir(dirptr))!=NULL)
	{
		if(startsWith(entry->d_name,argv[1])==0)
			printf("\n%s",entry->d_name);
	}
	closedir(dirptr);
	return 0;
}
