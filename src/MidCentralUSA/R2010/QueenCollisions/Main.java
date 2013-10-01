package MidCentralUSA.R2010.QueenCollisions;

import java.util.Scanner;

/*

7 2
4 1 1 1 2
3 5 2 1 2
5 1
5 5 1 -1 1
8 3
1 2 1 0 0
3 1 8 3 -1
3 4 8 2 -3
0

*/

public class Main {
    Scanner scanner;
    public static String END = "0";
    public int n; // board size
    public int g; // linear patterns of queens to be described
    public int[] rows;
    public int[] cols;
    public int[] dag1;
    public int[] dag2;

    public void readInput(String input) {
        String[] items = input.split(" ");

        if (items.length == 2) {
            n = Integer.parseInt(items[0]);
            g = Integer.parseInt(items[1]);
            rows = new int[n];
            cols = new int[n];
            dag1 = new int[(n*2)-1];
            dag2 = new int[(n*2)-1];
        } else {
            // the following represent a linear pattern
            int k = Integer.parseInt(items[0]); // the number of queens in the pattern
            int x = Integer.parseInt(items[1])-1; // the starting x position
            int y = Integer.parseInt(items[2])-1; // the starting y position
            int s = Integer.parseInt(items[3]); // add to last x position to get next
            int t = Integer.parseInt(items[4]); // add to last y position to get next
            --g; // decrement g
            for (int i = 0; i < k; i++) {
                int t1 = x-y;
                int t2 = x+y;
                int d1 = t1 >= 0 ? t1 : ((n-1)+(-t1));
                int d2 = t2 >= 0 ? t2 : ((n-1)+(-t2));
                dag1[d1]++;
                dag2[d2]++;
                rows[x]++;
                cols[y]++;
                x += s;
                y += t;
            }
        }

        if (g == 0) {
            // tally queen collisions
            int tally = 0;

            for (int i = 0; i < rows.length; i++) {
                if (rows[i] > 0) {
                    tally += rows[i]-1;
                }
            }

            for (int i = 0; i < cols.length; i++) {
                if (cols[i] > 0) {
                    tally += cols[i]-1;
                }
            }

            for (int i = 0; i < dag1.length; i++) {
                if (dag1[i] > 0) {
                    tally += dag1[i]-1;
                }
            }

            for (int i = 0; i < dag2.length; i++) {
                if (dag2[i] > 0) {
                    tally += dag2[i]-1;
                }
            }

            System.out.println(tally);
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
