#include<sys/stat.h>
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<sys/types.h>
#include<pwd.h>
#include<grp.h>
#include<dirent.h>
#include<unistd.h>

int main(int argc,char *argv[])
{
	DIR *dirptr,*subdirptr;
	struct dirent *entry,*subentry;
	struct stat s;
	memset(&s,0,sizeof(s));

	int n = atoi(argv[1]);
	char curDir[80];
	getcwd(curDir,80);
	if(argc<2)
	{
		printf("\n Insufficient arguments\n");
		exit(1);
	}	
	dirptr = opendir(curDir);
	while((entry = readdir(dirptr))!=NULL)
	{
		stat(entry->d_name,&s);
		printf("\n%s",entry->d_name);
		if(((s.st_mode & S_IFMT)==S_IFREG) && s.st_size > n)
			printf("\n%s : %ld",entry->d_name,s.st_size);
		if((s.st_mode & S_IFMT)==S_IFDIR) 
		{
			subdirptr = opendir(entry->d_name);
			while((subentry = readdir(subdirptr))!=NULL)
			{
				stat(subentry->d_name,&s);
				if(((s.st_mode & S_IFMT)==S_IFREG) && s.st_size > n)
					printf("\n%s : %ld",subentry->d_name,s.st_size);
			}
		}
	}
	closedir(dirptr);
	return 0;
}
