#include<stdio.h>
#include<stdlib.h>
#define ERROR 0
#define OK 1
typedef int ElemType;
typedef int Status;

typedef struct Node
{
	ElemType element;
	struct Node *link; 
}Node;
typedef struct
{
	struct Node *head;
	int n;
}SingleList;

Status Init(SingleList *L)
{
	L->head=NULL;
	L->n=0;
	return OK; 
}


void Convert(SingleList *L)
{
	Node *p,*q;
	p=L->head;
    L->head=NULL;
	while(p!=NULL)
	{
		q=p;
		p=p->link;
		q->link=L->head; 
		L->head=q;//变为L新的未节点 
	 }   
}
Status Insert(SingleList *L,int i,ElemType x)
{
	Node *p,*q;
	int j;
	if(i<-1||i>L->n-1)
	return ERROR;
	p=L->head;
	for(j=0;j<i;j++) p=p->link;
	q=malloc(sizeof(Node));
	q->element=x;
	if(i>-1)
	{
		q->link=p->link;
		p->link=q;
	}
	else
	{
		q->link=L->head;
		L->head=q;
	}
	L->n++;
	return OK; 
 } 
Status Output(SingleList L)
{
	Node *p;
	if(!L.n)
	{
		return ERROR;
	} 
	p=L.head;
	while(p)
	{
		printf("%d ",p->element);
		p=p->link;
	}
	return OK;
}
void Destroy(SingleList *L)
{
	Node *p;
	while(L->head)
	{
		p=L->head->link;
		free(L->head);
		L->head=p;
		 
	 } 
}
int main()
{
	int i;
	int x;
	SingleList list;
	Init(&list); 
	int number;
	printf("the number is:");
	scanf("%d",&number);
	for(i=0;i<number;i++) 
	Insert(&list,i-1,i); 
	printf("the linklist is:");
	Output(list); 
    Convert(&list);
     
    printf("\nthe convertlink is:");
    Output(list); 
	Destroy(&list);  
	return 0;
}
