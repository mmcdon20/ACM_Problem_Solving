package MidCentralUSA.R2010.QueenCollisions;

import java.util.Scanner;

/*

7 2
4 1 1 1 2
3 5 2 1 2
5 1
5 5 1 -1 1
8 3
1 2 1 0 0
3 1 8 3 -1
3 4 8 2 -3
0

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
