package MidCentralUSA.R2009.DuplicateRemoval;

import java.util.Scanner;

/*

5 1 22 22 22 3
4 98 76 20 76
6 19 19 35 86 86 86
1 7
0

*/

public class Main {
    Scanner scanner;
    public static String END = "0";

    public void readInput(String input) {
        String last = "Bob Saget";
        String[] items = input.split(" ");

        for (int i = 1; i < items.length; i++) {
            if (!items[i].equals(last)) {
                last = items[i];
                System.out.print(items[i] + " ");
            }
        }
        System.out.println("$");
    }

    public Main() throws Exception {
        scanner = new Scanner(System.in);
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
