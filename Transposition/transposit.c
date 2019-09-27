#include<stdio.h>
#define maxSize 7
typedef int ElemType;
typedef struct
{
	int col;
	int row;
	ElemType element;
}Term;
void creat(int col1,int row1,ElemType element1,Term *arr)
{
	arr->col=col1;
	arr->row=row1;
	arr->element=element1;
}

void Sortofcol(Term ter[]) 
{
	int i;
	int j;
	Term temp;
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
void Transposit(Term ter[])
{
	int i;
	int temp;
	for(i=0;i<maxSize;i++)
	{
		temp=ter[i].col;
		ter[i].col=ter[i].row;
		ter[i].row=temp;
	}
}
void Output(Term ter[])
{
	int i;
	for(i=0;i<maxSize;i++)
	{
		printf("%d %d %d\n",ter[i].col,ter[i].row,ter[i].element);
	} 
	printf("\n");
}
int main()
{
	Term arr[maxSize];
	creat(0,0,-5,&arr[0]);
	creat(0,1,-2,&arr[1]);
	creat(1,3,-6,&arr[2]);
	creat(3,1,-3,&arr[3]);
	creat(4,0,-7,&arr[4]);
	creat(4,3,-4,&arr[5]);
	creat(5,2,-1,&arr[6]);
	Output(arr);
	Transposit(arr);
	Output(arr); 
	Sortofcol(arr);
	Output(arr);
	return 0;
}
