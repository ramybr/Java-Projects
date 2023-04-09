package swingProject;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FRMListeEmployes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable listeTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMListeEmployes frame = new FRMListeEmployes();
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
	public FRMListeEmployes() {
		setTitle("Liste des employés");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LocalDate dateToday = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = dateToday.format(dateTimeFormatter);
		JLabel listeLabel = new JLabel("La liste des employés (Le : "+date+ ")");
		listeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		listeLabel.setBounds(195, 22, 353, 25);
		contentPane.add(listeLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 684, 324);
		contentPane.add(scrollPane);
		
		listeTable = new JTable();
		scrollPane.setViewportView(listeTable);
		listeTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		EmployeDAO empDAOImp = new EmployeDAOImp();
		try {
			empDAOImp.getAll(listeTable);
			
			JButton retourButton = new JButton("Retour");
			retourButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					FRMGestionEmploye frmGestion = new FRMGestionEmploye();
					frmGestion.setVisible(true);
				}
			});
			retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			retourButton.setBounds(294, 401, 90, 30);
			contentPane.add(retourButton);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
