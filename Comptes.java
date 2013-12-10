class Compte{
//attributs
	private Client titulaire;
	



/**
* constructeur général : crée un compte de type et de titulaire connus
* le compte est muni d'un numéro qui lui est réservé (égal au nombre
* de comptes déjà créés par la banque),
* et son solde initial est nul
*
* @param tc type de compte désiré (si null, alors simple compte chèque)
* @param cl client titulaire du compte (si null, alors titulaire est nul, type de compte est nul, solde initial est nul et numéro de compte est -1)
*/
public Compte(Compte tc,Client cl){
	this.Client=cl;
	this.=tc;
}