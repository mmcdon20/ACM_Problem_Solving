package MidCentralUSA.R2012.LRUCaching;

import java.util.*;

/*

5 ABC!DEAF!B!
3 WXWYZ!YZWYX!XYXY!
5 EIEIO!
0

 */

public class Main {
    Scanner scanner;
    public static String END = "0";
    public int count = 0;

    public void readInput(String input) {
        String[] items = input.split(" ");
        int n = Integer.parseInt(items[0]);
        ArrayList<Character> cach = new ArrayList<Character>();
        System.out.println("Simulation " + (++count));

        for (int i = 1; i < items.length; i++) {
            for (Character c : items[1].toCharArray()) {
                if (c.equals('!')) {
                    while (cach.size() > n) {
                        cach.remove(0);
                    }
                    for (Character d : cach) {
                        System.out.print(d);
                    }   System.out.println();
                } else if (cach.contains(c)) {
                    cach.remove(c);
                    cach.add(c);
                } else {
                    cach.add(c);
                }
            }
        }
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
