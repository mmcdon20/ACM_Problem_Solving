package MidCentralUSA.R2007.RockSkipping;

import java.util.Scanner;

public class Main {
	
	Scanner scanner;
	public static String END = "END";

	public String processInput(String input) {
		int i = 0;
		int d = 1;
		int besti = i;
		int bestd = d;
		int skips = 0;
		int bestSkips = skips;
		char[] cs = input.toCharArray();
		
		for (i = 0; i < cs.length; i++) {
			for (d = 1; d < cs.length; d++) {
				skips = 0;
				
				if (i + d > cs.length)
					break;
				
				for (int t = i; t < cs.length; t += d) {
					skips++;
					if (cs[t] != '.')
						break;
				}
				
				if (skips >= bestSkips) {
					bestSkips = skips;
					besti = i;
					bestd = d;
				}
			}
		}
		return "" + besti + " " + bestd;
	}
	
	public Main() {
		scanner = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
        Main m = new Main();
        m.loop();
	}
	
	public void loop() {
        Scanner scanner = new Scanner(System.in);
        String input;
        
        while (true) {
			input = scanner.nextLine();
			if (isEnd(input))
				break;
			System.out.println(processInput(input));
        }
        
        scanner.close();
	}
	
	public boolean isEnd(String input) {
		return input.equals(END);
	}
}
