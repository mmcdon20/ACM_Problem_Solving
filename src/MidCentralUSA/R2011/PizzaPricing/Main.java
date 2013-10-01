package MidCentralUSA.R2011.PizzaPricing;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner;
    public static String END = "0";
    public ArrayList<ArrayList<Double>> menu;
    public int count = 0;
    public int n;

    public void readInput(String input) {
        String[] items = input.split(" ");

        if (items.length == 1) {
            n = Integer.parseInt(input);
        } else {
            ArrayList<Double> item = new ArrayList<Double>();
            item.add(Double.parseDouble(items[0]));
            item.add(Double.parseDouble(items[1]));
            menu.add(item);
            n--;
        }

        if (n == 0) {
            double bestValue = 99999999;
            double bestSize  = -2;
            for (ArrayList<Double> item : menu) {
                double value = (item.get(1)/(item.get(0)*item.get(0)));
                if (value < bestValue) {
                    bestValue = value;
                    bestSize = item.get(0);
                }
            }
            System.out.println("Menu " + (++count) + ": " + ((int)bestSize));
            setup();
        }
    }

    public void setup() {
        menu = new ArrayList<ArrayList<Double>>();
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
