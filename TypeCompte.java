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
    
    public static int codeInterne =-1;
    
    // attributs
    public int compteur;
    public double taux;
    public boolean plafondDepot;
    public double montantPlafond;	
    public boolean accesCompte;
    public double montantRessources;
    
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
    public double montantMinimumRessources(){
	if ((this!=null) && (this.accesCompte))
	    return this.montantRessources;
	else
	    return Double.MAX_VALUE;
    }
}

