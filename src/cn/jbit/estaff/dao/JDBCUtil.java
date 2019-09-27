package cn.jbit.estaff.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class JDBCUtil {
	private static String url="jdbc:mysql://localhost:3306/staffmanagement";
	private static String name="root";//
	private static String password="Root";
	private static Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;
	private static JDBCUtil jdbcUtil=null;
	
	public static synchronized JDBCUtil getInitJDBCUtil() {
		if(jdbcUtil==null) {
			jdbcUtil=new JDBCUtil();
		} 
		return jdbcUtil;
	}
	public JDBCUtil() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection(){
		try {
			connection=DriverManager.getConnection(url,name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public int executeUpdate(String sql,Object[] params) {
		int affectedLine=0;
		connection=getConnection();
		try {
			preparedStatement=connection.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				preparedStatement.setObject(i+1, params[i]);
			}
			affectedLine=preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			CloseAll();
		}
		return affectedLine;
	}
	/**doc注释
	 * 
	 * @param sql
	 * @return
	 */
	public int executeUpdate(String sql)  {//更新函数,直接写完整的SQL语句
		int affectedLine=0;
		try {
			preparedStatement=getConnection().prepareStatement(sql);
			affectedLine=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseAll();
		}
		return affectedLine;
	}
	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeQueryRs(String sql,Object[] params) {//查询函数
		connection=getConnection();
		try {
			preparedStatement=connection.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				preparedStatement.setObject(i+1, params[i]);//索引从1开始，所以参数为i+1
			}
			resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
		
	}
	public ArrayList<HashMap> executeQuery(String sql,Object[] params){//查询放到表中
		ResultSet rs=executeQueryRs(sql, params);
		ResultSetMetaData rsmd=null;
		int columnCount=0;
		try {
			rsmd=rs.getMetaData();
			columnCount=rsmd.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<HashMap> list=new ArrayList<>();
		try {
			while(rs.next()) {
				HashMap<String, Object> map=new HashMap<>();
				for(int i=1;i<=columnCount;i++) {
					map.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
				System.out.println(map);
				System.out.println("\n");
				list.add(map);//加到list
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseAll();//关闭文件
		}
		return list;
	}
	private void CloseAll() {
		// TODO Auto-generated method stub
		if(resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
