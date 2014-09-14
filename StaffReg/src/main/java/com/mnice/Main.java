package com.mnice;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JToolBar;








import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JMenuItem;



///import staff.DbConfig;
//import staff.Db;
import NffvSample.NffvApplication;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;



public class Main {	
	//Db db = new Db();
	//Connection cn = db.connect("mysql");
	Db db = new Db();
	Connection cn = db.connect("javadb" ,"localhost","staffdb", "admin", "admin");
	private JFrame frmStaffRegistration;
	private JTextField fullnametxt;
	private JTextField compnantxt;
	private JTextField designationtxt;
	private JTextField contacttxt;
	private JTextField dobtxt;
	private JTextField emailtxt;
	private JTextField textField_6;
	private JTextField dateregtxt;
	private JTextArea addresstxt;
	private JComboBox gendercmb;
	//private Connection cn;
	private JTable table;
	private JPanel panel;
	private WebcamPanel panel_1;
	Webcam webcam;
	private JPanel panel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmStaffRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStaffRegistration = new JFrame();
		frmStaffRegistration.setTitle("Staff Registration");
		frmStaffRegistration.setBounds(100, 100, 882, 724);
		frmStaffRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStaffRegistration.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Full Name:");
		lblName.setBounds(10, 11, 132, 14);
		frmStaffRegistration.getContentPane().add(lblName);
		
		fullnametxt = new JTextField();
		fullnametxt.setBounds(152, 11, 223, 20);
		frmStaffRegistration.getContentPane().add(fullnametxt);
		fullnametxt.setColumns(10);
		
		JLabel lblCompanyNo = new JLabel("Company No:");
		lblCompanyNo.setBounds(10, 42, 132, 14);
		frmStaffRegistration.getContentPane().add(lblCompanyNo);
		
		compnantxt = new JTextField();
		compnantxt.setBounds(152, 42, 223, 20);
		frmStaffRegistration.getContentPane().add(compnantxt);
		compnantxt.setColumns(10);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setBounds(10, 67, 132, 14);
		frmStaffRegistration.getContentPane().add(lblDesignation);
		
		designationtxt = new JTextField();
		designationtxt.setBounds(152, 70, 223, 20);
		frmStaffRegistration.getContentPane().add(designationtxt);
		designationtxt.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setBounds(10, 103, 132, 14);
		frmStaffRegistration.getContentPane().add(lblContactNo);
		
		contacttxt = new JTextField();
		contacttxt.setBounds(152, 101, 223, 20);
		frmStaffRegistration.getContentPane().add(contacttxt);
		contacttxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Gender:");
		lblNewLabel.setBounds(10, 128, 132, 14);
		frmStaffRegistration.getContentPane().add(lblNewLabel);
		
		gendercmb = new JComboBox();
		gendercmb.setBounds(152, 131, 223, 20);
		gendercmb.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		frmStaffRegistration.getContentPane().add(gendercmb);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(10, 164, 132, 14);
		frmStaffRegistration.getContentPane().add(lblDateOfBirth);
		
		dobtxt = new JTextField();
		dobtxt.setBounds(152, 162, 223, 20);
		frmStaffRegistration.getContentPane().add(dobtxt);
		dobtxt.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 189, 132, 14);
		frmStaffRegistration.getContentPane().add(lblEmail);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(152, 186, 223, 20);
		frmStaffRegistration.getContentPane().add(emailtxt);
		emailtxt.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 214, 132, 14);
		frmStaffRegistration.getContentPane().add(lblAddress);
		
		addresstxt = new JTextArea();
		addresstxt.setBounds(152, 209, 223, 109);
		frmStaffRegistration.getContentPane().add(addresstxt);
		
		JButton btnNewButton = new JButton("Take/Upload photo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				BufferedImage image = webcam.getImage();

				// save image to PNG file
				try {
					ImageIO.write(image, "PNG", new File("photos/test.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
panel_1.setVisible(false);

JLabel label = new JLabel("", new ImageIcon("photos/test.png"), JLabel.CENTER);

//JPanel panel = new JPanel(new BorderLayout());
panel2.add( label, BorderLayout.CENTER );

frmStaffRegistration.getContentPane().add(panel2);

		*/

			}
		});
		btnNewButton.setBounds(679, 210, 123, 23);
		frmStaffRegistration.getContentPane().add(btnNewButton);
		
		JButton btnSaveRecord = new JButton("Save Record");
		btnSaveRecord.setBounds(10, 349, 109, 23);
		btnSaveRecord.addActionListener(new ActionListener() {
			private Connection cn;

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frmStaffRegistration.getContentPane().add(btnSaveRecord);
		
		JButton btnPrintForm = new JButton("Print Form");
		btnPrintForm.setBounds(209, 349, 89, 23);
		frmStaffRegistration.getContentPane().add(btnPrintForm);
		
		JButton btnNewButton_1 = new JButton("Analyse Finger Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStaffRegistration.setVisible(false);
				FingerEnrollment finger = new FingerEnrollment();
				finger.main(null);
			}
		});
		btnNewButton_1.setBounds(679, 266, 134, 57);
		frmStaffRegistration.getContentPane().add(btnNewButton_1);
		
		JLabel lblEarchBy = new JLabel("Search By:");
		lblEarchBy.setBounds(10, 397, 107, 14);
		frmStaffRegistration.getContentPane().add(lblEarchBy);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(127, 397, 134, 23);
		frmStaffRegistration.getContentPane().add(comboBox_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(337, 397, 146, 23);
		frmStaffRegistration.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(497, 397, 89, 23);
		frmStaffRegistration.getContentPane().add(btnSearch);
		
		///Object[][] data = db.getData("staff");
		
		//table.setModel(new DefaultTableModel(data,new String[] {"ID", "Fullname", "Company No","Designaton","Contact No", "Email", "Date Register"}));
		
		JLabel lblDateOfRegister = new JLabel("Date of Register");
		lblDateOfRegister.setBounds(401, 11, 173, 14);
		frmStaffRegistration.getContentPane().add(lblDateOfRegister);
		
		
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	    String cdate = ft.format(dNow);

	      
		dateregtxt = new JTextField();
		dateregtxt.setBounds(401, 39, 200, 20);
		dateregtxt.setText(cdate);
		frmStaffRegistration.getContentPane().add(dateregtxt);
		dateregtxt.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 431, 846, 223);
		frmStaffRegistration.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		//Db db = new Db("mysql" ,"localhost","staffdb", "admin", "admin");
		//cn = db.connect("mysql" ,"localhost","staffdb", "admin", "admin");
		//String[] fields = {"id","name","age"};
		//db.create("staff",fields);
		
		Object[][] oo = db.getData("staff");
		//System.out.println(oo.length);
		
		table.setModel(new DefaultTableModel(oo,
			new String[] {
				"ID", "Staff Name"
			}
		));
		scrollPane.setViewportView(table);
		
		//panel = new JPanel();
		webcam = Webcam.getDefault();

		panel_1 = new WebcamPanel(webcam);
		panel_1.setFillArea(true);
		panel_1.setBounds(678, 11, 135, 167);
		frmStaffRegistration.getContentPane().add(panel_1);
		
		panel2 = new JPanel();
		panel_1.add(panel2);
		
		JButton btnFingerPrint = new JButton("Finger Print");
		btnFingerPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullname = fullnametxt.getText();
				String companyno = compnantxt.getText();
				String designation = designationtxt.getText();
				String mobileno = contacttxt.getText();
				String gender = gendercmb.getSelectedItem().toString();
				String dob = dobtxt.getText();
				String email = emailtxt.getText();
				String address = addresstxt.getText();
				String datereg = dateregtxt.getText();
				
				Staff staff = new Staff();
				staff.setFullname(fullname);
				staff.setCompanyno(companyno);
				staff.setDesignation(designation);
				staff.setMobileno(mobileno);
				staff.setGender(gender);
				staff.setDob(dob);
				staff.setEmail(email);
				staff.setAddress(address);
				staff.setDatereg(datereg);
				
				
				NffvApplication nffv = new NffvApplication(staff);
				nffv.main(null);
				
			}
		});
		btnFingerPrint.setBounds(401, 80, 200, 41);
		frmStaffRegistration.getContentPane().add(btnFingerPrint);
		
		JMenuBar menuBar = new JMenuBar();
		frmStaffRegistration.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenuItem mntmDbSettings = new JMenuItem("Database Settings");
		mntmDbSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frmEbahnIptvMiddleware.setVisible(false);
				///DbConfig dbconfig = new DbConfig();
				///dbconfig.setVisible(true);
			}
		});
		mnSettings.add(mntmDbSettings);
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
	}
	
	
}
