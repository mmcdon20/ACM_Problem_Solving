package MidCentralUSA.R2009.GnomeSequencing;

import java.util.Scanner;

/*

3
40 62 77
88 62 77
91 33 18

 */

public class Main {
    public Scanner scanner;

    public Main() throws Exception {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.loop();
    }

    public void loop() throws Exception {
        String input = scanner.nextLine();
        int sets = Integer.parseInt(input.split(" ")[0]);
        System.out.println("Gnomes:");

        while (sets > 0) {
            input = scanner.nextLine();
            String[] numbers = input.split(" ");

            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            int c = Integer.parseInt(numbers[2]);

            if ((a <= b && b <= c) || (c <= b && b <= a)) {
                System.out.println("Ordered");
            } else {
                System.out.println("Unordered");
            }

            sets--;
        }
    }
}


