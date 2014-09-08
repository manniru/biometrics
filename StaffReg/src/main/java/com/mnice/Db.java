package com.mnice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.ResultSetMetaData;

public class Db {
	static Connection conn;
	private String framework = "embedded";
	private String protocol = "jdbc:derby:";
	String dbName = "JavaDB";
    PreparedStatement psInsert;
    PreparedStatement psUpdate;
    Statement s;
    ResultSet rs = null;
   

	public static void main(String[] args) {
		Db db = new Db();
		Connection cn = db.connect("javadb" ,"localhost","staffdb", "admin", "admin");
		///db.create("STAFF");
		
		//Staff st = new Staff();
		//Staff staff = st.load(1);
		//System.out.println(staff.getName());
		//Staff st = staff.load(1);
				
		//db.insert(staff);

	}
	
	public Db() {
		/**
		Properties props = new Properties();
		props.put("user", "admin");
        props.put("password", "admin");
        try {
			conn = DriverManager.getConnection(protocol + dbName + ";create=true", props);
			System.out.println("Connected to and created database " + dbName);
		} catch (SQLException e) { System.out.println(e); }
        */
	}
	
	public Connection connect(String dbtype, String dbhost, String dbname, String dbuser, String dbpass) {
		Connection con = null;
		try { conn = DriverManager.getConnection(protocol + dbName + ";create=true", "admin","admin");
			System.out.println("Connected!");
		} catch (SQLException e) { System.out.println(e); }
		
		return con;
	}
	
	public void create(String table) {
		try { s.execute("drop table "+table); } catch(Exception e1) { }
		try { s = conn.createStatement();
		
		String sql = "CREATE TABLE ADMIN."+table+"\r\n" + 
				"(ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,\r\n" + 
				"USERNAME VARCHAR(20),\r\n" + 
				"PASSWORD VARCHAR(20),\r\n" + 
				"MOBILENO VARCHAR(20),\r\n" + 
				"EMAIL VARCHAR(50),\r\n" + 
				"FULLNAME VARCHAR(50),\r\n" + 
				"DESIGNATION VARCHAR(50),\r\n" + 
				"GENDER VARCHAR(10),\r\n" + 
				"DOB DATE,\r\n" + 
				"ADDRESS VARCHAR(50),\r\n" + 
				"COMPANYNO VARCHAR(20),\r\n" + 
				"DATEREG DATE,\r\n" + 
				"PRIMARY KEY (ID))";
		
			s.execute(sql);
			System.out.println("Table  Created");
		} catch (SQLException e) {System.out.println(e); }
	}


	/*public ArrayList<String> getStaff() {
		ArrayList<String> list = new ArrayList<String>();
		try { ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STAFF WHERE ID=?");
		while(rs.next()) {
			System.out.println(rs.getString("STAFF"));
			list.add(rs.getString("STAFF")); }
		} catch(Exception e) { System.out.println(e); }
		return list;
		
	}*/
	


}
