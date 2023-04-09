package TP_TD;


public class Etudiant implements Comparable<Etudiant> {
    private int nce;
    private String nom;
    private float moyenne;
    private Groupe groupeEtudiant;

    public Etudiant(int nCE) {
        this.nce = nCE;
    }

    public Etudiant(int nCE, String nom, float moyenne) {
        this.nce = nCE;
        this.nom = nom;
        this.moyenne = moyenne;
    }

    public int getNce() {
        return nce;
    }

    public void setNce(int nce) {
        this.nce = nce;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public Groupe getGroupeEtudiant() {
        return groupeEtudiant;
    }

    public void setGroupeEtudiant(Groupe groupeEtudiant) {
        this.groupeEtudiant = groupeEtudiant;
    }

    public Etudiant() {
    }

    @Override
    public String toString() {
        return "Etudiant : " +
                "NCE : " + nce + '\'' +", "+
                "Nom : " + nom + '\'' +", "+
                "Groupe : " + groupeEtudiant+", "+
                "Moyenne : " + moyenne;
    }

	@Override
	public int compareTo(Etudiant e) {
		if (this.getNce() > e.getNce())		
			return 1;
		else if (this.getNce()<e.getNce()) 
			return -1;
		else return 0;
	}
}
