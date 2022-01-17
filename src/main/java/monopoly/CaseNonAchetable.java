package monopoly;

public abstract class CaseNonAchetable extends Case {
	
	public abstract int getIndice();
	
	public abstract void setIndice(int indice);
	
	public abstract String getNom();
	
	public abstract void setNom(String nom);
	
	public abstract void joueurArrive(Joueur joueur);
	
}