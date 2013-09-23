package MidCentralUSA.R2009.CellTowers;

import java.util.*;

/*

INPUT:

2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
0

OUTPUT:

(0,A) (5,B) (10,A)
(0,A) (3,C) (9,B)
(0,A) (2,C)

*/

public class Main {
    Scanner scanner;
    public static String END = "0";
    public ArrayList<Coordinate> points;
    public ArrayList<Tower> towers;
    public int state;
    public int T; // the number of towers (1 <= T <= 10)
    public int R; // the number of line segments which comprise the road (1 <= R <= 10)
    public char[] names = {
            'A','B','C','D',
            'E','F','G','H',
            'I','J','K','L',
            'M','N','O','P',
            'Q','R','S','T',
            'U','V','W','X',
            'Y','Z'};
    public int name;

    public void readInput(String input) {
        String[] inputs = input.split(" ");

        if (state == 0) {
            // Read T and R
            T = Integer.parseInt(inputs[0]);
            R = Integer.parseInt(inputs[1]);
            state = 1;
        } else if (state == 1) {
            // The next T lines each contain three space separated
            // integers representing the X-coordinate, Y-coordinate, and
            // power of one tower, respectively. The towers are implicitly
            // labeled `A', `B', `C', and so on.
            // Instantiate a tower and add it to towers.
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            long p = Long.parseLong(inputs[2]);

            Coordinate c = new Coordinate(x,y);
            Tower t = new Tower(c,p,names[name]);

            towers.add(t);

            name++;
            T--;

            if (T == 0) {
                state = 2;
            }
        } else if (state == 2) {
            // The next line contains 2(R + 1) integers which are the
            // coordinates for the R + 1 points that define the road.
            // The road starts on the first point and moves in straight
            // line segments through all R remaining points.
            // Read points, instantiate a road, and simulate outcome.
            for (int i = 0; i < inputs.length-1; i+=2) {
                int x = Integer.parseInt(inputs[i]);
                int y = Integer.parseInt(inputs[i]);
                Coordinate c = new Coordinate(x,y);
                points.add(c);
            }

            printData();
            simulate();
            setup();
        }
    }

    public void printData() {
        System.err.println("ROAD:");
        for (Coordinate c : points) {
            System.err.println("x: " + c.x + ", y: " + c.y);
        }

        System.err.println("TOWERS:");
        for (Tower t : towers) {
            System.err.println("x: " + t.c.x + ", y: " + t.c.y + ", p: " + t.p + ", name: " + t.name);
        }

        System.err.println();
    }

    public void setup() {
        state = 0;
        name = 0;
        T = 0;
        R = 0;
        points = new ArrayList<Coordinate>();
        towers = new ArrayList<Tower>();
    }

    ////////////////////////////////////////
    ////////////////////////////////////////
    ////////////////////////////////////////
    ////////////////////////////////////////
    ////////////////////////////////////////

    public void simulate() {
        // TODO - traverse miles until end of road, checking best signal at each mile.
        Coordinate current = points.get(0);
        int c = 1;
    }

    private void checkMile (int m) {
        // TODO - check current coordinates for best signal if signal different from last then print signal


        if (false) {
            System.out.println("(" + m + "," + "TOWER" + ")");
        }
    }

    private Coordinate moveMile(Coordinate current, int c) {
        float cx = current.x;
        float cy = current.y;

        Coordinate target = points.get(c);

        float tx = target.x;
        float ty = target.y;

        // TODO - find nx and ny from cx,cy and tx,ty
        float nx = 0;
        float ny = 0;

        Coordinate next = new Coordinate(nx,ny);
        return next;
    }

    ////////////////////////////////////////
    ////////////////////////////////////////
    ////////////////////////////////////////
    ////////////////////////////////////////
    ////////////////////////////////////////

    class Coordinate {
        float x, y;
        Coordinate(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    class Tower {
        Coordinate c;
        long p;
        char name;
        Tower(Coordinate c, long p, char name) {
            this.c = c;
            this.p = p;
            this.name = name;
        }
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
