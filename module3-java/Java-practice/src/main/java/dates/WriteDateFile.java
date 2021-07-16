package dates;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WriteDateFile {


    /**
     * Ecrire un programme JAVA permettant d’écrire les dates
     * des 20 prochains jours dans un fichier texte dans votre
     * espace de travail, le contenu du fichier serait :
     * 16/07/2021
     * 17/07/2021
     * 18/07/2021
     */

    public static void main(String[] args) {

        writeFile(getDates(), "C:\\Users\\Karine\\Desktop\\fichier_dates.txt");
    }

    private static List<String> getDates() {

        List<String> dates = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            LocalDate day = LocalDate.now().plusDays(i);
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
            String formattedDay = day.format(formatters);
            dates.add(formattedDay);
        }

        return dates;
    }

    private static void writeFile(List<String> dates, String filename) {
        try {
            File dateFile = new File(filename);
            FileWriter writer = new FileWriter(dateFile);

            for (String s : dates) {
                writer.write(s);
                writer.write("\n");
            }
            writer.close();
            System.out.println("Les dates ont bien été ajoutées au fichier !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
