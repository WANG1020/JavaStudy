package cn.jbit.epet.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cn.jbit.epet.dao.JDBCUtil;
import cn.jbit.epet.dao.petDao;
import cn.jbit.epet.entity.Pet;

public class PetDaoMySqlImpl  extends JDBCUtil implements petDao {

	@Override
	public int insert(Pet pet) {
		// TODO Auto-generated method stu
		String sql=new String("insert into pet(id,master_id,name,health,love,strain)values(?,?,?,?,?,?)");
		Object  []prms={pet.getId(),pet.getMasterId(),pet.getName(),pet.getHealth(),pet.getLove(),pet.getStrain()};
		this.executeUpdate(sql,prms);
		JOptionPane.showMessageDialog(null, "插入记录成功!");
		return 0;
	}

	@Override
	public int del(Pet pet) {
		// TODO Auto-generated method stub 
		String sql="delete from pet where name=?";
		Object  []prms={pet.getName()};
		this.executeUpdate(sql,prms);
		return 0;
	}

	@Override
	public int update(Pet pet) {
		// TODO Auto-generated method stub
		String sql="update pet set name=?  where id=?";
		Object  []prms={pet.getName(),pet.getId()};
		this.executeUpdate(sql,prms);
		return 0;
	}

	@Override
	public Pet getByName(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT* FROM pet WHERE name=?";
		Object  []prms={name};
		this.executeQueryRs(sql,prms);
		return null;
	}

	@Override
	public List<HashMap> findByName(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT* FROM pet WHERE name=?";
		Object  []prms={name};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}

	@Override
	public List<HashMap> findById(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT* FROM pet WHERE id=?";
		Object  []prms={id};
		this.executeQuery(sql,prms);
		return this.executeQuery(sql,prms);
	}

}
