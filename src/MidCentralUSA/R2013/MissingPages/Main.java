package MidCentralUSA.R2013.MissingPages;

import java.util.*;

public class Main {
    Scanner scanner;
    public static String END = "0";

    public void readInput(String input) {
        int N = Integer.parseInt(input.split(" ")[0]);
        int P = Integer.parseInt(input.split(" ")[1]);
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        if (P % 2 == 0) {
            numbers.add(P-1);
            numbers.add(N-P+2);
            numbers.add(N-P+1);
        } else {
            numbers.add(P+1);
            numbers.add(N-P+1);
            numbers.add(N-P+0);
        }

        Collections.sort(numbers);
        System.out.println(numbers.get(0) + " " +
                           numbers.get(1) + " " +
                           numbers.get(2));
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
