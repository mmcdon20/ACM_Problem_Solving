package MidCentralUSA.R2012.JuggleFest;

import java.util.*;

/*

3 3 4 5
1 3
3 3 5 4
5 7 7 7 3 1
0

*/

public class Main {
    Scanner scanner;
    public static String END = "0";
    public static final String[] letters =
            { "A","B","C","D","E","F","G","H","I",
              "J","K","L","M","N","O","P","Q","R",
              "S","T","U","V","W","X","Y","Z" };

    public void readInput(String input) {
        String[] items = input.split(" ");
        String[] result = new String[20];
        int[]    pattern = new int[20];

        int n = Integer.parseInt(items[0]);

        for (int i = 0; i < 20; ) {
            for (int j = 0; j < items.length-1; j++) {
                if (i < 20) {
                    int throwSize = Integer.parseInt(items[j+1]);
                    pattern[i] = throwSize;
                }
                i++;
            }
        }

        boolean keepGoing = false;
        int ln = 0;

        do {
            keepGoing = false;
            int start = 0;

            for (int i = 0; i < 20; i++) {
                if (result[i] == null) {
                    start = i;
                    break;
                }
            }

            int current = start;
            String letter = letters[ln];
            ln++;

            while (current < 20) {
                if (result[current] != null) {
                    System.out.println("CRASH");
                    return;
                } else {
                    result[current] = letter;
                    current += pattern[current];
                }
            }

            for (int i = 0; i < 20; i++) {
                if (result[i] == null) {
                    keepGoing = true;
                }
            }
        } while (keepGoing);

        for (String s : result) {
            System.out.print(s);
        }   System.out.println();
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
