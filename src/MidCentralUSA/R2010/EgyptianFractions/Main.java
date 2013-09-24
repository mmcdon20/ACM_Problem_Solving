package MidCentralUSA.R2010.EgyptianFractions;

import java.util.Scanner;

/*

3 4
2 7
9 20
17 69
0 0

*/

public class Main {
    Scanner scanner;
    public static String END = "#";

    public void readInput(String input) {

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
