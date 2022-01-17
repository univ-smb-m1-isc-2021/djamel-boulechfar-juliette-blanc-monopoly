package monopoly;

import java.util.ArrayList;

public class Plateau {
	
	ArrayList<Case> listeCases;
	
	// Constructeurs
	
	public Plateau() {
		this.listeCases = new ArrayList<Case>();
	}
	
	// Méthodes
	
	/* Getters et setters */
	
	public void setListeCases(ArrayList<Case> listeCases) {
		this.listeCases = listeCases;
	}
	
	public ArrayList<Case> getListeCases() {
		return listeCases;
	}
	
	/* ------------------ */

    public void genererCases() {
    	
    	CaseDepart caseDepart = new CaseDepart();
    	
    	Quartier quartierBleu = new Quartier("Bleu");
    	Quartier quartierBlanc = new Quartier("Blanc");
    	Quartier quartierRouge = new Quartier("Rouge");
    	
    	Rue rueDeLaPaix = new Rue(1, "RUE DE LA PAIX", 400, quartierBleu);
    	
    	Gare gareMontparnasse = new Gare(2, "GARE MONTPARNASSE", 200);
    	
    	Rue rueDeVaugirard = new Rue(3, "RUE DE VAUGIRARD", 100, quartierBlanc);
    	
    	Service serviceDesEaux = new Service(4, "SERVICE DES EAUX", 150);
    	
    	Rue rueDeParadis = new Rue(5, "RUE DE PARADIS", 160, quartierRouge);
    	
    	Gare gareDeLyon = new Gare(6, "GARE DE LYON", 200);
    	
    	Rue rueChampsElysees = new Rue(7, "AVENUE DES CHAMPS-ELYSEES", 350, quartierBleu);
    	
    	Rue rueAvenueRepublique = new Rue(8, "AVENUE DE LA REPUBLIQUE", 120, quartierBlanc);
    	
    	Rue rueAvenueNeuilly = new Rue(9, "AVENUE DE NEUILLY", 140, quartierRouge);
    	
    	Gare gareDuNord = new Gare(10, "GARE DU NORD", 200);
    	
    	Rue rueAvenueFoch = new Rue(11, "AVENUE FOCH", 300, quartierBleu);
    	
    	Service serviceElectricite = new Service(12, "SERVICE DE L'ELECTRICITE", 150);
    	
    	Rue rueDesCourcelles = new Rue(13, "RUE DES COURCELLES", 100, quartierBlanc);
    	
    	Gare gareSaintLazare = new Gare(14, "GARE SAINT-LAZARE", 200);
    	
    	Rue rueBoulevardVillette = new Rue(15, "BOULEVARD DE LA VILLETTE", 140, quartierRouge);
    	
    	quartierBleu.getListeRues().add(rueDeLaPaix);
    	quartierBleu.getListeRues().add(rueChampsElysees);
    	quartierBleu.getListeRues().add(rueAvenueFoch);
    	
    	quartierBlanc.getListeRues().add(rueDeVaugirard);
    	quartierBlanc.getListeRues().add(rueAvenueRepublique);
    	quartierBlanc.getListeRues().add(rueDesCourcelles);
    	
    	quartierRouge.getListeRues().add(rueDeParadis);
    	quartierRouge.getListeRues().add(rueAvenueNeuilly);
    	quartierRouge.getListeRues().add(rueBoulevardVillette);
    	
    	this.listeCases.add(caseDepart);this.listeCases.add(rueDeLaPaix);this.listeCases.add(gareMontparnasse);this.listeCases.add(rueDeVaugirard);
    	this.listeCases.add(serviceDesEaux);this.listeCases.add(rueDeParadis);this.listeCases.add(gareDeLyon);this.listeCases.add(rueChampsElysees);
    	this.listeCases.add(rueAvenueRepublique);this.listeCases.add(rueAvenueNeuilly);this.listeCases.add(gareDuNord);this.listeCases.add(rueAvenueFoch);
    	this.listeCases.add(serviceElectricite);this.listeCases.add(rueDesCourcelles);this.listeCases.add(gareSaintLazare);this.listeCases.add(rueBoulevardVillette);
    	
    }
    
    public Case allerSur(int indexCase) {
    	return this.listeCases.get(indexCase % 16);
    }

    public ArrayList<Rue> getRuesConstructiblesJoueur(Joueur joueur) {
    	ArrayList<Rue> listeRuesConstructibles = new ArrayList<Rue>();
    	for(int i = 0; i < listeCases.size(); i++) {
    		Case caseCourante = listeCases.get(i);
    		if(caseCourante instanceof Rue) {
    			Rue rueCourante = (Rue) caseCourante;
    			if(rueCourante.getEtatRue() instanceof RueConstructible || rueCourante.getEtatRue() instanceof RueExploitee) {
    				if(rueCourante.getProprietaire() == joueur) {
    					if(rueCourante.getNbHotels() < 1) {
    						listeRuesConstructibles.add((Rue)caseCourante);
    					}
        			}
    			}
    		}
    	}
    	return listeRuesConstructibles;
    }

}