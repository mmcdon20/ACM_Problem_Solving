package MidCentralUSA.R2004.FlowLayout;/*
 
35
10 5
20 12
8 13
-1 -1
25
10 5
20 13
3 12
-1 -1
15
5 17
5 17
5 17
7 9
7 20
2 10
-1 -1
0

*/

import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "0";
	int width = 0;
	int remainingWidth = 0;
	int right = 0;
	int down = 0;
	int lastDown = 0;
	int maxRight = 0;
	int maxDown = 0;
	
	public void readInput(String input) {
		if (input.equals("-1 -1")) {
			System.out.println(maxRight + " x " + maxDown);
			width = 0;
			remainingWidth = 0;
			right = 0;
			down = 0;
			maxRight = 0;
			maxDown = 0;
			return;
		} else if (input.split(" ").length == 1) {
			width = Integer.parseInt(input);
		} else {
			int w = Integer.parseInt(input.split(" ")[0]);
			int h = Integer.parseInt(input.split(" ")[1]);
			
			if (w <= remainingWidth) {
				remainingWidth -= w;
				right += w;
				down = lastDown + h;
			} else {
				remainingWidth = width - w;
				right = w;
				lastDown = maxDown;
				down = lastDown + h;
			}
			
			if (right > maxRight) {
				maxRight = right;
			}
			if (down > maxDown) {
				maxDown = down;
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
