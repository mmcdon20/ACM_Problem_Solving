package MidCentralUSA.R2011.Sokoban;

import java.util.Scanner;

/*

8 9
#########
#...#...#
#..bb.b.#
#...#w#.#
#...#b#.#
#...++++#
#...#..##
#########
ULRURDDDUULLDDD
6 7
#######
#..####
#.+.+.#
#.bb#w#
##....#
#######
DLLUDLULUURDRDDLUDRR
0 0

*/

public class Main {
    Scanner scanner;
    public static String END = "0 0";
    public static final char SPACE         = '.';
    public static final char WALL          = '#';
    public static final char TARGET        = '+';
    public static final char BOX           = 'b';
    public static final char TARGET_BOX    = 'B';
    public static final char WORKER        = 'w';
    public static final char TARGET_WORKER = 'W';
    public int row;
    public int rows;
    public int cols;
    public int state;
    public int x;
    public int y;
    public int t;
    public int count = 0;
    public char[][] grid;

    public void readInput(String input) {
        if (state == 0) { // read r and c
            String[] data = input.split(" ");
            rows = Integer.parseInt(data[0]);
            cols = Integer.parseInt(data[1]);
            grid = new char[rows][cols];
            state = 1;
        } else if (state == 1) {
            grid[row] = input.toCharArray();
            row++;
            if (row == rows) {
                state = 2;
            }
        } else if (state == 2) {
            scanGrid();
            for (char c : input.toCharArray()) {
                if (c == 'U') {
                    //System.err.println("Up");
                    moveUp();
                }  else if (c == 'D') {
                    //System.err.println("Down");
                    moveDown();
                }  else if (c == 'L') {
                    //System.err.println("Left");
                    moveLeft();
                }  else if (c == 'R') {
                    //System.err.println("Right");
                    moveRight();
                }
                //errGrid();
                if (hasWon()) {
                    break;
                }
            }
            printGrid();
            setup();
        }
    }

    public boolean hasWon() {
        int b = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'B') {
                    b++;
                }
            }
        }
        return t == b;
    }

    public void moveUp() {
        // x = collumn
        // y = row
        char upOne = grid[y-1][x];
        char upTwo = y-2 < 0 ? '#' : grid[y-2][x];
        char worker = grid[y][x];

        //System.err.println("up1 " + upOne);
        //System.err.println("up2 " + upTwo);

        if (upOne == '.') {
            grid[y][x] = worker == 'w' ? '.' : '+';
            grid[y-1][x] = 'w';
            y = y-1;
        } else if (upOne == '#') {
            // do nothing
        } else if (upOne == '+') {
            grid[y][x] = worker == 'w' ? '.' : '+';
            grid[y-1][x] = 'W';
            y = y-1;
        } else if (upOne == 'b') {
            if (upTwo == '.') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y-1][x] = 'w';
                grid[y-2][x] = 'b';
                y = y-1;
            } else if (upTwo == '+') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y-1][x] = 'w';
                grid[y-2][x] = 'B';
                y = y-1;
            }
        } else if (upOne == 'B') {
            if (upTwo == '.') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y-1][x] = 'W';
                grid[y-2][x] = 'b';
                y = y-1;
            } else if (upTwo == '+') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y-1][x] = 'W';
                grid[y-2][x] = 'B';
                y = y-1;
            }
        }
    }

    public void moveDown() {
        // x = collumn
        // y = row
        char downOne = grid[y+1][x];
        char downTwo = y+2 > rows-1 ? '#' : grid[y+2][x];
        char worker = grid[y][x];

        //System.err.println("down1 " + downOne);
        //System.err.println("down2 " + downTwo);

        if (downOne == '.') {
            grid[y][x] = worker == 'w' ? '.' : '+';
            grid[y+1][x] = 'w';
            y = y+1;
        } else if (downOne == '#') {
            // do nothing
        } else if (downOne == '+') {
            grid[y][x] = worker == 'w' ? '.' : '+';
            grid[y+1][x] = 'W';
            y = y+1;
        } else if (downOne == 'b') {
            if (downTwo == '.') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y+1][x] = 'w';
                grid[y+2][x] = 'b';
                y = y+1;
            } else if (downTwo == '+') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y+1][x] = 'w';
                grid[y+2][x] = 'B';
                y = y+1;
            }
        } else if (downOne == 'B') {
            if (downTwo == '.') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y+1][x] = 'W';
                grid[y+2][x] = 'b';
                y = y+1;
            } else if (downTwo == '+') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y+1][x] = 'W';
                grid[y+2][x] = 'B';
                y = y+1;
            }
        }
    }

    public void moveLeft() {
        // x = collumn
        // y = row
        char upOne = grid[y][x-1];
        char upTwo = x-2 < 0 ? '#' : grid[y][x-2];
        char worker = grid[y][x];

        //System.err.println("left1 " + upOne);
        //System.err.println("left2 " + upTwo);

        if (upOne == '.') {
            grid[y][x] = worker == 'w' ? '.' : '+';
            grid[y][x-1] = 'w';
            x = x-1;
        } else if (upOne == '#') {
            // do nothing
        } else if (upOne == '+') {
            grid[y][x] = worker == 'w' ? '.' : '+';
            grid[y][x-1] = 'W';
            x = x-1;
        } else if (upOne == 'b') {
            if (upTwo == '.') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y][x-1] = 'w';
                grid[y][x-2] = 'b';
                x = x-1;
            } else if (upTwo == '+') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y][x-1] = 'w';
                grid[y][x-2] = 'B';
                x = x-1;
            }
        } else if (upOne == 'B') {
            if (upTwo == '.') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y][x-1] = 'W';
                grid[y][x-2] = 'b';
                x = x-1;
            } else if (upTwo == '+') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y][x-1] = 'W';
                grid[y][x-2] = 'B';
                x = x-1;
            }
        }
    }

    public void moveRight() {
        // x = collumn
        // y = row
        char upOne = grid[y][x+1];
        char upTwo = x+2 > cols-1 ? '#' : grid[y][x+2];
        char worker = grid[y][x];

        //System.err.println("right1 " + upOne);
        //System.err.println("right2 " + upTwo);

        if (upOne == '.') {
            grid[y][x] = worker == 'w' ? '.' : '+';
            grid[y][x+1] = 'w';
            x = x+1;
        } else if (upOne == '#') {
            // do nothing
        } else if (upOne == '+') {
            grid[y][x] = worker == 'w' ? '.' : '+';
            grid[y][x+1] = 'W';
            x = x+1;
        } else if (upOne == 'b') {
            if (upTwo == '.') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y][x+1] = 'w';
                grid[y][x+2] = 'b';
                x = x+1;
            } else if (upTwo == '+') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y][x+1] = 'w';
                grid[y][x+2] = 'B';
                x = x+1;
            }
        } else if (upOne == 'B') {
            if (upTwo == '.') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y][x+1] = 'W';
                grid[y][x+2] = 'b';
                x = x+1;
            } else if (upTwo == '+') {
                grid[y][x] = worker == 'w' ? '.' : '+';
                grid[y][x+1] = 'W';
                grid[y][x+2] = 'B';
                x = x+1;
            }
        }
    }

    public void scanGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'w' || grid[i][j] == 'W') {
                    x = j;
                    y = i;
                }
                if (grid[i][j] == '+' || grid[i][j] == 'W' || grid[i][j] == 'B') {
                    t++;
                }
            }
        }
    }

    public void errGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.err.print(grid[i][j]);
            }   System.err.println();
        }
    }

    public void printGrid() {
        String completion;

        if (hasWon()) {
            completion = "complete";
        }  else {
            completion = "incomplete";
        }

        System.out.println("Game " + (++count) + ": " + completion);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }   System.out.println();
        }
    }

    public void setup() {
        row = 0;
        rows = 0;
        cols = 0;
        state = 0;
        x = 0;
        y = 0;
        t = 0;
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
