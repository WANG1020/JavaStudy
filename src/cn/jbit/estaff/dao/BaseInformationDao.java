package cn.jbit.estaff.dao;

import java.util.HashMap;
import java.util.List;

import cn.jbit.estaff.entity.Staff;
/**
 * 员工基本信息
 * @author asus
 *
 */

public interface BaseInformationDao {
	public int insertSta(Staff staff);
	public int delSta(Staff staff);
	public int updateSta(Staff staff);
	public Boolean finSta(Staff staff);
	public List<HashMap> findStaInfor(Staff staff);
	public List<HashMap> findStaInfor(String string);
}
