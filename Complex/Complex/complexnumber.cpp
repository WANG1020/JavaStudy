#include "stdafx.h"
#include "complexnumber.h"

complex::complex()
{
}

complex::complex(float real, float imag)
{
	m_real = real;
	m_imag=imag;
}

void complex::print()
{
	if (m_real != 0)
	{
		cout << m_real;
		if(m_imag!=0)
		{
			if (m_imag > 0 ) cout << "+";
		    cout << m_imag << "i"; 
		}
	}
	else
	{
		if (m_imag != 0)
		{
			cout << m_imag << "i";
		}
		else
		{
			cout << 0;
		}
	}
	cout << endl;
}

complex::~complex()
{
}

complex operator+(complex &c1, complex &c2)
{
	complex sum;
	sum.m_imag = c1.m_imag + c2.m_imag;
	sum.m_real = c1.m_real + c2.m_real;
	return sum;
}

complex operator-(complex &c1, complex &c2)
{
	complex minus;
	minus.m_imag = c1.m_imag - c2.m_imag;
	minus.m_real = c1.m_real - c2.m_real;
	return minus;
}

complex operator*(complex & c1, complex & c2)
{
	complex product;
	product.m_real = c1.m_real*c2.m_real + c1.m_imag*c2.m_imag;
	product.m_imag = c1.m_real*c2.m_imag + c1.m_imag*c2.m_real;
	return product;
}

complex operator/(complex & com1, complex & com2)
{
	complex div;
	div.m_real = (com1.m_real*com2.m_real + com1.m_imag*com2.m_imag)
		/ (com2.m_imag*com2.m_imag + com2.m_real*com2.m_real);
	div.m_imag=(com1.m_imag*com2.m_real-com1.m_real*com2.m_imag)
		/ (com2.m_imag*com2.m_imag + com2.m_real*com2.m_real);
	return div;
}
