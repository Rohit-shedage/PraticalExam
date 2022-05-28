#include<setjmp.h>
#include<stdio.h>
#include<stdlib.h>

static jmp_buf jmpbuffer;

static void f1()
{
	printf("\nInside f1(): before longjmp");
	longjmp(jmpbuffer,1);
	printf("\nInside f1(): after longjmp");
}


int main()
{
	if(setjmp(jmpbuffer)!=0)
		printf("\nInside main():after longjmp\n");
	else
	{
		printf("\nInside main: calling f1()");
		f1();
	}

	return 0;
}


