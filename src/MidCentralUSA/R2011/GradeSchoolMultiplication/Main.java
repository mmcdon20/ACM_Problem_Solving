package MidCentralUSA.R2011.GradeSchoolMultiplication;

import java.util.Scanner;

public class Main {
    Scanner scanner;
    public static String END = "0 0";
    public int count = 0;
    public long a;
    public long b;
    public long c;

    public void readInput(String input) {
        String[] items = input.split(" ");
        a = Long.parseLong(items[0]);
        b = Long.parseLong(items[1]);
        c = a * b;
        printHeader();
        printContent();
        printFooter();
        setup();
    }

    public void printContent() {
        int bl = (""+b).length();
        int cl = (""+c).length();
        char[] bc = (""+b).toCharArray();
        int nonZeros = 0;
        int j = 0;
        boolean zero;
        int num0 = 0;

        for (char c : bc)  {
            if (c != '0') {
                nonZeros++;
            }
        }

        if (nonZeros <= 1) {
            return;
        } else {
            printDash(cl);
        }

        for (int i = bl-1; i >= 0; i--) {
            long item = (bc[i]-48)*a;
            int il = (""+item).length();

            if (bc[i] == '0') {
                zero = true;
                num0++;
            } else {
                zero = false;
            }

            if (item != 0) {
                printSpace((cl-il)-j);
                System.out.print(item);
                if (!zero) {
                    printZero(num0);
                    num0 = 0;
                }
                System.out.println();
            }
            j++;
        }
    }

    public void printHeader() {
        int al = (""+a).length();
        int bl = (""+b).length();
        int cl = (""+c).length();
        System.out.println("Problem " + (++count));
        printSpace(cl-al);
        System.out.println(a);
        printSpace(cl-bl);
        System.out.println(b);
    }

    public void printFooter() {
        int cl = (""+c).length();
        printDash(cl);
        System.out.println(c);
    }

    public void printSpace(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    public void printZero(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("0");
        }
    }

    public void printDash(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        } System.out.println();
    }

    public void setup() {
        a = b = c = 0;
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
