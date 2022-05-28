#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main()
{

//	int *arr1 = malloc(20);
	int *arr1 = alloca(20);
	memset(arr1,0,20);
	printf("\narr1 size = %lu\n",sizeof(arr1));
//	free(arr1);
	return 0;
}
