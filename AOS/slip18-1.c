#include<sys/stat.h>
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<sys/types.h>
#include<pwd.h>
#include<grp.h>

int main(int argc,char *argv[])
{
	struct stat s;
	struct tm *timeinfo;
	memset(&s,0,sizeof(s));
	char *date;
	
	if(argc<2)
	{
		printf("Insufficient arguments\n");
		exit(1);
	}
	stat(argv[1],&s);
	date = ctime(&s.st_atime);
	timeinfo = localtime(&s.st_atime);
	printf("\nFile modification time = %s",ctime(&s.st_mtime));
	printf("\nFile access time = %s",ctime(&s.st_atime));
	return 0;
}
