#include<stdio.h>
#include<stdlib.h>
#define Error 0
#define ok 1
#define Overflow 2
#define Underflow 3
#define NotPresent 4
#define Duplicate 5
typedef int ElemType;

typedef struct
{
	int n;
	int maxLength;
	ElemType *element;
}SeqList;
ElemType Init(SeqList *L,int mSize)//初始化顺序表 
{
	L->maxLength=mSize;
	L->n=0;
	L->element=malloc(sizeof(ElemType)*mSize);
	if(!L->element)
	return Error;
	return ok;
}
ElemType Find(SeqList L,int i,ElemType *x)//顺序表查找 
{
	if(i<0||i>L.n-1) 
	return Error;
	*x=L.element[i];
	return ok;
} 
ElemType Insert(SeqList *L,int i,ElemType x)//顺序表元素插入 
{
	int j;
	if(i<-1||i>L->n-1)
	return Error;
	if(L->n==L->maxLength)
	return Error;
	for(j=L->n-1;j>i;j--)
	L->element[j+1]=L->element[j];
	L->element[i+1]=x;
	L->n=L->n+1;
	return ok;
}
ElemType Delete(SeqList *L,int i)//顺序表元素删除 
{
	int j;
	if(i<0||i>L->n-1)
	return Error;
	if(!L->n)
	return Error;
	for(j=i+1;j<L->n;j++)
	L->element[j-1]=L->element[j];
	L->n--;
	return ok;
}
ElemType Output(SeqList L)//输出
{
	int i;
	if(!L.n)
	return Error;
	for(i=0;i<=L.n-1;i++) 
	printf("%d",L.element[i]);
	return ok;
}
void Destroy(SeqList *L)//顺序表撤销 
{
	(*L).n=0;
	(*L).maxLength=0;
	free((*L).element); 
}
int main(){
	int i;
	SeqList list;
	int time;
	printf("请输入长度:"); 
	scanf("%d",&time);
	Init(&list,time);
	for(i=0;i<time-1;i++) 
	Insert(&list,i-1,i);
	Output(list); 
	printf("\n请输入想要插入那个位置的后面："); 
	int place;
    scanf("%d",&place);
    printf("请输入想要插入的值："); 
	int value;
    scanf("%d",&value);
    Insert(&list,place,value);
	Output(list);
	printf("\n输入你删除的位置：");
	int val; 
	scanf("%d",&val);
	Delete(&list,val);
	Output(list); 
	Destroy(&list);
	return 0;
} 

