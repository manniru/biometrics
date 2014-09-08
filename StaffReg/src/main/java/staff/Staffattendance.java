package staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Staffattendance {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staffattendance window = new Staffattendance();
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
	public Staffattendance() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 624, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 105, 145, 138);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 254, 145, 161);
		frame.getContentPane().add(panel_1);
		
		JLabel lblComeLate = new JLabel("Come late ");
		lblComeLate.setBounds(172, 139, 108, 14);
		frame.getContentPane().add(lblComeLate);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(166, 272, 84, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblTimeIn = new JLabel("Time In");
		lblTimeIn.setBounds(165, 297, 46, 14);
		frame.getContentPane().add(lblTimeIn);
		
		JLabel lblTimeOut = new JLabel("Time Out");
		lblTimeOut.setBounds(165, 352, 46, 14);
		frame.getContentPane().add(lblTimeOut);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(509, 392, 89, 23);
		frame.getContentPane().add(btnLogin);
	}

}
