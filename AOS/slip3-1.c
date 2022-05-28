#include<sys/stat.h>
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<sys/types.h>
#include<pwd.h>
#include<grp.h>

int main(int argc,char *argv[])
{
	struct stat s;
	struct tm *timeinfo;
	struct passwd *pw;
	struct group*gr;
	char filetype,perm,*date;
	memset(&s,0,sizeof(s));

	if(argc<2)
	{
		printf("Insufficient arguments\n");
		exit(1);
	}
	printf("\nFile size \t inode\n");	
	for(int i=1;i<argc;i++) 
	{
		printf("\n");
		stat(argv[i],&s);
		if((s.st_mode & S_IFMT)==S_IFREG) filetype = 'R';
		else if((s.st_mode & S_IFMT)==S_IFSOCK) filetype = 'S';
		else if((s.st_mode & S_IFMT)==S_IFLNK) filetype = 'L';
		else if((s.st_mode & S_IFMT)==S_IFBLK) filetype = 'B';
		else if((s.st_mode & S_IFMT)==S_IFDIR) filetype = 'D';
		else if((s.st_mode & S_IFMT)==S_IFCHR) filetype = 'C';
		else if((s.st_mode & S_IFMT)==S_IFIFO) filetype = 'F';
			printf("%s\t%ld\t%C\t%ld\t%ld",argv[i],s.st_ino,filetype,s.st_size,s.st_nlink);	
		date = ctime(&s.st_atime);
		timeinfo = localtime(&s.st_atime);
		printf("\nmonth=%d\n",timeinfo->tm_mon);
		printf("\nFile access time = %s",date);
		printf("\nFile access time = %s",ctime(&s.st_mtime));
		printf("\nFile access time = %s",ctime(&s.st_ctime));

		pw = getpwuid(s.st_uid);
		gr = getgrgid(s.st_gid);
		printf("\n user = %s",pw->pw_name);
		printf("\n group = %s",gr->gr_name);
		
		
		printf((s.st_mode & S_IRUSR)?"r":"-");
		printf((s.st_mode & S_IWUSR)?"w":"-");
		printf((s.st_mode & S_IXUSR)?"x":"-");
		printf((s.st_mode & S_IRGRP)?"r":"-");
		printf((s.st_mode & S_IWGRP)?"w":"-");
		printf((s.st_mode & S_IXGRP)?"x":"-");
		printf((s.st_mode & S_IROTH)?"r":"-");
		printf((s.st_mode & S_IWOTH)?"w":"-");
		printf((s.st_mode & S_IXOTH)?"x":"-");

	}
	return 0;
}
