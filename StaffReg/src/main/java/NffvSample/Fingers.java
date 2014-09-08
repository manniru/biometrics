package NffvSample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.neurotechnology.Nffv.Nffv;
import com.neurotechnology.Nffv.NffvStatus;
import com.neurotechnology.Nffv.NffvUser;
import com.neurotechnology.Nffv.ScannerModule;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;

public class Fingers extends JPanel implements ActionListener, ListSelectionListener{
	
	static final int TIMEOUT = 10000;
	JList users;
	DefaultListModel usersmodel;
	JButton enroll;
	JButton remove;
	JButton clearusers;
	JButton parameters;
	
	Nffv engine;
	NffvUser curruser;
	
	String database;
	private JButton f2;
	private JButton f1;
	private JButton f3;
	private JButton f4;
	private JButton f5;
	private JButton f6;
	private JButton f7;
	private JButton f8;
	private JButton f9;
	private JButton f10;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textField;

	public Fingers(ScannerModule[] scanners, String database, String password){
		System.out.println("Loading scanner modules");
		for (ScannerModule modules : scanners) {	
			System.out.println(modules.getName());
		}	
		
		this.database = database;
		
		
		engine = new Nffv(database, password, scanners);
		
		usersmodel = new DefaultListModel();
		loadIDNames();
		
		users = new JList(usersmodel);
		users.setMinimumSize(new Dimension(150,Integer.MAX_VALUE));
		users.setPreferredSize(new Dimension(150,Integer.MAX_VALUE));
		users.setMaximumSize(new Dimension(150,Integer.MAX_VALUE));
		users.setBorder(new TitledBorder("Users"));
		users.addListSelectionListener(this);
		
		enroll = new JButton("Enroll");
		remove = new JButton("Remove");
		clearusers = new JButton("Clear users");
		parameters = new JButton("Settings");
		
		enroll.addActionListener(this);
		remove.addActionListener(this);
		clearusers.addActionListener(this);
		parameters.addActionListener(this);
		
		
		JPanel buttons = new JPanel();
		buttons.setBounds(0, 0, 500, 23);
		buttons.setLayout(new BoxLayout(buttons,BoxLayout.X_AXIS));
		buttons.add(enroll);
		buttons.add(remove);
		buttons.add(clearusers);
		buttons.add(parameters);
		buttons.add(Box.createGlue());
		setLayout(null);
		//add(users, BorderLayout.EAST);
		add(buttons);
		
		setPreferredSize(new Dimension(670, 624));
		
		f2 = new JButton("New button");
		f2.setIcon(new ImageIcon(Fingers.class.getResource("/resources/fingers.jpg")));
		f2.setBounds(140, 30, 120, 150);
		add(f2);
		
		f1 = new JButton("New button");
		f1.setIcon(new ImageIcon(Fingers.class.getResource("/resources/fingers.jpg")));
		f1.setBounds(10, 30, 120, 150);
		add(f1);
		
		f3 = new JButton("New button");
		f3.setIcon(new ImageIcon(Fingers.class.getResource("/resources/fingers.jpg")));
		f3.setBounds(270, 30, 120, 150);
		add(f3);
		
		f4 = new JButton("New button");
		f4.setIcon(new ImageIcon(Fingers.class.getResource("/resources/fingers.jpg")));
		f4.setBounds(400, 30, 120, 150);
		add(f4);
		
		f5 = new JButton("New button");
		f5.setIcon(new ImageIcon(Fingers.class.getResource("/resources/fingers.jpg")));
		f5.setBounds(530, 30, 120, 150);
		add(f5);
		
		f6 = new JButton("New button");
		f6.setIcon(new ImageIcon(Fingers.class.getResource("/resources/fingers.jpg")));
		f6.setBounds(10, 190, 120, 150);
		add(f6);
		
		f7 = new JButton("New button");
		f7.setIcon(new ImageIcon(Fingers.class.getResource("/resources/fingers.jpg")));
		f7.setBounds(140, 190, 120, 150);
		add(f7);
		
		f8 = new JButton("New button");
		f8.setIcon(new ImageIcon(Fingers.class.getResource("/resources/fingers.jpg")));
		f8.setBounds(270, 190, 120, 150);
		add(f8);
		
		f9 = new JButton("New button");
		f9.setIcon(new ImageIcon(Fingers.class.getResource("/resources/fingers.jpg")));
		f9.setBounds(400, 190, 120, 150);
		add(f9);
		
		f10 = new JButton("New button");
		f10.setIcon(new ImageIcon(Fingers.class.getResource("/resources/fingers.jpg")));
		f10.setBounds(530, 191, 120, 150);
		add(f10);
		
		f1.addActionListener(this);
		f2.addActionListener(this);
		f3.addActionListener(this);
		f4.addActionListener(this);
		f5.addActionListener(this);
		f6.addActionListener(this);
		f7.addActionListener(this);
		f8.addActionListener(this);
		f9.addActionListener(this);
		f10.addActionListener(this);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Employee Photo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 369, 181, 228);
		add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Employee Information", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(208, 370, 442, 227);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(10, 23, 93, 26);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setBounds(145, 23, 200, 26);
		panel_1.add(textField);
		textField.setColumns(10);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == f1){ f1.setIcon(capture(1)); }		
		if(arg0.getSource() == f2){ f2.setIcon(capture(2)); }
		if(arg0.getSource() == f3){ f3.setIcon(capture(3)); }
		if(arg0.getSource() == f4){ f4.setIcon(capture(4)); }
		if(arg0.getSource() == f5){ f5.setIcon(capture(5)); }
		if(arg0.getSource() == f6){ f6.setIcon(capture(6)); }
		if(arg0.getSource() == f7){ f7.setIcon(capture(7)); }
		if(arg0.getSource() == f8){ f8.setIcon(capture(8)); }
		if(arg0.getSource() == f9){ f9.setIcon(capture(9)); }
		if(arg0.getSource() == f10){ f10.setIcon(capture(10)); }
		
		
		if(arg0.getSource() == enroll){
			
			String name = "user1"; // JOptionPane.showInputDialog(this,new JLabel("Enter name"),"Enter user name");
			if(name == null) return;
			
			try{
				curruser = engine.enroll(TIMEOUT);
				System.out.println(engine.getEngineStatus());
			
				if(engine.getEngineStatus() != NffvStatus.TemplateCreated){
					JOptionPane.showMessageDialog(this, "Enroll failed - " + engine.getEngineStatus(), "Failed", JOptionPane.ERROR_MESSAGE);
					return;
				}
			
			
				//img.setIcon(curruser.getNffvImage().getImageIcon());
				System.out.println("height="+curruser.getNffvImage().getHeight());
				curruser.getNffvImage().setHeight(80);
				curruser.getNffvImage().setWidth(75);
				System.out.println("height="+curruser.getNffvImage().getHeight());

				f1.setIcon(curruser.getNffvImage().getImageIcon());
				f2.setIcon(curruser.getNffvImage().getImageIcon());
				///ImageIcon img = curruser.getNffvImage().getImageIcon();
				
				usersmodel.addElement(new IDName(curruser.getID(),name));
				saveIDNames();
			}catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Enroll failed - " + e.getMessage(), "Failed", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(arg0.getSource() == remove){
			Object [] selections = users.getSelectedValues();
			for (Object object : selections) {
				engine.removeUserID(((IDName)object).getID());
				usersmodel.removeElement((IDName)object);
				users.updateUI();
				saveIDNames();
			}
		}
		
		if(arg0.getSource() == clearusers){
			engine.clearUsers();
			usersmodel.removeAllElements();
			users.updateUI();
			saveIDNames();
		}
		
		if(arg0.getSource() == parameters) new Parameters(engine);
		
	}
	
	public void loadIDNames(){
		File dbfile = new File(database + ".fdb");
		if(dbfile.exists())
		try{
			FileInputStream fis = new FileInputStream(dbfile);
			ObjectInputStream in = new ObjectInputStream(fis);
			
			for (IDName idname = (IDName)in.readObject(); idname != null; idname = (IDName)in.readObject()){
				System.out.println(idname);
				usersmodel.addElement(idname);
			}
			
			in.close();
		}catch (EOFException eof){}
		catch (Exception e) {
			e.printStackTrace();
		}
			
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
	
	public void valueChanged(ListSelectionEvent e){
		IDName selection = (IDName)users.getSelectedValue();
		if (selection == null) {
			//img.setIcon(null);
			return;
		}
		curruser = engine.getUserByID(selection.getID());
		try{
			//TODO REMOVE img.setIcon(curruser.getNffvImage().getImageIcon());
		}catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	public ImageIcon capture(int no) {
		ImageIcon imageicon = null;
		try{
			String username = "user1";
			curruser = engine.enroll(TIMEOUT);
			System.out.println(engine.getEngineStatus());
		
			if(engine.getEngineStatus() != NffvStatus.TemplateCreated){ JOptionPane.showMessageDialog(this, engine.getEngineStatus(), "Failed", JOptionPane.ERROR_MESSAGE); }
			curruser.getNffvImage().setWidth(75);
			//f2.setIcon(curruser.getNffvImage().getImageIcon());
			imageicon = curruser.getNffvImage().getImageIcon();
			usersmodel.addElement(new IDName(curruser.getID(),username));
			saveIDNames();
		}catch (Exception e) { e.printStackTrace(); JOptionPane.showMessageDialog(this, e.getMessage(), "Failed", JOptionPane.ERROR_MESSAGE); }
		
		return imageicon;
	}
}
