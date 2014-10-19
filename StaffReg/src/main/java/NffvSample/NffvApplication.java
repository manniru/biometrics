package NffvSample;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mnice.Db;
import com.mnice.Staff;
import com.neurotechnology.Nffv.Nffv;
import com.neurotechnology.Nffv.ScannerModule;

public class NffvApplication extends JFrame implements PanelContainer{
	ScannerModule[] scanners;
	String dbname = "db1";
	String dbpass = "";
	
	PanelContainer owner;

	public NffvApplication(Staff staff){
		this.setTitle("Neurotechnology - Nffv Sample");
		//this.setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		///setPanel(new ScannerModules(this));
		
		this.owner = owner;
		scanners = Nffv.getAvailableScannerModules();
		ScannerModule[] scanners = new ScannerModule[3];
		scanners[0] = this.scanners[25];
		scanners[1] = this.scanners[26];
		scanners[2] = this.scanners[27];
		setPanel(new Fingers(scanners, dbname, dbpass, staff));
		System.out.println("Scanner modules loading done");
		
		
	}
	

	public void setPanel(JPanel panel){
		setContentPane(panel);
		this.setSize(panel.getPreferredSize());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Db db = new Db();
		Staff staff = db.loadStaff();
		System.out.println(staff.getFullname());
		new NffvApplication(staff);
	}

}
