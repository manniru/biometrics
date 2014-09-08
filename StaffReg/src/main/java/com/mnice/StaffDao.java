package com.mnice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDao {
	String dbname = "JavaDB";
	String dbuser = "admin";
	String dbpass = "admin";
	
	public Connection cn() {
		Connection con = null;
		try { //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nfcserver", "root", "13131");
			con = DriverManager.getConnection("jdbc:derby:" + dbname + ";create=true", dbuser, dbpass);
			System.out.println("Connected!");
			} catch(Exception e) { System.out.println(e); }
			return con;
	}
	
	public void create(String table) {
		try {
			cn().createStatement().execute("drop table "+table); } catch(Exception e1) { }
		try {
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
		
		cn().createStatement().execute(sql);
			System.out.println("Table  Created");
		} catch (SQLException e) {System.out.println(e); }
	}
	
	public Staff load(int id) {
		String username = "auwal";
		String password = "12345";
		String mobileno = "601123049948";
		String email = "auwal@gmal.com";
		String fullname = "Auwal Muhammad";
		String designation = "Software Engineer";
		String gender = "Male";
		String dob = "1980-05-03";
		String address = "Sri Petaling";
		String companyno = "123456";
		String datereg = "2014-09-05";
		
		Staff staff = new Staff();
		staff.setUsername(username);
		staff.setPassword(password);
		staff.setMobileno(mobileno);
		staff.setEmail(email);
		staff.setFullname(fullname);
		staff.setDesignation(designation);
		staff.setGender(gender);
		staff.setDob(dob);
		staff.setAddress(address);
		staff.setCompanyno(companyno);
		staff.setDatereg(datereg);
		
		return staff;
	}
		
	public void addStaff(Staff staff) {
		/**
		String username = staff.getUsername();
		String password = staff.getPassword();
		String mobileno = staff.getMobileno();
		String email = staff.getEmail();
		String fullname = staff.getFullname();
		String designation = staff.getDesignation();
		String gender = staff.getGender();
		String dob = staff.getDob();
		String address = staff.getAddress();
		String datereg = staff.getDatereg();
		*/
		try {
			//String sql = "";
			//cn().createStatement().execute("INSERT INTO ADMIN.STAFF (USERNAME, PASSWORD, MOBILENO, EMAIL, FULLNAME, DESIGNATION, GENDER, DOB, ADDRESS, COMPANYNO, DATEREG) "
			//		+ "VALUES ('auwal', 'auwal', '60299393849', 'auwal@gmail.com', 'Auwal Ibrahim', 'Programmer', 'Male', '1980-12-30', 'Bukit Jalil', '12203', '2014-05-09')");
			
			
			PreparedStatement ps = cn().prepareStatement("INSERT INTO ADMIN.STAFF(USERNAME, PASSWORD, MOBILENO, EMAIL, FULLNAME, "
					+ "DESIGNATION, GENDER, DOB, ADDRESS, COMPANYNO, DATEREG) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, staff.getUsername());
			ps.setString(2, staff.getPassword());
			ps.setString(3, staff.getMobileno());
			ps.setString(4, staff.getEmail());
			ps.setString(5, staff.getFullname());
			ps.setString(6, staff.getDesignation());
			ps.setString(7, staff.getGender());
			ps.setString(8, staff.getDob());
			ps.setString(9, staff.getAddress());
			ps.setString(10, staff.getCompanyno());
			ps.setString(11, staff.getDatereg());
			System.out.println("value="+staff.getFullname());
			ps.executeUpdate();
			System.out.println("Record Saved!");
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public Staff getStaff(int id) {
		Staff staff = new Staff();
		try {
			ResultSet rs = cn().createStatement().executeQuery("SELECT * FROM ADMIN.STAFF WHERE id="+id); rs.next();
			int id2 = Integer.parseInt(rs.getString("id"));
			String username = rs.getString("username");
			String password = rs.getString("password");
			String mobileno = rs.getString("mobileno");
			String email = rs.getString("email");
			String fullname = rs.getString("fullname");
			String designation = rs.getString("designation");
			String gender = rs.getString("gender");
			String dob = rs.getString("dob");
			String address = rs.getString("address");
			String companyno = rs.getString("companyno");
			String datereg = rs.getString("datereg");
			
			staff.setId(id2);
			staff.setUsername(username);
			staff.setPassword(password);
			staff.setMobileno(mobileno);
			staff.setEmail(email);
			staff.setFullname(fullname);
			staff.setDesignation(designation);
			staff.setGender(gender);
			staff.setDob(dob);
			staff.setAddress(address);
			staff.setDatereg(datereg);
		} catch(Exception e) { System.out.println(e); }
		
		return staff;

	}
	
	public void updateStaff(Staff staff) {
		try {
			PreparedStatement ps = cn().prepareStatement("UPDATE ADMIN.STAFF set "
					+ "USERNAME=?,"
					+ "PASSWORD=?,"
					+ "MOBILENO=?,"
					+ "EMAIL=?,"
					+ "FULLNAME=?,"
					+ "DESIGNATION=?,"
					+ "GENDER=?,"
					+ "DOB=?,"
					+ "ADDRESS=?,"
					+ "COMPANYNO=?,"
					+ "DATEREG=? where ID=?");
			ps.setString(1, staff.getUsername());
			ps.setString(2, staff.getPassword());
			ps.setString(3, staff.getMobileno());
			ps.setString(4, staff.getEmail());
			ps.setString(5, staff.getFullname());
			ps.setString(6, staff.getDesignation());
			ps.setString(7, staff.getGender());
			ps.setString(8, staff.getDob());
			ps.setString(9, staff.getAddress());
			ps.setString(10, staff.getCompanyno());
			ps.setString(11, staff.getDatereg());
			ps.setInt(12, staff.getId());
			ps.executeUpdate();
			System.out.println("Record Updated!");
		} catch(Exception e) { System.out.println(e); }
	}
	
	public List getAllStaff() {
		List list = new ArrayList();
		
		return list;
	}

}
