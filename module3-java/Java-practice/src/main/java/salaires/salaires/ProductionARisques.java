package salaires.salaires;

public class ProductionARisques implements EmployeARisque {

	int age, nbUniteProduitesMensuelles;
	int prime;

	public int getPrime() {
		return prime;
	}

	public ProductionARisques(String nom, String prenom, int age, int nbUniteProduitesMensuelles) {
		super();
	}

	public double calculerSalaire() {
		return nbUniteProduitesMensuelles * 5 + EmployeARisque.PRIMEMENSUELLE;
	}

	public String afficherSalaire() {
		return "L'employ� de production � risque gagne " + calculerSalaire() + " francs.";
	}

	public String getNom() {
		return "L'employ� de production � risque s'appelle " + prenom + nom;
	}

}
