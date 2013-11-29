package MidCentralUSA.R2013.DigitSum;

import java.util.*;

public class Main {
    Scanner scanner;
    public static String END = "0";

    public void readInput(String input) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String[] items = input.split(" ");
        for (int i = 1; i < items.length; i++) {
            numbers.add(new Integer(items[i]));
        }

        String a = "" + getLowestNonZero(numbers);
        String b = "" + getLowestNonZero(numbers);

        boolean turn = true;

        while (numbers.size() > 0) {
            if (turn) {
                a += getLowest(numbers);
            } else {
                b += getLowest(numbers);
            }
            turn = !turn;
        }

        System.out.println(Integer.parseInt(a) + Integer.parseInt(b));

    }

    public int getLowestNonZero(ArrayList<Integer> items) {
        Integer i = Integer.MAX_VALUE;
        for (Integer item : items) {
            if (item != 0 && item < i) {
                i = item;
            }
        }
        items.remove(items.indexOf(i));
        return i;
    }

    public int getLowest(ArrayList<Integer> items) {
        Integer i = Integer.MAX_VALUE;
        for (Integer item : items) {
            if (item < i) {
                i = item;
            }
        }
        items.remove(items.indexOf(i));
        return i;
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
