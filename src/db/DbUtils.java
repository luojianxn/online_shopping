package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import  java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import db.Interface.IConnectConfig;
import db.Interface.IDbUtils;



public class DbUtils implements IDbUtils{
	
	private  IConnectConfig cfg;
	private static ThreadLocal<Connection> localConn = new ThreadLocal<Connection>() ;
    	
	public static void main(String[] args){
		Connection con=new DbUtils().getConnection();
		if(con!=null)
			System.out.println("123");		
	}

	@Override
	public Connection getConnection(IConnectConfig confg) {
		Connection con=null;
		try {
			Class.forName(confg.getDriver());			
			con=DriverManager.getConnection(confg.getUrl(), confg.getUsername(),confg.getPassword());
		} catch (ClassNotFoundException e) {		
			System.out.println("加载驱动失败！");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接数据库失败");
		}	
		localConn.set(con);
		return con;		
	}

	@Override
	public Connection getConnection() {
		return cfg==null?null:getConnection(cfg) ;
	}
	public Connection getCurrentConnection(){		
		return localConn.get();		
	}
	@Override
	public void setConnectConfig(IConnectConfig cfg) {
		this.cfg=cfg;	
	}

	@Override
	public List<Map<String, Object>> getMapList(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> datas=null;		
	try{
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
		    ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] colNames = new String[count]; 
			for (int i = 1; i <= count; i++) {
				colNames[i - 1] = rsmd.getColumnName(i).toUpperCase();
			}			
			datas = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> data = new HashMap<String, Object>();
				for (int i = 0; i < colNames.length; i++) {
					data.put(colNames[i], rs.getObject(colNames[i]));
				}
				datas.add(data);
			}
	}catch(SQLException e){
		e.printStackTrace();
				
	}	
		return datas;
	}
	
}
