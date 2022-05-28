#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>
#include<stdlib.h>

int main()
{
	int fd;
	fd = open("output.txt",O_CREAT | O_RDWR);
	if(fd<0)
	{
		printf("\nfailed to create file\n");
		exit(1);
	}
	close(1);
	dup(fd);
	printf("\nThis msg will be written to output.txt\n");
	close(fd);
	return 0;
}

