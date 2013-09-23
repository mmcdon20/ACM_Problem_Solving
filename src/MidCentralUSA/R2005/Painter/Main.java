package MidCentralUSA.R2005.Painter;
/*
 
 
3 40 95 21 0
7 25 60 400 250 0 60 0 500
4 90 95 75 95 10
4 90 95 75 95 11
5 0 0 0 0 0 333
0

 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "0";
	int n = 0;
	int g = 0;
	ArrayList<Integer> colors = new ArrayList<Integer>();
	
	public void readInput(String input) {
		n = Integer.parseInt(input.split(" ")[0]);
		colors = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			colors.add(Integer.parseInt(input.split(" ")[i]));
		}
		g = Integer.parseInt(input.split(" ")[n+1]);
		evalInput();
	}
	
	public void evalInput() {
		if (g == 0) {
			computeKits();
		} else {
			makeGray();
			computeKits();
		}
	}
	
	public void makeGray() {
		while (g > 0) {
			Collections.sort(colors);
			colors.set(0,colors.get(0)+1);
			colors.set(1,colors.get(1)+1);
			colors.set(2,colors.get(2)+1);
			--g;
		}
	}
	
	public void computeKits() {
		int j = -1;
		for (int i : colors) if (i > j) j = i;
		int result = (int)Math.ceil(((double)j)/50.0);
		System.out.println(result);
	}
	
	public void print() {
		System.out.println("N: " + n + " G: " + g);
		for (int i : colors)
			System.out.print(i + " ");
		System.out.println("\n");
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
