package monopoly;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
	
	// Attributs
    private String nom;
    private int solde;
    private int nbServices;
    private int nbGares;
    private Partie partie;
    private Case caseActuelle;
    private ArrayList<Propriete> listeProprietes;
    
    // Constructeurs
    public Joueur() {}
    
    public Joueur(String nom, Partie partie) {
    	this.nom = nom;
    	this.solde = 1500;
    	this.nbServices = 0;
    	this.nbGares = 0;
    	this.partie = partie;
    	this.caseActuelle = partie.getPlateau().getListeCases().get(0);
    	this.listeProprietes = new ArrayList<Propriete>();
    }
    
    // Méthodes
    
    /* ------------------ */
    /* Getters et setters */
    /* ------------------ */
    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}
	
    public int getNbServices() {
    	return this.nbServices;
    }
	
	public void setNbServices(int nbServices) {
		this.nbServices = nbServices;
	}

    public int getNbGares() {
    	return this.nbGares;
    }
	
	public void setNbGares(int nbGares) {
		this.nbGares = nbGares;
	}
	
	public Partie getPartie() {
		return this.partie;
	}
	
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
    public Case getCaseActuelle() {
    	return this.caseActuelle;
    }

    public void setEstSur(Case nouvelleCase) {
    	this.caseActuelle = nouvelleCase;
    }
    
    public ArrayList<Propriete> getListeProprietes() {
    	return this.listeProprietes;
    }
    
    public void setListePropriete(ArrayList<Propriete> listeProprietes) {
    	this.listeProprietes = listeProprietes;
    }
    /* ------------------ */
    /* ------------------ */
    /* ------------------ */

    public boolean verifieSoldeSuffisant(int montant) {
    	return this.solde >= montant;
    }

    public void crediterSolde(int montant) {
    	this.solde += montant;
    	System.out.println("Le solde de " + this.nom + " a été crédité de " + montant + "M. Nouveau solde : " + this.solde + "M.");
    }
    
    public void debiterSolde(int montant) {
    	if(verifieSoldeSuffisant(montant)) {
    		this.solde -= montant;
        	System.out.println("Le solde de " + this.nom + " a été débité de " + montant + "M. Nouveau solde : " + this.solde + "M.");
    	} else {
    		this.solde = 0;
    		System.out.println("Le solde de " + this.nom + " n'était pas suffisant pour payer " + montant + "M, la somme maximale possible a été débitée. Vous avez de la chance, nous n'avons pas implémenté le découvert. Nouveau solde : " + this.solde + "M.");
    	}
    }
    
    public void jouerTour() {
    	System.out.println(this.nom + " est actuellement sur la case '" + this.caseActuelle.getNom() + "' (" + this.caseActuelle.getIndice() + ").");
    	partie.deplacerJoueur(this, caseActuelle);
    	caseActuelle.joueurArrive(this);
    }

    public void propositionAchat(int montant) {
    	System.out.println("La case '" + this.caseActuelle.getNom() + "' est achetable pour " + montant + "M.");
    	System.out.println("Votre solde : " + this.solde + "M.");
    	
    	@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
    	String input = "";
    	
    	while(!(input.equals("OUI") || input.equals("NON"))) {
    		System.out.print("Voulez-vous acheter cette case ? 'Oui'/'Non' : ");
    		input = inputScanner.nextLine().toUpperCase();
        	if(input.equals("OUI")) {
        		System.out.println("Vous avez décidé d'acheter la case '" + caseActuelle.getNom() + "'.");
        		acheterCaseActuelle(montant);
        	} else if (input.equals("NON")) {
        		System.out.println("Vous avez décidé de ne pas acheter la case '" + caseActuelle.getNom() + "'.");
        	} else {
        		System.out.println("Choix invalide.");
        	}
    	}
    	//inputScanner.close();
    }

    public void acheterCaseActuelle(int montant) {
    	if(verifieSoldeSuffisant(montant)) {
    		Propriete propriete = (Propriete) this.caseActuelle;
    		propriete.joueurAchete(this);
    	} else {
    		System.out.println("Solde insufisant, impossible d'acheter la case.");
    	}
    }

    public void payerTaxeService(int nbServices, Joueur proprietaire) {
		if(nbServices == 1 || nbServices == 2) {
			
			System.out.println(proprietaire.getNom() + " possède " + nbServices + " service(s).");
			
			int multiplicateur = 0;
	    	if(nbServices == 1) {
	    		multiplicateur = 4;
	    	} else if (nbServices == 2) {
	    		multiplicateur = 10;
	    	}
	    	
	    	int tirageDes = partie.lancerDes();
	    	
	    	System.out.println("Vous avez lancé les dés... et obtenu un résultalt de " + tirageDes + ".");
	    	
	    	System.out.println(this.getNom() + " paie donc la taxe de 150 * " + multiplicateur + " * " + tirageDes + " soit " + (150 * multiplicateur * tirageDes) + "M à " + proprietaire.getNom() + ".");
	    	
	    	debiterSolde(150 * multiplicateur * tirageDes);
			
			proprietaire.crediterSolde(150 * multiplicateur * tirageDes);
		} else {
    		System.out.println("Erreur payerTaxeService");
    	}
    }

    public void payerTaxeGare(Joueur proprietaire, int nbGares) {
    	
    	System.out.println(proprietaire.getNom() + " possède " + nbGares + " gare(s).");
    	
    	System.out.println(this.getNom() + " paie donc la taxe de 200 * " + nbGares + " soit " + (200 * nbGares) + "M à " + proprietaire.getNom() + ".");
    	
    	debiterSolde(200 * nbGares);
    	
    	proprietaire.crediterSolde(200 * nbGares);
    	
    }

}