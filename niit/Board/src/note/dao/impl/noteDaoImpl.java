package note.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.sun.media.jfxmedia.events.NewFrameEvent;

import note.dao.noteDao;
import note.util.SplitPage;
import note.util.DataBaseConnection;
import note.vo.Note;

public class noteDaoImpl implements noteDao{

	@Override
	public void insert(Note note) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO note(id,title,author,content) VALUES(id,?,?,?)";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,note.getTitle());
			pstmt.setString(2,note.getAuthor());
			pstmt.setString(3,note.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Note note) {
		// TODO Auto-generated method stub
		String sql="UPDATE note SET title=?,author=?,content=? WHERE id=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,note.getTitle());
			pstmt.setString(2,note.getAuthor());
			pstmt.setString(3,note.getContent());
			pstmt.setInt(4, note.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM note WHERE id=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Note> queryAll() {
		// TODO Auto-generated method stub
		List all=new ArrayList();//新建List all接收查询结果
		String sql = "SELECT id,title,author,content FROM note" ;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try
		{
			pstmt=dbc.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){//有下个就执行，没有跳出
				Note tempnote=new Note();//新建临时变量为了接收每一个Note,并逐个将信息“存入”tempnote
				tempnote.setId(rs.getInt(1));//给每一个tempnote赋值
				tempnote.setTitle(rs.getString(2));
				tempnote.setAuthor(rs.getString(3));
				tempnote.setContent(rs.getString(4));
				all.add(tempnote);//将tempnote存入all
			}
			rs.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		
		return all;//返回all
	}

	@Override
	public List<Note> findAll(int contNow, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		List all=new ArrayList();
		String sql="select *from note limit ?,?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, contNow);
			pstmt.setInt(2, pageSize);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Note tempNote=new Note();
				tempNote.setId(rs.getInt(1));
				tempNote.setTitle(rs.getString(2));
				tempNote.setAuthor(rs.getString(3));
				tempNote.setContent(rs.getString(4));
				all.add(tempNote);
			}
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return all;
	}

	@Override
	public List<Note> findAll(SplitPage sp) throws Exception {
		// TODO Auto-generated method stub
		List<Note> list=new ArrayList<>();
		/*DataBaseConnection ptBaseConnection=null;*/
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
	/*	System.out.println(sp.getPageRows());*/
		String sql="select *from note limit "+sp.getPageRows()*(sp.getCurrentPage()-1)+","+sp.getPageRows();
		try{
			pstmt=dbc.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Note tempNote=new Note();
				tempNote.setId(rs.getInt(1));
				tempNote.setTitle(rs.getString(2));
				tempNote.setAuthor(rs.getString(3));
				tempNote.setContent(rs.getString(4));
				list.add(tempNote);
			}
			rs.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return list;
	}

	@Override
	public boolean search(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select id from note where id=?";
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try {
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return flag;
	}

}
