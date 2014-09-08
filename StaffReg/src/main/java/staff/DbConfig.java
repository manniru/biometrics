package staff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DbConfig extends JFrame {
	static String file = "config.properties";
	private JPanel contentPane;
	private JTextField dbhosttxt;
	private JTextField dbnametxt;
	private JTextField dbusertxt;
	private JTextField dbpasstxt;
	public String dbhost = "";
	public String dbport = "";
	public String dbname = "";
	public String dbuser = "";
	public String dbpass = "";
	private JLabel lblDatabasePort;
	private JTextField dbporttxt;
	private JLabel lblEbahnIptvDatabase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DbConfig frame = new DbConfig();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DbConfig() {
		Properties prop = new Properties();
		
		try { InputStream in = new FileInputStream(file);
        prop.load(in); } catch(Exception e3) { System.out.println(e3); }
        
		dbhost = prop.getProperty("dbhost");
		dbport = prop.getProperty("dbport");
		dbname = prop.getProperty("dbname");
		dbuser = prop.getProperty("dbuser");
		dbpass = prop.getProperty("dbpass");
		
		setTitle("eBahn IPTV Database Configuration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatabaseServer = new JLabel("Database Host");
		lblDatabaseServer.setBounds(10, 60, 143, 14);
		contentPane.add(lblDatabaseServer);
		
		dbhosttxt = new JTextField();
		dbhosttxt.setText(dbhost);
		dbhosttxt.setBounds(163, 60, 86, 20);
		contentPane.add(dbhosttxt);
		dbhosttxt.setColumns(10);
		
		JLabel lblDatabaseName = new JLabel("Database Name");
		lblDatabaseName.setBounds(10, 120, 143, 14);
		contentPane.add(lblDatabaseName);
		
		JLabel lblDatabaseUsername = new JLabel("Database Username");
		lblDatabaseUsername.setBounds(10, 150, 143, 14);
		contentPane.add(lblDatabaseUsername);
		
		JLabel lblDatabasePassword = new JLabel("Database Password");
		lblDatabasePassword.setBounds(10, 180, 143, 14);
		contentPane.add(lblDatabasePassword);
		
		dbnametxt = new JTextField();
		dbnametxt.setText(dbname);
		dbnametxt.setColumns(10);
		dbnametxt.setBounds(163, 120, 86, 20);
		contentPane.add(dbnametxt);
		
		dbusertxt = new JTextField();
		dbusertxt.setText(dbuser);
		dbusertxt.setColumns(10);
		dbusertxt.setBounds(163, 150, 86, 20);
		contentPane.add(dbusertxt);
		
		dbpasstxt = new JTextField();
		dbpasstxt.setText(dbpass);
		dbpasstxt.setColumns(10);
		dbpasstxt.setBounds(163, 180, 86, 20);
		contentPane.add(dbpasstxt);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dbhost = dbhosttxt.getText();
				String dbport = dbporttxt.getText();
				String dbname = dbnametxt.getText();
				String dbuser = dbusertxt.getText();
				String dbpass = dbpasstxt.getText();
				
				try {
					PrintWriter writer = new PrintWriter(file, "UTF-8");
					writer.println("#eBahn IPTV Properties");
					writer.println("dbhost="+dbhost);
					writer.println("dbport="+dbport);
					writer.println("dbname="+dbname);
					writer.println("dbuser="+dbuser);
					writer.println("dbpass="+dbpass);
					writer.close();
					} catch(Exception e2) { System.out.println(e2); }
				
				dispose();
				
				//frmEbahnIptvMiddleware.setVisible(false);
				//DbConfig dbconfig = new DbConfig();
				//dbconfig.setVisible(true);
				
				//Main main = new Main();
				//main.main(null);
			}
		});
		btnNewButton.setBounds(160, 214, 89, 23);
		contentPane.add(btnNewButton);
		
		lblDatabasePort = new JLabel("Database Port");
		lblDatabasePort.setBounds(10, 90, 143, 14);
		contentPane.add(lblDatabasePort);
		
		dbporttxt = new JTextField();
		dbporttxt.setText(dbport);
		dbporttxt.setColumns(10);
		dbporttxt.setBounds(163, 90, 86, 20);
		contentPane.add(dbporttxt);
		
		lblEbahnIptvDatabase = new JLabel("eBahn IPTV Database Settings");
		lblEbahnIptvDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblEbahnIptvDatabase.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEbahnIptvDatabase.setBounds(10, 11, 309, 23);
		contentPane.add(lblEbahnIptvDatabase);
	}
}
