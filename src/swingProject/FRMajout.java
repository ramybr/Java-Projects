package swingProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class FRMajout extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblId;
	private JTextArea idTextArea;
	private JTextField nomTextField;
	private JTextField prenomTextField;
	private JLabel lblDept;
	JComboBox<Integer> deptComboBox = new JComboBox<Integer>();
	private JTextField emailTextField;
	private JTextField telTextField;
	private JTextField salaireTextField;
	JDateChooser date = new JDateChooser();
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
	private static final String NOM_PATTERN = "^[A-Za-z ]+$";
	private JButton btnRetour;
	FRMGestionEmploye gestionEmploye;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMajout frame = new FRMajout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void incrementId(JTextArea idTextArea) {
		try {
			Connection connection = Database.getConnection();
			String query = "select * from employe ORDER BY employe_id DESC LIMIT 1";
			java.sql.Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				idTextArea.setText(Integer.toString(res.getInt("employe_id") + 1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void retrieveDepId(JComboBox<Integer> department) {
		try {

			Connection connection = Database.getConnection();
			java.sql.Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select id from department");
			while (res.next()) {
				department.addItem(res.getInt("id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clear(JTextArea jTextArea) {
		incrementId(idTextArea);
		nomTextField.setText("");
		prenomTextField.setText("");
		emailTextField.setText("");
		telTextField.setText("");
		deptComboBox.setSelectedIndex(0);
		salaireTextField.setText("");
		date.setDate(null);

	}

	/**
	 * Create the frame.
	 */
	public FRMajout() {
		setTitle("Ajouter un employé");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setBounds(10, 66, 59, 14);
		contentPane.add(lblNom);

		nomTextField = new JTextField();
		lblNom.setLabelFor(nomTextField);
		nomTextField.setBounds(10, 91, 130, 20);
		contentPane.add(nomTextField);
		nomTextField.setColumns(10);

		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrenom.setBounds(10, 122, 59, 14);
		contentPane.add(lblPrenom);

		prenomTextField = new JTextField();
		lblPrenom.setLabelFor(prenomTextField);
		prenomTextField.setColumns(10);
		prenomTextField.setBounds(10, 147, 130, 20);
		contentPane.add(prenomTextField);

		idTextArea = new JTextArea();
		idTextArea.setEditable(false);
		idTextArea.setBounds(10, 33, 37, 22);
		contentPane.add(idTextArea);
		incrementId(idTextArea);

		lblId = new JLabel("Id");
		lblId.setLabelFor(idTextArea);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 14, 46, 14);
		contentPane.add(lblId);

		lblDept = new JLabel("Dept.Id");
		lblDept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDept.setBounds(10, 178, 46, 20);
		contentPane.add(lblDept);
		retrieveDepId(deptComboBox);

		lblDept.setLabelFor(deptComboBox);
		deptComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deptComboBox.setBounds(10, 209, 59, 22);
		contentPane.add(deptComboBox);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 242, 59, 14);
		contentPane.add(lblEmail);

		emailTextField = new JTextField();
		lblEmail.setLabelFor(emailTextField);
		emailTextField.setColumns(10);
		emailTextField.setBounds(10, 267, 130, 20);
		contentPane.add(emailTextField);

		JLabel lblTel = new JLabel("Téléphone");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTel.setBounds(294, 90, 75, 20);
		contentPane.add(lblTel);

		telTextField = new JTextField();
		lblTel.setLabelFor(telTextField);
		telTextField.setColumns(10);
		telTextField.setBounds(294, 118, 130, 20);
		contentPane.add(telTextField);

		JLabel lblSalaire = new JLabel("Salaire");
		lblSalaire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalaire.setBounds(294, 151, 59, 14);
		contentPane.add(lblSalaire);

		salaireTextField = new JTextField();
		lblSalaire.setLabelFor(salaireTextField);
		salaireTextField.setColumns(10);
		salaireTextField.setBounds(294, 174, 130, 20);
		contentPane.add(salaireTextField);

		JLabel lblEmbauche = new JLabel("Date d'embauche");
		lblEmbauche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmbauche.setBounds(294, 210, 130, 20);
		contentPane.add(lblEmbauche);

		date.setDateFormatString("dd/MM/yyyy");
		lblEmbauche.setLabelFor(date);
		date.setBounds(294, 236, 130, 20);
		contentPane.add(date);

		JButton ajouterButton = new JButton("Ajouter");
		ajouterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(idTextArea.getText());
				String firstName = prenomTextField.getText();
				String lastName = nomTextField.getText();
				int departmentId = (int) deptComboBox.getSelectedItem();
				String mail = (String) emailTextField.getText();
				String numTel = telTextField.getText();
				int salaire = Integer.parseInt(salaireTextField.getText());
				int telLength = numTel.length();

				java.util.Date dateUtil = date.getDate();
				java.sql.Date dateEmbauche = new Date(dateUtil.getTime());
				// controle de saisie

				// nom et prenom
				Pattern patternNom = Pattern.compile(NOM_PATTERN);
				Matcher prenomMatcher = patternNom.matcher(firstName);
				Matcher nomMatcher = patternNom.matcher(lastName);
				if (!nomMatcher.matches() || !prenomMatcher.matches())
					JOptionPane.showMessageDialog(ajouterButton, "Entrez un nom et un prénom valide");

				// numero de telephone
				if (telLength < 8)
					JOptionPane.showMessageDialog(ajouterButton, "Entrez un numéro de téléphone valide");
				try {
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(ajouterButton, "Entrez un numéro de téléphone valide");
				}

				// email
				Pattern pattern = Pattern.compile(EMAIL_PATTERN);
				Matcher mailMatcher = pattern.matcher(mail);
				if (!mailMatcher.matches())
					JOptionPane.showMessageDialog(ajouterButton, "Entrez une adresse e-mail valide");

				// salaire
				try {
					salaire = Integer.parseInt(salaireTextField.getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(ajouterButton, "Entrez un salaire valide");
				}
				EmployeDAO employeDAO = new EmployeDAOImp();
				Employe employe = new Employe(id, lastName, firstName, departmentId, mail, numTel, salaire,
						dateEmbauche);
				try {
					employeDAO.ajouter(employe);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(ajouterButton, "Employé ajouté ");
				clear(idTextArea);
			}
		});
		ajouterButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ajouterButton.setBounds(133, 298, 89, 23);
		contentPane.add(ajouterButton);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				gestionEmploye = new FRMGestionEmploye();
				gestionEmploye.setVisible(true);
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRetour.setBounds(232, 298, 89, 23);
		contentPane.add(btnRetour);

	}
}