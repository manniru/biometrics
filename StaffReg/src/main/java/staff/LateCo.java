package staff;

import java.sql.Connection;

public class LateCo {
	int id;
	String name;
	String contact;
	String reasons;
	Connection cn;
	
	
	public void addLateCo(LateCo lateco) {
		Db db = new Db("mysql" ,"localhost","staffdb", "root", "");
		cn = db.connect("mysql" ,"localhost","staffdb", "root", "");
		name = lateco.getName();
		contact = lateco.getContact();
		reasons = lateco.getReasons();
		

		String sql = "INSERT INTO LATECO("
				+ "name,"
				+ "contact,"
				+ "reasons) VALUES('"+
				name+"','"+
				contact+"','"+
				reasons+"')";
		try { cn.createStatement().execute(sql); System.out.println("Reasons Added!");
		} catch (Exception ex) { System.err.println(ex.getMessage()); }
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getReasons() {
		return reasons;
	}
	public void setReasons(String reasons) {
		this.reasons = reasons;
	}
	


}
