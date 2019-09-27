package cn.jbit.estaff.dao;

import java.util.HashMap;
import java.util.List;

import cn.jbit.estaff.entity.Staff;
import cn.jbit.estaff.entity.User;
import cn.jbit.estaff.test.findSta;

public interface ManagerDao {
	public List<HashMap> total(String job);
	public List<HashMap> totalDep(String dep);
	public Boolean findRS(User user);
	public Boolean findCW(User user);
	public boolean finSta(Staff staff,String userJNum);
}
