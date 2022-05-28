#include<stdio.h>
#include<dirent.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<fcntl.h>
#include<sys/stat.h>

int endsWith(char *fileName, char *ext)
{
	int i,len = strlen(ext),j=0;
	for(i=0;fileName[i]!='.';i++);
	for(++i;fileName[i]!='\0';i++,j++)
	{
		if(fileName[i]==ext[j])
			continue;
		break;
	}
	if(i==strlen(fileName))
		return 0;
	return 1;
}

int main(int argc,char *argv[])
{
	int fd,fd1,handle;
	char ch;
	fd = open("/home/rekha/AOS/slip5-2.txt",O_CREAT | O_WRONLY);
	chmod("/home/rekha/AOS/slip5-2.txt",0777);
	if(fd<0)
	{
		printf("\nfailed to create file\n");
		exit(1);
	}
	
	DIR *dirptr;
	struct dirent *entry;
	char curDir[80];

	getcwd(curDir,80);
	if(argc<2)
	{
		printf("\n Insufficient arguments\n");
		exit(1);
	}	
	dirptr = opendir(curDir);
	while((entry = readdir(dirptr))!=NULL)
	{
		if(endsWith(entry->d_name,argv[1])==0)
		{
			printf("\n%s",entry->d_name);
			fd1 = open(entry->d_name,O_RDONLY);
			while((read(fd1,&ch,1)!=0))
				write(fd,&ch,1);
		}
	}
	close(fd);
	close(fd1);
	closedir(dirptr);
	return 0;
}
