import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        Fdibamon firstFdibamon = null;
        Fdibamon secondFdibamon = null;
        List<Fdibamon> fdibamons = createFdibamonList();

        int input;
        int selectedFdibamons = 0;
        int upperBound = fdibamons.size();

        while (selectedFdibamons < 2) {
            printCurrentFdibamonList(fdibamons);
            System.out.printf("%nEnter your Fdibamon #%d: ", selectedFdibamons + 1);
            try {
                input = Integer.parseInt(bufferedReader.readLine());
                if (input <= 0 || input > upperBound) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ex) {
                System.out.printf("%nInvalid input, try again.%n%n");
                continue;
            }

            if (selectedFdibamons == 0) {
                firstFdibamon = getFdibamon(fdibamons, input);
                ++selectedFdibamons;
                continue;
            }
            secondFdibamon = getFdibamon(fdibamons, input);
            ++selectedFdibamons;
        }

        System.out.printf("Creating arena...:%nFighter N1: %s%nFighter N2: %s",
                firstFdibamon.getName(),
                secondFdibamon.getName());
    }

    private static Fdibamon getFdibamon(List<Fdibamon> fdibamons, int input) {
        Fdibamon fdibamon = fdibamons.get(input - 1);
        System.out.printf("%n%s selected!%n%n", fdibamon.getName());
        fdibamons.remove(input - 1);
        return fdibamon;
    }

    private static void printCurrentFdibamonList(List<Fdibamon> fdibamons) {
        int counter = 1;
        for (Fdibamon fdibamon : fdibamons) {
            System.out.printf("ID: %d. | Name: %15s | HP: %7d | Attack Points: %7d%n",
                    counter++,
                    fdibamon.getName(),
                    fdibamon.getHitPoints(),
                    fdibamon.getAttackPower());
        }
    }

    private static List<Fdibamon> createFdibamonList() {
        List<Fdibamon> fdibamons = new ArrayList<>();
        fdibamons.add(new Fdibamon("Torud", 50, 20));
        fdibamons.add(new Fdibamon("Morzith", 40, 50));
        fdibamons.add(new Fdibamon("Unoth", 60, 30));
        fdibamons.add(new Fdibamon("Gandalf", 50, 40));
        fdibamons.add(new Fdibamon("Mordekeiser", 70, 70));
        return fdibamons;
    }
}