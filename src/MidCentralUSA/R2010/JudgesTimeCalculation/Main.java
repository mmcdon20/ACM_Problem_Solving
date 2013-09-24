package MidCentralUSA.R2010.JudgesTimeCalculation;

import java.util.Scanner;

/*

3
12 30 5 0
7 0 2 59
9 59 4 1

*/

public class Main {
    Scanner scanner;
    public static String END = "#";
    int N = -1;

    public void readInput(String input) {
        String[] items = input.split(" ");

        if (items.length == 1) {
            N = Integer.parseInt(items[0]);
        } else {
            int SH = Integer.parseInt(items[0]);
            int SM = Integer.parseInt(items[1]);
            int DH = Integer.parseInt(items[2]);
            int DM = Integer.parseInt(items[3]);
            int T = totalHours(SH,SM,DH,DM);
            int H = SH;

            printHeader();

            for (int i = 0; i < T; i++) {
                printHour(H,i,SM);
                if (H < 12) {
                    H++;
                } else {
                    H = 1;
                }
            }

            N--;
        }
    }

    public int totalHours(int SH, int SM, int DH, int DM) {
        int result = DH+1;

        if (SM + DM >= 60) {
            result++;
        }

        return result;
    }

    public void printHeader() {
        System.out.println("------+---------");
        System.out.println(" time | elapsed");
        System.out.println("------+---------");
    }

    public void printHour(int H, int i, int SM) {
        if (H < 10) {
            System.out.print(" ");
        }

        int points = (i*60) - SM;

        System.out.print(H);
        System.out.print(":XX | XX");

        if (points == 0) {
            System.out.println();
        } else if (points < 0) {
            System.out.println(" - " + (-points));
        } else if (points > 0) {
            System.out.println(" + " + (points));
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
            readInput(input);
            if (isEnd(input)) {
                break;
            }
        }
    }

    public boolean isEnd(String input) {
        return N == 0;
    }
}
