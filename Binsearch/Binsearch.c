#include<stdio.h>
#define maxSize 5

void Sort(int *ter)
{
	int temp;
	int i,j;
	for(i=0;i<maxSize;i++)
	{
		for(j=i+1;j<maxSize;j++)
		{
			if(ter[j]<ter[i])
			{
					temp=ter[i];
					ter[i]=ter[j];
					ter[j]=temp;
			}
		}
	}
}
void Output(int *a)
{
	int i;
	for(i=0;i<maxSize;i++)
	{
		printf("%d",a[i]);
		printf(" ");
	}
	printf("\n");
}

void Binsearch(int *arr, int data,int begin,int end)
{
	int mid;
	int time = 0;

	while (begin <= end)
	{
		mid = (begin + end) / 2;
		if (data<arr[mid])
		{
			end = mid - 1;
		}
		else if (data>arr[mid])
		{
			begin = mid + 1;
		}
		else
		{
			time++;
			printf("查找的位置：%d\n", mid);
			printf("查找次数：%d\n", time);
			break;
		}
		time++;
	}
	if (begin>end)
	{
		printf("查找失败，无此元素");
	}
}

int main()
{
	int a[maxSize];
	int i;
	printf("初始化数组："); 
	for(i=0;i<maxSize;i++)
	{
		scanf("%d",&a[i]);
	}
	printf("打印数组："); 
	Output(a);
	printf("数组排序："); 
	Sort(a);
	Output(a);
	
	int x;
	printf("请输入你想要查找的值："); 
	scanf("%d",&x);
	Binsearch(a,x,0,maxSize-1); 
	return 0;
} 
