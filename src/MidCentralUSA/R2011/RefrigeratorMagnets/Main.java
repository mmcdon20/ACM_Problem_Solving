package MidCentralUSA.R2011.RefrigeratorMagnets;
/*

I LOVE YOU
I LOVE MUSTARD
HAPPY BIRTHDAY
GLAD U BORN
SMILE
IMAGINE
WHATS UP DOC
HAVE A NICE DAY
END

 */

import java.util.*;

public class Main {
	Scanner scanner;
	public static String END = "END";
	ArrayList<String> letters = new ArrayList<String>();
	
	public void readInput(String input) {
		setup();
		char[] chars = input.replaceAll(" ", "").toCharArray();
		for (char c : chars) {
			if (letters.contains(""+c)) {
				letters.remove(""+c);
			} else {
				return;
			}
		}
		System.out.println(input);
	}

	public void setup() {
		letters = new ArrayList<String>();
		letters.add("A");
		letters.add("B");
		letters.add("C");
		letters.add("D");
		letters.add("E");
		letters.add("F");
		letters.add("G");
		letters.add("H");
		letters.add("I");
		letters.add("J");
		letters.add("K");
		letters.add("L");
		letters.add("M");
		letters.add("N");
		letters.add("O");
		letters.add("P");
		letters.add("Q");
		letters.add("R");
		letters.add("S");
		letters.add("T");
		letters.add("U");
		letters.add("V");
		letters.add("W");
		letters.add("X");
		letters.add("Y");
		letters.add("Z");
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

