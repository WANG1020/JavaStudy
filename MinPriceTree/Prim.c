 #include<stdio.h>
#include<stdlib.h> 
typedef int Status;
typedef int ElemType;
typedef struct ENode
{
	int adjVex;//任意顶点相邻的顶点 
	ElemType w;//边的权值 
	struct ENode* nextArc;//指向下一个边界点 
}ENode;
typedef struct
{
	int n;
	int e;
	ENode **a;
}LGraph;
#define INFTY  32767
typedef int Status;
Status Prim(int k,int *closeVex,ElemType *lowWeight,LGraph g)
{
	ENode *p;
	int i,j;
	ElemType min;
	int *isMark=malloc(sizeof(int)*g.n);
	if(k<0||k>g.n-1) return ERROR;
	for(i=0;i<g.n;i++)
	{
		closeVex[i]=-1;
		lowWeight[i]=INFTY;
		isMark[i]=0;
	}
	lowWeight[k]=0;
	closeVex[k]=k;
	isMark[k]=1;
	for(i=1;i<g.n;i++)
	{
		for(p=g.a[k];p;p=p->nextArc)
		{
			j=p->adjVex;
			if((!isMark[j])&&(lowWeight[j]>p-w))
			{
				lowWeight[j]=p->w;
				closeVex[j]=k;
			}
		}
		min=INFTY;
		for(j=0;j<g.n;j++)
			if((!isMark[j])&&(lowWeight[j]<min))
			{
				min=lowWeight[j];
				k=j;
			}
			isMark[k]=1;
	}
	for(i=0;i<g.n;i++)
	{
		printf("%d",closeVex[i]);
		printf("%d",i);
		printf("%d",lowWeight[i]);
		printf("\n");
	}
	return ok;
}
int main(void)
{
	return 0;
}
