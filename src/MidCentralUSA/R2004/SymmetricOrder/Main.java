package MidCentralUSA.R2004.SymmetricOrder;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	Scanner scanner;
	public static String END = "0";
	public boolean print = true;
	public Stack<String> tail = new Stack<String>();
	public int count = -1;
	public int set = 0;
	
	public void readInput(String input) {
		if (count == -1) {
			count = Integer.parseInt(input);
			print = true;
			++set;
			System.out.println("SET " + set);
		} else if (print) {
			System.out.println(input);
			--count;
			print = !print;
		} else {
			tail.push(input);
			--count;
			print = !print;
		}
		
		if (count == 0) {
			while (!tail.isEmpty())
				System.out.println(tail.pop());			
			--count;
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
