#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<sys/stat.h>

#define RWRWRW (S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH)
int main()
{
	umask(0111);
	if(creat("first",RWRWRW) < 0)
		printf("\ncreate error for first");

	umask(0177);
	if(creat("second",RWRWRW) < 0)
		printf("\ncreate error for first");
	chmod("second",S_IRUSR | S_IRGRP | S_IROTH);
	
	return 0;
}
