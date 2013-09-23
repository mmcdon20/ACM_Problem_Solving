package MidCentralUSA.R2006.Quicksum;

import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "#";

	public int processInput(String input) {
		
		char[] cs = input.toCharArray();
		int total = 0;
		
		for (int i = 0; i < cs.length; i++) {
			int n = (cs[i]==' ') ? 0 : ((int)cs[i])-64;
			total += (n*(i+1));
		}

		return total;
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
