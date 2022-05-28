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
	char filetype;
	memset(&s,0,sizeof(s));

	if(argc<2)
	{
		printf("Insufficient arguments\n");
		exit(1);
	}
	stat(argv[1],&s);
	if((s.st_mode & S_IFMT)==S_IFREG) filetype = 'R';
	else if((s.st_mode & S_IFMT)==S_IFSOCK) filetype = 'S';
	else if((s.st_mode & S_IFMT)==S_IFLNK) filetype = 'L';
	else if((s.st_mode & S_IFMT)==S_IFBLK) filetype = 'B';
	else if((s.st_mode & S_IFMT)==S_IFDIR) filetype = 'D';
	else if((s.st_mode & S_IFMT)==S_IFCHR) filetype = 'C';
	else if((s.st_mode & S_IFMT)==S_IFIFO) filetype = 'F';
	printf("%s\t%c\n",argv[1],filetype);	
	return 0;
}
