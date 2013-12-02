package MidCentralUSA.R2002.TanningSalon;

import java.util.*;

public class Main {
    Scanner scanner;
    public static String END = "0";

    public void readInput(String input) {
        int beds = Integer.parseInt(input.split(" ")[0]);
        String customers = input.split(" ")[1];
        ArrayList<Character> salon = new ArrayList<Character>();
        int walkouts = 0;

        for (Character c : customers.toCharArray()) {
            if (salon.contains(c)) { // walk out
                if (salon.size() > beds) {
                    ++walkouts;
                }
                salon.remove(c);
            } else { // walk in
                salon.add(c);
            }
        }

        if (walkouts == 0) {
            System.out.println("All customers tanned successfully.");
        } else {
            System.out.println("" + walkouts + " customer(s) walked away.");
        }
    }

    public void setup() {

    }

    public Main() throws Exception {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.setup();
        m.loop();
    }

    public void loop() {
        while (true) {
            String input = scanner.nextLine();
            if (isEnd(input)) {
                break;
            } else {
                readInput(input);
            }
        }
    }

    public boolean isEnd(String input) {
        return input.equals(END);
    }
}
