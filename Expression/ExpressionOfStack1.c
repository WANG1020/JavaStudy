#include<stdio.h> 
#include<stdlib.h>
#include<math.h>
#include<stdbool.h>
#include<ctype.h> 
#define ElemType char 

typedef struct Node
{
	ElemType element;
	struct Node *link; 
}Node;
typedef struct
{
	struct Node *head;
}Stack;

void Create(Stack *L)
{
	L->head=NULL;
}
void Destroy(Stack *L)
{
	Node *temp;
	while(L->head)
	{
		temp=L->head->link;
		free(L->head);
		L->head=temp;
	}
}
void Clear(Stack *S)
{
	S->head=NULL;
}
bool IsEmpty(Stack *L)
{
	return L->head=NULL; 
}

bool Top(Stack *L,ElemType *x)
{
	Node *p;
	p=L->head; 
	*x=p->element;
	return true;
}
bool Push(Stack *L,ElemType x)
{
	Node *p=(Node*)malloc(sizeof(Node));
	p->element=x;
	p->link=L->head;
	L->head=p;
	return true; 
}
bool Pop(Stack *L)
{
	Node *p;
	p=L->head;
	L->head=L->head->link;
	free(p);
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
	Create(S);
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
int main(void)
{
	InfixToPostfix(); 
	return 0;
}

