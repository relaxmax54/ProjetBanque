/**
* classe qui répertorie les types de comptes :
* CC	:	compte courant
* LEP	:	Livret d'épargne Populaire
* LDD	:	Livret de Développement Durable
*
*/
class TypeCompte{
	//compteur de comptes crées pour identification unique par type de compte
	
	public static int compteurCC	=0;
	public static int compteurLA	=0;
	public static int compteurLDD	=0;
	public static int compteurLEP	=0;

	//compteur de comptes général

	public static int codeInterne	=0;

	// attributs

	public double taux;
	public boolean plafondDepot;
	public double montantPlafond;	
	public boolean accesCompte;
	public double montantRessources;
	
	/**
	*constructeurs des types de comptes
	*/
	public TypeCompte(){
		//Compte Courant
		this.taux		=0.0;
		this.plafondDepot	=false;
		this.montantPlafond	=Double.MAX_VALUE;
		this.accesCompte	=false;
		this.montantRessources	=Double.MAX_VALUE;
	}
	// Autres comptes :
	public TypeCompte(double t,boolean p,double m,boolean a,double r){
		this.taux		=t;
		this.plafondDepot	=p;
		this.montantPlafond	=m;
		this.accesCompte	=a;
		this.montantRessources	=r;
	}
	/**
	* methode par laquelle un type de compte indique la somme
	* maximale qui peut etre depose
	* @return plafond de depot (Double.MAX_VALUE si "illimite")
	*/
	public double retourneMontantMaximumPlafond(TypeCompte tc){
		if (tc.plafondDepot)
			return tc.montantPlafond;
		else		
			return Double.MAX_VALUE;
	}
	/**
	* methode par laquelle un type de compte indique le plafond
	* maximal de revenus (en fait d’impot sur le revenu)
	* impose a l’ouverture du compte
	* @return plafond de revenus (Double.MAX_VALUE si "illimite")
	*/
	public double retourneMontantRessourcesMinimum(TypeCompte tc){
		if (tc.accesCompte)
			return tc.montantRessources;
		else
			return Double.MAX_VALUE;
	}
}

