 #include<stdio.h>
#include<stdlib.h>
//��������ʵ��
/**
�ṩ����������2 3 6 7
�����2 3 6 7 5 11 18
��Ȩ��·������Ϊ��34 
*/ 
typedef char ElemType;
#define maxSize 4
typedef struct HFMNode{
	ElemType date;
	int w; 
	int parent,lChild,rChild;
}HFMNode;
int Wpl(HFMNode Ht[],int N) 
{
	int i;
	int wpl=0;
	for(i=1;i<=N;i++)
	{
		int k=i;
		int size=0;
		while(Ht[k].parent!=-1)
		{
			k=Ht[k].parent;
			size++;	
		} 
		wpl+=Ht[i].w*size;
	}
	return wpl;
}
void Init(HFMNode Ht[],int N)
{
	int i,j,k,lmin,rmin;
	int min1,min2;
	for(i=1;i<N+N;i++) 
	{
		Ht[i].parent=Ht[i].lChild=Ht[i].rChild=-1;//��ʼ�����������ʼֵΪ-1��Ϊ�˷��㿴�Ƿ�ʹ�ã�����һ��ɾ���Ѿ�ʹ�ù�����Сֵ���ʹ�Сֵ������ 
	}
	for(i=N+1;i<N+N;i++)
	{
		min1=min2=100;
		lmin=rmin=-1;
		for(k=1; k<=i-1;k++)
		{
			if(Ht[k].parent==-1)
			{
				if(Ht[k].w<min1)
				{
					min2=min1; 
				  	rmin=lmin; 
				  	min1=Ht[k].w;
				  	lmin=k;
				} 
				else if(Ht[k].w<min2)
				{
					min2=Ht[k].w;
					rmin=k;
				}
			}	 
		}
		Ht[lmin].parent=i;
		Ht[rmin].parent=i;
		Ht[i].w=Ht[lmin].w+Ht[rmin].w;
		Ht[i].lChild=lmin;
		Ht[i].rChild=rmin; 
	}
}
int main(void)
{
	HFMNode hfm[maxSize+maxSize];
	int i;
	for(i=1;i<=maxSize;i++)
	{
		scanf("%d",&hfm[i].w);
	} 
	Init(hfm,maxSize);
	for(i=1;i<maxSize+maxSize;i++)
	{
		printf("%d",hfm[i].w);
		printf(" ");
	}
	int wpl=Wpl(hfm,maxSize);
	printf("\n��Ȩ��·������Ϊ��"); 
	printf("%d",wpl);
	return 0;
}
