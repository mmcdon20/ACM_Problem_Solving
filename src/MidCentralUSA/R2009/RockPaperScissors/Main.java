package MidCentralUSA.R2009.RockPaperScissors;

import java.util.Scanner;

/*

RRSRS
SRSPS
PPP
SSS
SPPSRR
PSPSRS
E
E

*/

public class Main {
    Scanner scanner;
    public static String END = "E";
    public boolean ending = false;
    public char[] player1 = null;
    public char[] player2 = null;

    public void readInput(String input) {
        if (player1 == null) {
            player1 = input.toCharArray();
        } else {
            player2 = input.toCharArray();

            int p1 = 0;
            int p2 = 0;

            for (int i = 0; i < player1.length; i++) {
                if (player1[i] == 'R') {
                    if (player2[i] == 'R') {
                        // draw
                    } else if (player2[i] == 'P') {
                        // loss
                        p2++;
                    } else if (player2[i] == 'S') {
                        // win
                        p1++;
                    }
                } else if (player1[i] == 'P') {
                    if (player2[i] == 'R') {
                        // win
                        p1++;
                    } else if (player2[i] == 'P') {
                        // draw
                    } else if (player2[i] == 'S') {
                        // loss
                        p2++;
                    }
                } else if (player1[i] == 'S') {
                    if (player2[i] == 'R') {
                        // loss
                        p2++;
                    } else if (player2[i] == 'P') {
                        // win
                        p1++;
                    } else if (player2[i] == 'S') {
                        // draw
                    }
                }
            }

            System.out.println("P1: " + p1);
            System.out.println("P2: " + p2);

            player1 = null;
            player2 = null;
        }
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
        if (ending) {
            return true;
        } else if (input.equals("E")) {
            ending = true;
            return false;
        } else {
            return false;
        }
    }
}
