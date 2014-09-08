package staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Db {
	String dbtype, dbhost, dbuser, dbpass, dbname;
	static Connection cn;

	public static void main(String[] args) {
		Db db = new Db("mysql" ,"localhost","staffdb", "admin", "admin");
		cn = db.connect("mysql" ,"localhost","staffdb", "admin", "admin");
		//String[] fields = {"id","name","age"};
		//db.create("staff",fields);
		
		Object[][] oo = db.getData("staff");
		System.out.println(oo.length);

	}

	public Db(String dbtype, String dbhost, String dbname, String dbuser, String dbpass) {
		if (dbtype.equals("mysql")) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				cn = DriverManager.getConnection("jdbc:mysql://" + dbhost + "/"
						+ dbname, dbuser, dbpass);
				if (!cn.isClosed())
					System.out.println("connected to Mysql");
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		else if (dbtype.equals("javadb")) {
			try{ Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); }catch(Exception e){ System.out.println(e); } 
			 try{ cn = DriverManager.getConnection("jdbc:derby:"+dbname+";create=true;user=admin;password=13131");
			 }catch(SQLException e){System.out.println(e); }

		}
		else if (dbtype.equals("sqlite")) {
			try {
				Class.forName("org.sqlite.JDBC");
				cn = DriverManager.getConnection("jdbc:sqlite:housenumsys.db");
				System.out.println("Sqlite database successfully connected!");

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
	
	public Connection connect(String dbtype, String dbhost, String dbname, String dbuser, String dbpass) {
		if (dbtype.equals("mysql")) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				cn = DriverManager.getConnection("jdbc:mysql://" + dbhost + "/"
						+ dbname, dbuser, dbpass);
				if (!cn.isClosed())
					System.out.println("connected to Mysql");
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		else if (dbtype.equals("javadb")) {
			try{ Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); }catch(Exception e){ System.out.println(e); } 
			 try{ cn = DriverManager.getConnection("jdbc:derby:"+dbname+";create=true;user=admin;password=13131");
			 }catch(SQLException e){System.out.println(e); }

		}
		else if (dbtype.equals("sqlite")) {
			try {
				Class.forName("org.sqlite.JDBC");
				cn = DriverManager.getConnection("jdbc:sqlite:housenumsys.db");
				System.out.println("Sqlite database successfully connected!");

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return cn;

	}
	public void create(String table, String[] fields) {
		Connection c = null;
	    Statement st = null;
	    try {

	      st = cn.createStatement();
	      String sql = "CREATE TABLE STAFF " +
	                   "(ID INT PRIMARY KEY     NOT NULL," +
	                   " NAME           TEXT    NOT NULL, " + 
	                   " AGE            INT     NOT NULL, " + 
	                   " ADDRESS        CHAR(50), " + 
	                   " SALARY         REAL)";
	      
	      String sql1 = "CREATE TABLE STAFF"+
	    		  "(id INT,"+
	    		  "name TEXT,"+
	    		  "companyno TEXT,"+
	    		  "designation TEXT,"+
	    		  "contact TEXT,"+
	    		  "gender TEXT,"+
	    		  "dob TEXT,"+
	    		  "email TEXT,"+
	    		  "address TEXT,"+
	    		  "dateregister TEXT)";
	      
	      String sql2 = "CREATE TABLE ADMIN.STAFF"+
	    		  "(id INT,"+
	    		  "name TEXT,"+
	    		  "companyno TEXT,"+
	    		  "designation TEXT,"+
	    		  "contact TEXT,"+
	    		  "gender TEXT,"+
	    		  "dob TEXT,"+
	    		  "email TEXT,"+
	    		  "address TEXT,"+
	    		  "dateregister TEXT)";
	      
	      String sql3 = "CREATE TABLE STAFF"+
	    		  "(id INT,"+
	    		  "name TEXT,"+
	    		  "companyno TEXT,"+
	    		  "designation TEXT,"+
	    		  "contact TEXT,"+
	    		  "gender TEXT,"+
	    		  "dob TEXT,"+
	    		  "email TEXT,"+
	    		  "address TEXT,"+
	    		  "dateregister TEXT)";
	      
	      String sql4 = "CREATE TABLE STAFF"+
	    		  "(id INT,"+
	    		  "name TEXT,"+
	    		  "companyno TEXT,"+
	    		  "designation TEXT,"+
	    		  "contact TEXT,"+
	    		  "gender TEXT,"+
	    		  "dob TEXT,"+
	    		  "email TEXT,"+
	    		  "address TEXT,"+
	    		  "dateregister TEXT)";
	      st.executeUpdate(sql1);
	      st.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
	}
	
	public void insert() {
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	                   "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
	      stmt.executeUpdate(sql);

	      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	            "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
	      stmt.executeUpdate(sql);

	      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	            "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
	      stmt.executeUpdate(sql);

	      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	            "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
	      stmt.executeUpdate(sql);

	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Records created successfully");
	}
	
	public void select() {
		 Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
		      while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String  name = rs.getString("name");
		         int age  = rs.getInt("age");
		         String  address = rs.getString("address");
		         float salary = rs.getFloat("salary");
		         System.out.println( "ID = " + id );
		         System.out.println( "NAME = " + name );
		         System.out.println( "AGE = " + age );
		         System.out.println( "ADDRESS = " + address );
		         System.out.println( "SALARY = " + salary );
		         System.out.println();
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully");
	}
	
	public void update() {
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
	      stmt.executeUpdate(sql);
	      c.commit();

	      ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
	      while ( rs.next() ) {
	         int id = rs.getInt("id");
	         String  name = rs.getString("name");
	         int age  = rs.getInt("age");
	         String  address = rs.getString("address");
	         float salary = rs.getFloat("salary");
	         System.out.println( "ID = " + id );
	         System.out.println( "NAME = " + name );
	         System.out.println( "AGE = " + age );
	         System.out.println( "ADDRESS = " + address );
	         System.out.println( "SALARY = " + salary );
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	}
	
	public void delete() {
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "DELETE from COMPANY where ID=2;";
	      stmt.executeUpdate(sql);
	      c.commit();

	      ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
	      while ( rs.next() ) {
	         int id = rs.getInt("id");
	         String  name = rs.getString("name");
	         int age  = rs.getInt("age");
	         String  address = rs.getString("address");
	         float salary = rs.getFloat("salary");
	         System.out.println( "ID = " + id );
	         System.out.println( "NAME = " + name );
	         System.out.println( "AGE = " + age );
	         System.out.println( "ADDRESS = " + address );
	         System.out.println( "SALARY = " + salary );
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	}

	public Object[][] getData(String tb) {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT * FROM "+tb);
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
		row = new Object[colCount];
		for (int a = 0; a < colCount; a++) {
		row[a] = r3.getObject(a + 1);
		}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("getObjects()"+e3);
		
		}
		return oo;
	}
}
