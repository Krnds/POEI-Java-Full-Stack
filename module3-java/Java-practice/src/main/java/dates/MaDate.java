package dates;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class MaDate {

    private int jour;
    private int mois;
    private int annee;

    public MaDate(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }


    public static LocalDate ajouterUnJour(MaDate date) {

        LocalDate localDate = LocalDate.of(date.getAnnee(), date.getMois(), date.getJour());
        LocalDate dateFormString = LocalDate.parse(localDate.toString());
        return dateFormString.plus(1, ChronoUnit.DAYS);

    }

    public static LocalDate ajouterPlusieursJours(MaDate date, int jours) {

        LocalDate localDate = LocalDate.of(date.getAnnee(), date.getMois(), date.getJour());
        LocalDate dateFormString = LocalDate.parse(localDate.toString());
        return dateFormString.plus(jours, ChronoUnit.DAYS);
    }

    public static LocalDate ajouterUnMois(MaDate date) {

        LocalDate localDate = LocalDate.of(date.getAnnee(), date.getMois(), date.getJour());
        LocalDate dateFormString = LocalDate.parse(localDate.toString());
        return dateFormString.plus(1, ChronoUnit.MONTHS);
    }

    public static LocalDate ajouterUnAn(MaDate date) {

        LocalDate localDate = LocalDate.of(date.getAnnee(), date.getMois(), date.getJour());
        LocalDate dateFormString = LocalDate.parse(localDate.toString());
        return dateFormString.plus(1, ChronoUnit.YEARS);
    }


    @Override
    public String toString() {
        return jour + "/" + mois + "/" + annee;
    }


}
