package swingProject;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FRMGestionEmploye extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	FRMListeEmployes frmListe;
	FRMajout ajoutEmploye;
	FRMInterfacePrincipale accueil;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMGestionEmploye frame = new FRMGestionEmploye();
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
	public FRMGestionEmploye() {
		
		setTitle("Gestion des employés");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton ajouterButton = new JButton("Ajouter Employé");
		ajouterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ajoutEmploye = new FRMajout();
				ajoutEmploye.setVisible(true);
				
				
			}
		});
		ajouterButton.setFocusable(false);
		ajouterButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ajouterButton.setBounds(185, 122, 160, 40);
		contentPane.add(ajouterButton);

		JButton chercherButton = new JButton("Chercher Employé");
		chercherButton.setFocusable(false);
		chercherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FRMRecherche frmRecherche = new FRMRecherche();
				frmRecherche.setVisible(true);
			}
		});
		
		
		chercherButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chercherButton.setBounds(185, 173, 160, 40);
		contentPane.add(chercherButton);

		JButton listeButton = new JButton("Liste des employés");
		listeButton.setFocusable(false);
		listeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frmListe = new FRMListeEmployes();
				frmListe.setVisible(true);
			}
		});
		listeButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listeButton.setBounds(185, 71, 160, 40);
		contentPane.add(listeButton);
		
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
		btnAccueil.setBounds(185, 294, 160, 40);
		contentPane.add(btnAccueil);
	}
}
