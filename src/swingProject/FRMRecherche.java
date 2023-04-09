package swingProject;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FRMRecherche extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rechercheIdtextField;
	private JTable rechercheTable;
	private JScrollPane scrollPane;
	private JButton chercherButton;
	private JButton modifierButton;
	private JButton retourButton;
	private JButton supprimerButton;
	FRMModifier frmModifier;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMRecherche frame = new FRMRecherche();
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
	public FRMRecherche() {
		setTitle("Chercher un employé");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel rechercheIdLabel = new JLabel("Inroduire ID employé :");
		rechercheIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rechercheIdLabel.setBounds(20, 28, 168, 24);
		contentPane.add(rechercheIdLabel);
		
		rechercheIdtextField = new JTextField();
		rechercheIdLabel.setLabelFor(rechercheIdtextField);
		rechercheIdtextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rechercheIdtextField.setBounds(20, 57, 86, 20);
		contentPane.add(rechercheIdtextField);
		rechercheIdtextField.setColumns(10);
		rechercheIdtextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(true);
				int id = Integer.parseInt(rechercheIdtextField.getText());
				EmployeDAO employeDAO = new EmployeDAOImp();
				try {
					employeDAO.chercher(id, rechercheTable);
					modifierButton.setVisible(true);
				    supprimerButton.setVisible(true);
				} catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
			
		});
		
		
		chercherButton = new JButton("Chercher");
		chercherButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chercherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(true);
				int id = Integer.parseInt(rechercheIdtextField.getText());
				EmployeDAO employeDAO = new EmployeDAOImp();
				try {
					employeDAO.chercher(id, rechercheTable);
					if (employeDAO.chercher(id, rechercheTable) != 0) 
						modifierButton.setVisible(true);
					    supprimerButton.setVisible(true);
				} catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
		});
		
		chercherButton.setBounds(135, 52, 90, 30);
		contentPane.add(chercherButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 720, 50);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		
		
		rechercheTable = new JTable();
		scrollPane.setViewportView(rechercheTable);
		
		retourButton = new JButton("Retour");
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FRMGestionEmploye frmGestion = new FRMGestionEmploye();
				frmGestion.setVisible(true);
			}
		});
		retourButton.setBounds(235, 52, 90, 30);
		contentPane.add(retourButton);
		
		supprimerButton = new JButton("Supprimer");
		setVisible(false);
		supprimerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(rechercheIdtextField.getText());
				EmployeDAO employeDAO = new EmployeDAOImp();
				int result = JOptionPane.showConfirmDialog(null,"Êtes-vous sûrs de vouloir supprimer l'employé de l'ID  "+id+" ?", "Modifier employé",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
						try {
					employeDAO.supprimer(id);
					employeDAO.clear(rechercheTable);
					rechercheIdtextField.setText("");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
				}
		});
		supprimerButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		supprimerButton.setBounds(368, 214, 90, 30);
		supprimerButton.setVisible(false);
		contentPane.add(supprimerButton);
		
		modifierButton = new JButton("Modifier");
		modifierButton.setVisible(false);
		modifierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(rechercheIdtextField.getText());
				try {
					frmModifier = new FRMModifier();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				frmModifier.setVisible(true);

				EmployeDAO employeDAO = new EmployeDAOImp();
				Employe employeModif = null;
				try {
					employeModif = employeDAO.getInfo(id);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				frmModifier.setData(employeModif);
				scrollPane.setVisible(false);
				rechercheIdtextField.setText("");	
			}
		});
		modifierButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		modifierButton.setBounds(268, 214, 90, 30);
		contentPane.add(modifierButton);
		
		
	}
}
