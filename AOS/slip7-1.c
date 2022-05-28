#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>
#include<sys/stat.h>
#include<stdlib.h>

int main()
{
	int fd;
	char *msg1="abcdefghij";
	char *msg2 = "ABCDEFGHIJ";
	fd = open("slip7-1.txt",O_CREAT | O_WRONLY);
	if(fd<0)
	{
		printf("\nfailed to create file\n");
		exit(1);
	}
	chmod("slip7-1.txt",0777);
	write(fd,msg1,10);
	lseek(fd,1024L,SEEK_CUR);
	write(fd,msg2,10);
	close(fd);
	return 0;
}
