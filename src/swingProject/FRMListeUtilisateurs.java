package swingProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FRMListeUtilisateurs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableUtlisateur;
	FRMAdmin frmAdmin;
	Authentification authentification;
	
	JButton supprimerButton;
	JButton retourButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMListeUtilisateurs frame = new FRMListeUtilisateurs();
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
	public FRMListeUtilisateurs() {
		setTitle("Liste des Utilisateurs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 11, 140, 187);
		contentPane.add(scrollPane);
		
		tableUtlisateur = new JTable();
		scrollPane.setViewportView(tableUtlisateur);
		tableUtlisateur.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				supprimerButton.setEnabled(true);
				
			}
		});
		
		authentification = new Authentification();
		try {
			authentification.getAllUsers(tableUtlisateur);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		supprimerButton = new JButton("Supprimer");
		supprimerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				authentification = new Authentification();
				try {
					authentification.supprmierUtilisateur(tableUtlisateur);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}

			}
		});
		supprimerButton.setEnabled(false);
		supprimerButton.setBounds(110, 214, 100, 33);
		contentPane.add(supprimerButton);
		
		retourButton = new JButton("Retour");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frmAdmin = new FRMAdmin();
				frmAdmin.setVisible(true);
			}
		});
		retourButton.setBounds(220, 214, 100, 33);
		contentPane.add(retourButton);
		
		
	}
}
