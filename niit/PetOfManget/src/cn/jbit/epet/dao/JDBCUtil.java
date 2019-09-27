package cn.jbit.epet.dao;

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
	private static String url="jdbc:mysql://localhost:3306/pett";
	private static String name="root";//
	private static String password="Root";
	private static Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;
	private static JDBCUtil jdbcUtil=null;
	//懒汉式加载
	public static synchronized JDBCUtil getInitJDBCUtil() {//同步
		if(jdbcUtil==null) {
			jdbcUtil=new JDBCUtil();//生成一个对象
		} 
		return jdbcUtil;
	}
	public JDBCUtil() {
		
	}
	//加载驱动
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//加载驱动Driver
	}
	//连接数据库
	public Connection getConnection(){//建立连接
		try {
			connection=DriverManager.getConnection(url,name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public int executeUpdate(String sql,Object[] params) {//更新函数，SQL语句关键部分可以不写，在params里面写
		int affectedLine=0;//受影响行数
		connection=getConnection();
		try {
			preparedStatement=connection.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				preparedStatement.setObject(i+1, params[i]);//索引从1开始，所以参数为i+1
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
			rsmd=rs.getMetaData();//取rs中的列
			columnCount=rsmd.getColumnCount();//取列的数目
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<HashMap> list=new ArrayList<>();
		try {
			while(rs.next()) {//一行一行读
				HashMap<String, Object> map=new HashMap<>();//放到HashMap存储
				for(int i=1;i<=columnCount;i++) {
					map.put(rsmd.getColumnLabel(i), rs.getObject(i));//一列一列的读
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
	private void CloseAll() {//关闭所有打开文件
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
