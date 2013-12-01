package MidCentralUSA.R2013.RoundRobin;

import java.util.*;

public class Main {
    Scanner scanner = new Scanner(System.in);
    public static String END = "0";

    public void readInput(String input) {
        int N = Integer.parseInt(input.split(" ")[0]);
        int T = Integer.parseInt(input.split(" ")[1]);

        ArrayList<Integer> board = new ArrayList<Integer>();
        for (int i = 0; i < N; i++){
            board.add(new Integer(0));
        }

        int j = -1;

        while (true) {
            for (int i = 0; i < T; i++) {
                j = (j+1) % board.size();
                board.set(j,board.get(j)+1);
            }

            board.remove(j);
            boolean same = true;
            int num = board.get(0);

            for (Integer i : board) {
                if (!(num == i)) {
                    same = false;
                }
            }

            if (same) {
                break;
            } else {
                --j;
            }
        }
        System.out.println("" + board.size() + " " + board.get(0));
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
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
