#include<stdio.h>
#include<dirent.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>

int main(int argc,char *argv[])
{
	DIR *dirptr;
	struct dirent *entry;
	int found = 0;
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
		if(strcmp(entry->d_name,argv[1])==0)
		{
			printf("\nFile %s present in current directory\n",argv[1]);
			found=1;
			break;
		}
	}
	closedir(dirptr);
	if(found==0)
		printf("\nnFile %s not present in current directory\n",argv[1]);
	return 0;
}
