package cn.jbit.estaff.dao;

import java.util.HashMap;
import java.util.List;

import cn.jbit.estaff.entity.Log;

public interface LogDao {
	public int insertLog(Log log);
	public int delLog(Log log);
	public int updateLog(Log log);
	public List<HashMap> findLog(Log log);
}
