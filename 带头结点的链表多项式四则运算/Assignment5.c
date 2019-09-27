/*带头节点多项式加减乘*/ 
#include<stdio.h> 
#include<stdlib.h>
typedef int elemtype;
typedef struct pNode
{
	int coef; //系数 
	int exp;  //指数 
	struct pNode *link;
}pNode;
typedef struct
{
	struct pNode *head;
}polynominal;
void create(polynominal *p)
{
	pNode *temp1,*temp2,*q;
	p->head=malloc(sizeof(pNode));
	p->head->exp=-1;
	p->head->link=NULL;
	/*int number;
	printf("输入多项式的项数");
	scanf("%d",&number);
	int i;
	for(i=0;i<number;i++)*/ 
	for(;;)
	{
		temp1=malloc(sizeof(pNode));
		printf("coef:");
		scanf("%d",&temp1->coef);//输入系数 
		printf("exp:");
		scanf("%d",&temp1->exp);//输入指数 
		if(temp1->exp<0) break;//指数为负数结束，//但是我限制了个数 
		temp2=p->head;
		q=p->head->link;
		while(q&&q->exp>temp1->exp) //插入新项并保持多项式的各项为降幂排列 
		{
			temp2=q;//temp2等于q当前所指节点 
			q=q->link;//q指向q的下一个节点 
		}
		temp1->link=q;//temp1的下一个节点指向q 
		temp2->link=temp1;//temp2的下一个节点指向temp1 
	}
}
void Mul(polynominal *px,polynominal *qx)//多项式乘法 
{
	pNode *q,*q1,*p,*temp;
	q1=qx->head;
	p=px->head->link;
	q=q1->link;
	while(q&&p)
	{
		while(p)
		{
			q->coef=q->coef*p->coef;
			q->exp=q->exp+p->exp;
			q1=q;
			p=p->link;	
		}
		q=q->link;
    }
}
void Sub(polynominal *px,polynominal *qx)//多项式减法 
{
	pNode *q,*q1,*p,*temp;
	q1=qx->head;
	p=px->head->link;
	q=q1->link;
	while(q&&p)
	{
		while(p->exp<q->exp)  
		{
			q1=q;
			q=q->link;
			p=p->link;
		} 
		if(p->exp==q->exp)
		{
			q->coef=q->coef-p->coef;//多项式二减去多项式一 
			if(p->coef==0)           
			{
				q1->link=q->link;  //删除p
				free(q);
				q=q1->link; //重置p
				p=p->link;          
			}
			else 
			{
				q1=q;
				q=q->link;
				p=p->link;
			}
		}
		else
		{
			p->coef=-p->coef;
			temp=malloc(sizeof(pNode));
			temp->coef=p->coef;
			temp->exp=p->exp;
			temp->link=q1->link;
			q1->link=temp;
			p=p->link;
			q=q->link;
		}
	}
}
void Add(polynominal *px,polynominal *qx) //多项式加法//带头结点 
{
	pNode *q,*q1,*p,*temp;
	q1=qx->head;  //q1指向qx头节点 
	p=px->head->link;//p指向px第一个有效节点 
	q=q1->link;//q指向qx第一个有效节点，即第二个 
	while(p&&q)  //q,p不为空 
	{
	    while(p->exp<q->exp) 
		{
			q1=q;  //q1指向q 
			q=q->link;  //指向下一个节点 
			p=p->link;
		}   
		if(p->exp==q->exp) //如果当前这个p的指数小于q的指数 
		{
			q->coef=q->coef+p->coef; //两个系数相加 
			if(q->coef==0)           //两个和为0 
			{
				q1->link=q->link;  //删除q 
				free(q);                //释放q 
				q=q1->link;
				p=p->link;          
			}
			else
			{
				q1=q;
				q=q->link;
				p=p->link;
			}
		}
		else
		{
			temp=malloc(sizeof(pNode));
			temp->coef=p->coef;
			temp->exp=p->exp;
			temp->link=q1->link;
			q1->link=temp;
			p=p->link;
		}
	}
}
void Output(polynominal *polynominal_1)
{
	pNode *p;
	p=polynominal_1->head->link;
	printf("%d",p->coef);
	printf("X^");
	printf("%d",p->exp);
	p=p->link; 
	while(p)
	{
		if(p->coef>0)
		{
			printf("+%d",p->coef);
	        printf("X^");
	        printf("%d",p->exp);
		}
		else if(p->coef<0)
		{
			printf("%d",p->coef);
	        printf("X^");
	        printf("%d",p->exp);
		} 
		p=p->link;
	}
	printf("\n");
} 
int main()
{
	polynominal polynominal_1;
	create(&polynominal_1);
	printf("输出多项式一："); 
	Output(&polynominal_1);
	polynominal polynominal_2;
	create(&polynominal_2);
	printf("输出多项式二："); 
	Output(&polynominal_2);
	
	/*Add(&polynominal_1,&polynominal_2);
	printf("输出和多项式："); 	
	Output(&polynominal_2);*/
	/*Sub(&polynominal_1,&polynominal_2);
	printf("输出多项式："); 	
	Output(&polynominal_2);*/
	Mul(&polynominal_1,&polynominal_2);
	printf("输出多项式："); 	
	Output(&polynominal_2);
	return 0;
}
