package swingProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FRMLoginUtilisateur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginTextField;
	private JPasswordField passwordField;
	FRMInterfacePrincipale principale;
	Authentification authentification;
	FRMGestionEmploye gestionEmploye;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMLoginUtilisateur frame = new FRMLoginUtilisateur();
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
	public FRMLoginUtilisateur() {
		setTitle("Gestion des employés - Connexion Utlisateur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur");
		lblUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUtilisateur.setBounds(152, 21, 110, 22);
		contentPane.add(lblUtilisateur);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginLabel.setBounds(183, 54, 50, 22);
		contentPane.add(loginLabel);
		
		loginTextField = new JTextField();
		loginTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		loginTextField.setColumns(10);
		loginTextField.setBounds(152, 76, 110, 20);
		contentPane.add(loginTextField);
		
		JLabel passwordLabel = new JLabel("Mot de passe");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(152, 107, 98, 22);
		contentPane.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				authentification = new Authentification();
				try {
					if(authentification.userAuthentification(loginTextField, passwordField)) {
					JOptionPane.showMessageDialog(null, "Connecté", "Connexion" , 3);
					dispose();
					gestionEmploye = new FRMGestionEmploye();
					gestionEmploye.setVisible(true);
					
					}else {
						JOptionPane.showMessageDialog(null, "Login et/ou Mot de passe erroné(s)", "Connexion", 3);
						loginTextField.setText("");
						passwordField.setText("");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		passwordField.setBounds(152, 129, 110, 20);
		contentPane.add(passwordField);
		
		JButton connexionButton = new JButton("Connexion");
		connexionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				authentification = new Authentification();
				try {
					if(authentification.userAuthentification(loginTextField, passwordField)) {
					JOptionPane.showMessageDialog(null, "Connecté", "Connexion" , 3);
					dispose();
					gestionEmploye = new FRMGestionEmploye();
					gestionEmploye.setVisible(true);
					
					}else {
						JOptionPane.showMessageDialog(null, "Login et/ou Mot de passe erroné(s)", "Connexion", 3);
						loginTextField.setText("");
						passwordField.setText("");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		connexionButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		connexionButton.setBounds(152, 182, 110, 23);
		contentPane.add(connexionButton);
		
		JButton retourButton = new JButton("Retour");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				principale = new FRMInterfacePrincipale();
				principale.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		retourButton.setBounds(152, 216, 110, 23);
		contentPane.add(retourButton);
	}
}
