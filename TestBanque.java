/**
 * classe de test pour le projet
 */
public class TestBanque {

	//caractéristiques réglementaires des différents livrets
	final double tauxLA	=1.75;
	final double tauxLDD	=1.75;
	final double tauxLEP	=2.25;
	
	final double plafondLA	=15300;
	final double plafondLDD	=6000;
	final double plafondLEP	=7700;

	final boolean accesLA	=false;
	final boolean accesLDD	=false;
	final boolean accesLEP	=true;

	final double ressourcesLA	=0;
	final double ressourcesLDD	=0;
	final double ressourcesLEP	=757;


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
	* test constructeurs des types de compte
	*/
	public void testTypesDeComptes(){
		//Compte courant
		TypeCompte CC = new TypeCompte();
		
		verifier(0.0,CC.taux, "taux incorrect");
		verifier(false,CC.plafondDepot, "Condition de plafond incorrecte");
		verifier(Double.MAX_VALUE,CC.montantPlafond, "montant plafond incorrect");
		verifier(false,CC.accesCompte, "Condition d'accès incorrecte");
		verifier(Double.MAX_VALUE,CC.montantRessources,"montant de ressources incorrect");

		TypeCompte LA = new TypeCompte(tauxLA,true,plafondLA,accesLA,ressourcesLA);
		
		verifier(tauxLA,LA.taux, "taux incorrect");
		verifier(true,LA.plafondDepot, "Condition de plafond incorrecte");
		verifier(plafondLA,LA.montantPlafond, "montant plafond incorrect");
		verifier(accesLA,LA.accesCompte, "Condition d'accès incorrecte");
		verifier(ressourcesLA,LA.montantRessources,"montant de ressources incorrect");

		TypeCompte LDD = new TypeCompte(tauxLDD,true,plafondLDD,accesLDD,ressourcesLDD);
		
		verifier(tauxLDD,LDD.taux, "taux incorrect");
		verifier(true,LDD.plafondDepot, "Condition de pLDDfond incorrecte");
		verifier(plafondLDD,LDD.montantPlafond, "montant plafond incorrect");
		verifier(accesLDD,LDD.accesCompte, "Condition d'accès incorrecte");
		verifier(ressourcesLDD,LDD.montantRessources,"montant de ressources incorrect");

		TypeCompte LEP = new TypeCompte(tauxLEP,true,plafondLEP,accesLEP,ressourcesLEP);
		
		verifier(tauxLEP,LEP.taux, "taux incorrect");
		verifier(true,LEP.plafondDepot, "Condition de plafond incorrecte");
		verifier(plafondLEP,LEP.montantPlafond, "montant plafond incorrect");
		verifier(accesLEP,LEP.accesCompte, "Condition d'accès incorrecte");
		verifier(ressourcesLEP,LEP.montantRessources,"montant de ressources incorrect");

		/**
		* test des méthodes demandées pour le type de compte
		*/

		verifier(Double.MAX_VALUE,CC.montantPlafond,"Valeur incorrecte");
		verifier(plafondLA,LA.montantPlafond,"Valeur incorrecte");
		verifier(plafondLDD,LDD.montantPlafond,"Valeur incorrecte");
		verifier(plafondLEP,LEP.montantPlafond,"Valeur incorrecte");

		verifier(Double.MAX_VALUE,CC.montantRessources,"Valeur incorrecte");
		verifier(ressourcesLA,LA.montantRessources,"Valeur incorrecte");
		verifier(ressourcesLDD,LDD.montantRessources,"Valeur incorrecte");
		verifier(ressourcesLEP,LEP.montantRessources,"Valeur incorrecte");
	}
	/**
	* test constructeurs des types de compte
	*/	

	/**
	* test constructeurs des types de compte
	*/

	/**
	* test constructeurs des types de compte
	*/

	/**
	 * Lancement des tests
	 * 
	 * @param args
	 *            inutile
	 */
	public static void main(String[] args) {
		LanceurProjet.lanceAvecInterface(new TestBanque());
	}
}
