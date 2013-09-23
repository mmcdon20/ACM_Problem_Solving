package MidCentralUSA.R2004.PrimaryXSubfactorSeries;/*

123456789
7
2004
6341
8013824
0

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "0";
	public int n;
	HashSet<Integer> numbs = new HashSet<Integer>();

	public void readInput(String input) {
		n = Integer.parseInt(input);
		numbs = new HashSet<Integer>();
		ArrayList<String> subSequences = new Combinations().generate(input);
		for (String s : subSequences) {
			System.out.println(s);
		}
	}
	
	public void findSubFactors(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = i+1; j < input.length()+1; j++) {
				String subs = input.substring(i,j);
				
				if (subs.startsWith("0")) {
					continue;
				}
				int num = Integer.parseInt(subs);
				if (n % num == 0)  {
					numbs.add(num);
				}
			}
		}
	}

	public void print() {
		
	}

	class Combinations {
		String input;
		StringBuilder cur;
		ArrayList<String> result;

		private void next(int pos, int reminder) {
			cur.append(input.charAt(pos));
			if (reminder == 1) {
				result.add(cur.toString());
			} else {
				for (int i = pos + 1; i + reminder - 1 <= input.length(); i++) {
					next(i, reminder - 1);
				}
			}
			cur.deleteCharAt(cur.length() - 1);
		}
		
		private ArrayList<String> filter() {
			ArrayList<String> ret = new ArrayList<String>();
			for (String r : result) {
				if (r.startsWith("0")) {
					continue;
				}
				if (n % Integer.parseInt(r) != 0) {
					continue;
				}
				ret.add(r);
			}
			return ret;
		}

		public ArrayList<String> generate(String input) {
			cur = new StringBuilder();
			result = new ArrayList<String>();
			this.input = input;
			for (int length = 1; length <= input.length(); length++) {
				for (int pos = 0; pos + length <= input.length(); pos++) {
					next(pos, length);
				}
			}
			return filter();
		}
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
