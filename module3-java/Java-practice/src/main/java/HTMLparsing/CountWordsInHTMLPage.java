package HTMLparsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountWordsInHTMLPage {

    /**
     * Ecrire un programme Java permettant de compter le nombre d'occurences du
     * mot "formation" sur la page d'accueil du site https://www.m2iformation.fr/
     */

    public static void main(String[] args) {

        String urlToParse = "https://www.m2iformation.fr/";
        try {
            int occurences = countWordsInString(readHTMLPage(urlToParse));
            System.out.println("Il y a " + occurences + " occurences du mot \"formation\"" + " sur la page " + urlToParse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static StringBuilder readHTMLPage(String adress) throws IOException {

        URL url = new URL(adress);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String line;

            while ((line = br.readLine()) != null) {

                sb.append(line.toLowerCase());
                sb.append(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb;
    }

    private static int countWordsInString(StringBuilder sb) {

        int count = 0;
        Matcher countMatcher = Pattern.compile("formation").matcher(sb.toString());

        while (countMatcher.find()) {
            count++;
        }

        return count;
    }

}
