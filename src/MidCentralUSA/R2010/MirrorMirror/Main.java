package MidCentralUSA.R2010.MirrorMirror;

/*

boowxod
bidi
bed
bbb
#


 */

import java.util.*;

public class Main {
	Scanner scanner;
	public static String END = "#";
	ArrayList<String> invalid = new ArrayList<String>();
	
	public void readInput(String input) {
		for (String i : invalid) {
			if (input.contains(i)) {
				System.out.println("INVALID");
				return;
			}
		}
		
		// b, d
		input = input.replaceAll("b", "1");
		input = input.replaceAll("d", "2");
		input = input.replaceAll("1", "d");
		input = input.replaceAll("2", "b");
		
		// p, q
		input = input.replaceAll("p", "1");
		input = input.replaceAll("q", "2");
		input = input.replaceAll("1", "q");
		input = input.replaceAll("2", "p");
		
		StringBuffer s = new StringBuffer(input);
		System.out.println(s.reverse());
	}

	public void setup() {
		invalid = new ArrayList<String>();
		invalid.add("a");
		//invalid.add("b");
		invalid.add("c");
		//invalid.add("d");
		invalid.add("e");
		invalid.add("f");
		invalid.add("g");
		invalid.add("h");
		//invalid.add("i");
		invalid.add("j");
		invalid.add("k");
		invalid.add("l");
		invalid.add("m");
		invalid.add("n");
		//invalid.add("o");
		//invalid.add("p");
		//invalid.add("q");
		invalid.add("r");
		invalid.add("s");
		invalid.add("t");
		invalid.add("u");
		//invalid.add("v");
		//invalid.add("w");
		//invalid.add("x");
		invalid.add("y");
		invalid.add("z");
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

