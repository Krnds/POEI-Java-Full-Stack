package salaires.salaires;

public class SalarieManutention extends Employe {

	String nom;
	String prenom;
	int age;
	int nbHeuresTravailMensuel;

	public SalarieManutention(String nom, String prenom, int age, String anneeRecrutement, int nbHeuresTravailMensuel) {
		super(nom, prenom, age, anneeRecrutement);
		this.nbHeuresTravailMensuel = nbHeuresTravailMensuel;
	}

	@Override
	double calculerSalaire() {
		return nbHeuresTravailMensuel * 65;
	}

	public String getNom() {
		return "Le manutentionnaire s'appelle " + prenom + nom;
	}

	public String afficherSalaire() {
		return "manutentionnaire gagne " + calculerSalaire() + " francs.";
	}

}
