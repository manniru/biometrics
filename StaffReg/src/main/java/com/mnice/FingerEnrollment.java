package com.mnice;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JLabel;

import NffvSample.IDName;

import com.neurotechnology.Nffv.Nffv;
import com.neurotechnology.Nffv.NffvStatus;
import com.neurotechnology.Nffv.NffvUser;
import com.neurotechnology.Nffv.ScannerModule;

public class FingerEnrollment {

	private JFrame frame;
	private JButton f1;
	private JButton f2;
	private JButton f3;
	private JButton f4;
	private JButton f5;
	private JButton f7;
	private JButton f8;
	private JButton f9;
	private JButton f10;
	private JButton f6;
	private JLabel img;
	
	Nffv engine;
	NffvUser curruser;
	static final int TIMEOUT = 10000;
	DefaultListModel usersmodel;
	String database;
	private JButton btnBackToMain;
	
	ScannerModule[] scanners;
	String dbname = "fingersdb";
	String dbpass = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FingerEnrollment window = new FingerEnrollment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FingerEnrollment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		f1 = new JButton("New button");
		f1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scanners = Nffv.getAvailableScannerModules();

				engine = new Nffv(dbname, dbpass, scanners);
				
				String name = JOptionPane.showInputDialog(null,new JLabel("Enter name"),"Enter user name");
				if(name == null) return;
				
				try{
					curruser = engine.enroll(TIMEOUT);
					System.out.println(engine.getEngineStatus());
				
					if(engine.getEngineStatus() != NffvStatus.TemplateCreated){
						JOptionPane.showMessageDialog(null, "Enroll failed - " + engine.getEngineStatus(), "Failed", JOptionPane.ERROR_MESSAGE);
						return;
					}
				
				
					img.setIcon(curruser.getNffvImage().getImageIcon());
					///ImageIcon img = curruser.getNffvImage().getImageIcon();
					
					usersmodel.addElement(new IDName(curruser.getID(),name));
					saveIDNames();
				}catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Enroll failed - " + e1.getMessage(), "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		f1.setIcon(new ImageIcon(FingerEnrollment.class.getResource("/resources/fingers.jpg")));
		f1.setBounds(10, 10, 75, 80);
		frame.getContentPane().add(f1);
		
		f2 = new JButton("New button");
		f2.setIcon(new ImageIcon(FingerEnrollment.class.getResource("/resources/fingers.jpg")));
		f2.setBounds(10, 110, 75, 80);
		frame.getContentPane().add(f2);
		
		f3 = new JButton("New button");
		f3.setIcon(new ImageIcon(FingerEnrollment.class.getResource("/resources/fingers.jpg")));
		f3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		f3.setBounds(10, 210, 75, 80);
		frame.getContentPane().add(f3);
		
		f4 = new JButton("");
		f4.setIcon(new ImageIcon(FingerEnrollment.class.getResource("/resources/fingers.jpg")));
		f4.setBounds(10, 310, 75, 80);
		frame.getContentPane().add(f4);
		
		f5 = new JButton("");
		f5.setIcon(new ImageIcon(FingerEnrollment.class.getResource("/resources/fingers.jpg")));
		f5.setBounds(10, 410, 75, 80);
		frame.getContentPane().add(f5);
		
		f6 = new JButton("");
		f6.setIcon(new ImageIcon(FingerEnrollment.class.getResource("/resources/fingers.jpg")));
		f6.setBounds(100, 11, 75, 80);
		frame.getContentPane().add(f6);
		
		f7 = new JButton("");
		f7.setIcon(new ImageIcon(FingerEnrollment.class.getResource("/resources/fingers.jpg")));
		f7.setBounds(100, 110, 75, 80);
		frame.getContentPane().add(f7);
		
		f8 = new JButton("");
		f8.setIcon(new ImageIcon(FingerEnrollment.class.getResource("/resources/fingers.jpg")));
		f8.setBounds(100, 210, 75, 80);
		frame.getContentPane().add(f8);
		
		f9 = new JButton("");
		f9.setIcon(new ImageIcon(FingerEnrollment.class.getResource("/resources/fingers.jpg")));
		f9.setBounds(100, 310, 75, 80);
		frame.getContentPane().add(f9);
		
		f10 = new JButton("");
		f10.setIcon(new ImageIcon(FingerEnrollment.class.getResource("/resources/fingers.jpg")));
		f10.setBounds(100, 410, 75, 80);
		frame.getContentPane().add(f10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(185, 10, 258, 302);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		img = new JLabel("img");
		img.setBounds(0, 0, 258, 302);
		panel.add(img);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(453, 10, 271, 426);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("New Registration");
		btnNewButton.setBounds(185, 323, 258, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton button_5 = new JButton("New Registration");
		button_5.setBounds(185, 364, 258, 30);
		frame.getContentPane().add(button_5);
		
		btnBackToMain = new JButton("Back to Main Form");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main main = new Main();
				main.main(null);
			}
		});
		btnBackToMain.setBounds(185, 407, 258, 30);
		frame.getContentPane().add(btnBackToMain);
	}
	
	public void saveIDNames(){
		File dbfile = new File(database + ".fdb");
		try{
			FileOutputStream fos = new FileOutputStream(dbfile);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			
			for (int i = 0; i < usersmodel.getSize(); i++)
				out.writeObject(usersmodel.get(i));
			
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
