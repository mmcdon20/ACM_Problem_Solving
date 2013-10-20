package MidCentralUSA.Practice1.MappingTheRoute;

import java.util.*;

/*

2 2 2 2 1 1
0 0
0 0
2 2 1 2 1 1
0 2
1 0
6 4 4 3 1 1
1 0 1 1
1 1 3 1
0 2 1 1
1 1 3 1
1 0 1 1
2 3 2 3
6 4 1 4 1 1
1 0 1 1
1 1 3 1
0 2 1 1
1 1 3 1
1 0 1 1
2 3 2 3
6 8 1 8 1 1
1 0 1 0 1 0 1 1
1 1 3 1 1 1 3 1
0 2 1 1 0 2 1 1
1 1 3 1 1 1 3 1
1 0 1 1 1 0 1 1
2 3 2 3 2 3 2 3
12 8 7 1 1 1
1 0 1 0 1 0 1 1
1 1 3 1 1 1 3 1
0 2 1 1 0 2 1 1
1 1 3 1 1 1 3 1
1 0 1 1 1 0 1 1
2 3 2 3 2 3 2 1
1 0 1 0 1 0 1 1
1 1 3 1 1 1 3 1
0 2 1 1 0 2 1 1
1 1 3 1 1 1 3 1
1 0 1 1 1 0 1 1
2 3 2 3 2 3 2 3
0 0 0 0 0 0

*/

public class Main {
    static Scanner scanner;
    public final String END = "0 0 0 0 0 0";
    public int state = 0;
    public int mazeNum = 0;
    int h, w, x, y, x2, y2;
    int r, c;
    int n;
    String[][] grid;

    public void readInput(String input) {
        String[] items = input.split(" ");
        if (state == 0) {
            h = Integer.parseInt(items[0]);
            w = Integer.parseInt(items[1]);
            x = Integer.parseInt(items[2]); // position of start
            y = Integer.parseInt(items[3]); // position of start
            x2 = Integer.parseInt(items[4]); // position of goal
            y2 = Integer.parseInt(items[5]); // position of goal
            state = 1;
            n = h;
            grid = new String[(h*2)+1][(w*3)+w+1];
            outline();
        } else {
            for (String item: items) {
                int n = Integer.parseInt(item);
                addDoor(c,r,n);
                c++;
            }
            c = 0;
            ++r;
            --n;
        }
        if (n == 0) {
            output();
            setup();
        }
    }

    public void addDoor(int r, int c, int n) {
        // 0 = no east no south
        // 1 = east
        // 2 = south
        // 3 = east and south
        int x = (r*4)+1;
        int y = (c*2)+1;
        if (n == 0) {
            return;
        } else if (n == 1) {
            addEast(x,y);
        } else if (n == 2) {
            addSouth(x,y);
        } else if (n == 3) {
            addEast(x,y);
            addSouth(x,y);
        }
    }

    public void addEast(int x, int y) {
        grid[y][x+3] = "|";
    }

    public void addSouth(int x, int y) {
        grid[y+1][x] = "-";
        grid[y+1][x+1] = "-";
        grid[y+1][x+2] = "-";
    }

    public void outline() {
        for (int i = 0; i < (h*2)+1; i ++) {
            for (int j = 0; j < (w*3)+w+1; j++) {
                if (j % 4 == 0 && i % 2 == 0) {
                    grid[i][j] = "+";
                } else if (i == 0 || i == (h*2)) {
                    grid[i][j] = "-";
                } else if (j == 0 || j == ((w*3)+w)) {
                    grid[i][j] = "|";
                } else {
                    grid[i][j] = " ";
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }	System.out.println();
        }
    }

    public void output() {
        System.out.println("Maze " + (++mazeNum));
        int r = y-1;
        int c = x-1;
        int p = 0;
        Stack<String> st = new Stack<String>();
        mark(r,c,++p);

        while (!(r+1 == x2 && c+1 == y2)) {
            if (canWest(r,c)) {
                --r;
                st.push("w");
                mark(r,c,++p);
            }  else if (canNorth(r,c)) {
                --c;
                st.push("n");
                mark(r,c,++p);
            }  else if (canEast(r,c)) {
                ++r;
                st.push("e");
                mark(r,c,++p);
            }  else if (canSouth(r,c)) {
                ++c;
                st.push("s");
                mark(r,c,++p);
            } else {
                String back = st.pop();
                if (back.equals("w")) {
                    markBlocked(r,c,--p);
                    ++r;
                } else if (back.equals("n")) {
                    markBlocked(r,c,--p);
                    ++c;
                } else if (back.equals("e")) {
                    markBlocked(r,c,--p);
                    --r;
                } else if (back.equals("s")) {
                    markBlocked(r,c,--p);
                    --c;
                }
            }
            System.err.println("(r+1): " + (r+1) + "\t" + "(c+1): " + (c+1) + "\t" + "x2: " + x2 + "\t" + "y2: " + y2);
        }
        print();
    }

    public void mark(int r, int c, int n) {
        int x = (r*4)+1;
        int y = (c*2)+1;
        String number = ""+n;
        if (number.length() == 1) {
            grid[y][x+2] = number;
        } else if (number.length() == 2) {
            grid[y][x+1] = "" + number.charAt(0);
            grid[y][x+2] = "" + number.charAt(1);
        } else if (number.length() == 3) {
            grid[y][x+0] = "" + number.charAt(0);
            grid[y][x+1] = "" + number.charAt(1);
            grid[y][x+2] = "" + number.charAt(2);
        }
    }

    public void markBlocked (int r, int c, int n) {
        int x = (r*4)+1;
        int y = (c*2)+1;
        grid[y][x] = "?";
        grid[y][x+1] = "?";
        grid[y][x+2] = "?";
    }

    public boolean canWest(int r, int c) {
        int x = (r*4)+1;
        int y = (c*2)+1;
        boolean isBlocked;
        try {
            isBlocked = hasBeen(r-1,c);
        } catch (Exception e) {
            isBlocked = false;
        }
        return grid[y][x-1].equals(" ") && !isBlocked;
    }

    public boolean canNorth(int r, int c) {
        int x = (r*4)+1;
        int y = (c*2)+1;
        boolean isBlocked;
        try {
            isBlocked = hasBeen(r,c-1);
        } catch (Exception e) {
            isBlocked = false;
        }
        return grid[y-1][x].equals(" ") && !isBlocked;
    }

    public boolean canEast(int r, int c) {
        int x = (r*4)+1;
        int y = (c*2)+1;
        boolean isBlocked;
        try {
            isBlocked = hasBeen(r+1,c);
        } catch (Exception e) {
            isBlocked = false;
        }
        return grid[y][x+3].equals(" ") && !isBlocked;
    }

    public boolean canSouth(int r, int c) {
        int x = (r*4)+1;
        int y = (c*2)+1;
        boolean isBlocked;
        try {
            isBlocked = hasBeen(r,c+1);
        } catch (Exception e) {
            isBlocked = false;
        }
        return grid[y+1][x].equals(" ") && !isBlocked;
    }

    public boolean hasBeen(int r, int c) {
        int x = (r*4)+1;
        int y = (c*2)+1;
        return !grid[y][x+2].equals(" ");
    }

    public void setup() {
        h = w = x = y = x2 = y2 = r = c = 0;
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

