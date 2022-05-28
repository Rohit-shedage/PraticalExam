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

int main(int argc,char *argv[])
{
	DIR *dirptr;
	struct dirent *entry;
	char curDir[80];
	getcwd(curDir,80);
	printf("%s\n",curDir);
	struct stat s;

	char *files[10],temp[10];
	int i=0,j,n;
	memset(&s,0,sizeof(s));

	dirptr = opendir(curDir);
	while((entry = readdir(dirptr))!=NULL)
	{
		stat(entry->d_name,&s);
		if((s.st_mode & S_IFMT)==S_IFDIR) 
		{
			files[i]=malloc(20);
			strcpy(files[i++],entry->d_name);
		}
	}
	n=i-1;
	for(i=0;i<n;i++)
	{
		for(j=i+1;j<n;j++)
		{
			if(strcmp(files[i],files[j])>0)
			{
				strcpy(temp,files[i]);
				strcpy(files[i],files[j]);
				strcpy(files[j],temp);
			} 
		}
	}
	for(i=0;i<n;i++)
		printf("\n%s",files[i]);	

	return 0;
}
