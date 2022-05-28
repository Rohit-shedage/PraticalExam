#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<stdlib.h>

int main()
{
	char ch;
	int fd1 = open("file1.txt",O_RDONLY);
	int fd2 = creat("file2.txt",O_CREAT | O_WRONLY);
	while((read(fd1,&ch,1)!=0))
		write(fd2,&ch,1);
	close(fd1);
	close(fd2);
	unlink("file1.txt");
	return 0;
}
