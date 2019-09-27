#include<stdio.h>
#include<stdlib.h>
/*
�ο�����������ABEH###C#D##MN### 
��������������ABEHCDMN
       Ҷ�ӽڵ���Ϊ��3
      �ڵ�����Ϊ��8 
*/
typedef char ElemType;
typedef struct BinaryTreeNode{
	ElemType date;
	struct BinaryTreeNode *lChild, *rChild;
}BinaryTreeNode;

static int numberOfLeaf=0;
static int numberOfNode=0; 

void Visit(BinaryTreeNode *t)//����Ҷ�ӽڵ���ܽ���� 
{
	printf("%c",t->date);
	numberOfNode++;
	if(t->lChild==NULL&&t->rChild==NULL)
	{
		numberOfLeaf++;
	}
}
void PreOrderTransverse(BinaryTreeNode *t)//���� 
{
	if(t!=NULL)
	{
		Visit(t);
		PreOrderTransverse(t->lChild);
		PreOrderTransverse(t->rChild);
	}  
}
void MiddleTransverse(BinaryTreeNode *t)
{
	if(t!=NULL)
	{
		PreOrderTransverse(t->lChild);
		Visit(t);
		PreOrderTransverse(t->rChild);
	}  
}
void BackTransverse(BinaryTreeNode *t)
{
	if(t!=NULL)
	{
		PreOrderTransverse(t->lChild);
		PreOrderTransverse(t->rChild);
		Visit(t);
	}  
}
BinaryTreeNode * CreatePTreeNode(BinaryTreeNode *t)
{
	
	char ch; 
	ch=getchar();
	if(ch=='#')
	{
		t=NULL;
	} 
	else
	{
		t=(BinaryTreeNode *)malloc(sizeof(BinaryTreeNode));
		t->date=ch; 
		t->lChild=CreatePTreeNode(t->lChild);
		t->rChild=CreatePTreeNode(t->rChild);
	}
	return t;
} 
int main(void)
{
	BinaryTreeNode *t;
	t=CreatePTreeNode(t);
	printf("\n���������");
	PreOrderTransverse(t);
	printf("\nҶ�ӽڵ���Ϊ��");
	printf("%d",numberOfLeaf);
	printf("\n�ڵ�����Ϊ��");
	printf("%d",numberOfNode);
	return 0;
} 
