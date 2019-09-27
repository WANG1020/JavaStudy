package cn.jbit.estaff.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cn.jbit.estaff.dao.AttendanceDao;
import cn.jbit.estaff.dao.BaseInformationDao;
import cn.jbit.estaff.dao.JDBCUtil;
import cn.jbit.estaff.dao.ManagerDao;
import cn.jbit.estaff.dao.SalaryDao;
import cn.jbit.estaff.dao.StaffDao;
import cn.jbit.estaff.entity.Attendance;
import cn.jbit.estaff.entity.Salary;
import cn.jbit.estaff.entity.SignIn;
import cn.jbit.estaff.entity.Staff;
import cn.jbit.estaff.entity.User;

public class ManagerDaoMysqlImpl extends JDBCUtil implements ManagerDao,SalaryDao,BaseInformationDao,AttendanceDao,StaffDao{

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
		return 0;
	}

	@Override
	public int updateWorkAtten(Attendance attend) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HashMap> findbyJobNumeOfWorkAtten(Attendance attend) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOfSignIn(SignIn sIn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOfSignIn(SignIn sIn) {
		// TODO Auto-generated method stub
		return 0;
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
		String sql="select * from employee where job_number=? ";
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
	public List<HashMap> findStaInfor(String string) {
		// TODO Auto-generated method stub
		String sql="SELECT *\r\n" + 
				"FROM employee \r\n" + 
				"WHERE department  IN\r\n" + 
				"(\r\n" + 
				"	SELECT  department\r\n" + 
				"	FROM employee\r\n" + 
				"	WHERE job_number=?\r\n" + 
				")\r\n" + 
				"";
		Object  []prms={string};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}
	@Override
	public void insertOfSalary(Salary sal) {
		// TODO Auto-generated method stub
		String sql1=new String("insert into salary(serial_number,job_number,name,baseSalary,overtimeSslary,subsidy,attendnceBonus,penalty,total,issueDate)values(?,?,?,?,?,?,?,?,?,?)");
		Object []params= {sal.getId(),sal.getJobOfNumber(),sal.getName(),sal.getBaseSalary(),sal.getOvertimeSslary(),sal.getSubsidy(),sal.getAttendnceBonus(),sal.getPenalty(),sal.getTotal(),sal.getIssueDate()};
		this.executeUpdate(sql1, params);
		JOptionPane.showMessageDialog(null, "修改成功!");
	}

	@Override
	public void delOfSalary(Salary sal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOfSalary(Salary sal) {
		// TODO Auto-generated method stub
		String sql1="update salary set baseSalary=?,overtimeSslary=?,subsidy=?,attendnceBonus=?,penalty=?,total=?,issueDate=? where job_number=?";
		Object []params= {sal.getBaseSalary(),sal.getOvertimeSslary(),sal.getSubsidy(),sal.getAttendnceBonus(),sal.getPenalty(),sal.getTotal(),sal.getIssueDate()};
		this.executeUpdate(sql1, params);
		JOptionPane.showMessageDialog(null, "修改成功!!");
	}

	@Override
	public Boolean findStaSal(Salary sal) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		String sql="select * from salary where job_number=? ";
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
		return null;
	}

	@Override
	public List<HashMap> total(String job) {
		// TODO Auto-generated method stub
		String sql="select  employee.serial_number,employee.job_number,employee.name,employee.position,user.identity \r\n" + 
				"from employee inner join user on employee.job_number=user.job_number ";
		Object  []prms={};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}

	@Override
	public List<HashMap> findSing(SignIn sIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HashMap> totalDep(String job) {
		// TODO Auto-generated method stub
		String sql="SELECT *\r\n" + 
				"FROM employee \r\n" + 
				"WHERE department  IN\r\n" + 
				"(\r\n" + 
				"	SELECT  department\r\n" + 
				"	FROM employee\r\n" + 
				"	WHERE job_number=?\r\n" + 
				")\r\n" + 
				"";
		Object  []prms={job};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}

	@Override
	public Boolean findRS(User user) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		String sql="select * from employee where job_number=? and department='人事部' ";
		Object params[]= {user.getJobOfNumber()};
		List<HashMap> listSector=new ArrayList<>();
		listSector=this.executeQuery(sql, params);
		if(listSector.size()>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public Boolean findCW(User user) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		String sql="select * from employee where job_number=? and  department='财务部'";
		Object params[]= {user.getJobOfNumber()};
		List<HashMap> listSector=new ArrayList<>();
		listSector=this.executeQuery(sql, params);
		if(listSector.size()>0) {
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean finSta(Staff staff, String userJNum) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		String sql="SELECT * FROM employee WHERE job_number=? AND department IN(\r\n" + 
				"  SELECT department FROM employee\r\n" + 
				"  WHERE job_number=?\r\n" + 
				")";
		Object params[]= {staff.getJobOfNumber(),userJNum};
		List<HashMap> listSector=new ArrayList<>();
		listSector=this.executeQuery(sql, params);
		if(listSector.size()>0) {
			flag=true;
		}
		return flag;
	}
}
