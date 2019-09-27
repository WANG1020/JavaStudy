package cn.jbit.epet.dao;

import javax.activation.UnsupportedDataTypeException;

import cn.jbit.epet.entity.Master;

public interface masterDao {
	/**
	 * 对master表进行插入操作
	 * @param master
	 * @return
	 */
	public int insert(Master master);
	/**
	 * 对master进行删除操作
	 * @param master
	 * @return
	 */
	public int del(Master master);
	/**
	 * 对master表进行更新，修改
	 * @param master
	 * @return
	 */
	public int update(Master master);
	/**
	 * 对master进行查找功能
	 * @param master
	 * @return
	 */
	public Boolean findMaster(Master master);
}
