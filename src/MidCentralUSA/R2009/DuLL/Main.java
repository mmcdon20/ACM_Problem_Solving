package MidCentralUSA.R2009.DuLL;

import java.util.*;

/*

2 2 3
500 600
100 A
200 B
2 1 2
5 4 8
100 400 200 500 300
250 AC
360 ACE
120 AB
40 DE
2 3 4 -3 1 2 -2 1
0

*/

public class Main {
    public Scanner scanner;
    public static String END = "0";
    public HashMap<Character,DuLL> dulls;
    public ArrayList<Program> programs;
    public int state;
    public int N; // number of DuLLs available
    public int P; // number of programs which can be executed
    public int S; // number of state transitions recorded
    public char[] names = {
            'A','B','C','D',
            'E','F','G','H',
            'I','J','K','L',
            'M','N','O','P',
            'Q','R','S','T'};

    public void readInput(String input) {

        String[] inputs = input.split(" ");

        if (state == 0) {
            // first line gives N P AND S values
            N = Integer.parseInt(inputs[0]);
            P = Integer.parseInt(inputs[1]);
            S = Integer.parseInt(inputs[2]);
            state = 1;
        } else if (state == 1) {
            // second line gives the size of each DuLL
            // DuLLs are assigned a character name 'A', 'B', 'C' ... 'T'
            for (int i = 0; i < inputs.length; i++) {
                DuLL dull = new DuLL(names[i],Integer.parseInt(inputs[i]));
                dulls.put(dull.name,dull);
            }
            state = 2;
        } else if (state == 2) {
            // The next P lines each representing a program
            // The first number represents the size of the program
            // The following characters represent the required DuLLs
            int size = Integer.parseInt(inputs[0]);
            char[] dlls = inputs[1].toCharArray();
            programs.add(new Program(size,dlls));

            P--;

            if (P == 0) {
                state = 3;
            }
        } else if (state == 3) {
            // The final line of the data set will contain S space separated integers
            // Each integer will either be a positive number indicating a new program has run
            // or a negative number indicating a program has been completed
            ArrayList<Program> current = new ArrayList<Program>();
            int maxMemory = 0;

            for (String in : inputs) {
                int prog = Integer.parseInt(in);

                if (prog > 0) {
                    // add program
                    Program p = programs.get(prog-1);
                    current.add(p);
                } else {
                    // remove program
                    prog = -prog;
                    Program p = programs.get(prog-1);
                    current.remove(p);
                }
                // find total memory
                int currentMemory = calculateMemory(current);
                if (currentMemory > maxMemory) {
                    maxMemory = currentMemory;
                }
            }
            System.out.println(maxMemory);
            setup();
        }
    }

    public int calculateMemory (ArrayList<Program> state) {
        int size = 0;
        HashSet<DuLL> duLLSet = new HashSet<DuLL>();

        for (Program p : state) {
            size += p.size;
            for (char s : p.dlls) {
                DuLL d = dulls.get(s);
                duLLSet.add(d);
            }
        }

        for (DuLL d : duLLSet) {
            size += d.size;
        }

        return size;
    }

    public void setup() {
        N        = 0;
        S        = 0;
        P        = 0;
        state    = 0;
        dulls    = new HashMap<Character,DuLL>();
        programs = new ArrayList<Program>();
    }

    class Program {
        public int    size;
        public char[] dlls;

        Program (int size, char[] dlls) {
            this.size = size;
            this.dlls = dlls;
        }
    }

    class DuLL {
        public char name;
        public int  size;

        DuLL (char name, int size) {
            this.name = name;
            this.size = size;
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
