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

Status Find(SingleList L,ElemType *x)
{
	Node *p;
	p=L.head;
	L.head=NULL;
	int i=1;
	while(p!=NULL)
	{
		if(p->element!=*x)
		{
			p=p->link;
			i++; 
		}
		else
		{
			printf("查询的值所在位置为：");
			printf("%d",i);
			break; 
		} 
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
	printf("输入链表长度:");
	scanf("%d",&number);
	for(i=0;i<number;i++) 
	Insert(&list,i-1,i); 
	printf("链表为:");
	Output(list); 
	printf("\n输入想要查询的值：");
	scanf("%d",&x); 
    Find(list,&x); 
	Destroy(&list);
	return 0;
}
