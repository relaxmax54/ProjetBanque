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
     * test constructeurs des types de compte
     */
    public void testTypesDeComptes(){
	verifier(0,TypeCompte.LA.compteur,"compteur non initialisé");
	verifier(TypeCompte.tauxLA,TypeCompte.LA.taux, "taux incorrect");
	verifier(true,TypeCompte.LA.plafondDepot, "Condition de plafond incorrecte");
	verifier(TypeCompte.accesLA,TypeCompte.LA.accesCompte, "Condition d'accès incorrecte");
	verifier(TypeCompte.ressourcesLA,TypeCompte.LA.montantMinimumRessources(), "montant de ressources incorrect");
	
	verifier(0,TypeCompte.LDD.compteur,"compteur non initialisé");
	verifier(TypeCompte.tauxLDD,TypeCompte.LDD.taux, "taux incorrect");
	verifier(true,TypeCompte.LDD.plafondDepot, "Condition de pLDDfond incorrecte");
	verifier(TypeCompte.accesLDD,TypeCompte.LDD.accesCompte, "Condition d'accès incorrecte");
	verifier(TypeCompte.ressourcesLDD,TypeCompte.LDD.montantMinimumRessources(), "montant de ressources incorrect");
	
	verifier(0,TypeCompte.LEP.compteur,"compteur non initialisé");
	verifier(TypeCompte.tauxLEP,TypeCompte.LEP.taux, "taux incorrect");
	verifier(true,TypeCompte.LEP.plafondDepot, "Condition de plafond incorrecte");
	verifier(TypeCompte.accesLEP,TypeCompte.LEP.accesCompte, "Condition d'accès incorrecte");
	verifier(TypeCompte.ressourcesLEP,TypeCompte.LEP.montantMinimumRessources(), "montant de ressources incorrect");
    }
    /**
     * test montantMaximumPlafond
     */
    public void testmontantMaximumPlafond(){
	verifier(TypeCompte.plafondLA,TypeCompte.LA.montantMaximumPlafond(), "montant plafond incorrect");
	verifier(TypeCompte.plafondLDD,TypeCompte.LDD.montantMaximumPlafond(), "montant plafond incorrect");
	verifier(TypeCompte.plafondLEP,TypeCompte.LEP.montantMaximumPlafond(), "montant plafond incorrect");
	verifier(Double.MAX_VALUE,TypeCompte.CC.montantMaximumPlafond(), "montant plafond incorrect");
    }

    /**
     *test tableau des comptes potentiels
     *@param montant_a_deposer : montant à déposer sur le compte
     */
    public void testTableau(){
	verifier(null,TypeCompte.tableauDesComptesPotentiels(-1)[0],"Mauvais compte");
	verifier(TypeCompte.LEP,TypeCompte.tableauDesComptesPotentiels(5500)[1],"Mauvais compte");
	verifier(null,TypeCompte.tableauDesComptesPotentiels(8000)[2],"Mauvais compte");
	verifier(null,TypeCompte.tableauDesComptesPotentiels(16000)[3],"Mauvais compte");
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
	verifier(0,cc.getNumeroDeCompte(),"Mauvais numéro de compte");
	verifier(0,c.comptes[0],"Mauvais numéro de compte dans le tableau");
	verifier(1,c.nb_comptes,"Mauvais nombre de comptes ouverts");
	// nombre de comptes courant existant a été incrémenté
	verifier(0,TypeCompte.codeInterne,"Mauvaise incrémentation des comptes en général");
    }
    /**
     * test constructeurs des types de compte
     */
    public void testdepot(){
	//création d'un nouveau compte courant
	Client c=new Client("Maxime","FRIEH");
	Compte cc=new Compte(null,c);
	Compte lep=new Compte(TypeCompte.LEP,c);
	Compte ldd=new Compte(TypeCompte.LDD,c);
	Compte la=new Compte(TypeCompte.LA,c);
	verifier(0,cc.depot(20000),"Mauvais montant retourné");
	verifier(12300,lep.depot(20000),"Mauvais montant retourné");
	verifier(14000,ldd.depot(20000),"Mauvais montant retourné");
	verifier(4700,la.depot(20000),"Mauvais montant retourné");
    }
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
