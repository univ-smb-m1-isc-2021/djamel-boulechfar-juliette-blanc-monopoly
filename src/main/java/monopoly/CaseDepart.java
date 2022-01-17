package monopoly;

public class CaseDepart extends CaseNonAchetable{
	
	// Attributs
	private int indice;
	private String nom;

	// Constructeur
	public CaseDepart() {
		this.indice = 0;
		this.nom = "Case départ";
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
	/* ------------------ */
	
	@Override
	public void joueurArrive(Joueur joueur) {
		joueur.crediterSolde(200);
	}

}
