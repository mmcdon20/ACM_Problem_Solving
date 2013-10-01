package MidCentralUSA.R2010.ImageCompression;

import java.util.Scanner;

/*


4 80
0000
1000
0011
0011
8 75
11111000
11110000
11000011
11000011
11000100
00000100
00010011
00010011
4 75
1101
1111
0111
0011
0


 */


public class Main {
    Scanner scanner;
    public static String END = "0";
    public int W;
    public int T;
    public int R;
    public int N = 0;
    public char[][] grid;

    public void readInput(String input) {
        String[] items = input.split(" ");

        if (W == 0 && T == 0) {
            W = Integer.parseInt(items[0]);
            T = Integer.parseInt(items[1]);
            grid = new char[W][W];
            R = 0;
        } else {
            char[] data = input.toCharArray();
            grid[R] = data;
            R++;
        }

        if (R == W) {
            recur(W,0,0);
            print();
            setup();
        }

    }

    public void setup() {
        T = 0;
        W = 0;
        R = 0;
    }

    public void print() {
        System.out.println("Image " + (++N) + ":");
        for (char[] row : grid) {
            for (char entry : row) {
                System.out.print(entry);
            }   System.out.println();
        }
    }

    public void recur (int size, int x, int y) {
        if (size == 1) {
            return;
        }  else if (ones(size,x,y)) {
            fill(size,x,y,'1');
        }  else if (zeros(size,x,y)) {
            fill(size,x,y,'0');
        }  else {
            int half = size/2;
            recur(half, x,      y);
            recur(half, x+half, y);
            recur(half, x,      y+half);
            recur(half, x+half, y+half);
        }
    }

    public void fill(int size, int x, int y, char s) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[x+i][y+j] = s;
            }
        }
    }

    public int count(int size, int x, int y, char s) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[x+i][y+j] == s) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean ones(int size, int x, int y) {
        double count = (count(size,x,y,'1'));
        double total = (size * size);
        return (int)((count/total)*100) >= T;
    }

    public boolean zeros(int size, int x, int y) {
        double count = count(size,x,y,'0');
        double total = size * size;
        return (int)((count/total)*100) >= T;
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
        return input.equals(END) && W == 0 && T == 0;
    }
}
