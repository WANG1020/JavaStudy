package cn.jbit.epet.dao;

import java.util.HashMap;
import java.util.List;

import cn.jbit.epet.entity.Pet;

public interface petDao {
	public int insert(Pet pet);
	public int del(Pet pet);
	public int update(Pet pet);
	public Pet getByName(String name);
	public List<HashMap> findByName(String name);
	public List<HashMap> findById(int id);
	
}
