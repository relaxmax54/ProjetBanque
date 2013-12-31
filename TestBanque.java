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

	final double ressourcesLA	=Double.MAX_VALUE;
	final double ressourcesLDD	=Double.MAX_VALUE;
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
	* test constructeurs des types de compte et des méthodes demandées
	*/
	public void testTypesDeComptes(){
		//Compte courant
		TypeCompte LA = new TypeCompte(tauxLA,true,plafondLA,accesLA,ressourcesLA);
		
		//verifier(0,LA.compteur,"compteur non initialisé");
		//verifier(tauxLA,LA.taux, "taux incorrect");
		//verifier(true,LA.plafondDepot, "Condition de plafond incorrecte");
		verifier(plafondLA,LA.montantMaximumPlafond(), "montant plafond incorrect");
		//verifier(accesLA,LA.montantMinimumRessources, "Condition d'accès incorrecte");
		verifier(ressourcesLA,LA.montantMinimumRessources(), "montant de ressources incorrect");

		TypeCompte LDD = new TypeCompte(tauxLDD,true,plafondLDD,accesLDD,ressourcesLDD);
		
		//verifier(0,LDD.compteur,"compteur non initialisé");
		//verifier(tauxLDD,LDD.taux, "taux incorrect");
		//verifier(true,LDD.plafondDepot, "Condition de pLDDfond incorrecte");
		verifier(plafondLDD,LDD.montantMaximumPlafond(), "montant plafond incorrect");
		//verifier(accesLDD,LDD.accesCompte, "Condition d'accès incorrecte");
		verifier(ressourcesLDD,LDD.montantMinimumRessources(), "montant de ressources incorrect");

		TypeCompte LEP = new TypeCompte(tauxLEP,true,plafondLEP,accesLEP,ressourcesLEP);

		//verifier(0,LEP.compteur,"compteur non initialisé");
		//verifier(tauxLEP,LEP.taux, "taux incorrect");
		//verifier(true,LEP.plafondDepot, "Condition de plafond incorrecte");
		verifier(plafondLEP,LEP.montantMaximumPlafond(), "montant plafond incorrect");
		//verifier(accesLEP,LEP.accesCompte, "Condition d'accès incorrecte");
		verifier(ressourcesLEP,LEP.montantMinimumRessources(), "montant de ressources incorrect");
	}
	/**
	* test constructeurs de comptes
	*/	
	public void testComptes(){
		//création d'un nouveau compte courant
		Client c=new Client("Maxime","FRIEH");
		Compte cc=new Compte(null,c);
		//vérifier les paramètres du compte crée
		verifier(c,cc.getTitulaire(),"Mauvais titulaire");
		verifier(0.0,cc.getSolde(),"Mauvais solde de départ");
		verifier(null,cc.getType(),"Mauvais type de compte");
		verifier(-1,cc.getNumeroDeCompte(),"Mauvais numéro de compte");
		//Tests impossibles car compilateur n'aime pas appliquer des méthodes à un objet null
		//verifier(Double.MAX_VALUE,cc.getType().montantMinimumRessources(),"Mauvais montant de condition de ressources");
		//verifier(Double.MAX_VALUE,cc.getType().montantMaximumPlafond(),"Mauvais montant de plafond");
		// nombre de comptes courant existant a été incrémenté
		verifier(0,TypeCompte.codeInterne,"Mauvaise incrémentation des comptes en général");
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
