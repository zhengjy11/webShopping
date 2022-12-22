package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class DataProcess {
	private String url="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8"; 
	private String user="root"; 
	private String password="12345678";
	private Connection conn=null;
	private Statement stm=null;
	
	//sql璇彞涓簊elect鏌ヨ璇彞
	public Vector<Vector<String>> getData(String sql){
		Vector<Vector<String>> rows=new Vector<Vector<String>>();
		try{
			//鍔犺浇椹卞姩
			Class.forName("com.mysql.jdbc.Driver"); 
			//鑾峰彇鏁版嵁搴撹繛鎺�(浼氳瘽)
			conn=DriverManager.getConnection(url, user, password);
			//鍒涘缓Statement瀵硅薄
			stm=conn.createStatement();
			//鎵цsql璇彞锛岃繑鍥炵粨鏋滈泦
			ResultSet rst=stm.executeQuery(sql); 
			ResultSetMetaData rstd=rst.getMetaData();
			Vector<String> rowData=null;
			while(rst.next()){
				rowData=new Vector<String>();
				for (int i = 1; i <rstd.getColumnCount()+1 ; i++) {
					rowData.add(rst.getString(i));
				}
//				rowData.add(rst.getString(1));
//				rowData.add(rst.getString(2));
				rows.add(rowData);
			}
			stm.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return rows;
	}
	
	//sql璇彞涓篿nsert锛寀pdate锛宒elete
	public int update(String sql){
		int num=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
			stm=conn.createStatement();
			num=stm.executeUpdate(sql);
			stm.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return num;
	}
}
