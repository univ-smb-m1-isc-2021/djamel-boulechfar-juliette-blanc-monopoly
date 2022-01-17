package monopoly;

public class RueConstructible extends EtatRue {
	
	// Attributs
	private Rue rue;
	
	// Constructeurs
	public RueConstructible() {}
	
	public RueConstructible(Rue rue) {
		this.rue = rue;
		this.rue.setEtatRue(this);
	}
	
	// M�thodes
	
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
			System.out.println("Cette rue appartient � " + proprietaire.getNom() + ".");
			System.out.println(proprietaire.getNom() + " poss�de le quartier dans laquelle la rue se trouve, " + joueur.getNom() + " paie le loyer de 50M.");
			joueur.debiterSolde(50);
			proprietaire.crediterSolde(50);
		} else {
			System.out.println("Cette case vous appartient.");
		}
	}

	@Override
	public void joueurAchete(Joueur joueur) {
		System.out.println("Achat impossible car cette rue a d�j� �t� achet�e.");
	}
	
	@Override
	public void construire(Joueur joueur) {
		Joueur proprietaire = this.rue.getProprietaire();
		if (joueur == proprietaire) {
			if (joueur.verifieSoldeSuffisant(200)) {
				new RueExploitee(this.rue);
			} else {
				System.out.println("Vous n'avez pas la somme requise (200M) pour construire, vous n'avez pas �t� d�bit�. Votre solde : " + joueur.getSolde() + "M.");
			}
		} else {
			System.out.println("Erreur sur la construction, vous  n'�tes pas le propri�taire de la rue.");
		}
	}

}