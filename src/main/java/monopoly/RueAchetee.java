package monopoly;

public class RueAchetee extends EtatRue {
	
	// Attributs
	private Rue rue;
	
	// Constructeurs
	public RueAchetee() {}
	
	public RueAchetee(Rue rue) {
		this.rue = rue;
		this.rue.setEtatRue(this);
		Joueur proprietaire = this.rue.getProprietaire();
		proprietaire.debiterSolde(this.rue.getPrixAchat());
		Quartier quartierRue = this.rue.getQuartier();
		boolean quartierPossede = quartierRue.joueurPossedeToutesRues(proprietaire);
		if(quartierPossede) {
			quartierRue.setRuesConstructibles();
			System.out.println(proprietaire.getNom() + " possede maintenant tout le quartier " + quartierRue.getCouleur() + ".");
		}
	}
	
	// Méthodes
	
	/* Getters et setters */
	public Rue getRue() {
		return rue;
	}

	public void setRue(Rue rue) {
		this.rue = rue;
	}
	/* ------------------ */
	
	@Override
	public void joueurArrive(Joueur joueur) {
		Joueur proprietaire = this.rue.getProprietaire();
		if(joueur != proprietaire) {
			System.out.println("Cette rue appartient à " + proprietaire.getNom() + ".");
			System.out.println(proprietaire.getNom() + " ne possède pas le quartier dans laquelle la rue se trouve, " + joueur.getNom() + " paie le loyer de 25M.");
			joueur.debiterSolde(25);
			proprietaire.crediterSolde(25);
		} else {
			System.out.println("Cette case vous appartient.");
		}
	}

	@Override
	public void joueurAchete(Joueur joueur) {
		System.out.println("Achat impossible car cette rue a déjà été achetée.");
	}
	
	@Override
	public void construire(Joueur joueur) {
		System.out.println("Construction impossible car cette rue n'est pas constructible.");
	}

}