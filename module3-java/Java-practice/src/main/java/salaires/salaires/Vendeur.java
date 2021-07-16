package salaires.salaires;

public class Vendeur extends Employe {

	String nom;
	String prenom;
	int age;
	String anneeRecrutement;
	private double chiffreAffairesMensuel;

	public Vendeur(String nom, String prenom, int age, String anneeRecrutement, int chiffreAffairesMensuel) {
		super(nom, prenom, age, anneeRecrutement);
		this.chiffreAffairesMensuel = chiffreAffairesMensuel;

	}

	@Override
	double calculerSalaire() {
		return (0.2 * chiffreAffairesMensuel) + 400;
	}

	public String getNom() {
		return "Le vendeur  " + prenom + nom;
	}

	public String afficherSalaire() {
		return "Le vendeur gagne " + calculerSalaire() + " francs.";
	}

}
