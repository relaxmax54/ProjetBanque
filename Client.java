/*
 * Classe Client
 */
public class Client{
    
    final static int NB_MAX_COMPTES=10;
    
    //attributs
    String nom,prenom;
    Compte[] comptes;
    int nb_comptes;
    int impots;
    /**
     * constructeur général : client dont le nom et le prénom sont donnés
     * il ne dispose d'aucun compte initialement, et le montant
     * de son impot sur le revenu est a priori inconnu (fixé a -1)
     *
     * @param n nom du client
     * @param p prénom du client
     */
    public Client(String p,String n){
	this.nom=n;
	this.prenom=p;
	this.nb_comptes=0;
	this.impots=-1;
	this.comptes=new Compte[NB_MAX_COMPTES];
    }
    /**
     * méthode exécutée par un client pour indiquer le montant
     * de son dernier impot sur le revenu
     * @param IR montant de l'impot sur le revenu payé (positif ou nul)
     */
    public void declarerImpots(int IR){
	this.impots=IR;
    }
    /**
     * méthode qui permet d'ouvrir un nouveau compte de Type de Compte tc à partir d'une instance de la classe Client
     *
     * on vérifie que tc n'est pas null et dans ce cas seulement on s'assure que les critères sont cohérents avec l'ouverture de ce nouveau compte
     * plafond de ressources : soit il est illimité soit le client en rempli les critères
     * le nombre maximum de comptes : le nombre de comptes ouvert par le client ne dépasse pas le nombre maximum autorisé
     * @param tc type de compte à ouvrir
     */
    public void ouvreNouveauCompte(TypeCompte tc) {
	if (tc!=null) {
	    if ((tc.plafondRevenus()==Double.MAX_VALUE) || (impots!=-1 && (impots<=tc.plafondRevenus())) && (nb_comptes<NB_MAX_COMPTES)){
		comptes[nb_comptes]=new Compte(tc,this);
		nb_comptes=nb_comptes+1;
	    }
	}
    }
}
