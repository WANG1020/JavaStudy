#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#define maxSize 7
//static int number=0;
void BubbleSort(int arr[])//ð�ݷ������ȶ� 
{
	int i,j;
	bool isSwap=false;
	int number=0;
	for(i=maxSize-1;i>0;i--)
	{
		for(j=0;j<i;j++)
		{
			if(arr[j]>arr[j+1])
			{
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
				Print(arr);
				number++;
				isSwap=true; 
			}
		}
		if(!isSwap) break;//ԭ����������ģ�û�о�������������ֱ�ӽ��� 
	}
	printf("%d\n",number);
}
void QuickSort(int R[],int s,int t)//���ţ����ȶ� 
{
	int i=s,j=t;
	int temp;
	int number=0;
	if(s<t)
	{
		temp=R[s];//ѡ���ĳ�ʼ��ֵ 
		while(i!=j)//i��j֮ǰ  
		{
			while(j>i&&R[j]>temp)//j��i֮ǰ�����ұ�temp�󣬲����� 
			{
				j--;
			}
			if(i<j)
			{
				R[i]=R[j];
				i++;
				number++;
				Print(R);
			}
			while(i<j&&R[i]<temp)
			{
				i++;
			}
			if(i<j)
			{
				R[j]=R[i];
				j--;
				number++;
				Print(R);
			}
		}
		R[i]=temp;
		QuickSort(R,s,i-1);
		QuickSort(R,j+1,t);
	}
	
}
void InsertSort(int arr[],int n)//ֱ�� 
{
	int i,j;
	int temp;
	int number=0;
	for(i=1;i<n;i++)
	{
		temp=arr[i];
		j=i-1;
		while(j>=0&&temp<arr[j])
		{
		 	arr[j+1]=arr[j];
		 	j--;
		 	number++;
		 	Print(arr);
		}
		arr[j+1]=temp;
	}
}
void shellSort(int arr[],int n)//ϣ������ 
{
	int i,j,d;
	int temp;
	int number=0;
	d=n/2;
	while(d>0)
	{
		for(i=d;i<n;i++)
		{
			j=i-d;
			while(j>=0&&arr[j]>arr[j+d])
			{
				temp=arr[j];
				arr[j]=arr[j+d];
				arr[j+d]=temp;
				j=j-d;
				number++;
				Print(arr);
			}
		}
		d=d/2;
	}
}
void selectSort(int arr[],int n)//ѡ������ 
{
	int i,j,k;
	int temp;
	int number=0;
	for(i=0;i<n-1;i++)
	{
		k=i;
		for(j=i+1;j<n;j++)
		{
			if(arr[j]<arr[k])
			{
				k=j;
			}
		}
		if(k!=j)
		{
			temp=arr[i];
			arr[i]=arr[k];
			arr[k]=temp;
			number++;
		}
		Print(arr);
	}
}
void Print(int arr[])
{
	int i;
	for(i=0;i<maxSize;i++)
	{
		printf("%d",arr[i]);
		printf(" ");
	}
	printf("\n");
}
int main(void)
{
	int arr1[maxSize]={24,29,45,73,89,90,11};
	int arr2[maxSize]={24,29,45,73,89,90,11};
	int arr3[maxSize]={24,29,45,73,89,90,11};
	int arr4[maxSize]={24,29,45,73,89,90,11};
	int arr5[maxSize]={24,29,45,73,89,90,11};
	printf("��ʼδ�������飺") ; 
	Print(arr1);
	BubbleSort(arr1);
	printf("�������飺") ; 
	Print(arr1);
	QuickSort(arr2,0,6) ;
	printf("�������飺") ; 
	Print(arr2);
	InsertSort(arr3,maxSize);
	printf("�������飺") ; 
	Print(arr3);
	shellSort(arr4,maxSize);
	printf("�������飺") ; 
	Print(arr4);
	selectSort(arr5,maxSize);
	printf("�������飺") ; 
	Print(arr5);
	
	return 0;
}
