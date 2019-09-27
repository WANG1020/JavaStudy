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
	Sortofcol(ter);
}
void Sub(Term *arr1,Term *arr2){
	
}
void Add(Term *arr1,Term *arr2){
	int i,j;
	for(i=0;i<maxSize;i++)
	{
		for(j=0;j<maxSize;j++)
		{
			if(arr1[i].col==arr2[j].col&&arr1[i].row==arr2[j].row)
			{
				arr1[i].element+=arr2[j].element;
				/*if (arr1[i].element==0)
				{
					int t1;
					for (t1 = i; t1 < 7; t1++)
					{					
						arr1[t1] = arr1[t1 + 1];
					}
				}
				int t2;
				for (t2 = j; t2 < 7; t2++)
				{
					arr2[t2] = arr2[t2 + 1];
				}*/
			}
		}
	}
	/*int x;int y;
	for (x = 7, y = 0; y<7; x++, y++)
	{
		arr1[x] = arr2[y];
	}*/
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
	printf("第一个稀疏矩阵为：\n");
	Output(arr);
	Transposit(arr);
	printf("转置后：\n");
	Output(arr);
	Term arr1[maxSize];
	creat(0,0,8,&arr1[0]);
	creat(0,2,3,&arr1[1]);
	creat(1,4,-6,&arr1[2]);
	creat(3,2,-3,&arr1[3]);
	creat(3,4,6,&arr1[4]);
	creat(4,3,8,&arr1[5]);
	creat(5,3,-1,&arr1[6]);
	printf("第二个稀疏矩阵为：\n");
	Output(arr1); 
	
	Add(arr,arr1);
	printf("执行加法后稀疏矩阵为：\n");
	Output(arr);

	return 0;
}
