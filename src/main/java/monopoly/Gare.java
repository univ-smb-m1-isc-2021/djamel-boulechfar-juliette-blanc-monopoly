package monopoly;

public class Gare extends Propriete {
	
	// Attributs
	private int indice;
	private String nom;
	private int prixAchat;
	private Joueur proprietaire;
	private EtatPropriete etat;
	
	// Constructeurs
	public Gare() {}
	
	public Gare(int indice, String nom, int prixAchat) {
		this.indice = indice;
		this.nom = nom;
		this.prixAchat = prixAchat;
		this.proprietaire = null;
		this.etat = new ProprieteLibre(this);
	}

	// Méthodes
	
	/* Getters et setters */
	@Override
	public int getIndice() {
		return this.indice;
	}

	@Override
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
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
	
	public EtatPropriete getEtat() {
		return etat;
	}

	public void setEtat(EtatPropriete etat) {
		this.etat = etat;
	}
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

}