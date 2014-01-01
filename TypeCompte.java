/**
* classe qui répertorie les types de comptes :
* CC	:	compte courant
* LA	:	Livret A
* LEP	:	Livret d'épargne Populaire
* LDD	:	Livret de Développement Durable
*
*/
class TypeCompte{
    //caractéristiques réglementaires des différents livrets
    static final double tauxLA	=1.75;
    static final double tauxLDD	=1.75;
    static final double tauxLEP	=2.25;
    
    static final double plafondLA	=15300;
    static final double plafondLDD	=6000;
    static final double plafondLEP	=7700;
    
    static final boolean accesLA	=false;
    static final boolean accesLDD	=false;
    static final boolean accesLEP	=true;
    
    static final double ressourcesLA	=Double.MAX_VALUE;
    static final double ressourcesLDD	=Double.MAX_VALUE;
    static final double ressourcesLEP	=757;
    
    //compteur de comptes général
    
    public static int codeInterne =-1;
    
    // attributs
    public int compteur;
    public double taux;
    public boolean plafondDepot;
    public double montantPlafond;	
    public boolean accesCompte;
    public double montantRessources;

    public static final TypeCompte LEP = new TypeCompte(TypeCompte.tauxLEP,true,TypeCompte.plafondLEP,TypeCompte.accesLEP,TypeCompte.ressourcesLEP);
    public static final TypeCompte LDD = new TypeCompte(TypeCompte.tauxLDD,true,TypeCompte.plafondLDD,TypeCompte.accesLDD,TypeCompte.ressourcesLDD);
    public static final TypeCompte LA = new TypeCompte(TypeCompte.tauxLA,true,TypeCompte.plafondLA,TypeCompte.accesLA,TypeCompte.ressourcesLA);	
    public static final TypeCompte CC = new TypeCompte(0.0,false,Double.MAX_VALUE,false,Double.MAX_VALUE);
    
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
	if (this.plafondDepot)
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
    public double plafondRevenus(){
	if (this.accesCompte)
	    return this.montantRessources;
	else
	    return Double.MAX_VALUE;
    }
    /**
     * methode de classe donnant dans un tableau tous les types de comptes
     * qu’il est possible d’ouvrir, etant donne un montant maximum a deposer
     * @param  montant_a_deposer montant qu’on souhaite deposer sur le compte
     * (-1 si sans importance)
     * @return tableau contenant tous les types de comptes qu’il est
     * possible d’ouvrir
     */
    public static TypeCompte[] tableauDesComptesPotentiels(double montant_a_deposer){
	TypeCompte[] tableau = new TypeCompte[4];
	tableau[0]=null; //quelque soit le montant à déposer, le compte courant est toujours éligible
	if(LEP.montantMaximumPlafond()>=montant_a_deposer || montant_a_deposer==-1)
	    tableau[1]=LEP;
	else
	    tableau[1]=null;
	if(LDD.montantMaximumPlafond()>=montant_a_deposer || montant_a_deposer==-1)
	    tableau[2]=LDD;
	else
	    tableau[2]=null;
	if(LA.montantMaximumPlafond()>=montant_a_deposer || montant_a_deposer==-1)
	    tableau[3]=LA;
	else
	    tableau[3]=null;
	return tableau;
    }
}
// quel intéret pour montantMinimumRessources et montantMaximumPlafond ?
// attributs TypeCompte à mettre en final ?
