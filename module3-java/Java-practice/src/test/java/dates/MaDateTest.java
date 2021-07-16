package dates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

public class MaDateTest {

    @Test
    public void ajouterUnJour_shouldReturnExpectedDate() {

        LocalDate startDate = LocalDate.now();
        LocalDate expectedDate = startDate.plusDays(1);
        LocalDate actualDate = MaDate.ajouterUnJour(new MaDate(startDate.getDayOfMonth(), startDate.getMonthValue(), startDate.getYear()));

        assertThat(actualDate.isEqual(expectedDate));
    }


    @Test
    public void ajouterPlusieursJours_shouldReturnExpectedDate() {

        LocalDate startDate = LocalDate.now();
        LocalDate expectedDate = startDate.plusDays(26);
        LocalDate actualDate = MaDate.ajouterPlusieursJours(new MaDate(startDate.getDayOfMonth(), startDate.getMonthValue(), startDate.getYear()), 26);

        assertThat(actualDate.isEqual(expectedDate));
    }

    @Test
    public void ajouterUnMois_shouldReturnExpectedDate() {

        LocalDate startDate = LocalDate.now();
        LocalDate expectedDate = startDate.plusMonths(1);
        LocalDate actualDate = MaDate.ajouterUnMois(new MaDate(startDate.getDayOfMonth(), startDate.getMonthValue(), startDate.getYear()));

        assertThat(actualDate.isEqual(expectedDate));
    }

    @Test
    public void ajouterUnAn_shouldReturnExpectedDate() {

        LocalDate startDate = LocalDate.now();
        LocalDate expectedDate = startDate.plusYears(1);
        LocalDate actualDate = MaDate.ajouterUnAn(new MaDate(startDate.getDayOfMonth(), startDate.getMonthValue(), startDate.getYear()));

        assertThat(actualDate.isEqual(expectedDate));
    }
}
