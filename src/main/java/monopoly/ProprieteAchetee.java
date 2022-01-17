package monopoly;

public class ProprieteAchetee extends EtatPropriete {
	
	// Attributs
	private Propriete propriete;
	
	// Constructeurs
	public ProprieteAchetee() {}
	
	public ProprieteAchetee(Propriete propriete) {
		this.propriete = propriete;
		Joueur proprietaire = this.propriete.getProprietaire();
		proprietaire.debiterSolde(propriete.getPrixAchat());
		
		if (this.propriete instanceof Service) {
			((Service) this.propriete).setEtat(this);
			proprietaire.setNbServices(proprietaire.getNbServices() + 1);
			System.out.println(proprietaire.getNom() + " poss�de maintenant " + proprietaire.getNbServices() + " service(s).");
		} else if (this.propriete instanceof Gare) {
			((Gare) this.propriete).setEtat(this);
			proprietaire.setNbGares(proprietaire.getNbGares() + 1);
			System.out.println(proprietaire.getNom() + " poss�de maintenant " + proprietaire.getNbGares() + " gare(s).");
		} else {
			System.out.println("Erreur propriet� achet�e.");
		}
	}
	
	// M�thodes
	
	/* Getters et setters */
	public Propriete getPropriete() {
		return propriete;
	}

	public void setPropriete(Propriete propriete) {
		this.propriete = propriete;
	}
	/* ------------------ */
	
	@Override
	public void joueurArrive(Joueur joueur) {
		Joueur proprietaire = this.propriete.getProprietaire();
		if(joueur != proprietaire) {
			System.out.println("Cette propri�t� appartient � " + proprietaire.getNom() + ".");
			if (this.propriete instanceof Service) {
				int nbServicesProprietaire = proprietaire.getNbServices();
				joueur.payerTaxeService(nbServicesProprietaire, proprietaire);
			} else if (this.propriete instanceof Gare) {
				int nbGaresProprietaire = proprietaire.getNbGares();
				joueur.payerTaxeGare(proprietaire, nbGaresProprietaire);
			} else {
				System.out.println("Erreur arriv�e joueur sur propri�t�.");
			}
		} else {
			System.out.println("Cette propri�t� vous appartient.");
		}
	}

	@Override
	public void joueurAchete(Joueur joueur) {
		System.out.println("Achat impossible car la propri�t� a d�j� �t� achet�e.");
	}

}