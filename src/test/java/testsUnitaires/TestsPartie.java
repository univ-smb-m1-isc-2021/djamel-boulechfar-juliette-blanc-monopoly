package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import monopoly.Joueur;
import monopoly.Partie;

class TestsPartie {

	@Test
	void testNbJoueurs() {
		Partie partie = new Partie();
		ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
		listeJoueurs.add(new Joueur());
		listeJoueurs.add(new Joueur());
		listeJoueurs.add(new Joueur());
		partie.ajouterJoueurs(listeJoueurs);
		assert(partie.getListeJoueurs().size() == 3);
	}

}
