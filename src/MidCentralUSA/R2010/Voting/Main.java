package MidCentralUSA.R2010.Voting;
/*

YNNAPYYNY
YAYAYAYA
PYPPNNYA
YNNAA
NYAAA
#

*/

import java.util.*;

public class Main {
	Scanner scanner;
	public static String END = "#";
	
	public void readInput(String input) {
		int y = 0;
		int n = 0;
		int p = 0;
		int a = 0;
		
		int count = input.toCharArray().length;
		
		for (char c : input.toCharArray()) {
			if (c == 'Y')
				y++;
			else if (c == 'N')
				n++;
			else if (c == 'P')
				p++;
			else if (c == 'A')
				a++;
		}
		
		if (a >= count/2 + count%2) {
			System.out.println("need quorum");
		} else if (y == n) {
			System.out.println("tie");
		} else if (y > n) {
			System.out.println("yes");
		} else if (n > y) {
			System.out.println("no");
		}
	}
	
	public Main() throws Exception {
		scanner = new Scanner(System.in);
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

