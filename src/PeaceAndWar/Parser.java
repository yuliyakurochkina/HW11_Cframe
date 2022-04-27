package PeaceAndWar;

import PeaceAndWar.Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {

    final static String regex = "^[Сс]трада(.*)";

    void parse(File file) {

        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();

        try (Scanner scanner = new Scanner(file).useDelimiter("[^а-яА-Я]+")) {

            String line = "";

            while (scanner.hasNextLine()) {
                lines.add(line);
                line = scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : lines) {
            words.addAll(Arrays.asList(line.split("[^а-яА-Я]+")));
        }

        Pattern pattern = Pattern.compile(regex);

        for (String word : words) {
            if (pattern.matcher(word).find()) {
                Main.sufferingWords.offer(word);
            }
            String poison = "POISON_PILL";
        }
    }
}
