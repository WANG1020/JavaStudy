/*��ͷ�ڵ����ʽ�Ӽ���*/ 
#include<stdio.h> 
#include<stdlib.h>
typedef int elemtype;
typedef struct pNode
{
	int coef; //ϵ�� 
	int exp;  //ָ�� 
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
	printf("�������ʽ������");
	scanf("%d",&number);
	int i;
	for(i=0;i<number;i++)*/ 
	for(;;)
	{
		temp1=malloc(sizeof(pNode));
		printf("coef:");
		scanf("%d",&temp1->coef);//����ϵ�� 
		printf("exp:");
		scanf("%d",&temp1->exp);//����ָ�� 
		if(temp1->exp<0) break;//ָ��Ϊ����������//�����������˸��� 
		temp2=p->head;
		q=p->head->link;
		while(q&&q->exp>temp1->exp) //����������ֶ���ʽ�ĸ���Ϊ�������� 
		{
			temp2=q;//temp2����q��ǰ��ָ�ڵ� 
			q=q->link;//qָ��q����һ���ڵ� 
		}
		temp1->link=q;//temp1����һ���ڵ�ָ��q 
		temp2->link=temp1;//temp2����һ���ڵ�ָ��temp1 
	}
}
void Mul(polynominal *px,polynominal *qx)//����ʽ�˷� 
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
void Sub(polynominal *px,polynominal *qx)//����ʽ���� 
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
			q->coef=q->coef-p->coef;//����ʽ����ȥ����ʽһ 
			if(p->coef==0)           
			{
				q1->link=q->link;  //ɾ��p
				free(q);
				q=q1->link; //����p
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
void Add(polynominal *px,polynominal *qx) //����ʽ�ӷ�//��ͷ��� 
{
	pNode *q,*q1,*p,*temp;
	q1=qx->head;  //q1ָ��qxͷ�ڵ� 
	p=px->head->link;//pָ��px��һ����Ч�ڵ� 
	q=q1->link;//qָ��qx��һ����Ч�ڵ㣬���ڶ��� 
	while(p&&q)  //q,p��Ϊ�� 
	{
	    while(p->exp<q->exp) 
		{
			q1=q;  //q1ָ��q 
			q=q->link;  //ָ����һ���ڵ� 
			p=p->link;
		}   
		if(p->exp==q->exp) //�����ǰ���p��ָ��С��q��ָ�� 
		{
			q->coef=q->coef+p->coef; //����ϵ����� 
			if(q->coef==0)           //������Ϊ0 
			{
				q1->link=q->link;  //ɾ��q 
				free(q);                //�ͷ�q 
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
	printf("�������ʽһ��"); 
	Output(&polynominal_1);
	polynominal polynominal_2;
	create(&polynominal_2);
	printf("�������ʽ����"); 
	Output(&polynominal_2);
	
	/*Add(&polynominal_1,&polynominal_2);
	printf("����Ͷ���ʽ��"); 	
	Output(&polynominal_2);*/
	/*Sub(&polynominal_1,&polynominal_2);
	printf("�������ʽ��"); 	
	Output(&polynominal_2);*/
	Mul(&polynominal_1,&polynominal_2);
	printf("�������ʽ��"); 	
	Output(&polynominal_2);
	return 0;
}
