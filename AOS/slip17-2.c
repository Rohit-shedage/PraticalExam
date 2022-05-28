#include<sys/stat.h>
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<sys/types.h>
#include<dirent.h>
#include<unistd.h>

int main(int argc,char *argv[])
{
	struct stat s;
	struct tm *timeinfo;
	DIR *dirptr;
	struct dirent *entry;
	char curDir[80];
	
	if(argc<2)
	{
		printf("\nInsufficient arguments");
		exit(1);
	}
	int month = atoi(argv[1]);

	getcwd(curDir,80);
	printf("%s\n",curDir);

	memset(&s,0,sizeof(s));

	dirptr = opendir(curDir);
	while((entry = readdir(dirptr))!=NULL)
	{
		stat(entry->d_name,&s);

		timeinfo = localtime(&s.st_atime);
		if(timeinfo->tm_mon==month)
			printf("\n%s",entry->d_name);
	}
	return 0;
}
