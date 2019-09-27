package cn.jbit.estaff.dao;

import java.util.HashMap;
import java.util.List;

import cn.jbit.estaff.entity.Attendance;
import cn.jbit.estaff.entity.SignIn;


public interface AttendanceDao {
	/**
	 * 考勤模块和签到的操作
	 * @param sector
	 * @return
	 */
	public int insertWorkAtten(Attendance attend);
	public int delWorkAtten(Attendance attend);
	public int updateWorkAtten(Attendance attend);
	public List<HashMap> findbyJobNumeOfWorkAtten(Attendance attend);
	
	public int insertOfSignIn(SignIn sIn);
	public int updateOfSignIn(SignIn sIn);
	public List<HashMap> findSing(SignIn sIn);
}
