package TP_TD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Groupe {
    private String nomGroupe;
    private ArrayList<Etudiant> listeEtudiants = new ArrayList<Etudiant>();

    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public boolean ajouterEtudiant (Etudiant e){
        if (listeEtudiants.contains(e)) return false;
        else {
            e.setGroupeEtudiant(this);
            listeEtudiants.add(e);
        }
        return true;
    }

    public int ajouterEtudiant(int index, Etudiant e){
        if (listeEtudiants.contains(e)) return 0;
        else {
            if (index < 0 || index >= listeEtudiants.size()) return -1;
            else {
                e.setGroupeEtudiant(this);
                listeEtudiants.add(index, e);
                return 1;
            }
        }
    }

    public boolean ajouterDebut(Etudiant e){
        if (listeEtudiants.contains(e)) return false;
        else e.setGroupeEtudiant(this);
        listeEtudiants.add(0, e);
        return true;
    }


    public Etudiant chercherEtudiant(String cer){
        Etudiant e = new Etudiant();
        e.setNce(cer);
        int i = listeEtudiants.indexOf(e);
        if (i == -1) return null;
        else return listeEtudiants.get(i);
    }

    public Etudiant chercherEtudiant(int i){
        Etudiant e = new Etudiant();
        if (i < 0 || i >= listeEtudiants.size()) return null;
        else return listeEtudiants.get(i);
    }

    public boolean supprimerEtudiant(String ces){
        Etudiant e = new Etudiant();
        e.setNce(ces);
        return listeEtudiants.remove(e);
    }
    //forEach
    public void afficherListeEtudiants(){
        System.out.println("La liste des etudiants du groupe " +nomGroupe+": \n");
        ListIterator<Etudiant> litr = listeEtudiants.listIterator();
        while (litr.hasPrevious()) {
            System.out.println(litr.previous() + "\n");
        }
        }
        /*for (Etudiant e: listeEtudiants) {
            System.out.println("Etudiant "+listeEtudiants.indexOf(e)+" "+e + "\n");
        }*/

        //iterator
           /*Iterator<Etudiant> itr = listeEtudiants.iterator();
            while (itr.hasNext()){
                System.out.println(itr.next()+ "\n");
            }*/
        //listIterator
      
    

    public void viderListeEtudiants(){
        listeEtudiants.clear();
    }

    @Override
    public String toString() {
        return "Groupe : " + nomGroupe + '\n' +
                "ListeEtudiants : " + listeEtudiants ;
    }
}
