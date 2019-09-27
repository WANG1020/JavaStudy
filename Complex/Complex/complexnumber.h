#pragma once
class complex
{
public:
	complex();
	float m_real;
	float m_imag;
	complex(float real,float imag);
	void print();
	friend complex operator +(complex &c1, complex &c2); 
	friend complex operator -(complex &c1, complex &c2);
	friend complex operator *(complex &c1, complex &c2);
	friend complex  operator /(complex &com1, complex &com2);
	~complex();
};

