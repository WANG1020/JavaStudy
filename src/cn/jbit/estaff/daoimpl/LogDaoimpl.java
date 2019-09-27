package cn.jbit.estaff.daoimpl;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cn.jbit.estaff.dao.JDBCUtil;
import cn.jbit.estaff.dao.LogDao;
import cn.jbit.estaff.entity.Log;

public class LogDaoimpl extends JDBCUtil implements LogDao {

	@Override
	public int insertLog(Log log) {
		// TODO Auto-generated method stub
		String sql=new String("insert into log(job_number,operation,operationTime)values(?,?,?)");
		Object []params= {log.getJobOfNumber(),log.getOperation(),log.getOperationTime()};
		this.executeUpdate(sql,params);
		return 0;
	}

	@Override
	public int delLog(Log log) {
		// TODO Auto-generated method stub
		String sql="delete  from  log where getJobOfNumber=? and operationTime=?)";
		Object []params= {log.getJobOfNumber(),log.getOperationTime()};
		this.executeUpdate(sql,params);
		return 0;
	}

	@Override
	public int updateLog(Log log) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public  List<HashMap> findLog(Log log) {
		// TODO Auto-generated method stub
		String sql="SELECT* FROM log WHERE job_number=?";
		Object  []prms={log.getJobOfNumber()};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}

}
