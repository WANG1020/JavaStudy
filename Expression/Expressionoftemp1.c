#include<stdio.h> 
#include<stdlib.h>
#include<math.h>
#include<stdbool.h>
#include<ctype.h> 
#define ElemType int
#define SIZE 20
typedef struct
{
	int top;
	int maxSize;
	ElemType *element;
}Stack;	
void Create(Stack *S,int size)
{
	S->maxSize=size-1;
	S->element=(ElemType*)malloc(sizeof(ElemType)*size);
	S->top=-1;
}
void Destroy(Stack *S)
{
	S->maxSize=-1;
	free(S->element);
	S->top=-1; 
}
void Clear(Stack *S)
{
	S->top=-1;
}
bool IsEmpty(Stack *S)
{
	return S->top==-1;
}
bool IsFULL(Stack *S)
{
	return S->top==S->maxSize;
}
bool Top(Stack *S,ElemType *x)
{
	if(IsEmpty(S))
		return false; 
	* x=S->element[S->top];
		return true;
}	
bool Push(Stack *S,ElemType x)
{
	if(IsFULL(S))
		return false;
	S->top++;
	S->element[S->top]=x;
	return true; 
}
bool Pop(Stack *S)
{
	if(IsEmpty(S))
		return false;
	S->top--;
		return true; 
}
bool GetOperands(Stack *S,int *op1,int *op2)
{
	if(!Top(S,op1))
	{
		printf("Missing oeprand!");
		return false;
	}
	Pop(S);
	if(!Top(S,op2))
	{
		printf("Missing oeprand!");
		return false;
	}
	Pop(S);
	return true;
}
void DoOperator(Stack *s,char oper)
{
	bool result;
	int oper1,oper2;
	result=GetOperands(s,&oper1,&oper2);
	if(!result)
	{
		Clear(s);
	}
	else
	{
		switch(oper)
		{
			case '+':
				Push(s,oper2+oper1);
				break;
			case '-':
				Push(s,oper2-oper1);
				break;
			case '*':
				Push(s,oper2*oper1);
				break;
			case '/':
				if(fabs(oper1)<1e-6){
					printf("Divide by 0!\n");
					Clear(s);
				} 
				else Push(s,oper2/oper1);
				break;
			case '^':
				Push(s,pow(oper2,oper1));
				break;
		}
	}
}

 int main()
 {
 
 	Stack *S=malloc(sizeof(Stack*));
 	Create(S,SIZE);
	char c;
	int newop;
	c=getchar();
	while(c!='#'){
		switch(c){
			case '+':
			case '-':
			case '*':
			case '/':
			case '^':
				     DoOperator(S,c);
					 break;
			default:
					ungetc(c,stdin);
					scanf("%d",&newop);
					Push(S,newop);				
		} 
		c=getchar();
	} 
	if(Top(S,&newop))
		printf("%d",newop);
	Destroy(S);
	return 0;
 }
