#include<stdio.h>
#include<stdlib.h>
#include<sys/mman.h>
#include<unistd.h>
#include<sys/stat.h>
#include<sys/types.h>
#include<fcntl.h>
#include<string.h>
#include<malloc.h>

int main()
{
	int fd,len,stats;
	char *addr,*rev;
	struct stat st;
	memset(&st,0,sizeof(st));

	fd = open("slip10-1.txt",O_RDONLY);
	stats = fstat(fd,&st);
	len = st.st_size;

	if((addr = mmap(NULL, len, PROT_READ, MAP_PRIVATE,fd,0))==MAP_FAILED)	
		printf("\nErroe in mmap");
	printf("\nmap=\n%s",addr);

	struct mallinfo mi;
	mi = mallinfo();
	printf("\nnon-mmapped space allocated = %d",mi.arena);
	printf("\nnumber of free chunks = %d",mi.ordblks);
	printf("\nnumber of free fast-bin blocks = %d",mi.smblks);
	printf("\nnumber of mmapped regions = %d",mi.hblks);
	printf("\nspace allocated in mmapped regions = %d",mi.hblkhd);
	printf("\nmaximum total allocated space = %d",mi.usmblks);
	printf("\nspace in freed fastbin blocks = %d",mi.fsmblks);
	printf("\ntotal allocated space = %d",mi.uordblks);
	printf("\ntotal free space = %d",mi.fordblks);
	printf("\ntopmost releasable space =%d",mi.keepcost);

	return 0;
}
