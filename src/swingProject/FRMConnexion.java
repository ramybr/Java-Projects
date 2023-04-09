package swingProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class FRMConnexion extends JFrame {

	private JPanel contentPane;
	private JTextField loginTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMConnexion frame = new FRMConnexion();
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
	public FRMConnexion() {
		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginLabel_1 = new JLabel("Nom d'utilisateur");
		loginLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginLabel_1.setBounds(170, 33, 102, 22);
		contentPane.add(loginLabel_1);
		
		loginTextField = new JTextField();
		loginTextField.setBounds(146, 66, 147, 20);
		contentPane.add(loginTextField);
		loginTextField.setColumns(10);
		
		JLabel mdpLabel = new JLabel("Mot de passe");
		mdpLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mdpLabel.setBounds(186, 97, 86, 27);
		contentPane.add(mdpLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 135, 147, 20);
		contentPane.add(passwordField);
		
		JButton connexionButton = new JButton("Connexion");
		connexionButton.setBounds(183, 202, 89, 23);
		contentPane.add(connexionButton);
	}
}
