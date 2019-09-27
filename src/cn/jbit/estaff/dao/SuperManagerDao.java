package cn.jbit.estaff.dao;

import java.util.HashMap;
import java.util.List;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import cn.jbit.estaff.entity.Attendance;
import cn.jbit.estaff.entity.Sector;
import cn.jbit.estaff.entity.Staff;
import cn.jbit.estaff.entity.User;

public interface SuperManagerDao  {
	//部门管理，考勤，工资，信息有接口
	public int deleteMan(User user);
	public int updateMan(User user);
	public int resetAdmPass(User user);
	
	
	public int resetStafPass(User user);
	
	public int Pass(String pass);
	public List<HashMap> total(String dep);
	
	
	
}
