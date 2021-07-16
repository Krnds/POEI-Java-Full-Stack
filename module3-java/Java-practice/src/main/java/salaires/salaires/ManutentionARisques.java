package salaires.salaires;

public class ManutentionARisques extends Employe implements EmployeARisque {

	String nom;
	String prenom;
	int age, nbUniteProduitesMensuelles;

	public ManutentionARisques(String nom, String prenom, int age, String anneeRecrutement, int nbUniteProduitesMensuelles) {
		super(nom, prenom, age, anneeRecrutement);
		this.nbUniteProduitesMensuelles = nbUniteProduitesMensuelles;
	}



	@Override
	double calculerSalaire() {
		return nbUniteProduitesMensuelles * 5 + EmployeARisque.PRIMEMENSUELLE;
	}
	
	
	public String afficherSalaire() {
		return "Le manutentionaire gagane " + calculerSalaire() + " francs.";
	}

	public String getNom() {
		return "Le manutentionaire à risques s'appelle " + prenom + nom;
	}
}
