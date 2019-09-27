package cn.jbit.estaff.dao;

import cn.jbit.estaff.entity.User;

public interface UserDao {
	public int insert(User user);
	public int del(User user);
	public int update(User user);
	public boolean findStaUser(User user);
	public boolean findManUser(User user);
	public boolean CheckUser(User user);
}
