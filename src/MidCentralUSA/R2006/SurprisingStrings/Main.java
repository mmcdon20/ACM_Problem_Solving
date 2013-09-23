package MidCentralUSA.R2006.SurprisingStrings;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "*";

	public String processInput(String input) {
		input = input.trim();
		if (input.length() == 1 || input.length() == 2)
			return input + " is surprising.";
		
		char[] cs = input.toCharArray();

		for (int i = 1; i < input.length()-1; i++) {
			ArrayList<String> temp = new ArrayList<String>();
			
			for (int j = 0; j < input.length()-i; j++) {
				String s = ""+cs[j]+cs[j+i];
				temp.add(s);
			}

			for (int n = 0; n < temp.size(); n++) {
				for (int m = 0; m < temp.size(); m++) {
					if(temp.get(m).equals(temp.get(n))) {
						if (m != n) {
							return input + " is NOT surprising.";
						}
					}
				}
			}
		}
		
		return input + " is surprising.";
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
