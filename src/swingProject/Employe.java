package swingProject;

import java.sql.Date;

public class Employe {
	private int id;
	private String nom;
	private String prenom;
	private int depId;
	private String email;
	private String tel;
	private int salaire;
	private Date dateEmbauche;

	public Employe(int id, String nom, String prenom, int depId, String email, String tel, int salaire,
			Date dateEmbauche) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.depId = depId;
		this.email = email;
		this.tel = tel;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;

	}

	public Employe(String nom, String prenom, int depId, String email, String tel, int salaire, Date dateEmbauche) {

		this.nom = nom;
		this.prenom = prenom;
		this.depId = depId;
		this.email = email;
		this.tel = tel;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
	}
	
	
	
	public Employe() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", depId=" + depId + ", email=" + email
				+ ", tel=" + tel + ", salaire=" + salaire + ", dateEmbauche=" + dateEmbauche + "]";
	}

}
