package PeaceAndWar;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;


public class Main {

    final static String regex = "^[Сс]трада(.*)";
    final static String pattern = "страдание";

    public static LinkedBlockingQueue<String> sufferingWords = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        File file = new File("voyna1.txt");

        new Thread(() -> {
            Parser parser = new Parser();
            parser.parse(file);
        }).start();

        new Thread(() -> {
            int number = 0;
            while (true) {
                try {
                    for (int i = 1; i < 45; i++) {
                        String word = sufferingWords.take();
                        if (word != null) {
                            number = number + 1;
                            System.out.println(i + ") " + word);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("total = " + number);
                break;
            }
        }).start();
    }
}

