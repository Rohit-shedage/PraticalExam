#include<stdio.h>
#include<stdlib.h>

int main()
{
	char *path = getenv("PATH");
	if(path)
		printf("\npath=%s\n",path);
	else printf("\nvar not found\n");

	char *home = getenv("HOME");
	if(home)
		printf("\nhome=%s\n",home);
	else printf("\nvar not found\n");

	char *shell = getenv("SHELL");
	if(shell)
		printf("\nshell=%s\n",shell);
	else printf("\nvar not found\n");

	setenv("HOME","/home/rekha/AOS",1);
	home = getenv("HOME");
	if(home)
		printf("\nhome=%s\n",home);
	else printf("\nvar not found\n");

	return 0;
}
