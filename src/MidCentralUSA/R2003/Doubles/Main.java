package MidCentralUSA.R2003.Doubles;/*

1 4 3 2 9 7 18 22 0
2 4 8 10 0
7 5 11 13 1 3 0
-1

*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "-1";
	public ArrayList<Integer> nums = new ArrayList<Integer>();
	public ArrayList<Integer> dubs = new ArrayList<Integer>();
	
	public void readInput(String input) {
		nums = new ArrayList<Integer>();
		dubs = new ArrayList<Integer>();
		for (String i : input.split(" ")) {
			int n = Integer.parseInt(i);
			nums.add(n);
			dubs.add(n*2);
		}
		int count = 0;
		for (int i : dubs) {
			for (int j : nums) {
				if (i == j) {
					if (i != 0) {
						count++;
					}
				}
			}
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
				return;
        	} else {
        		readInput(input);
        	}
        }
	}
	
	public boolean isEnd(String input) {
		return input.equals(END);
	}
}
