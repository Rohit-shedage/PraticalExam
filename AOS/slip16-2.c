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
#include<fcntl.h>

int main(int argc,char *argv[])
{
	DIR *dirptr;
	struct dirent *entry;
	char curDir[80];
	getcwd(curDir,80);
	printf("%s\n",curDir);
	struct stat s;
	struct tm *timeinfo;
	struct passwd *pw;
	struct group*gr;
	int fd;
	char filetype,perm,*date;
	memset(&s,0,sizeof(s));

	fd=open("slip16-2.txt",O_CREAT | O_WRONLY);
	chmod("slip16-2.txt",0777);
	close(1);
	dup(fd);

	dirptr = opendir(curDir);
	while((entry = readdir(dirptr))!=NULL)
	{
		printf("\n");
		stat(entry->d_name,&s);
		if((s.st_mode & S_IFMT)==S_IFREG) filetype = '-';
		else if((s.st_mode & S_IFMT)==S_IFSOCK) filetype = 'S';
		else if((s.st_mode & S_IFMT)==S_IFLNK) filetype = 'L';
		else if((s.st_mode & S_IFMT)==S_IFBLK) filetype = 'B';
		else if((s.st_mode & S_IFMT)==S_IFDIR) filetype = 'D';
		else if((s.st_mode & S_IFMT)==S_IFCHR) filetype = 'C';
		else if((s.st_mode & S_IFMT)==S_IFIFO) filetype = 'F';
			
		date = ctime(&s.st_atime);
		timeinfo = localtime(&s.st_atime);
		date[strlen(date)-1]='\0';
		pw = getpwuid(s.st_uid);
		gr = getgrgid(s.st_gid);
		
		printf("%c",filetype);		
		printf((s.st_mode & S_IRUSR)?"r":"-");
		printf((s.st_mode & S_IWUSR)?"w":"-");
		printf((s.st_mode & S_IXUSR)?"x":"-");
		printf((s.st_mode & S_IRGRP)?"r":"-");
		printf((s.st_mode & S_IWGRP)?"w":"-");
		printf((s.st_mode & S_IXGRP)?"x":"-");
		printf((s.st_mode & S_IROTH)?"r":"-");
		printf((s.st_mode & S_IWOTH)?"w":"-");
		printf((s.st_mode & S_IXOTH)?"x":"-");
		printf(" %ld %s %s %ld\t%s %s",s.st_nlink,pw->pw_name,pw->pw_name,s.st_size,date,entry->d_name);	

	}
	close(fd);
	return 0;
}
