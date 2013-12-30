class Compte{
//attributs
	private Client titulaire;
	private TypeCompte type;
	private double solde;
	private int numeroDeCompte;

/**
* getter
*/
	public Client getTitulaire(){
		return this.titulaire;
	}
	public TypeCompte getType(){
		return this.type;
	}
	public double getSolde(){
		return this.solde;
	}
	public int getNumeroDeCompte(){
		return this.numeroDeCompte;
	}
/**
* constructeur général : crée un compte de type et de titulaire connus
* le compte est muni d'un numéro qui lui est réservé (égal au nombre
* de comptes déjà créés par la banque),
* et son solde initial est nul
*
* @param tc type de compte désiré (si null, alors simple compte chèque)
* @param cl client titulaire du compte (si null, alors titulaire est nul, type de compte est nul, solde initial est nul et numéro de compte est -1)
*/






	public Compte(TypeCompte tc,Client cl){
		if(cl==null){
			this.type=null;
			this.titulaire=null;
			this.numeroDeCompte=-1;
		}else{
			this.titulaire=cl;
			if(tc=null)
				
			this.type=tc;
			this.numeroDeCompte=TypeCompte.codeInterne;
		}
		this.solde=0;
	}






}