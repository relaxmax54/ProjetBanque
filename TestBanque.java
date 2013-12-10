/**
 * classe de test pour le projet
 */
public class TestBanque {

	/**
	 * methode verifier
	 * comme Lanceur.assertEquals mais plus rapide a ecrire
	 */
	public void verifier(Object attendu, Object obtenu, String erreur) {
		LanceurProjet.assertEquals(attendu, obtenu, erreur);
	}
	/**
	 * test constructeur avec param
	 */
	public void testClient() {
		//test
 		Client c = new Client("Maxime","FRIEH");

		verifier("Maxime",c.prenom, "Prenom incorrect");
		verifier("FRIEH",c.nom, "Nom incorrect");
		verifier(0,c.nb_comptes, "nombre de comptes incorrect");
		verifier(-1,c.impots, "montant des revenus incorrect");
		verifier(10,c.comptes.length,"Erreur tableau des comptes");
	}
	
	/**
	 * lancement des tests
	 * 
	 * @param args
	 *            inutile
	 */
	public static void main(String[] args) {
		LanceurProjet.lanceAvecInterface(new TestBanque());
	}

}
