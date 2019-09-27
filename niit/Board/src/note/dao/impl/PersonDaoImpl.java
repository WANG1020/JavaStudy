package note.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.sun.org.apache.regexp.internal.recompile;

import note.dao.PersonDao;
import note.util.DataBaseConnection;
import note.vo.person;

public class PersonDaoImpl implements PersonDao{

	@Override
	public boolean login(person person) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select username,password from person where username=? and password=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		pstmt=dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1,person.getUserName());
		pstmt.setString(2,person.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean checkFlag(person person) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select flag from person where username=? and password=? and flag=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		pstmt=dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1,person.getUserName());
		pstmt.setString(2,person.getPassword());
		pstmt.setInt(3,1);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			flag=true;
		}
		return flag;
	}

	@Override
	public void register(person person) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into person(username,password,email,flag,active,image) values (?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		pstmt=dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1,person.getUserName());
		pstmt.setString(2,person.getPassword());
		pstmt.setString(3,person.getEmail());
		pstmt.setInt(4, person.getFlag());
		pstmt.setInt(5, person.getActive());
		pstmt.setString(6, person.getImage());
		pstmt.executeUpdate();
	}

	@Override
	public boolean checkUser(person person) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select username FROM person WHERE username=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		pstmt=dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1,person.getUserName());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			flag=true;
		}
		return flag;
	}

	@Override
	public String QueryId(person person) throws Exception {
		// TODO Auto-generated method stub
		String bString="";
		String sql="SELECT id FROM person WHERE username=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		
		pstmt=dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1,person.getUserName());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			bString=rs.getString(1);
		}
		return bString;
		
	}

	@Override
	public boolean checkUserById(String id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="SELECT id FROM person WHERE id=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return flag;
	}

	@Override
	public person checkPersonById(String id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="SELECT * FROM person WHERE id=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		
		pstmt=dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1,id);
		ResultSet rs=pstmt.executeQuery();
		person tperson=new person();
		if(rs.next())
		{
			flag=true;
			tperson.setId(rs.getInt(1));
			tperson.setUserName(rs.getString(2));
			tperson.setPassword(rs.getString(3));
			tperson.setEmail(rs.getString(4));
			tperson.setFlag(rs.getInt(5));
			tperson.setActive(rs.getInt(6));
			tperson.setImage(rs.getString(7));
		}
		return tperson;
	}

	@Override
	public void update(String id) throws Exception {
		// TODO Auto-generated method stub
		String sql="UPDATE person SET active=? WHERE id=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,"1");
			pstmt.setString(2,id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			dbc.close();
		}
	}

	@Override
	public String checkPersonImg(person person) throws Exception {
		// TODO Auto-generated method stub
		String bString="";
		String sql="SELECT image FROM person WHERE username=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
	/*	System.out.println("adf"+person.getUserName());*/
		pstmt=dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1,person.getUserName());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			bString=rs.getString(1);
			/*System.out.println("img"+bString);*/
		}
		return bString;
	}

}
