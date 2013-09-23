package MidCentralUSA.R2003.ClayBully;/*

3
10 10 2 Jill
5 3 10 Will
5 5 10 Bill
4
2 4 10 Cam
4 3 7 Sam
8 11 1 Graham
6 2 7 Pam
-1

*/

import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "-1";
	int count = -1;
	String bully = "";
	String victim = "";
	int min = 99999;
	int max = -1;
	
	public void readInput(String input) {
		if (count == -1) {
			count = Integer.parseInt(input);
			return;
		} else {
			--count;
			int x = Integer.parseInt(input.split(" ")[0]);
			int y = Integer.parseInt(input.split(" ")[1]);
			int z = Integer.parseInt(input.split(" ")[2]);
			String name = input.split(" ")[3];
			int size = x*y*z;
			System.out.println(name + ": " + size);
			if (size < min) {
				min = size;
				victim = name;
			} else if (size > max) {
				max = size;
				bully = name;
			}
		}
		
		if (count == 0) {
			System.out.println(bully + " took clay from " + victim + ".");
			count = -1;
			bully = "";
			victim = "";
			min = 99999;
			max = -1;
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
