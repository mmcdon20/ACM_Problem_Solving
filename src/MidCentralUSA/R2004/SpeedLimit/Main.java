package MidCentralUSA.R2004.SpeedLimit;/*

3
20 2
30 6
10 7
2
60 1
30 5
4
15 1
25 2
30 3
10 5
-1

*/

import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "-1";
	int time = 0;
	int hours = 0;
	int speed = 0;
	int count = 0;
	int result = 0;
	
	public void readInput(String input) {
		if (input.split(" ").length == 1) {
			count = Integer.parseInt(input);
			hours = 0;
			speed = 0;
			result = 0;
			time = 0;
		} else {
			speed = Integer.parseInt(input.split(" ")[0]);
			hours = Integer.parseInt(input.split(" ")[1]) - time;
			time  = Integer.parseInt(input.split(" ")[1]);
			result += hours*speed;
			if (count == 1) {
				System.out.println(result + " miles");
			} else {
				--count;
			}
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
