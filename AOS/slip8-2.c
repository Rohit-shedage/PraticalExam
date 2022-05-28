#include<sys/stat.h>
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<sys/types.h>
#include<pwd.h>
#include<grp.h>
#include<dirent.h>
#include<unistd.h>

struct fileinfo
{
	char fileName[20];
	int size;
}files[20],temp;

int main(int argc,char *argv[])
{
	struct stat s;
	memset(&s,0,sizeof(s));
	int i,j,n;
	
	for(i=1;i<argc;i++)
	{
		printf("\n");
		stat(argv[i],&s);
		strcpy(files[i-1].fileName,argv[i]);
		files[i-1].size = s.st_size;
	}
	n=i-1;
	for(i=0;i<n;i++)
	{
		for(j=i+1;j<n;j++)
		{
			if(files[i].size > files[j].size)
			{
				temp = files[i];
				files[i]=files[j];
				files[j]=temp;
			}
		}
	}
	for(i=0;i<n;i++)
		printf("\n%s\t%d",files[i].fileName,files[i].size);
	return 0;
}
