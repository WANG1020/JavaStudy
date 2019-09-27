package cn.jbit.estaff.dao;

import java.util.HashMap;
import java.util.List;

import cn.jbit.estaff.entity.Salary;
import cn.jbit.estaff.entity.User;

public interface SalaryDao {
	public void insertOfSalary(Salary sal);
	public void delOfSalary(Salary sal);
	public void updateOfSalary(Salary sal);
	public Boolean findStaSal(Salary sal);
	public List<HashMap> findStasl(Salary sal);
}
