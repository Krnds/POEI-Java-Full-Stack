package dates;

public class MainMaDate {

    public static void main(String[] args) {

        //tester méthode ajouterUnJour
        MaDate d1 = new MaDate(01, 5, 2008);
        System.out.println(MaDate.ajouterUnJour(d1).toString());
        System.out.println(MaDate.ajouterPlusieursJours(d1, 14).toString());
        System.out.println(MaDate.ajouterUnMois(d1).toString());
        System.out.println(MaDate.ajouterUnAn(d1).toString());
    }
}
