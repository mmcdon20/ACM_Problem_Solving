package MidCentralUSA.R2008.Parity;

import java.util.Scanner;

public class Main {
    Scanner scanner;
    public static String END = "#";

    public void readInput(String input) {
        if (input.endsWith("o"))
            System.out.println(o(input));
        if (input.endsWith("e"))
            System.out.println(e(input));
    }

    public Main() throws Exception {
        scanner = new Scanner(System.in);
    }

    public static String o(String in) {
        int n = 0;
        for (char c : in.toCharArray())
            if (c == '1')
                n++;
        return (n % 2 != 0) ? // is odd?
                in.replace('o', '0') : // keep parity
                in.replace('o', '1'); // change parity
    }

    public static String e(String in) {
        int n = 0;
        for (char c : in.toCharArray())
            if (c == '1')
                n++;
        return (n % 2 == 0) ? // is even?
                in.replace('e', '0') : // keep parity
                in.replace('e', '1'); // change parity
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
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
