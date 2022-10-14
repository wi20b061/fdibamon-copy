import entity.Fdibamon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Fdibamon> fdibamons = new ArrayList<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        fdibamons.add(new Fdibamon("Torud", 50, 20));
        fdibamons.add(new Fdibamon("Morzith", 40, 50));
        fdibamons.add(new Fdibamon("Unoth", 60, 30));
        fdibamons.add(new Fdibamon("Gandalf", 50, 40));
        fdibamons.add(new Fdibamon("Mordekeiser", 70, 70));

        printHelloMessage();
        int counter = 1;
        int userInput;
        //TODO: fix the do while loop
        do {
            for (Fdibamon fdibamon : fdibamons) {
                System.out.printf("%d. %-15s | Hit Points: %5d | Attack Power: %5d%n",
                        counter++,
                        fdibamon.getName(),
                        fdibamon.getHitPoints(),
                        fdibamon.getAttackPower());
            }
            userInput = Integer.parseInt(bf.readLine());
        } while (userInput <= 0 && userInput >= 5);



    }

    private static void printHelloMessage() {
        System.out.println("Welcome. Please, pick a valid fdibamon: ");
    }
}
