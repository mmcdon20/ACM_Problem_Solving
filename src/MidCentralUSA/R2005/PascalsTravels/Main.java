package MidCentralUSA.R2005.PascalsTravels;

import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "-1";
	int count = -1;
	int[][] table;
	int[][] result;
	int n;
	int row = 0;

	public void print(int[][] t) {
		for (int[] i : t) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	public int steps(int i, int j) {
		int c = table[i][j];
		int s = 0;

		if (c + i < n) {
			s += result[i+c][j];
		}

		if (c + j < n) {
			s += result[i][j+c];
		}
		
		return s;
	}
	
	public int processInput() {
		for (int i = n-1; i >= 0; i--) {
			for (int j = n-1; j >= 0; j--) {
				if (i == j && i == n-1) {
					result[i][j] = 1;
				} else {
					result[i][j] = steps(i,j);
				}
			}
		}
		return result[0][0];
	}
	
	public void readInput(String input) {
		input = input.trim();
		char[] inputs = input.toCharArray();
		if (count == -1) {
			count = n = Integer.parseInt(input);
			table = new int[n][n];
			result = new int[n][n];
			result[n-1][n-1] = 1;
			row = 0;
		} else {
			for (int i = 0; i < n; i++) {
				table[row][i] = Integer.parseInt(""+inputs[i]);
			}
			++row;
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
        	} else if (count == 0) {
        		readInput(input);
        		System.out.println(processInput());
        		count = -1;
        	} else {
        		readInput(input);
        		--count;
        	}
        }
	}
	
	public boolean isEnd(String input) {
		return input.equals(END);
	}
}
