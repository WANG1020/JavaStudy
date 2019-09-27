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

Status Find(SingleList L,int i,ElemType *x)
{
	Node *p;
	int j;
	if(i<0||i>L.n-1)
	return ERROR;
	p=L.head;
	for(j=0;j<i;j++) p=p->link;
	*x=p->element;
	return OK;
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
 Status Delete(SingleList *L,int i)
 {
 	int j;
 	Node *p,*q;
 	if(!L->n)
 	return ERROR;
 	if(i<0||i>L->n-1)
 	return ERROR; 
	q=L->head;
	p=L->head;
	for(j=0;j<i-1;j++) q=q->link;
	if(i=0)
	L->head=L->head->link;
	else
	{
		p=q->link;
		q->link=p->link;
	}
	free(p);
	L->n--;
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
	printf("\nenter the insertion position："); 
	int place;
    scanf("%d",&place);
    printf("enter the inserted value: "); 
	int value;
    scanf("%d",&value);
    Insert(&list,place,value); 
    printf("the linklist is:");
	Output(list);
	printf("\nenter the delete position：");
	int val; 
	scanf("%d",&val);
	Delete(&list,val);
	Output(list); 
	Find(list,3,&x);
	Destroy(&list);
	return 0;
}
