package MidCentralUSA.R2006.RootOfTheProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "0 0";

	public int processInput(String input) {
		int b = Integer.parseInt(input.split(" ")[0]);
		int n = Integer.parseInt(input.split(" ")[1]);
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		for (int i = 0; i <= b; i++) {
			int result = (int)Math.pow(i, n);
			results.add(result);
			if (result > b)
				break;
		}
		
		int distance = 1000000001;
		int answer = -1;
		
		for (int i = 0; i < results.size(); i++) {
			int d = Math.abs(results.get(i) - b);
			
			if (d < distance) {
				distance = d;
				answer = i;
			}
		}
		
		return answer;
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
