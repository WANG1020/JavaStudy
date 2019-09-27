#include<stdio.h>
#include<stdlib.h>
#define maxSize 20
#define N 6 
typedef int ElemType;
typedef struct
{
	int col;
	int row;
	ElemType element;
}Picture;
void creat(int col1,int row1,ElemType element1,Picture *arr)
{
	arr->col=col1;
	arr->row=row1;
	arr->element=element1;
}
void Output(Picture ter[])
{
	int i;
	for(i=0;i<maxSize;i++)
	{
		printf("%d %d %d\n",ter[i].col,ter[i].row,ter[i].element);
	} 
	printf("\n");
}
void Sortofcol(Picture ter[]) 
{
	int i;
	int j;
	Picture temp;
	for(i=0;i<maxSize;i++)
	{
		for(j=i+1;j<maxSize;j++)
		{
			if(ter[j].col<ter[i].col)
			{
					temp=ter[i];
					ter[i]=ter[j];
					ter[j]=temp;
			}
			
			if(ter[j].col==ter[i].col)
			{
				if(ter[j].row<ter[i].row)
				{
					temp=ter[i];
					ter[i]=ter[j];
					ter[j]=temp;
				}
			}
		}
	}
}
void count(Picture ter[])
{
	int i,j;
	for(j=1;j<=N;j++)
	{
		int number=0;
		for(i=0;i<maxSize;i++)
		{
			if(ter[i].col==j)
			{
				number++;
			}
		}
		printf("%dµÄ¶ÈÎª%d\n",j,number);
	} 
}
int main(void)
{
	Picture pict[maxSize];
	creat(1,2,1,&pict[0]);
	creat(1,5,1,&pict[1]);
	creat(1,6,1,&pict[2]);
	creat(2,3,1,&pict[3]);
	creat(2,4,1,&pict[4]);
	creat(2,6,1,&pict[5]);
	creat(3,4,1,&pict[6]);
	creat(4,5,1,&pict[7]);
	creat(4,6,1,&pict[8]);
	creat(5,6,1,&pict[9]);
	creat(2,1,1,&pict[10]);
	creat(5,1,1,&pict[11]);
	creat(6,1,1,&pict[12]);
	creat(3,2,1,&pict[13]);
	creat(4,2,1,&pict[14]);
	creat(6,2,1,&pict[15]);
	creat(4,3,1,&pict[16]);
	creat(5,4,1,&pict[17]);
	creat(6,4,1,&pict[18]);
	creat(6,5,1,&pict[19]);
	Sortofcol(pict);
	Output(pict);
	count(pict);
	return 0;
}
