/*
 * Classe Client
 */
public class Client{
    
    final static int NB_MAX_COMPTES=10;
    
    //attributs
    public String nom,prenom;
    public Compte[] comptes;
    public int nb_comptes;
    public int impots;
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
	    if ((tc.plafondDeRevenus()==Double.MAX_VALUE) || (this.impots!=-1 && (this.impots<=tc.plafondDeRevenus())) && (this.nb_comptes<NB_MAX_COMPTES)){
		this.comptes[nb_comptes]=new Compte(tc,this);
		this.nb_comptes+=1;
	   } 
	}
    }
    /**
     * methode qui recherche dans les comptes ouverts par un client
     * le compte dont le numero est donne
     * @param num_compte numero de compte cherche
     * @return compte correspondant (null si le client n’a ouvert aucun compte
     * ayant ce numero)
     */
    public Compte retrouverCompte(int num_numero){
	int i=0;
	while (i<this.nb_comptes-1 && comptes[i].getNumeroDeCompte()!=num_numero){
	     i++;
	}
	if (i==nb_comptes)
	    return null;
	else
	    return comptes[i];
    }
}
