/**
* classe qui répertorie les types de comptes :
* CC	:	compte courant
* LEP	:	Livret d'épargne Populaire
* LDD	:	Livret de Développement Durable
*
*/
class TypeCompte{
	//caractéristiques réglementaires des différents livrets
	final float tauxLA	=1.75;
	final float tauxLDD	=1.75;
	final float tauxLEP	=2.25;
	
	final int plafondLA	=15300;
	final int plafondLDD	=6000;
	final int plafondLEP	=7700;

	final boolean accesLA	=false;
	final boolean accesLDD	=false;
	final boolean accesLEP	=true;

	final int ressourcesLA	=0;
	final int ressourcesLDD	=0;
	final int ressourcesLEP	=757;

	//compteur de comptes crées pour identification unique par type de compte
	
	public static int compteurCC	=0;
	public static int compteurLA	=0;
	public static int compteurLEP	=0;
	public static int compteurLDD	=0;

	//compteur de comptes général

	public int codeInterne		=0;

	// attributs

	public float taux;
	public boolean plafondDepot;
	public int montantPlafond;	
	public boolean accesCompte;
	public int montantRessources;
	
	/**
	*constructeurs de comptes
	*/

	// compte courant :
	private static TypeCompte(){
		compteurCC++;
		codeInterne++;
		this.taux=0;
		this.plafondDepot=false;
		this.montantDepot=0;
		this.accesCompte=false;
		this.montantRessources=0;
	}
	// Autres comptes :
	private static TypeCompte(float t,boolean p,int m,boolean a,int r,int c){
		switch(c){
		case 1
			compteurLA++;
			break;
		case 2
			compteurLEP++;			
			break;
		case 3
			compteurLEP++;
			break;
		default
			break;
		}		
		compteur
		codeInterne++;
		this.taux=t;
		this.plafondDepot=p;
		this.montantDepot=m
		this.accesCompte=a;
		this.montantRessources=r;
	}
}		
