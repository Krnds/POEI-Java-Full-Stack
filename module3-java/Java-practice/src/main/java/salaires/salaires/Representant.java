package salaires.salaires;

public class Representant extends Employe{
	
	String nom;
	String prenom;
	int age;
	private double chiffreAffairesMensuel;

	public Representant(String nom, String prenom, int age, String anneeRecrutement, int chiffreAffairesMensuel) {
		super(nom, prenom, age, anneeRecrutement);
		this.chiffreAffairesMensuel = chiffreAffairesMensuel;
	}
	@Override
	double calculerSalaire() {
		return (0.2 * chiffreAffairesMensuel) + 800;
	}
	
	public String getNom() {
		return "Le représentant s'appelle " + prenom + nom;
	}
	
	
	public String afficherSalaire() {
		return "Le représentant gagne " + calculerSalaire() + " francs.";
	}

}
