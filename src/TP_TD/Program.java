package TP_TD;

import java.util.Scanner;

public class Program {
    public static Etudiant creerEtudiant(){
        Scanner sc = new Scanner(System.in);
        System.out.println("N.C.E : ");
        String nce = sc.nextLine();
        System.out.println("Nom : ");
        String nom = sc.nextLine();
        System.out.println("Moyenne :");
        float moy = sc.nextFloat();
        Etudiant e = new Etudiant(nce, nom, moy);
        return e;
    }

    public static void main(String[] args) {
        Groupe g1 = new Groupe("DSI21");
       
     Scanner sc = new Scanner(System.in);
        int choice;
        	do {
            System.out.println("------------------------------MENU------------------------------\n" +
                    "1-Ajouter un étudiant\n" +
                    "2-Insérer un étudiant dans une position donnée\n" +
                    "3-Ajouter un étudiant en début de la liste\n" +
                    "4-Consulter un étudiant en fournissant son n°C.E\n" +
                    "5-Consulter un étudiant se trouvant dans une position donnée\n" +
                    "6-Supprimer un étudiant en fournissant son n°C.E\n" +
                    "7-Afficher la liste des étudiants\n" +
                    "8-Vider la liste des étudiants\n" +
                    "9-Quitter");

             choice = sc.nextInt();
             Etudiant e;
            switch (choice) {
                case 1:
                    e = creerEtudiant();
                    g1.ajouterEtudiant(e);
                    break;
                case 2:
                    System.out.println("Donner la position : ");
                    int p = sc.nextInt();
                    g1.ajouterEtudiant(p,creerEtudiant());
                    break;
                case 3 :
                    g1.ajouterDebut(creerEtudiant());
                    break;
                case 4 :
                    System.out.println("Donner le n°C.E de l'étudiant : ");
                    String nce = sc.nextLine();
                    g1.chercherEtudiant(nce);
                    break;
                case 5 :
                    System.out.println("Donner la position : ");
                    int pos = sc.nextInt();
                    g1.chercherEtudiant(pos);
                    break;
                case 6 :
                    System.out.println("Donner n°C.E de l'étudiant : ");
                    String NCE = sc.nextLine();
                    g1.supprimerEtudiant(NCE);
                    break;
                case 7 :
                    g1.afficherListeEtudiants();
                    break;
                case 8 :
                    g1.viderListeEtudiants();
                    break;
            }
        	}
        while (choice != 9);
        }
    }

