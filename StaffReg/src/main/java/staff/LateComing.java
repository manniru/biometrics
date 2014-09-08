package staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.TextArea;

public class LateComing {

	private JFrame frame;
	private TextArea reasonstxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LateComing window = new LateComing();
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
	public LateComing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblReasonsForLate = new JLabel("Reasons  For  Late Coming");
		lblReasonsForLate.setBounds(10, 133, 190, 33);
		frame.getContentPane().add(lblReasonsForLate);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(259, 252, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 45, 46, 14);
		frame.getContentPane().add(lblName);
		
		JTextField nametxt = new JTextField();
		nametxt.setBounds(145, 45, 266, 23);
		frame.getContentPane().add(nametxt);
		nametxt.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(lblContact);
		
		JTextField contacttxt = new JTextField();
		contacttxt.setBounds(145, 80, 266, 20);
		frame.getContentPane().add(contacttxt);
		contacttxt.setColumns(10);
		
		reasonstxt = new TextArea();
		reasonstxt.setBounds(145, 133, 294, 113);
		frame.getContentPane().add(reasonstxt);
	}
}
