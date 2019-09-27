package cn.jbit.estaff.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cn.jbit.estaff.dao.AttendanceDao;
import cn.jbit.estaff.dao.BaseInformationDao;
import cn.jbit.estaff.dao.JDBCUtil;
import cn.jbit.estaff.dao.LogDao;
import cn.jbit.estaff.dao.SalaryDao;
import cn.jbit.estaff.dao.SectorDao;
import cn.jbit.estaff.dao.StaffDao;
import cn.jbit.estaff.dao.SuperManagerDao;
import cn.jbit.estaff.entity.Attendance;
import cn.jbit.estaff.entity.Log;
import cn.jbit.estaff.entity.Salary;
import cn.jbit.estaff.entity.Sector;
import cn.jbit.estaff.entity.SignIn;
import cn.jbit.estaff.entity.Staff;
import cn.jbit.estaff.entity.User;

public class SuperManagerDaoImpl extends JDBCUtil implements SuperManagerDao,SectorDao,AttendanceDao,SalaryDao,BaseInformationDao{

	@Override
	public int insertWorkAtten(Attendance attend) {
		// TODO Auto-generated method stub
		String sql="insert into attendance(serial_number,job_number,name,workday)values(?,?,?,?)";
		Object []params= {attend.getId(),attend.getJobOfNumber(),attend.getName(),attend.getWorkday()};
		this.executeUpdate(sql, params);
		JOptionPane.showMessageDialog(null, "考勤成功！！");
		return 0;
	}

	@Override
	public int delWorkAtten(Attendance attend) {
		// TODO Auto-generated method stub
		String sql="delete from attendance where job_number=? and workday=?";
		Object []params= {attend.getJobOfNumber(),attend.getWorkday()};
		this.executeUpdate(sql, params);
		JOptionPane.showMessageDialog(null, "删除成功！！");
		return 0;
	}

	@Override
	public int updateWorkAtten(Attendance attend) {
		// TODO Auto-generated method stub
		String sql="update attendance set workday=? where job_number=?";
		Object []params= {attend.getWorkday(),attend.getJobOfNumber()};
		this.executeUpdate(sql, params);
		return 0;
	}

	@Override
	public List<HashMap> findbyJobNumeOfWorkAtten(Attendance attend) {
		// TODO Auto-generated method stub
		String sql="SELECT* FROM attendance WHERE job_number=?";
		Object  []prms={attend.getJobOfNumber()};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}
	/**
	 * 部门模块接口实现
	 */
	@Override
	public int insert(Sector sector) {
		// TODO Auto-generated method stub
		String sql=new String("insert into Sector(serial_number,name,departmentManager,contctInformation,introduction)values(?,?,?,?,?)");
		Object []prms= {sector.getId(),sector.getName(),sector.getDepartmentManager(),sector.getContctInformation(),sector.getIntroduction()};
		this.executeUpdate(sql, prms);
		JOptionPane.showMessageDialog(null, "新建一个部门成功！！","插入成功",JOptionPane.PLAIN_MESSAGE);
		return 0;
	}

	@Override
	public int delete(Sector sector) {
		// TODO Auto-generated method stub
		String sql="delete from sector where name=?";
		Object []parms= {sector.getName()};
		this.executeUpdate(sql, parms);
		JOptionPane.showMessageDialog(null, "删除成功！！","删除成功",JOptionPane.PLAIN_MESSAGE);
		return 0;
	}

	@Override
	public int update(Sector sector) {
		// TODO Auto-generated method stub
		String  sql="update sector set departmentManager=? where name=? ";
		Object []prms= {sector.getDepartmentManager(),sector.getName()};
		this.executeUpdate(sql,prms);
		String  sql1="update sector set contctInformation=? where name=? ";
		Object []prms1= {sector.getContctInformation(),sector.getName()};
		this.executeUpdate(sql1,prms1);
		JOptionPane.showMessageDialog(null, "修改成功！！","修改成功",JOptionPane.PLAIN_MESSAGE);
		return 0;
	}
	@Override
	public List<HashMap> findSector(Sector sector) {
		// TODO Auto-generated method stub
		String sql="SELECT* FROM sector WHERE name=?";
		Object  []prms={sector.getName()};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}

	@Override
	public Boolean findexistSec(Sector sector) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		String sql="select * from sector where name=?";
		Object params[]= {sector.getName()};
		List<HashMap> listSector=new ArrayList<>();
		listSector=this.executeQuery(sql, params);
		if(listSector.size()>0) {
			flag=true;
		}
		return flag;
	}
	/**
	 * 用户
	 */
	@Override
	public int deleteMan(User user) {
		// TODO Auto-generated method stub
		String sql="update user set identity='员工' where userName=?";
		Object params[]= {user.getName()};	
		this.executeUpdate(sql, params);
		JOptionPane.showMessageDialog(null, "删除管理员成功");
		return 0;
	}

	@Override
	public int updateMan(User user) {
		// TODO Auto-generated method stub
		String sql="update user set identity='普通管理员'  where userName=?";
		Object params[]= {user.getName()};	
		this.executeUpdate(sql, params);
		JOptionPane.showMessageDialog(null, "添加管理员成功");
		return 0;
	}

	@Override
	public int resetAdmPass(User user) {
		// TODO Auto-generated method stub
		String sql="update user set passward='123456' where job_number=?";
		Object params[]= {user.getJobOfNumber()};
		this.executeUpdate(sql, params);
		JOptionPane.showMessageDialog(null, "重置密码成功");
		return 0;
	}
	@Override
	public int resetStafPass(User user) {
		// TODO Auto-generated method stub
		String sql="update user set passward=? where job_number=? ";
		Object params[]= {user.getPassword(),user.getJobOfNumber()};
		this.executeUpdate(sql, params);
		JOptionPane.showMessageDialog(null, "重置密码成功");
		return 0;
	}

	@Override
	public void insertOfSalary(Salary sal) {
		// TODO Auto-generated method stub
		String sql="update salary set baseSalary=? where job_number=?";
		Object params[]= {sal.getBaseSalary(),sal.getJobOfNumber()};
		this.executeUpdate(sql, params);
		JOptionPane.showMessageDialog(null, "设置成功");
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
		Boolean flag=false;
		String sql="select * from salary where job_number=?";
		Object params[]= {sal.getJobOfNumber()};
		List<HashMap> listSector=new ArrayList<>();
		listSector=this.executeQuery(sql, params);
		if(listSector.size()>0) {
			flag=true;
		}
		return flag;
	}
	@Override
	public List<HashMap> findStasl(Salary sal) {
		// TODO Auto-generated method stub
		String sql="SELECT* FROM salary WHERE job_number=? and name=?";
		Object  []prms={sal.getJobOfNumber(),sal.getName()};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
		
	}

	@Override
	public List<HashMap> findSing(SignIn sIn) {
		// TODO Auto-generated method stub
		String  sql="select * from sign where job_number=?";
		Object []params= {sIn.getJobOfNumber()};
		this.executeQuery(sql, params);
		return this.executeQuery(sql,params);
	}

	@Override
	public int insertOfSignIn(SignIn sIn) {
		// TODO Auto-generated method stub
		String sql="insert into sign(serial_number,job_number,name,signedNumber,signenTime)values(?,?,?,?,?)";
		Object []params= {sIn.getId(),sIn.getJobOfNumber(),sIn.getName(),sIn.getSignedNumber(),sIn.getSignenTime()};
		this.executeUpdate(sql, params);
		return 0;
	}

	@Override
	public int updateOfSignIn(SignIn sIn) {
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
		String sql="SELECT* FROM employee WHERE job_number=? and name=?";
		Object  []prms={staff.getJobOfNumber(),staff.getName()};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}

	@Override
	public int insertSta(Staff staff) {
		// TODO Auto-generated method stub
		String sql=new String("insert into employee(serial_number,job_number,name,sex,age,department,position,dateOnBoard,departureDate,workingYears,idNumber,educationBackground,address,honeNumber,mailBox,picture)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		Object []prms= {staff.getId(),staff.getJobOfNumber(),staff.getName(),staff.getSex(),staff.getAge(),staff.getDepartment(),staff.getPosition(),staff.getDateOnBoard(),staff.getDepartureDate(),staff.getWorkingYears(),staff.getIdNumber(),staff.getEducationBackground(),staff.getFamilyAddress(),staff.getPhoneNumber(),staff.getMailBox(),staff.getPicture()};
		this.executeUpdate(sql, prms);
		String sql1=new String("insert into salary(serial_number,job_number,name)values(?,?,?)");
		Object []params= {staff.getId(),staff.getJobOfNumber(),staff.getName()};
		this.executeUpdate(sql1, params);
		JOptionPane.showMessageDialog(null, "插入成功！！","插入成功",JOptionPane.PLAIN_MESSAGE);
		return 0;
	}

	@Override
	public int delSta(Staff staff) {
		// TODO Auto-generated method stub
		String sql="delete from employee where job_number=? and name=?";
		Object []params= {staff.getJobOfNumber(),staff.getName()};
		this.executeUpdate(sql, params);
		JOptionPane.showMessageDialog(null, staff.getName()+"已被解雇");
		return 0;
	}

	@Override
	public int updateSta(Staff staff) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Pass(String pass) {
		// TODO Auto-generated method stub
		String sql="update user set passward=? WHERE passward<>?";
		Object []params= {pass,pass};
		this.executeUpdate(sql, params);
		JOptionPane.showMessageDialog(null, "重置密码成功");
		return 0;
	}
	@Override
	public List<HashMap> total(String dep) {
		// TODO Auto-generated method stub
		String sql="select  employee.serial_number,employee.job_number,employee.name,employee.department,employee.position,user.identity \r\n" + 
				"from employee inner join user on employee.job_number=user.job_number\r\n" + 
				" WHERE department=?";
		Object  []prms={dep};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}

	@Override
	public List<HashMap> findStaInfor(String string) {
		// TODO Auto-generated method stub
		return null;
	}


}
