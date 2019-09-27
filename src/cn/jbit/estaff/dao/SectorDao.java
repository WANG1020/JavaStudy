package cn.jbit.estaff.dao;

import java.util.HashMap;
import java.util.List;

import cn.jbit.estaff.entity.Sector;

public interface SectorDao {
	/**
	 * 部门管理模块
	 * @param sector
	 * @return
	 */
	public int insert(Sector sector);
	public int delete(Sector sector);
	public int update(Sector sector);
	public Boolean findexistSec(Sector sector);
	public List<HashMap> findSector(Sector sector);
}
