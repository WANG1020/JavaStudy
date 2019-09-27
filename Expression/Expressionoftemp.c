#include<stdio.h> 
#include<stdlib.h>
#include<math.h>
#include<stdbool.h>
#include<ctype.h> 
#define ElemType char
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
	*x=S->element[S->top];
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
int icp(char c)
{
	int priority;
	switch(c)
	{
		case '#':
			priority=0;
			break;
		case '(':
			priority=8;
			break;
		case '^':
			priority=6;
			break;
		case '*':
		case '/':
			priority=4;
			break;
		case '+':
		case '-':
			priority=2;
			break;
		case ')':
			priority=1;
			break;
			
	}
	return priority;
} 
int isp(char c)
{
	int priority;
	switch(c)
	{
		case '#':
			priority=0;
			break;
		case '(':
			priority=1;
			break;
		case '*':
		case '/':
			priority=5;
			break;
		case '+':
		case '-':
			priority=3;
			break;
		case '6': 
		    priority=7;
			break;
		case ')':
			priority=8;
			break;
			
	}
	return priority;
 } 
void InfixToPostfix()
{
	Stack *S;
	Create(S,SIZE);
	char ch,y;
	Push(S,'#');
	ch=getchar();
	while(ch!='#')
	{
		if(isdigit(ch)||isalpha(ch))
		{
			printf("%c",ch); 
		}
		else if(ch==')')
		{
			for(Top(S,&y),Pop(S);y!=')'&&!IsEmpty(S);Top(S,&y),Pop(S))
				printf("%c",y);
				printf(" "); 
		}
		else
		{
			for(Top(S,&y),Pop(S);icp(ch)<=isp(y);Top(S,&y),Pop(S)) 
				printf("%c",y);
				printf(" ");
			Push(S,y);
			Push(S,ch); 
		}
		ch=getchar();
	}
	while(!IsEmpty(S))
	{
		Top(S,&y); 
	Pop(S);
	if(y!='#')
		printf("%c",y);
	} 
	printf("\n"); 
} 

 int main()
 {
 	InfixToPostfix(); 
 	return 0;
 }
