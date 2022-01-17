package monopoly;

public abstract class Propriete extends Case {

	public abstract int getPrixAchat();
	
	public abstract Joueur getProprietaire();
	
	public abstract void setProprietaire(Joueur proprietaire);
	
	public abstract void proposerAchat(Joueur joueur);
	
    public abstract void joueurAchete(Joueur joueur);

}