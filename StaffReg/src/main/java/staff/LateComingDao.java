package staff;

import java.sql.Connection;

public class LateComingDao {

	private Connection cn;

	public void addLateCo(LateCo lateco) {
		Db db = new Db("mysql" ,"localhost","staffodb", "root", "");
		cn = db.connect("mysql" ,"localhost","staffcodb", "root", "");
		String name = lateco.getName();
		String contact = lateco.getContact();
		String reasons = lateco.getReasons();
	

		String sql = "INSERT INTO LATECO("
				+ "name,"
				+ "contact,"
				+ "reasons) VALUES('"+
				name+"','"+
				contact+"','"+
				reasons+"')";
		try { cn.createStatement().execute(sql); System.out.println("Late Coming Added!");
		} catch (Exception ex) { System.err.println(ex.getMessage()); }
	}

}
