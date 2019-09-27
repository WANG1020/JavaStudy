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

Status Init(SingleList *);
Status Insert(SingleList *,int ,ElemType );
SingleList *Union(SingleList *,SingleList *);
Status Output(SingleList );
void Destroy(SingleList *);
int main()
{
	int i;
	int j;
	SingleList list1;
	SingleList list2;
	Init(&list1); 
	Init(&list2);
	int element1[7]={0,1,3,4,5,7,9};
	int element2[6]={0,2,3,6,7,8};
	for(i=0;i<7;i++)
	{
		Insert(&list1,i-1,element1[i]);
	} 
	for(j=0;j<6;j++)
	{
		Insert(&list2,j-1,element2[j]);
	} 
	printf("the linklist1 is:");
	Output(list1); 
	
	printf("\nthe linklist2 is:");
	Output(list2); 
	
    Union(&list1,&list2);
    printf("\nthe link is:");
    Output(list1); 
    Destroy(&list1);
    Destroy(&list2);
	return 0;
}
Status Init(SingleList *h)
{
	h->head=(Node*)malloc(sizeof(Node));
	if(!h->head)
	return ERROR;	 
	h->head->link=NULL;
	h->n=0;
	return OK; 
}
Status Insert(SingleList *L,int i,ElemType x)
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
SingleList *Union(SingleList *list1,SingleList *list2)
{
	Node *p,*q;
	p=list1->head;
	q=list2->head;
    Node *temp;
    temp=list1; 
    while(p&&q)
    {
        if(p->element<q->element) 
		{
    	  temp->link=p;
    	  temp=p;
    	  p=p->link;
	    }
     	else if(p->element>q->element)
		{
		  temp->link=q;
		  temp=q;
		  q=q->link; 
	    }
	    else
	    {
	      temp->link=p;
    	  temp=p;
    	  p=p->link;
    	  q=q->link;
		}
	}
	if(p) temp->link=p;
	else temp->link=q;
	free(list2); 
    return list1; 
}

Status Output(SingleList L)
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
