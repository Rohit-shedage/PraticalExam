#include<stdio.h>
#include<stdlib.h>
#include<sys/mman.h>
#include<unistd.h>
#include<sys/stat.h>
#include<sys/types.h>
#include<fcntl.h>
#include<string.h>
#include<malloc.h>

char *addr;

int main()
{
	int fd,len,stats;
	char *rev;
	struct stat st;
	memset(&st,0,sizeof(st));

	fd = open("slip6-1.txt",O_RDONLY);
	stats = fstat(fd,&st);
	len = st.st_size;

	if((addr = mmap(NULL, len, PROT_READ, MAP_PRIVATE,fd,0))==MAP_FAILED)	
		printf("\nError in mmap");
	printf("\nmap=\n%s",addr);	// display mapped file

	printf("\nmapped file in reverse order\n");
	rev = addr + strlen(addr);
	while(rev != addr)
	{
		printf("%c",*rev);
		rev--;
	}
	printf("%c",*rev);
	return 0;
}

