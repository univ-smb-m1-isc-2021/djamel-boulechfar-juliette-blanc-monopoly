package monopoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Partie {
    
	// Attributs
    private int nbJoueurs;
    private ArrayList<Joueur> listeJoueurs;
    private Plateau plateau;
    
    // Constructeurs
    public Partie() {}
    
    // Méthodes
    
    /* Getters et setters */
    public int getNbJoueurs() {
    	return nbJoueurs;
    }
    
    public void setNbJoueurs(int nbJoueurs) {
    	this.nbJoueurs = nbJoueurs;
    }
    
    public ArrayList<Joueur> getListeJoueurs() {
    	return this.listeJoueurs;
    }
    
    public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
    	this.listeJoueurs = listeJoueurs;
    }
    
    public Plateau getPlateau() {
    	return this.plateau;
    }
    
    public void setPlateau(Plateau plateau) {
    	this.plateau = plateau;
    }
    /* ------------------ */
    
    public void debuterPartie(int nbJoueurs) {
    	
    	setNbJoueurs(nbJoueurs);
    	
    	@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
    	
    	ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
    	
    	System.out.println("\nVeuillez saisir les noms des joueurs :");
    	
    	for (int i = 0; i < nbJoueurs; i++) {
    		System.out.print("Nom du joueur " + (i+1) + " : ");
    		String nomJoueur = inputScanner.nextLine();
    		listeJoueurs.add(new Joueur(nomJoueur, this));
    	}
    	
    	//inputScanner.close();
    	
    	System.out.print("\nListe des joueurs : ");
    	
    	for (int i = 0; i < listeJoueurs.size(); i++) {
    		if(i != listeJoueurs.size() - 1) {
    			System.out.print(listeJoueurs.get(i).getNom() + ", ");
    		} else {
    			System.out.print(listeJoueurs.get(i).getNom());
    		}
    	}
    	
    	ajouterJoueurs(listeJoueurs);
    }

    public void ajouterJoueurs(ArrayList<Joueur> listeJoueurs) {
    	
    	// Un commentaire pour tester
    	
    	setListeJoueurs(listeJoueurs);
    	
    }

    public void definirOrdre() {
    	
    	ArrayList<Joueur> listeMelangee = new ArrayList<Joueur>();
    	
    	for (int i = 0; i < nbJoueurs; i++) {
    		int randomNum = ThreadLocalRandom.current().nextInt(0, this.listeJoueurs.size());
    		Joueur joueur = this.listeJoueurs.get(randomNum);
    		this.listeJoueurs.remove(randomNum);
    		listeMelangee.add(joueur);
    	}
    	
    	this.listeJoueurs = listeMelangee;
    	
    	System.out.print("\n\nOrdre de jeu des joueurs : ");
    	
    	for (int i = 0; i < listeJoueurs.size(); i++) {
    		if(i != listeJoueurs.size() - 1) {
    			System.out.print(listeJoueurs.get(i).getNom() + ", ");
    		} else {
    			System.out.print(listeJoueurs.get(i).getNom());
    		}
    	}
    	
    }

    public void genererPlateau() {
    	Plateau plateau = new Plateau();
    	plateau.genererCases();
    	setPlateau(plateau);
    }

    public int lancerDes() {
    	
    	@SuppressWarnings("resource")
		Scanner scannerInput = new Scanner(System.in);
    	
    	String input = "";
    	
    	System.out.print("Appuyez sur 'Entrée' pour lancer les dés : ");
    	
    	input = scannerInput.nextLine();
    	
    	if(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") || input.equals("6") || input.equals("7") || input.equals("8") || input.equals("9") || input.equals("10") || input.equals("11") || input.equals("12")) {
    		System.out.print("[Lancer truqué] ");
    		return Integer.parseInt(input);
    	} else {
    		int resultat = ThreadLocalRandom.current().nextInt(2, 13);
        	return resultat;
    	}
    	
    }
    
    public void deplacerJoueur(Joueur joueur, Case caseActuelle) {
    	int resultatDes = lancerDes();
    	System.out.println("Joueur " + joueur.getNom() + " lance les dés depuis la case " + caseActuelle.getIndice() + "... Il a fait " + resultatDes + " !");
    	Case caseArrivee = plateau.allerSur(caseActuelle.getIndice() + resultatDes);
    	joueur.setEstSur(caseArrivee);
    	int difference = 16 - (caseActuelle.getIndice() + resultatDes);
    	if(difference < 0) {
    		System.out.print(joueur.getNom() + " est passé par la case départ. ");
    		joueur.crediterSolde(200);
    	}
    	System.out.println(joueur.getNom() + " est sur la case '" + joueur.getCaseActuelle().getNom() + "' (" + joueur.getCaseActuelle().getIndice() + ").");
    }

    public ArrayList<Rue> getRuesConstructiblesJoueur(Joueur joueur) {
    	return plateau.getRuesConstructiblesJoueur(joueur);
    }

}