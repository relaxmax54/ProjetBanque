/*
 * Classe Client
 */
public class Client{
    final static int NB_MAX_COMPTES=10;
    
    //attributs
    String nom,prenom;
    int[] comptes;
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
	this.comptes=new int[NB_MAX_COMPTES];
    }
    /**
     * méthode exécutée par un client pour indiquer le montant
     * de son dernier impot sur le revenu
     * @param IR montant de l'impot sur le revenu payé (positif ou nul)
     */
    public void declarerImpots(int IR){
	this.impots=IR;
    }
}
