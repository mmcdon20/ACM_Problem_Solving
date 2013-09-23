package SkeletonCode;

import java.util.*;

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
