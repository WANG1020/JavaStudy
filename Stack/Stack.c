#include<stdio.h> 
#include<stdlib.h>
#define ElemType int
#define BOOL int 
#define FALSE 0
#define TRUE 1
typedef struct Node
{
	ElemType element;
	struct Node *link; 
}Node;

typedef struct
{
	struct Node *head;
	int maxSize;
}Stack;

void Create(Stack *L)
{
	L->head=NULL;
	L->maxSize=0; 
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
BOOL IsEmpty(Stack *L)
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
		return TRUE;
	}
	else
	{
		return FALSE;
	}
}
BOOL IsFULL(Stack *L)
{
	int i=0;
	Node *p;
	p=L->head; 
	while(L->head)
	{
		i++;
		p=p->link;
	}
	if(i==L->maxSize)
	{
		return TRUE;
	}
	else
	{
		return FALSE;
	}
}
BOOL Top(Stack *L,ElemType *x)
{
	Node *p;
	p=L->head; 
	*x=p->element;
	return TRUE;
}
BOOL Push(Stack *L,ElemType x)
{
	Node *p=(Node*)malloc(sizeof(Node));
	p->element=x;
	p->link=L->head;
	L->head=p;
	return TRUE; 
}
BOOL Pop(Stack *L)
{
	Node *p;
	p=L->head;
	L->head=L->head->link;
	free(p);
	return TRUE;
}
void Output(Stack L)
{
	Node *p;
	p=L.head;
	while(p)
	{
		printf("%d ",p->element);
		p=p->link;
	}
	printf("\n");
}
int main(void)
{
	Stack sta;
	Create(&sta);
	Push(&sta,1);
	Push(&sta,2);
	Push(&sta,3);
	Push(&sta,4);
	Output(sta);
	Pop(&sta);
	Output(sta);
	int x;
	Top(&sta,&x);
	printf("%d",x);
	Destroy(&sta);
	return 0;
}

