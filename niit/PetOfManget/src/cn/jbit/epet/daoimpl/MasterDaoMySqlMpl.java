package cn.jbit.epet.daoimpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.jbit.epet.dao.JDBCUtil;
import cn.jbit.epet.dao.masterDao;
import cn.jbit.epet.entity.Master;

public class MasterDaoMySqlMpl extends JDBCUtil implements masterDao{
	
	@Override
	public int insert(Master mas) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int del(Master mas) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Master mas) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean findMaster(Master mas) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		String sql="select * from master where name=? and password=?";
		Object params[]= {mas.getName(),mas.getPassword()};
		List<HashMap> listMaster=new ArrayList<>();
		listMaster=this.executeQuery(sql, params);
		if(listMaster.size()>0) {
			flag=true;
		}
		return flag;
	}
	
}
