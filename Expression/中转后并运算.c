#include<stdio.h> 
#include<stdlib.h>
#include<math.h>
#include<stdbool.h>
#include<ctype.h> 
#define ElemType char
/**
²âÊÔÓÃÀý£º6 4 2 - /3 2 * + 
*/
typedef struct Node
{
	ElemType element;
	struct Node *link; 
}Node;
typedef struct
{
	struct Node *head;
}Stack;


void Create(Stack *L)
{
	L->head=NULL;
}
void Destroy(Stack *L)
{
	Node *temp;
	while(L->head)
	{
		temp=L->head->link;
		free(L->head);
		L->head=temp;
	}
}
void Clear(Stack *S)
{
	S->head=NULL;
}
bool IsEmpty(Stack *L)
{
	int i=0;
	Node *p;
	p=L->head;
	while(L->head)
	{
		i++;
		p=p->link;
	}
	if(i==0)
	{
		return true;
	}
	else
	{
		return false;
	}
}

bool Top(Stack *L,ElemType *x)
{
	Node *p;
	p=L->head; 
	*x=p->element;
	return true;
}
bool Push(Stack *L,ElemType x)
{
	Node *p=(Node*)malloc(sizeof(Node));
	p->element=x;
	p->link=L->head;
	L->head=p;
	return true; 
}
bool Pop(Stack *L)
{
	Node *p;
	p=L->head;
	L->head=L->head->link;
	free(p);
	return true;
}
bool Topofint(Stack *L,int *x)
{
	Node *p;
	p=L->head; 
	*x=p->element;
	return true;
}
bool Pushofint(Stack *L,int x)
{
	Node *p=(Node*)malloc(sizeof(Node));
	p->element=x;
	p->link=L->head;
	L->head=p;
	return true; 
}

bool GetOperands(Stack *S,int *op1,int *op2)
{
	
	if(!Topofint(S,op1))
	{
		printf("Missing oeprand!");
		return false;
	}
	Pop(S);
	if(!Topofint(S,op2))
	{
		printf("Missing oeprand!");
		return false;
	}
	Pop(S);
	return true;
}
void DoOperator(Stack *s,char oper)
{
	bool result;
	int oper1,oper2;
	result=GetOperands(s,&oper1,&oper2);
	if(!result)
	{
		Clear(s);
	}
	else
	{
		switch(oper)
		{
			case '+':
				Pushofint(s,oper2+oper1);
				break;
			case '-':
				Pushofint(s,oper2-oper1);
				break;
			case '*':
				Pushofint(s,oper2*oper1);
				break;
			case '/':
				if(fabs(oper1)<1e-6){
					printf("Divide by 0!\n");
					Clear(s);
				} 
				else Pushofint(s,oper2/oper1);
				break;
			case '^':
				Pushofint(s,pow(oper2,oper1));
				break;
		}
	}
}

void Count()
{
	Stack *S=(Stack*)malloc(sizeof(Stack));
	Create(S);
	char c;
	int newop;
	c=getchar();
	while(c!='#'){
		switch(c){
			case '+':
			case '-':
			case '*':
			case '/':
			case '^':
				     DoOperator(S,c);
					 break;
			default:
					ungetc(c,stdin);
					scanf("%d",&newop);
					Pushofint(S,newop);				
		} 
		c=getchar();
	} 
	if(Topofint(S,&newop))
		printf("%d",newop);
	Destroy(S);
}

int icp(char c)
{
	int priority;
	switch(c)
	{
		case '#':
			priority=0;
			break;
		case '(':
			priority=8;
			break;
		case '^':
			priority=6;
			break;
		case '*':
		case '/':
			priority=4;
			break;
		case '+':
		case '-':
			priority=2;
			break;
		case ')':
			priority=1;
			break;
			
	}
	return priority;
} 
int isp(char c)
{
	int priority;
	switch(c)
	{
		case '#':
			priority=0;
			break;
		case '(':
			priority=1;
			break;
		case '*':
		case '/':
			priority=5;
			break;
		case '+':
		case '-':
			priority=3;
			break;
		case '6': 
		    priority=7;
			break;
		case ')':
			priority=8;
			break;
			
	}
	return priority;
 } 
void InfixToPostfix(Stack *S)
{
	char ch,y;
	Push(S,'#');
	ch=getchar();
	while(ch!='#')
	{
		if(isdigit(ch)||isalpha(ch))
		{
			printf("%c",ch); 
		}
		else if(ch==')')
		{
			for(Top(S,&y),Pop(S);y!=')'&&!IsEmpty(S);Top(S,&y),Pop(S))
				printf("%c",y);
				printf(" "); 
		}
		else
		{
			for(Top(S,&y),Pop(S);icp(ch)<=isp(y);Top(S,&y),Pop(S)) 
				printf("%c",y);
				printf(" ");
			Push(S,y);
			Push(S,ch); 
		}
		ch=getchar();
	}
	while(!IsEmpty(S))
	{
		Top(S,&y); 
	Pop(S);
	if(y!='#')
		printf("%c",y);
	} 
	printf("\n"); 
} 
int main(void)
{
	Stack *stack=(Stack*)malloc(sizeof(Stack));
	Create(stack);
	InfixToPostfix(stack); 	
	Count();
	return 0;
}

