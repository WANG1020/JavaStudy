#include<stdio.h> 
#include<stdlib.h>
#include<math.h>
#include<stdbool.h>
#include<ctype.h> 
#define ElemType int

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
	int i=0;
	Node *p;
	p=L->head;
	while(L->head)
	{
		i++;
		p=p->link;
	}
	if(i==0)
	{
		return true;
	}
	else
	{
		return false;
	}
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
int main(void)
{
	Stack *S=malloc(sizeof(Stack*));
 	Create(S);
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

