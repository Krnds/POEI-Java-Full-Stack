package salaires.salaires;

public class Salaires {

	double chiffreAffairesMensuel;

	public static void main(String[] args) {

		Personnel p = new Personnel();
		p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
		p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
		p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
		p.ajouterEmploye(new SalarieManutention("Jeanne", "Stocketout", 32, "1998", 45));
		p.ajouterEmploye(new Technicien("Jean", "Flippe", 28, "2000", 1000));
		p.ajouterEmploye(new ManutentionARisques("Al", "Abordage", 30, "2001", 45));

		for (Employe e : p.getEmployes()) {
			System.out.println(e.toString());
		}

		System.out.println("\n" + p.afficherSalaires());

	}

}
