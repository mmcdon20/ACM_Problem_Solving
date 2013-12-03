package MidCentralUSA.R2001.Hangover;

import java.util.Scanner;

public class Main {
    Scanner scanner;
    public static String END = "0.00";

    public void readInput(String input) {
        double over = Double.parseDouble(input);
        double sum = 0.0;
        int n = 0;

        while (sum < over) {
            sum += 1.0 / (n + 2);
            ++n;
        }

        System.out.println(n + " card(s)");
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
