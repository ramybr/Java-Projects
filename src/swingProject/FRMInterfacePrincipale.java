package swingProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FRMInterfacePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton adminButton;
	private JButton userButton;
	FRMLoginAdmin loginAdmin;
	FRMLoginUtilisateur loginUtilisateur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMInterfacePrincipale frame = new FRMInterfacePrincipale();
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
	public FRMInterfacePrincipale() {
		setTitle("Gestion des employés");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		adminButton = new JButton("Administrateur");
		adminButton.setFocusable(false);
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				loginAdmin = new FRMLoginAdmin();
				loginAdmin.setVisible(true);
			}
		});
		adminButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adminButton.setBounds(141, 74, 137, 40);
		contentPane.add(adminButton);

		userButton = new JButton("Utilisateur");
		userButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				loginUtilisateur = new FRMLoginUtilisateur();
				loginUtilisateur.setVisible(true);
			}
		});
		userButton.setFocusable(false);
		userButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userButton.setBounds(141, 137, 137, 40);
		contentPane.add(userButton);
	}
}
