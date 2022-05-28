#include<setjmp.h>
#include<stdio.h>
#include<stdlib.h>

static void f1(int,int,int,int);
static void f2(void);

static jmp_buf jmpbuffer;
int globval;

int main()
{
	int autoval;
	register int regval;
	volatile int volval;
	static int statval;
	
	globval=1;autoval=2;regval=3;volval=4;statval=5;
	
	if(setjmp(jmpbuffer)!=0)
	{
		printf("\nAfter longjmp:\n");
		printf("\nGlobal value = %d\n",globval);
		printf("\nAuto value = %d\n",autoval);
		printf("\nRegister value = %d\n",regval);
		printf("\nVolatile value = %d\n",volval);
		printf("\nStatic value = %d\n",statval);

		exit(0);
	}

	globval=95;autoval=96;regval=97;volval=98;statval=99;
	f1(autoval,regval,volval,statval);
	
	return 0;
}

static void f1(int i,int j,int k,int l)
{
	printf("\nIn f1():\n");
	printf("\nGlobal value = %d\n",globval);
	printf("\nAuto value = %d\n",i);
	printf("\nRegister value = %d\n",j);
	printf("\nVolatile value = %d\n",k);
	printf("\nStatic value = %d\n",l);
	f2();
}

static void f2(void)
{
	longjmp(jmpbuffer,1);
}
