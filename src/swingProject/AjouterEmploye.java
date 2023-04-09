package swingProject;
import java.awt.EventQueue;
import java.sql.*; 
import java.util.regex.*;    
import java.util.*; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.result.Field;
import com.mysql.cj.xdevapi.Statement;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class AjouterEmploye extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextField id;
	private JTextField nom;
	private JTextField prenom;
	private JComboBox<Integer> idDepartement;
	private JTextField email;
	private JTextField tel;
	private JTextField salaire;
	private JTextField dateEmbauche;
	private JButton ajouterBtn;
	private JButton fermerBtn;
	private static final  String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";  
	private static final String NOM_PATTERN = "^[A-Za-z ]+$";
	
	public static void main (String [] args) {
		
		AjouterEmploye frame = new AjouterEmploye();
		frame.setVisible(true);
		frame.setTitle("Gestion des employés - Ajout");
        
		String urlString = "jdbc:mysql://localhost:3306/hr";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "admin");
				java.sql.Statement st = connection.createStatement();
				ResultSet res = st.executeQuery("select * from employe");
			 while (res.next()) {
				 System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + res.getInt(4)
				 +" "+ res.getString(5) + " " + res.getString(6) + " " + res.getInt(7)  + " " + res.getDate(8) );
				 if (!connection.isClosed())
		                System.out.println("Successfully connected to MySQL server");

			 }
			} catch (Exception e) {
				System.out.println(e);
			//e.printStackTrace();
			}
			
	}
	
	public AjouterEmploye() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
        
        JLabel lblEmployeJLabel = new JLabel("Ajouter un employé");
        lblEmployeJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblEmployeJLabel.setBounds(362, 52, 325, 50);
        contentPanel.add(lblEmployeJLabel);
        
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Times New Roman",Font.PLAIN, 18));
        lblId.setBounds(85, 100, 100, 43);
        contentPanel.add(lblId);
        
        
        JLabel lblNom = new JLabel("Nom");
        lblNom.setFont(new Font("Times New Roman",Font.PLAIN, 18));
        lblNom.setBounds(85, 140, 100, 43);
        contentPanel.add(lblNom);
        
        JLabel lblPrenom = new JLabel("Prenom");
        lblPrenom.setFont(new Font("Times New Roman",Font.PLAIN, 18));
        lblPrenom.setBounds(85, 200, 100, 43);
        contentPanel.add(lblPrenom);
        
        JLabel lblDept = new JLabel("ID.Dept.");
        lblDept.setFont(new Font("Times New Roman",Font.PLAIN, 18));
        lblDept.setBounds(85, 260, 100, 43);
        contentPanel.add(lblDept);
        
        JLabel lblEmailAdress = new JLabel("Email");
        lblEmailAdress.setFont(new Font("Times New Roman",Font.PLAIN, 18));
        lblEmailAdress.setBounds(85, 320, 100, 43);
        contentPanel.add(lblEmailAdress);
        
        JLabel lblTel = new JLabel("Tel.");
        lblTel.setFont(new Font("Times New Roman",Font.PLAIN, 18));
        lblTel.setBounds(540, 140, 100, 43);;
        contentPanel.add(lblTel);
        
        JLabel lblSalaire = new JLabel("Salaire");
        lblSalaire.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblSalaire.setBounds(540, 200, 100, 43);
        contentPanel.add(lblSalaire);
        
        JLabel lblDate = new JLabel("Date Embauche");
        lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblDate.setBounds(540, 260, 150, 43);
        contentPanel.add(lblDate);
      
        id = new JTextField();
        id.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        id.setBounds(120, 105, 50, 30);
        id.setEditable(false);
        contentPanel.add(id);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "admin");
			String query ="select *from employe ORDER BY employe_id DESC LIMIT 1";
			java.sql.Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				id.setText(Integer.toString(res.getInt("employe_id")+1));
			}

		} catch (Exception e) {
			System.out.println(e);
		//e.printStackTrace();
		}
        
        
        
        nom = new JTextField();
        nom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        nom.setBounds(160, 145, 228, 30);
        contentPanel.add(nom);
        nom.setColumns(10);
        
        prenom = new JTextField();
        prenom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        prenom.setBounds(160,205,228,30);
        contentPanel.add(prenom);
        prenom.setColumns(10);
        
        idDepartement = new JComboBox<Integer>();
        idDepartement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        idDepartement.setBounds(160, 265, 150, 30);
        contentPanel.add(idDepartement);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "admin");
			java.sql.Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select id from department");
				while (res.next()) {
					idDepartement.addItem(res.getInt("id"));
				}

		} catch (Exception e) {
			System.out.println(e);
		}
        
        email = new JTextField();
        email.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        email.setBounds(160, 325, 228, 30);
        contentPanel.add(email);
        email.setColumns(10);
        
        tel = new JTextField();
        tel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        tel.setBounds(615, 145, 120, 30);
        contentPanel.add(tel);
        tel.setColumns(10);
        
        salaire = new JTextField();
        salaire.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        salaire.setBounds(615, 205, 120, 30);
        contentPanel.add(salaire);
        salaire.setColumns(10);
        
        JDateChooser date = new JDateChooser();
        date.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        contentPanel.add(date);
        date.setBounds(540, 300, 150,30);
        
        
        ajouterBtn = new JButton("Ajouter");
        ajouterBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String  firstName = prenom.getText();
				String lastName = nom.getText();
				int departmentId = (int)idDepartement.getSelectedItem();
				String mail = (String)email.getText();
				String numTel = tel.getText();
				int telLength = numTel.length();
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String dateEmbauche = dateFormat.format(date.getDate());
				
				//controle de saisie
				
				//nom et prenom
				Pattern patternNom = Pattern.compile(NOM_PATTERN);
				Matcher prenomMatcher = patternNom.matcher(firstName);
				Matcher nomMatcher = patternNom.matcher(lastName);
				if (!nomMatcher.matches() || !prenomMatcher.matches())
					JOptionPane.showMessageDialog(ajouterBtn, "Entrez un nom et un prénom valide");
				
				//numero de telephone
				if (telLength < 8)
					JOptionPane.showMessageDialog(ajouterBtn, "Entrez un numéro de téléphone valide");
				try {
					int phone = Integer.parseInt(numTel);
				} catch (NumberFormatException nfe) {
					System.out.println("Entrez un numéro de téléphone valide");
				}
				
				//email
				Pattern pattern = Pattern.compile(EMAIL_PATTERN);
				Matcher mailMatcher = pattern.matcher(mail);
				if (!mailMatcher.matches())	
				JOptionPane.showMessageDialog(ajouterBtn, "Entrez une adresse e-mail valide");
				
				//salaire
				 try {
					 int salary = Integer.parseInt(salaire.getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(ajouterBtn, "Entrez un salaire valide");
				}
				
			
			
			}
		});
        
        
        
        ajouterBtn.setBounds(400, 400, 200, 40);
        contentPanel.add(ajouterBtn);
     
      
        
		
	}
	




}
