package exceptions;

import java.io.*;
import java.util.Scanner;

public class ExoException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un mot : ");
        String motUtilisateur = sc.nextLine();
        System.out.println("Le mot \"" + motUtilisateur + "\" apparaît " + compterOccurencesMot(motUtilisateur) + " fois dans le fichier de référence.");
    }

    public static int compterOccurencesMot(String mot) {
        File file = new File("C:\\Users\\Karine-PC-portable\\Desktop\\texte_reference.txt");

        int count = 0;

        if (mot.equals("")) {
            throw new SaisieErroneeException("Saisie erronée : le mot est vide");
        }

        try (LineNumberReader r = new LineNumberReader(new FileReader(file))) {
            String line;
            while ((line = r.readLine()) != null) {
                for (String element : line.split(" ")) {
                    if (element.equalsIgnoreCase(mot)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }


    public static void ecrireFichier() {
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\Karine-PC-portable\\Desktop\\test.txt");
            myWriter.write("Ceci est une phrase écrite directement dans un fichier texte.");
            myWriter.close();
            System.out.println("Le fichier a bien été modifié en écriture.");
        } catch (IOException e) {
            System.out.println("Erreur d'écriture du fichier.");
            e.printStackTrace();
        }
    }
}
