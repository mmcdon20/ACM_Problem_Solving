package MidCentralUSA.R2003.Robots;/*

1 2
1 4
2 4
2 6
4 4
4 7
6 6
0 0
1 1
2 2
4 4
0 0
-1 -1

*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	Scanner scanner;
	public static String END = "-1 -1";
	ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
	
	public void readInput(String input) {
		if (input.equals("0 0")) {
			evalInput();
		} else {
			int x = Integer.parseInt(input.split(" ")[0]);
			int y = Integer.parseInt(input.split(" ")[0]);
			ArrayList<Integer> set = new ArrayList<Integer>();
			set.add(x);
			set.add(y);
			nums.add(set);
		}
	}
	
	public void evalInput() {
		int count = 0;
		Stack<ArrayList<Integer>> sets = new Stack<ArrayList<Integer>>();
		
		while (nums.size() > 0) {
			int x = 0;
			int y = 0;
			
			for (ArrayList<Integer> set : nums) {
				int gx = set.get(0);
				int gy = set.get(1);
				if (y <= gy && x < gx) {
					y = gy;
					x = gx;
					sets.push(set);
				} 
			}
			
			while (!sets.isEmpty()) {
				nums.remove(sets.pop());
			}

			++count;
		}
		System.out.println(count);
	}

	public Main() throws Exception {
		scanner = new Scanner(System.in);
	}
	
	public static void main(String[] args) throws Exception  {
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
