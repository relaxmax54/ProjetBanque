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
    public void test_1_Client() {

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
    public void test_2_TypesDeComptes(){
	verifier(0,TypeCompte.LA.compteur,"compteur non initialisé");
	verifier(TypeCompte.tauxLA,TypeCompte.LA.taux, "taux incorrect");
	verifier(true,TypeCompte.LA.plafondDepot, "Condition de plafond incorrecte");
	verifier(TypeCompte.accesLA,TypeCompte.LA.accesCompte, "Condition d'accès incorrecte");
	verifier(TypeCompte.ressourcesLA,TypeCompte.LA.plafondRevenus(), "montant de ressources incorrect");
	
	verifier(0,TypeCompte.LDD.compteur,"compteur non initialisé");
	verifier(TypeCompte.tauxLDD,TypeCompte.LDD.taux, "taux incorrect");
	verifier(true,TypeCompte.LDD.plafondDepot, "Condition de pLDDfond incorrecte");
	verifier(TypeCompte.accesLDD,TypeCompte.LDD.accesCompte, "Condition d'accès incorrecte");
	verifier(TypeCompte.ressourcesLDD,TypeCompte.LDD.plafondRevenus(), "montant de ressources incorrect");
	
	verifier(0,TypeCompte.LEP.compteur,"compteur non initialisé");
	verifier(TypeCompte.tauxLEP,TypeCompte.LEP.taux, "taux incorrect");
	verifier(true,TypeCompte.LEP.plafondDepot, "Condition de plafond incorrecte");
	verifier(TypeCompte.accesLEP,TypeCompte.LEP.accesCompte, "Condition d'accès incorrecte");
	verifier(TypeCompte.ressourcesLEP,TypeCompte.LEP.plafondRevenus(), "montant de ressources incorrect");
    }
    /**
     * test montantMaximumPlafond
     */
    public void test_3_MontantMaximumPlafond(){
	verifier(TypeCompte.plafondLA,TypeCompte.LA.montantMaximumPlafond(), "montant plafond incorrect");
	verifier(TypeCompte.plafondLDD,TypeCompte.LDD.montantMaximumPlafond(), "montant plafond incorrect");
	verifier(TypeCompte.plafondLEP,TypeCompte.LEP.montantMaximumPlafond(), "montant plafond incorrect");
	verifier(Double.MAX_VALUE,TypeCompte.CC.montantMaximumPlafond(), "montant plafond incorrect");
    }

    /**
     *test tableau des comptes potentiels
     *@param montant_a_deposer : montant à déposer sur le compte
     */
    public void test_4_Tableau(){
	verifier(null,TypeCompte.tableauDesComptesPotentiels(-1)[0],"Mauvais compte");
	verifier(TypeCompte.LEP,TypeCompte.tableauDesComptesPotentiels(5500)[1],"Mauvais compte");
	verifier(null,TypeCompte.tableauDesComptesPotentiels(8000)[2],"Mauvais compte");
	verifier(null,TypeCompte.tableauDesComptesPotentiels(16000)[3],"Mauvais compte");
    }
    /**
     * test constructeurs de comptes
     */	
    public void test_5_Comptes(){
	//création d'un nouveau compte courant
	Client c=new Client("Maxime","FRIEH");
	Compte cc=new Compte(TypeCompte.CC,c);
	//vérifier les paramètres du compte crée
	verifier(c,cc.getTitulaire(),"Mauvais titulaire");
	verifier(0.0,cc.getSolde(),"Mauvais solde de départ");
	verifier(TypeCompte.CC,cc.getType(),"Mauvais type de compte");
	verifier(0,cc.getNumeroDeCompte(),"Mauvais numéro de compte");
	// nombre de comptes courant existant a été incrémenté
	verifier(0,TypeCompte.codeInterne,"Mauvaise incrémentation des comptes en général");
    }
    /**
     * test des méthodes pour le dép^ot ou le retrait d'argent sur un compte
     */
    public void test_6_MouvementsDeCompte(){
	//création d'un nouveau compte courant
	Client c=new Client("Maxime","FRIEH");
	Compte cc=new Compte(TypeCompte.CC,c);
	Compte lep=new Compte(TypeCompte.LEP,c);
	Compte ldd=new Compte(TypeCompte.LDD,c);
	Compte la=new Compte(TypeCompte.LA,c);
	// test de la méthode de depot d'argent
	verifier(0.0,cc.depot(20000),"Mauvais montant retourné");
	verifier(12300.0,lep.depot(20000),"Mauvais montant retourné");
	verifier(14000.0,ldd.depot(20000),"Mauvais montant retourné");
	verifier(4700.0,la.depot(20000),"Mauvais montant retourné");
	// test de la méthode de retrait d'argent
	verifier(20000.0,cc.retrait(20000),"Mauvais montant retourné");
	verifier(7700.0,lep.retrait(20000),"Mauvais montant retourné");
	verifier(6000.0,ldd.retrait(20000),"Mauvais montant retourné");
	verifier(15300.0,la.retrait(20000),"Mauvais montant retourné");
    }
    /**
     * test de la méthode d'ouverture de compte directement à partir du client
     */
    public void test_7_ouvreNouveauCompte(){
	//création d'un nouveau client
	Client c=new Client("Maxime","FRIEH");
	c.declarerImpots(800);
	//récupération des données de base
	int code=TypeCompte.codeInterne;
	int comptes = c.nb_comptes;

	//tests

	// vérifier bypass si tc null
	c.ouvreNouveauCompte(null);
	verifier(code,TypeCompte.codeInterne,"Incrémentation injustifiée");
	verifier(comptes,c.nb_comptes,"Compte ajouté au tableau par erreur");

	// vérifier bypass si critères non restectés
	c.ouvreNouveauCompte(TypeCompte.LEP);
	verifier(code,TypeCompte.codeInterne,"Incrémentation injustifiée");
	verifier(comptes,c.nb_comptes,"Compte ajouté au tableau par erreur");

	// vérifier création du compte si critères restectés
	c.declarerImpots(700);
	c.ouvreNouveauCompte(TypeCompte.LEP);
	verifier(code+1,TypeCompte.codeInterne,"Absence d'incrémentation");
	verifier(comptes+1,c.nb_comptes,"Compte non ajouté au tableau");
	verifier(TypeCompte.LEP,c.comptes[c.nb_comptes-1].getType(),"Mauvais type de compte ajouté");
    }
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
// impossible de verifier la référence des comptes enregstrés dans le tableau
