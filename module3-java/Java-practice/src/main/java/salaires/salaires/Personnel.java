package salaires.salaires;

import java.util.ArrayList;
import java.util.Collection;

public class Personnel {

	Collection<Employe> employes = new ArrayList<Employe>();

	public Personnel() {
	}

	public Collection<Employe> getEmployes() {
		return employes;
	}

	void ajouterEmploye(Employe e) {
		employes.add(e);
	}

	public double salaireMoyen() {

		double sum = 0;
		try {
			sum = employes.stream().mapToDouble(e -> e.calculerSalaire()).sum();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sum / employes.size();
	}

	public String afficherSalaires() {

		return "Le salaire moyen dans l'entreprise est de " + salaireMoyen() + " francs.";

	}

}
