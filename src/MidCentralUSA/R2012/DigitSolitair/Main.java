package MidCentralUSA.R2012.DigitSolitair;

import java.util.Scanner;

/*

95
396
28
4
40
0

*/

public class Main {
    Scanner scanner;
    public static String END = "0";

    public void readInput(String input) {
        String output = "" + input + " ";

        while (input.length() > 1) {
            char[] chars = input.toCharArray();
            int i = 1;
            for (char c : chars) {
                i *= (c-48);
            }
            input = "" + i;
            output += "" + i + " ";
        }

        System.out.println(output.substring(0,output.length()-1));
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
