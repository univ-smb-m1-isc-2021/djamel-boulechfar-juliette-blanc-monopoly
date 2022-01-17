package monopoly;

public class Rue extends Propriete {
	
	// Attributs
	private int indice;
	private String nom;
    private Quartier quartier;
    private int prixAchat;
	private Joueur proprietaire;
	private EtatRue etat;
    private int nbMaisons;
    private int nbHotels;
    
    // Constructeurs
    public Rue() {}
    
    public Rue(int indice, String nom, int prixAchat, Quartier quartier) {
    	this.indice = indice;
    	this.nom = nom;
    	this.quartier = quartier;
    	this.prixAchat = prixAchat;
    	this.proprietaire = null;
    	this.etat = new RueLibre(this);
    	this.nbMaisons = 0;
    	this.nbHotels = 0;
    }

    // Méthodes 
    
    /* ------------------ */
    /* Getters et setters */
    /* ------------------ */
    @Override
    public String getNom() {
    	return this.nom;
    }
    
    @Override
    public void setNom(String nom) {
    	this.nom = nom;
    }
    
	@Override
	public int getIndice() {
		return this.indice;
	}

	@Override
	public void setIndice(int indice) {
		this.indice = indice;
	}
    
    public Quartier getQuartier() {
    	return this.quartier;
    }
    
    public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
    
    @Override
    public int getPrixAchat() {
    	return this.prixAchat;
    }
    
    public void setPrixAchat(int prixAchat) {
    	this.prixAchat = prixAchat;
    }
    
	@Override
	public Joueur getProprietaire() {
		return this.proprietaire;
	}

	@Override
	public void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}
    
    public EtatRue getEtatRue() {
		return etat;
	}

	public void setEtatRue(EtatRue etat) {
		this.etat = etat;
	}

	public int getNbMaisons() {
    	return this.nbMaisons;
    }
    
    public void setNbMaisons(int nbMaisons) {
    	this.nbMaisons = nbMaisons;
    }
    
    public int getNbHotels() {
    	return this.nbHotels;
    }
    
    public void setNbHotels(int nbHotels) {
    	this.nbHotels = nbHotels;
    }
    /* ------------------ */
    /* ------------------ */
    /* ------------------ */

	@Override
	public void joueurArrive(Joueur joueur) {
		this.etat.joueurArrive(joueur);
	}
    
	@Override
	public void proposerAchat(Joueur joueur) {
		joueur.propositionAchat(this.prixAchat);
	}
	
	@Override
	public void joueurAchete(Joueur joueur) {
		this.etat.joueurAchete(joueur);
	}
	
    public void construire(Joueur joueur) {
    	this.etat.construire(joueur);
    }

    public void ajouterBatiment() {
    	if (this.nbHotels < 1) {
        	if(nbMaisons < 4) {
        		this.nbMaisons++;
        	} else if (nbMaisons == 4) {
        		this.nbMaisons = 0;
        		this.nbHotels++;
        	}
    	}
    	System.out.println("Suite à la construction, il y a maintenant " + this.nbMaisons + " maison(s) et " + this.nbHotels + " hotel(s) sur la case '" + this.nom + "'.");
    }

    public int calculeLoyer() {
    	if(this.nbHotels < 1) {
    		return 200 * this.nbMaisons;
    	} else {
    		return 1200;
    	}
    }

}