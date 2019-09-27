package cn.jbit.estaff.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.jbit.estaff.dao.BaseInformationDao;
import cn.jbit.estaff.dao.JDBCUtil;
import cn.jbit.estaff.dao.SalaryDao;
import cn.jbit.estaff.dao.StaffDao;
import cn.jbit.estaff.entity.Salary;
import cn.jbit.estaff.entity.Staff;
import cn.jbit.estaff.entity.User;

public class StaffDaoMysqlImpl extends JDBCUtil implements BaseInformationDao,SalaryDao{
    

	@Override
	public void insertOfSalary(Salary sal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delOfSalary(Salary sal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOfSalary(Salary sal) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Boolean findStaSal(Salary sal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HashMap> findStasl(Salary sal) {
		// TODO Auto-generated method stub
		String sql="SELECT* FROM salary WHERE job_number=? and issueDate is not NULL";
		Object[]prms={sal.getJobOfNumber()};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}

	@Override
	public int insertSta(Staff staff) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delSta(Staff staff) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSta(Staff staff) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean finSta(Staff staff) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		String sql="select * from employee where job_number=?";
		Object params[]= {staff.getJobOfNumber()};
		List<HashMap> listSector=new ArrayList<>();
		listSector=this.executeQuery(sql, params);
		if(listSector.size()>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public List<HashMap> findStaInfor(Staff staff) {
		// TODO Auto-generated method stub
		String sql="SELECT* FROM employee WHERE job_number=?";
		Object[]prms={staff.getJobOfNumber()};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}

	@Override
	public List<HashMap> findStaInfor(String string) {
		// TODO Auto-generated method stub
		return null;
	}


}
