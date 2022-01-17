package monopoly;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner scannerInput = new Scanner(System.in);
		
		System.out.println("---------- Monopoly ----------");
		
		int nbJoueurs = -1;
		
		while (nbJoueurs == -1) {
			
			System.out.print("Nombre de joueurs (de 2 à 4) : ");
			
			int inputValue = scannerInput.nextInt();
			
			if(inputValue > 1 && inputValue <= 4) {
				nbJoueurs = inputValue;
			} else {
				System.out.println("Veuillez entrer une valeur valide (de 2 à 4).");
			}
			
		}
		
		Partie partie = new Partie();
		
		partie.genererPlateau();
		
		partie.debuterPartie(nbJoueurs);
		
		partie.definirOrdre();
		
		int indexJoueur = 0;
		
		while(true) {
			
			Joueur joueurCourant = partie.getListeJoueurs().get(indexJoueur);
			
			System.out.println("\n-------------------- TOUR DE " + joueurCourant.getNom() + " --------------------");
			
			joueurCourant.jouerTour();
			
			ArrayList<Rue> rueConstructibles = partie.getRuesConstructiblesJoueur(joueurCourant);
			
			for (int i = 0; i < rueConstructibles.size(); i++) {
				if(i == 0) {
					System.out.println("Vous pouvez construire sur l'une des rues suivantes car vous possédez le quartier dans lequel elle est :");
				}
				Rue rueCourante = rueConstructibles.get(i);
				System.out.println("   '" + (i+1) + "' - '" + rueCourante.getNom() + "' : " + rueCourante.getNbMaisons() + " maison(s) et " + rueCourante.getNbHotels() + " hotel(s).");
			}
			
			if (rueConstructibles.size() > 0) {
				int numRue = -2;
				
				while (!(numRue == -1 || numRue >= 1 && numRue <= rueConstructibles.size())) {
					System.out.print("Entrez le chiffre correspondant à la rue sur laquelle vous voulez construire (ou -1 si vous ne voulez pas construire) : ");
					numRue = scannerInput.nextInt();
				}
				
				if (numRue != -1) {
					Rue rueAConstruire = rueConstructibles.get(numRue - 1);
					System.out.println("Vous avez décide de construire sur la rue '" + rueAConstruire.getNom() + "'.");
					rueAConstruire.construire(joueurCourant);
				} else {
					System.out.println("Vous avez décidé de ne pas construire.");
				}
			}

			indexJoueur++;
			if(indexJoueur == nbJoueurs) {
				indexJoueur = 0;
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("-------------------- FIN DU TOUR DE " + joueurCourant.getNom() + " --------------------");
			
		}
		
		//scannerInput.close();
		
	}
	
}