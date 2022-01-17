package monopoly;

public class RueLibre extends EtatRue {
	
	// Attributs
	private Rue rue;
	
	// Constructeurs
	public RueLibre() {}
	
	public RueLibre(Rue rue) {
		this.rue = rue;
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
		rue.proposerAchat(joueur);
	}

	@Override
	public void joueurAchete(Joueur joueur) {
		this.rue.setProprietaire(joueur);
		new RueAchetee(this.rue);
	}
	
	@Override
	public void construire(Joueur joueur) {
		System.out.println("Construction impossible car cette rue n'est pas constructible.");
	}

}