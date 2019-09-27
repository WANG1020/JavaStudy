package cn.jbit.estaff.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.jbit.estaff.dao.JDBCUtil;
import cn.jbit.estaff.dao.UserDao;
import cn.jbit.estaff.entity.User;

public class UserDaoImpl extends JDBCUtil implements UserDao{


	@Override
	public int del(User user) {
		// TODO Auto-generated method stub
		String sql="delete from user where job_number=?";
		Object  []prms={user.getJobOfNumber()};
		this.executeUpdate(sql,prms);
		return 0;
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		String sql=new String("insert into user(serial_number,job_number,userName,passward,identity)values(?,?,?,?,?)");
		Object  []prms={user.getId(),user.getJobOfNumber(),user.getName(),user.getPassword(),user.getPost()};
		this.executeUpdate(sql,prms);
		return 0;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public boolean CheckUser(User user) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		String sql="select * from user where job_number=? and passward=? and identity=?";
		Object params[]= {user.getJobOfNumber(),user.getPassword(),user.getPost()};
		List<HashMap> listMaster=new ArrayList<>();
		listMaster=this.executeQuery(sql, params);
		if(listMaster.size()>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean findStaUser(User user) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		String sql="select * from user where job_number=? and identity='员工'";
		Object params[]= {user.getJobOfNumber()};
		List<HashMap> listMaster=new ArrayList<>();
		listMaster=this.executeQuery(sql, params);
		if(listMaster.size()>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean findManUser(User user) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		String sql="select * from user where job_number=? and identity='普通管理员'";
		Object params[]= {user.getJobOfNumber()};
		List<HashMap> listMaster=new ArrayList<>();
		listMaster=this.executeQuery(sql, params);
		if(listMaster.size()>0) {
			flag=true;
		}
		return flag;
	}
}
