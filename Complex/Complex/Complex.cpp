// Complex.cpp: 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "complexnumber.h"



int main()
{
	cout << "请依次输入复数的实部和虚部：";
	complex c1, c2,sum,minus,product,div;
	cin >> c1.m_real>>c1.m_imag;
	cin >> c2.m_real >> c2.m_imag;
	cout << "第一个复数为：";
	c1.print();
	cout << "第二个复数为：";
	c2.print();
	sum = c1 + c2;
	minus = c1 - c2;
	product = c1 * c2;
	cout << "c1+c2= ";
	sum.print();
	cout << "c1-c2= ";
	minus.print();
	cout << "c1*c2= "; 
	product.print();
	cout << "c1/c2=";
	div.print();
    return 0;
}






