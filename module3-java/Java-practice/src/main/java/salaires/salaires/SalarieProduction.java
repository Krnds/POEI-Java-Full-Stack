package salaires.salaires;

public class SalarieProduction extends Employe {

	
	String nom;
	String prenom;
	int age, nbUniteProduitesMensuelles;
	
	
	public SalarieProduction(String nom, String prenom, int age, String anneeRecrutement, int nbUniteProduitesMensuelles) {
		super(nom, prenom, age, anneeRecrutement);
		this.nbUniteProduitesMensuelles = nbUniteProduitesMensuelles;
	}

	@Override
	double calculerSalaire() {
		return nbUniteProduitesMensuelles * 5;
	}
	
	public String getNom() {
		return "Le salari� de production s'appelle " + prenom + nom;
	}

	
	public String afficherSalaire() {
		return "Le salari� de production gagne " + calculerSalaire() + " francs.";
	}
}
