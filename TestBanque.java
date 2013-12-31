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
		TypeCompte LA = new TypeCompte(tauxLA,true,plafondLA,accesLA,ressourcesLA);
		
		verifier(0,LA.compteur,"compteur non initialisé");
		verifier(tauxLA,LA.taux, "taux incorrect");
		verifier(true,LA.plafondDepot, "Condition de plafond incorrecte");
		verifier(plafondLA,LA.montantPlafond, "montant plafond incorrect");
		verifier(accesLA,LA.accesCompte, "Condition d'accès incorrecte");
		verifier(ressourcesLA,LA.montantRessources,"montant de ressources incorrect");

		TypeCompte LDD = new TypeCompte(tauxLDD,true,plafondLDD,accesLDD,ressourcesLDD);
		
		verifier(0,LDD.compteur,"compteur non initialisé");
		verifier(tauxLDD,LDD.taux, "taux incorrect");
		verifier(true,LDD.plafondDepot, "Condition de pLDDfond incorrecte");
		verifier(plafondLDD,LDD.montantPlafond, "montant plafond incorrect");
		verifier(accesLDD,LDD.accesCompte, "Condition d'accès incorrecte");
		verifier(ressourcesLDD,LDD.montantRessources,"montant de ressources incorrect");

		TypeCompte LEP = new TypeCompte(tauxLEP,true,plafondLEP,accesLEP,ressourcesLEP);

		verifier(0,LEP.compteur,"compteur non initialisé");
		verifier(tauxLEP,LEP.taux, "taux incorrect");
		verifier(true,LEP.plafondDepot, "Condition de plafond incorrecte");
		verifier(plafondLEP,LEP.montantPlafond, "montant plafond incorrect");
		verifier(accesLEP,LEP.accesCompte, "Condition d'accès incorrecte");
		verifier(ressourcesLEP,LEP.montantRessources,"montant de ressources incorrect");

		/**
		* test des méthodes demandées pour le type de compte
		*/
		verifier(plafondLA,LA.montantPlafond,"Valeur incorrecte");
		verifier(plafondLDD,LDD.montantPlafond,"Valeur incorrecte");
		verifier(plafondLEP,LEP.montantPlafond,"Valeur incorrecte");

		verifier(ressourcesLA,LA.montantRessources,"Valeur incorrecte");
		verifier(ressourcesLDD,LDD.montantRessources,"Valeur incorrecte");
		verifier(ressourcesLEP,LEP.montantRessources,"Valeur incorrecte");
	}
	/**
	* test constructeurs de comptes
	*/	
	public void testComptes(){
		//création d'un nouveau compte courant
		Client c=new Client("Maxime","FRIEH");
		Compte cc=new Compte(null,c);
		verifier(c,cc.getTitulaire(),"Mauvais titulaire");
		verifier(0.0,cc.getSolde(),"Mauvais solde de départ");
		verifier(null,cc.getType(),"Mauvais type de compte");
		verifier(0.0,cc.getType().taux,"Mauvais taux");
		//verifier(false,ccc.getType().plafondDepot,"Mauvaise condition de plafond");
		//verifier(Double.MAX_VALUE,ccc.getType().montantPlafond,"Mauvais montant de plafond");
		//verifier(false,ccc.getType().accesCompte,"Mauvaise condition de ressources");
		//verifier(Double.MAX_VALUE,ccc.getType().montantRessources,"Mauvais montant de condition de ressources");
		// nombre de comptes courant existant a été incrémenté
		//verifier(1,TypeCompte.compteurCC,"Mauvaise incrémentation des comptes CC");
		// codeinterne des comptes a bien été incrémenté
		//verifier(1,TypeCompte.codeInterne,"Mauvaise incrémentation des comptes en général");
	}
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
