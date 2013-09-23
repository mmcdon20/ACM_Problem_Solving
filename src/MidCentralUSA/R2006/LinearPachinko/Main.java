package MidCentralUSA.R2006.LinearPachinko;

import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "#";

	public int processInput(String input) {
		input = input.trim();
		int divisor = input.length();
		input = " " + input + " ";
		char[] cs = input.toCharArray();
		int total = 0;
		
		for (int i = 1; i < input.length()-1; i++) {
			if (cs[i] == '.') { // hole 100%
				total += 100;
			} else if (cs[i] == '_') { // floor
				total += 0;
			} else if (cs[i] == '/') { // mountain left
				total += (rollOff(cs,i,-1)) ? 100 : 0;
			} else if (cs[i] == '\\') { // mountain right
				total += (rollOff(cs,i,1)) ? 100 : 0;
			} else if (cs[i] == '|') { // wall
				int subtotal = 0;
				subtotal += (rollOff(cs,i,-1)) ? 100 : 0;
				subtotal += (rollOff(cs,i,1)) ? 100 : 0;
				subtotal /= 2;
				total += subtotal;
			}
		}
		
		return total/divisor;
	}
	
	public static boolean rollOff(char[] cs, int i, int d) {
		while (true) {
			i += d;
			if (cs[i] == '.' || cs[i] == ' ')
				return true;
			if (cs[i] == '/' || cs[i] == '\\' || cs[i] == '|')
				return false;
		}
	}
	
	public Main() {
		scanner = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
        Main m = new Main();
        m.loop();
	}
	
	public void loop() {
        while (true) {
        	String input = scanner.nextLine();
			if (isEnd(input))
				break;
			System.out.println(processInput(input));
        }
	}
	
	public boolean isEnd(String input) {
		return input.equals(END);
	}
}
