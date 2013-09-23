package MidCentralUSA.R2009.RIPOFF;

import java.util.*;

/*

10 4 5
100 50 -20 60 30
-10 -30 -50 20 70
9 3 4
150 100 -200
-100 -300 -100
-200 100 150
0

 */

public class Main {
    Scanner scanner;
    public static String END = "0";
    public int n = -1;
    public int s = -1;
    public int t = -1;
    public int minInf = Integer.MIN_VALUE/2;
    public ArrayList<Integer> ripoff = new ArrayList<Integer>();
    public int[][] grid = new int[0][0];

    public void readInput(String input) throws Exception {
        String[] items = input.split(" ");
        int[] nums = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            nums[i] = Integer.parseInt(items[i]);
        }

        if (n == -1) {
            n = nums[0];
            s = nums[1];
            t = nums[2];
            grid = new int[t-1][n];
        } else {
            for (int i : nums) {
                ripoff.add(i);
            }
            n -= nums.length;
        }

        if (n == 0) {
            // end of input set - process result
            gridFill();
            System.out.println(max());
            setup();
        }
    }

    public int max() {
        int[] last = grid[grid.length-1];
        int max = minInf;

        for (int i = last.length-1; i > last.length-1-s; i--) {
            if (max < last[i]) {
                max = last[i];
            }
        }

        return max;
    }

    public void gridUnit(int x, int y) throws Exception {
        int max = minInf;

        for (int i = x-1; i >= x-s; i--) {
            if (i >= 0) {
                int current = grid[y-1][i];
                if (max < current) {
                    max = current;
                }
            }
        }

        int result = max + ripoff.get(x);
        grid[y][x] = result;
    }

    public void gridFill() throws Exception {
        for (int i = 0; i < grid[0].length; i++) {
            if (i < s) {
                grid[0][i] = ripoff.get(i);
            } else {
                grid[0][i] = minInf;
            }
        }

        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = minInf;
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                gridUnit(j,i);
            }
        }
    }

    public void setup() {
        n = -1;
        s = -1;
        t = -1;
        ripoff = new ArrayList<Integer>();
        grid = new int[0][0];
    }

    public Main() throws Exception {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.setup();
        m.loop();
    }

    public void loop() throws Exception {
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
