package monopoly;

import java.util.ArrayList;

public class Quartier {
	
	// Attributs
    private String couleur;
    private ArrayList<Rue> listeRues;
    
    // Constructeurs
    public Quartier() {}
    
    public Quartier(String couleur) {
    	this.couleur = couleur;
    	this.listeRues = new ArrayList<Rue>();
    }
    
    // Méthodes
    
    /* Getters et setters */
    public String getCouleur() {
    	return this.couleur;
    }
    
    public void setCouleur(String couleur) {
    	this.couleur = couleur;
    }
    
    public ArrayList<Rue> getListeRues() {
    	return this.listeRues;
    }
    
    public void setListeRues(ArrayList<Rue> listeRues) {
    	this.listeRues = listeRues;
    }
    /* ------------------ */

    public boolean joueurPossedeToutesRues(Joueur joueur) {
    	boolean resultat = true;
    	for(int i = 0; i < this.listeRues.size(); i++) {
    		Rue rueCourante = this.listeRues.get(i);
    		if(rueCourante.getProprietaire() != joueur) {
    			resultat = false;
    		}
    	}
    	return resultat;
    }
    
    public void setRuesConstructibles() {
    	for(int i = 0; i < this.listeRues.size(); i++) {
    		Rue rueCourante = this.listeRues.get(i);
    		new RueConstructible(rueCourante);
    	}
    }

}