#include<stdio.h>
#include<stdlib.h>
/*
参考测试用例：ABEH###C#D##MN### 
结果：先序遍历：ABEHCDMN
       叶子节点数为：3
      节点总数为：8 
*/
typedef char ElemType;
typedef struct BinaryTreeNode{
	ElemType date;
	struct BinaryTreeNode *lChild, *rChild;
}BinaryTreeNode;

static int numberOfLeaf=0;
static int numberOfNode=0; 

void Visit(BinaryTreeNode *t)//计算叶子节点和总结点数 
{
	printf("%c",t->date);
	numberOfNode++;
	if(t->lChild==NULL&&t->rChild==NULL)
	{
		numberOfLeaf++;
	}
}
void PreOrderTransverse(BinaryTreeNode *t)//先序 
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
	printf("\n先序遍历：");
	PreOrderTransverse(t);
	printf("\n叶子节点数为：");
	printf("%d",numberOfLeaf);
	printf("\n节点总数为：");
	printf("%d",numberOfNode);
	return 0;
} 
