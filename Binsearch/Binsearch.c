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
			printf("���ҵ�λ�ã�%d\n", mid);
			printf("���Ҵ�����%d\n", time);
			break;
		}
		time++;
	}
	if (begin>end)
	{
		printf("����ʧ�ܣ��޴�Ԫ��");
	}
}

int main()
{
	int a[maxSize];
	int i;
	printf("��ʼ�����飺"); 
	for(i=0;i<maxSize;i++)
	{
		scanf("%d",&a[i]);
	}
	printf("��ӡ���飺"); 
	Output(a);
	printf("��������"); 
	Sort(a);
	Output(a);
	
	int x;
	printf("����������Ҫ���ҵ�ֵ��"); 
	scanf("%d",&x);
	Binsearch(a,x,0,maxSize-1); 
	return 0;
} 
