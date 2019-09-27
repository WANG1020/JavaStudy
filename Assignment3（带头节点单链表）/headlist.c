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
}HeaderList;

Status Init(HeaderList *);
Status Insert(HeaderList*,int,ElemType);
Status Delete(HeaderList *,int );
Status Find(HeaderList,int,ElemType *);
Status Output(HeaderList);
void Destroy(HeaderList *);


int main()
{
	int i;
	int x;
	HeaderList list;
	Init(&list); 
	int number;
	printf("the number is:");
	scanf("%d",&number);
	for(i=0;i<number;i++) 
	Insert(&list,i-1,i);//初始化线性表 
	printf("the linklist is:");
	Output(list); 
	printf("\nenter the insertion position："); 
	int place;
    scanf("%d",&place);
    printf("enter the inserted value: "); 
	int value;
    scanf("%d",&value);
    Insert(&list,place,value); //指定位置插入 
    printf("the linklist is:");
	Output(list);
	printf("\nenter the delete position：");
	int val; 
	scanf("%d",&val);
	Delete(&list,val);//线性表删除元素 
	Output(list); 
	Find(list,3,&x);
	Destroy(&list);//销毁线性表  
	return 0;
}
Status Init(HeaderList *h)
{
	h->head=(Node*)malloc(sizeof(Node));
	if(!h->head)
	return ERROR;	 
	h->head->link=NULL;
	h->n=0;
	return OK; 
}
Status Insert(HeaderList *L,int i,ElemType x)
{
	Node *p; 
	int j; 
	if(i<-1||i>L->n-1)
	return ERROR;
	p=L->head;
	for( j=0;j<=i;j++)
	{
		p=p->link;
	}
	Node *q;
	q=malloc(sizeof(Node));//生成新节点 
	q->element=x;
	q->link=p->link;//新节点插入表中 
	p->link=q;	
	L->n++;
	return OK; 
}
Status Delete(HeaderList *h,int i)
{
	int j;
	Node *p,*q;
	if(!h->n)
	{
		return ERROR;
	}
	if(i<0||i>h->n-1)
	{
		return ERROR;
	}
	q=h->head;
	for(j=0;j<i;j++)
	{
		q=q->link;
	}
	p=q->link;
	q->link=p->link;
	free(p);
	h->n--;
	return OK; 
}
Status Find(HeaderList L,int i,ElemType *x)
{
	Node *p;
	int j;
	if(i<0||i>L.n-1)
	{
		return ERROR;
	}
	p=L.head;
	for(j=0;j<=i;j++)
	{
		p=p->link;
	}
	*x=p->element;
	printf("%d",p->element);
	return OK;
}
Status Output(HeaderList L)
{
	Node *p;
	if(!L.n)
	{
		return ERROR;
	} 
	p=L.head->link;
	while(p)
	{
		printf("%d ",p->element);
		p=p->link;
	}
	return OK;
}
void Destroy(HeaderList *L)
{
	Node *p;
	while(L->head)
	{
		p=L->head->link;
		free(L->head);
		L->head=p;
	}
}
