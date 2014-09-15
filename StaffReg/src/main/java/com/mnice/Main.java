package com.mnice;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.UIManager;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.ItemSelectable;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JMenuItem;




///import staff.DbConfig;
//import staff.Db;
import NffvSample.NffvApplication;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import javax.swing.border.TitledBorder;



public class Main {
	private TableRowSorter<MyTableModel> sorter;
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
	private JTextField filterText;
	private JTextField dateregtxt;
	private JTextArea addresstxt;
	private JComboBox gendercmb;
	//private Connection cn;
	private JTable table;
	private JPanel panel;
	Webcam webcam;
	private JLabel label;
	int columnfilter = 0;
	private JComboBox filtercmb;

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
				String coyno = compnantxt.getText().toString();
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			    chooser.setFileFilter(filter);
			    //chooser.setCurrentDirectory(dir);
			    int returnVal = chooser.showOpenDialog(frmStaffRegistration);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	File file = chooser.getSelectedFile();
			    	String src = file.getPath();
			    	//String dest = "D:\\git\\biometrics\\StaffReg\\photos\\baby.jpg";
			    	String loc = "photos/"+coyno+".jpg";
			    	File dest = new File(loc);
			    	try{
			    		 
			    		BufferedImage originalImage = ImageIO.read(file);
			    		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			     
			    		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
			    		ImageIO.write(resizeImageJpg, "jpg", dest); 

			     
			    	}catch(IOException e2){
			    		System.out.println(e2.getMessage());
			    	}
			     
			    	

			    	
			    	label.setIcon(new ImageIcon(loc));
			    	///label.setIcon(new ImageIcon(Main.class.getResource("/resources/fingers.jpg")));
			       System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			    }
			}
		});
		btnNewButton.setBounds(661, 210, 152, 23);
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
		btnNewButton_1.setBounds(661, 266, 152, 32);
		frmStaffRegistration.getContentPane().add(btnNewButton_1);
		
		JLabel lblEarchBy = new JLabel("Search By:");
		lblEarchBy.setBounds(10, 397, 107, 14);
		frmStaffRegistration.getContentPane().add(lblEarchBy);
		
		filtercmb = new JComboBox();
		filtercmb.setModel(new DefaultComboBoxModel(new String[] {"id", "companyno", "fullname", "gender", "phoneno", "designation", "address"}));
		filtercmb.setBounds(127, 397, 134, 23);
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		        int state = itemEvent.getStateChange();
		       // System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
		        //System.out.println("Item: " + itemEvent.getItem());
		        ItemSelectable is = itemEvent.getItemSelectable();
		        //System.out.println(", Selected: " + is);
		        
		        columnfilter = filtercmb.getSelectedIndex();
		        
		      }
		    };
		    filtercmb.addItemListener(itemListener);
		    
		frmStaffRegistration.getContentPane().add(filtercmb);
		
		filterText = new JTextField();
		filterText.setBounds(337, 397, 146, 23);
		filterText.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });
		/**
		filterText.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    //warn();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    //warn();
			  }
			  public void insertUpdate(DocumentEvent e) {
				  String search = filterText.getText().toString();
				  System.out.println(search);
			   // warn();
			  }

			  public void warn() {
			     if (Integer.parseInt(filterText.getText())<=0){
			       JOptionPane.showMessageDialog(null,
			          "Error: Please enter number bigger than 0", "Error Massage",
			          JOptionPane.ERROR_MESSAGE);
			     }
			  }
			});
		 */
		frmStaffRegistration.getContentPane().add(filterText);
		filterText.setColumns(10);
		
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
		
		MyTableModel model = new MyTableModel();
        sorter = new TableRowSorter<MyTableModel>(model);
        table = new JTable(model);
        table.setRowSorter(sorter);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //For the purposes of this example, better to have a single
        //selection.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Db db = new Db("mysql" ,"localhost","staffdb", "admin", "admin");
		//cn = db.connect("mysql" ,"localhost","staffdb", "admin", "admin");
		//String[] fields = {"id","name","age"};
		//db.create("staff",fields);
		
		Object[][] oo = db.getData("staff");
		//System.out.println(oo.length);
		/**
		table.setModel(new DefaultTableModel(oo,
			new String[] { "ID", "Company No","Fullname", "Gender","Phone No","Designation", "Address" }
		));
		*/
		
		
		/**
		table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        int viewRow = table.getSelectedRow();
                        if (viewRow < 0) {
                            //Selection got filtered away.
                           // statusText.setText("");
                        } else {
                            int modelRow = 
                                table.convertRowIndexToModel(viewRow);
                            String st = String.format("Selected Row in view: %d. " +"Selected Row in model: %d.",viewRow, modelRow);
                            System.out.println(st);
                        }
                    }
                }
        );
		*/
		
		
		
		
		
		
		
		
		scrollPane.setViewportView(table);
		
		//panel = new JPanel();
		webcam = Webcam.getDefault();
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Employee Photo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(661, 11, 152, 192);
		frmStaffRegistration.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(10, 22, 132, 159);
		panel_1.add(label);
		label.setIcon(new ImageIcon("photos/photo.jpg"));
		
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
	
	private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath());
		}
	
	private static BufferedImage resizeImage(BufferedImage originalImage, int type){
		BufferedImage resizedImage = new BufferedImage(150, 170, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, 150, 170, null);
		g.dispose();
	 
		return resizedImage;
	    }
	
	private void newFilter() {
        RowFilter<MyTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try { rf = RowFilter.regexFilter(filterText.getText(), columnfilter);
        } catch (java.util.regex.PatternSyntaxException e) { return; }
        sorter.setRowFilter(rf);
    }
	
	class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"ID", "Fullname", "Company No","Designaton","Contact No", "Email", "Date Register"};
        
        Object[][] data = db.getData("staff");
       
        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }


        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
        	System.out.println(row+"=="+col+"=="+value);

        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }

}
