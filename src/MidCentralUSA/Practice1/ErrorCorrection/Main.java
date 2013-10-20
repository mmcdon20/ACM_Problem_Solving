package MidCentralUSA.Practice1.ErrorCorrection;

import java.util.*;

public class Main {
    static Scanner scanner;
    public String END = "0";
    public int n;
    public int p;
    public int state = 0;
    public String[][] grid;

    public void readInput(String input) {
        String[] items = input.split(" ");
        if (state == 0) {
            n = Integer.parseInt(input);
            grid = new String[n][n];
            state = 1;
        } else if (state == 1) {
            grid[p] = items;
            --n;
            p++;
        }
        if (n == 0) {
            output();
            setup();
        }
    }

    public void output() {
        if (isOk(grid)) {
            System.out.println("OK");
        } else {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    String[][] newGrid = copyGrid(i,j);
                    if (isOk(newGrid)) {
                        System.out.println("Change bit (" + (i+1) + "," + (j+1) + ")");
                        return;
                    }
                }
            }
            System.out.println("Corrupt");
        }
    }

    public String[][] copyGrid(int a, int b) {
        String[][] cg = new String[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == a && j == b) {
                    String temp = grid[i][j];
                    if (temp.equals("1")) {
                        temp = "0";
                    } else {
                        temp = "1";
                    }
                    cg[i][j] = temp;
                } else {
                    cg[i][j] = grid[i][j];
                }
            }
        }
        return cg;
    }

    public boolean isOk(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int parity1 = 0;
            int parity2 = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j].equals("1")) {
                    parity1++;
                }
                if (grid[j][i].equals("1")) {
                    parity2++;
                }
            }
            if (parity1 % 2 != 0) {
                return false;
            }
            if (parity2 % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]);
            }   System.out.println();
        }
    }

    public void setup() {
        p = 0;
        n = 0;
        state = 0;
    }

    public Main() {
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
        return END.equals(input);
    }
}

