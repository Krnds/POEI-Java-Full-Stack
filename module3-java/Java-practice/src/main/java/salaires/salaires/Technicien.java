package salaires.salaires;

public class Technicien extends Employe {

	private int nbUniteProduitesMensuelles;

	public Technicien(String nom, String prenom, int age, String anneeRecrutement,
			int nbUnitesProduites) {
		super(nom, prenom, age, anneeRecrutement);
		this.nbUniteProduitesMensuelles = nbUnitesProduites;
	}


	@Override
	double calculerSalaire() {
		return nbUniteProduitesMensuelles * 5;
	}
	
	
	public String afficherSalaire() {
		return "Le technicien gagane " + calculerSalaire() + " francs.";
	}

	public String getNom() {
		return "Le technicine s'appelle " + prenom + nom;
	}

}
