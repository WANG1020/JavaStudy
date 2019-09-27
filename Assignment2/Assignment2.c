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
ElemType Init(SeqList *L,int mSize)//��ʼ��˳��� 
{
	L->maxLength=mSize;
	L->n=0;
	L->element=malloc(sizeof(ElemType)*mSize);
	if(!L->element)
	return Error;
	return ok;
}
ElemType Find(SeqList L,int i,ElemType *x)//˳������ 
{
	if(i<0||i>L.n-1) 
	return Error;
	*x=L.element[i];
	return ok;
} 
ElemType Insert(SeqList *L,int i,ElemType x)//˳���Ԫ�ز��� 
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
ElemType Delete(SeqList *L,int i)//˳���Ԫ��ɾ�� 
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
ElemType Output(SeqList L)//���
{
	int i;
	if(!L.n)
	return Error;
	for(i=0;i<=L.n-1;i++) 
	printf("%d",L.element[i]);
	return ok;
}
void Destroy(SeqList *L)//˳����� 
{
	(*L).n=0;
	(*L).maxLength=0;
	free((*L).element); 
}
int main(){
	int i;
	SeqList list;
	int time;
	printf("�����볤��:"); 
	scanf("%d",&time);
	Init(&list,time);
	for(i=0;i<time-1;i++) 
	Insert(&list,i-1,i);
	Output(list); 
	printf("\n��������Ҫ�����Ǹ�λ�õĺ��棺"); 
	int place;
    scanf("%d",&place);
    printf("��������Ҫ�����ֵ��"); 
	int value;
    scanf("%d",&value);
    Insert(&list,place,value);
	Output(list);
	printf("\n������ɾ����λ�ã�");
	int val; 
	scanf("%d",&val);
	Delete(&list,val);
	Output(list); 
	Destroy(&list);
	return 0;
} 

