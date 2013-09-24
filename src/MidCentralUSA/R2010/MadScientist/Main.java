package MidCentralUSA.R2010.MadScientist;

import java.util.Scanner;

/*

6 2 7 7 8 12 13
1 4
3 4 4 5
3 0 4 5
5 2 2 4 7 7
0

*/

public class Main {
    Scanner scanner;
    public static String END = "0";

    public void readInput(String input) {
        //
        String[] items = input.split(" ");

        int last = 0;

        for (int i = 1; i < items.length; i++) {
            int item = Integer.parseInt(items[i]);

            int diff = item-last;

            for (int j = 0; j < diff; j++) {
                System.out.print(i);
                System.out.print(" ");
            }

            last = item;
        }
        System.out.println();
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
