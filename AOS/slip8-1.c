#include<stdio.h>
#include<stdlib.h>
#include<sys/time.h>
#include<sys/resource.h>

int main()
{
	struct rlimit limit;
	if(getrlimit(RLIMIT_NPROC,&limit)<0)
		printf("getrlimit error\n");
	printf("No. of extant process = [%10ld][%10ld]\n",limit.rlim_max,limit.rlim_cur);

	if(getrlimit(RLIMIT_CPU,&limit)<0)
		printf("getrlimit error\n");
	printf("limit on amount of CPU time that process can consume = [%ld][%ld]\n",limit.rlim_max,limit.rlim_cur);

	if(getrlimit(RLIMIT_DATA,&limit)<0)
		printf("getrlimit error\n");
	printf("max.size of process's data segment = [%ld][%ld]\n",limit.rlim_max,limit.rlim_cur);

	if(getrlimit(RLIMIT_FSIZE,&limit)<0)
		printf("getrlimit error\n");
	printf("max. size in bytes of files that process may create = [%ld][%ld]\n",limit.rlim_max,limit.rlim_cur);

	if(getrlimit(RLIMIT_LOCKS,&limit)<0)
		printf("getrlimit error\n");
	printf("limit on locks = [%ld][%ld]\n",limit.rlim_max,limit.rlim_cur);

	if(getrlimit(RLIMIT_MEMLOCK,&limit)<0)
		printf("getrlimit error\n");
	printf("max. no. of bytes of memory that can be locked in RAM = [%ld][%ld]\n",limit.rlim_max,limit.rlim_cur);

	if(getrlimit(RLIMIT_MSGQUEUE,&limit)<0)
		printf("getrlimit error\n");
	printf("msg queue = [%ld][%ld]\n",limit.rlim_max,limit.rlim_cur);

	return 0;
}
