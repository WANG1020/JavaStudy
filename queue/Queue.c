#include<stdio.h> 
#include<stdlib.h>
#include<stdbool.h>
#define ElemType int

typedef struct Node
{
	ElemType element;
	struct Node *link; 
}Node;
typedef struct
{
	struct Node *front;
	struct Node *rear;
	int maxSize;
}Queue;
void create(Queue *Q)
{
	
	Q->front=NULL;
	Q->rear=NULL;
}
void Destory(Queue *Q)
{
	Node *temp;
	while(Q->front)
	{
		temp=Q->front->link;
		free(Q->front);
		Q->front=temp;
	}
}
int Front(Queue *Q)
{
	int x;
	Node *p;
	p=Q->front; 
	x=p->element;
	return x;
}
bool EnQueue(Queue *Q,ElemType x)
{
	Node *p=malloc(sizeof(Node));
	p->element=x;
	p->link=NULL; 
	if(Q->rear == NULL)
	{
		Q->rear=p;
		Q->front=p;
	}
	else
	{
		Q->rear->link=p;
		Q->rear=p;
	}
	return true; 
}
bool DeQueue(Queue *Q) 
{
	Node *p;
	p=Q->front;
	Q->front=Q->front->link;
	free(p);
	return true; 
}
void Output(Queue L)
{
	Node *p;
	p=L.front;
	while(p)
	{
		printf("%d ",p->element);
		p=p->link;
	}
	printf("\n");
}
int main()
{
	Queue q;
	create(&q);
	EnQueue(&q,1);
	EnQueue(&q,2);
	EnQueue(&q,3);
	EnQueue(&q,4);
	Output(q);
	DeQueue(&q);
	Output(q);
	int x=Front(&q);
	printf("%d",x);
	Destory(&q);
}
