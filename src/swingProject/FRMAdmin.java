package swingProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FRMAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	FRMajoutUtilisateur ajoutUtilisateur;
	FRMListeUtilisateurs listeUtilisateur;
	FRMInterfacePrincipale accueil ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMAdmin frame = new FRMAdmin();
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
	public FRMAdmin() {
		setTitle("Gestion des employés - Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton ajoutUtilisateurButton = new JButton("Ajouter utlisateur");
		ajoutUtilisateurButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ajoutUtilisateur = new FRMajoutUtilisateur();
				ajoutUtilisateur.setVisible(true);
				
			}
		});
		ajoutUtilisateurButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ajoutUtilisateurButton.setBounds(158, 48, 144, 35);
		contentPane.add(ajoutUtilisateurButton);
		ajoutUtilisateurButton.setFocusable(false);


		JButton ConsulterUtilisateurButton = new JButton("<html>Consulter la liste <br  />   des utlisateurs</html>");
		ConsulterUtilisateurButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				listeUtilisateur = new FRMListeUtilisateurs();
				listeUtilisateur.setVisible(true);
			}
		});
		ConsulterUtilisateurButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ConsulterUtilisateurButton.setBounds(158, 104, 144, 46);
		contentPane.add(ConsulterUtilisateurButton);
		ConsulterUtilisateurButton.setFocusable(false);
		
		JButton btnAccueil = new JButton("Accueil");
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				accueil = new FRMInterfacePrincipale();
				accueil.setVisible(true);
			}
		});
		btnAccueil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAccueil.setFocusable(false);
		btnAccueil.setBounds(158, 202, 144, 35);
		contentPane.add(btnAccueil);

	}

}
