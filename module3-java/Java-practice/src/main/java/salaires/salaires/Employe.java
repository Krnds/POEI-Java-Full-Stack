package salaires.salaires;

public abstract class Employe {

	String nom;
	String prenom;
	int age;
	String anneeRecrutement;

	public Employe(String nom, String prenom, int age, String anneeRecrutement) {
		this.nom = nom;
		this.prenom = prenom;
		this.anneeRecrutement = anneeRecrutement;
		this.age = age;
	}

	abstract double calculerSalaire();

	public String getNom() {
		return "L'employé " + prenom + nom;
	}

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", anneeRecrutement=" + anneeRecrutement
				+ "]";
	}
	


}
