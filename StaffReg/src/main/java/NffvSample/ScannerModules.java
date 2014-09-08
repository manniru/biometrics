package NffvSample;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.neurotechnology.Nffv.Nffv;
import com.neurotechnology.Nffv.ScannerModule;

public class ScannerModules extends JPanel implements ActionListener {
	
	JButton load;
	ScannerModule[] scanners;
	JCheckBox[] selections;
	String dbname = "fingersdb";
	String dbpass = "";
	
	PanelContainer owner;
	
	public ScannerModules(PanelContainer owner){
		
		this.owner = owner;
		
		scanners = Nffv.getAvailableScannerModules();
		//selections = new JCheckBox[scanners.length];
		JPanel selectionpan = new JPanel();
		
		/**
		selectionpan.setLayout(new GridLayout(scanners.length / 3 + 1, 3));
		selectionpan.setPreferredSize(new Dimension(450, 23 * (scanners.length / 3 + 3)));
		selectionpan.setMaximumSize(new Dimension(450, 23 * (scanners.length / 3 + 3)));
		
		for (int i = 0; i < scanners.length; i++) {
			selections[i] = new JCheckBox(scanners[i].getName());
			//System.out.println(i+"=="+scanners[i].getName());
			selectionpan.add(selections[i]);
		}
		*/
		load = new JButton("Load");
		//database = new JTextField();
		//password = new JPasswordField();
		load.addActionListener(this);
		
		//setLayout(new BorderLayout());
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel bottompan = new JPanel();
		bottompan.setLayout(new GridLayout(1,2));
		//JPanel dbpasspan = new JPanel();
		//dbpasspan.setLayout(new GridLayout(2,2));
		
		//dbpasspan.add(new JLabel("Database"));
		//dbpasspan.add(database);
		//dbpasspan.add(new JLabel("Password"));
		//dbpasspan.add(password);
		
		//bottompan.add(dbpasspan);
		bottompan.add(load);
		bottompan.setPreferredSize(new Dimension(400, 45));
		bottompan.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
		
		add(selectionpan);
		add(bottompan);
		add(Box.createGlue());
	}

	public void actionPerformed(ActionEvent arg0) {
		
		//int count = 0;
		
		//for (JCheckBox selection : selections) 
			//if (selection.isSelected()) count++;
		
		/**
		count = 0;
		for(int i = 0; i < selections.length; i++)
			if (selections[i].isSelected()){
				scanners[count] = this.scanners[i];
				System.out.println(i+"==="+this.scanners[i]);
				count++;
			}
		*/
		
		ScannerModule[] scanners = new ScannerModule[3];
		scanners[0] = this.scanners[25];
		scanners[1] = this.scanners[26];
		scanners[2] = this.scanners[27];
		owner.setPanel(new MainPanel(scanners, dbname, dbpass));
		System.out.println("Scanner modules loading done");
	}
}
