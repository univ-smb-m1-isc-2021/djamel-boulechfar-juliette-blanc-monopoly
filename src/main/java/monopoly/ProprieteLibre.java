package monopoly;

public class ProprieteLibre extends EtatPropriete {
	
	// Attributs
	private Propriete propriete;
	
	// Constructeurs
	public ProprieteLibre() {}
	
	public ProprieteLibre(Propriete propriete) {
		this.propriete = propriete;
	}
	
	// Méthodes
	
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
		propriete.proposerAchat(joueur);
	}

	@Override
	public void joueurAchete(Joueur joueur) {
		this.propriete.setProprietaire(joueur);
		new ProprieteAchetee(this.propriete);
	}

}