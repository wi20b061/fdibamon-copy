import entity.Fdibamon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Engine implements Runnable {

    @Override
    public void run() {
        List<Fdibamon> fdibamons = createFdibamonList();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Fdibamon firstFdibamon = null;
        Fdibamon secondFdibamon = null;

        int counter = 1;
        int userInput = 0;
        int flag = 0;
        while (flag < 2) {
            do {
                for (Fdibamon fdibamon : fdibamons) {
                    System.out.printf("%d. %-15s | Hit Points: %5d | Attack Power: %5d%n",
                            counter++,
                            fdibamon.getName(),
                            fdibamon.getHitPoints(),
                            fdibamon.getAttackPower());
                }
                try {
                    userInput = Integer.parseInt(bf.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                counter = 1;
            } while (userInput <= 0 || userInput > 5);
            flag++;
            if (flag == 1) {
                firstFdibamon = fdibamons.get(userInput - 1);
                fdibamons.remove(userInput - 1);
            }
        }
        //TODO: Fix the error with the second entry == 5
        try {
            secondFdibamon = fdibamons.get(userInput - 1);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Out of index");
        }
        Arena arena = new Arena(firstFdibamon, secondFdibamon);
        System.out.printf("You choose: %s and %s", arena.getFirstFdibamon().getName(), arena.getSecondFdibamon().getName());

    }

    private List<Fdibamon> createFdibamonList() {
        List<Fdibamon> fdibamons = new ArrayList<>();
        fdibamons.add(new Fdibamon("Torud", 50, 20));
        fdibamons.add(new Fdibamon("Morzith", 40, 50));
        fdibamons.add(new Fdibamon("Unoth", 60, 30));
        fdibamons.add(new Fdibamon("Gandalf", 50, 40));
        fdibamons.add(new Fdibamon("Mordekeiser", 70, 70));
        return fdibamons;
    }
}
