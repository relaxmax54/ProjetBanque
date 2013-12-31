/**
* classe qui répertorie les types de comptes :
* null	:	compte courant
* LA	:	Livret A
* LEP	:	Livret d'épargne Populaire
* LDD	:	Livret de Développement Durable
*
*/
class TypeCompte{
    //compteur de comptes général
    
    public static int codeInterne	=-1;
    
    // attributs
    private int compteur;
    private double taux;
    private boolean plafondDepot;
    private double montantPlafond;	
    private boolean accesCompte;
    private double montantRessources;
    
    /**
     *constructeurs des types de comptes
     */
    public TypeCompte(double t,boolean p,double m,boolean a,double r){
	this.compteur			=0;
	this.taux			=t;
	this.plafondDepot		=p;
	this.montantPlafond		=m;
	this.accesCompte		=a;
	this.montantRessources		=r;
    }
    /**
     *permet d'incrémenter les compteur pour les types de compte
     */
    public void incrementerCompteur(){
	this.compteur+=1;
    }
    /**
     * methode par laquelle un type de compte indique la somme
     * maximale qui peut etre depose
     * @return plafond de depot (Double.MAX_VALUE si "illimite")
     */
    public double montantMaximumPlafond(){
	if ((this!=null) && (this.plafondDepot))
	    return this.montantPlafond;
	else		
	    return Double.MAX_VALUE;
    }
    /**
     * methode par laquelle un type de compte indique le plafond
     * maximal de revenus (en fait d’impot sur le revenu)
     * impose a l’ouverture du compte
     * @return plafond de revenus (Double.MAX_VALUE si "illimite")
     */
    public double montantMinimumRessources(TypeCompte tc){
	if ((this!=null) && (this.accesCompte))
	    return this.montantRessources;
	else
	    return Double.MAX_VALUE;
    }
}

