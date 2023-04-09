package swingProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;

public class FRMajoutUtilisateur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newLoginTextField;
	private JPasswordField newPasswordField;
	private JLabel lblConfirmerMotDe;
	private JPasswordField confirmPasswordField;
	private JButton btnNewButton;
	Authentification authentification;
	private JButton retourButton;
	FRMAdmin frmAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMajoutUtilisateur frame = new FRMajoutUtilisateur();
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
	public FRMajoutUtilisateur() {
		setTitle("Ajouter un utlisateur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel newLoginLabel = new JLabel("Nouveau Login");
		newLoginLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newLoginLabel.setBounds(177, 22, 102, 23);
		contentPane.add(newLoginLabel);

		newLoginTextField = new JTextField();
		newLoginTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newLoginTextField.setBounds(177, 45, 102, 20);
		contentPane.add(newLoginTextField);
		newLoginTextField.setColumns(10);

		JLabel newPasswordLabel = new JLabel("Nouveau Mot de passe");
		newPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newPasswordLabel.setBounds(150, 70, 154, 23);
		contentPane.add(newPasswordLabel);

		newPasswordField = new JPasswordField();
		newPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newPasswordField.setBounds(176, 93, 102, 20);
		contentPane.add(newPasswordField);

		lblConfirmerMotDe = new JLabel("Confirmer Mot de passe");
		lblConfirmerMotDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmerMotDe.setBounds(150, 122, 154, 23);
		contentPane.add(lblConfirmerMotDe);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		confirmPasswordField.setBounds(176, 144, 102, 20);
		contentPane.add(confirmPasswordField);
		confirmPasswordField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				authentification = new Authentification();
				try {
					authentification.ajoutUser(newLoginTextField, newPasswordField, confirmPasswordField);

					newLoginTextField.setText("");
					newPasswordField.setText("");
					confirmPasswordField.setText("");

				} catch (SQLException e1) {
					if (e1 instanceof SQLIntegrityConstraintViolationException) {
						JOptionPane.showMessageDialog(null, "Utilisateur existe déjà");
						newLoginTextField.setText("");
						newPasswordField.setText("");
						confirmPasswordField.setText("");
						e1.printStackTrace();
					}
				}
			}
		});

		btnNewButton = new JButton("Ajouter Utilisateur");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				authentification = new Authentification();
				try {
					authentification.ajoutUser(newLoginTextField, newPasswordField, confirmPasswordField);

					newLoginTextField.setText("");
					newPasswordField.setText("");
					confirmPasswordField.setText("");
					newLoginTextField.setFocusable(true);

				} catch (SQLException e1) {
					if (e1 instanceof SQLIntegrityConstraintViolationException) {
						JOptionPane.showMessageDialog(null, "Utilisateur existe déjà");
						newLoginTextField.setText("");
						newPasswordField.setText("");
						confirmPasswordField.setText("");
						newLoginTextField.setFocusable(true);
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(165, 175, 135, 32);
		contentPane.add(btnNewButton);

		retourButton = new JButton("Retour");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frmAdmin = new FRMAdmin();
				frmAdmin.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		retourButton.setBounds(165, 218, 135, 32);
		contentPane.add(retourButton);
	}
}
