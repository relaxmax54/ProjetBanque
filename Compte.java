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
	//on incrémente le nombre total de comptes créés
	TypeCompte.codeInterne+=1;
	
	if(cl!=null){
	    if (cl.nb_comptes<Client.NB_MAX_COMPTES){
		this.numeroDeCompte=TypeCompte.codeInterne;
		cl.nb_comptes+=1;
		cl.comptes[cl.nb_comptes-1]=TypeCompte.codeInterne;
	    }
	    if (tc==null)
		this.type=TypeCompte.CC;
	    else
		this.type=tc;
	    this.type.compteur+=1;	    
	}else{
	    this.type=null;
	    this.numeroDeCompte=-1;
	}
	this.titulaire=cl;
	this.solde=0;
    }
    /**
     * methode de depot d’argent sur le compte (jusqu’au plafond eventuel)
     * @param somme quantite d’argent a deposer sur le compte
     * @return quantite d’argent eventuellement non deposee sur le compte (a rendre
     * au client)
     */
    public double depot(double somme){
	if (this.solde+somme<=this.type.montantMaximumPlafond()){
	    this.solde+=somme;
	    return 0;
	}else{
	    double ancienSolde=this.solde;
	    this.solde=this.type.montantMaximumPlafond();
	    return somme-this.type.montantMaximumPlafond()-ancienSolde;
	}
    }
    /**
     * methode de retrait d’argent depuis le compte (decouvert interdit)
     * @param somme quantite d’argent a retirer du compte
     * @return quantite d’argent effectivement retiree du compte et donnee au client
     */
    public double retrait(double somme){
	if (this.solde-somme>=0){
	    this.solde-=somme;
	    return somme;
	}else{
	    double ancienSolde=this.solde;
	    this.solde=0;
	    return ancienSolde;
	}
    }
}

