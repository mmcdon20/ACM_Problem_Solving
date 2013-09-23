package MidCentralUSA.R2008.Steganography;

import java.util.Scanner;

public class Main {

	public String processInput(String input) {
		
		String bin = "";
		String out = "";
		
		char[] cs = input.toCharArray();
		
		int numInRow = 0;
		for (char c : cs) {
			if (c == ' '){
				++numInRow;
			} else if (numInRow > 0) {
				bin += (numInRow % 2 == 0) ? 1 : 0;
				numInRow = 0;
			} else {
				numInRow = 0;
			}
		}

		String[] bins = bin.split("(?<=\\G.....)"); // Split at every 5 chars		
		for (String b : bins) {
			while(b.length() < 5) {
				b += "0";
			}
			out += binChar(b);
		}
		
		return out;
	}
	
	public String binChar(String s) {
		     if (s.equals("00000")) return " ";
        else if (s.equals("00001")) return "A";
        else if (s.equals("00010")) return "B";
        else if (s.equals("00011")) return "C";
        else if (s.equals("00100")) return "D";
        else if (s.equals("00101")) return "E";
        else if (s.equals("00110")) return "F";
        else if (s.equals("00111")) return "G";
        else if (s.equals("01000")) return "H";
        else if (s.equals("01001")) return "I";
        else if (s.equals("01010")) return "J";
        else if (s.equals("01011")) return "K";
        else if (s.equals("01100")) return "L";
        else if (s.equals("01101")) return "M";
        else if (s.equals("01110")) return "N";
        else if (s.equals("01111")) return "O";
        else if (s.equals("10000")) return "P";
        else if (s.equals("10001")) return "Q";
        else if (s.equals("10010")) return "R";
        else if (s.equals("10011")) return "S";
        else if (s.equals("10100")) return "T";
        else if (s.equals("10101")) return "U";
        else if (s.equals("10110")) return "V";
        else if (s.equals("10111")) return "W";
        else if (s.equals("11000")) return "X";
        else if (s.equals("11001")) return "Y";
        else if (s.equals("11010")) return "Z";
        else if (s.equals("11011")) return "'";
        else if (s.equals("11100")) return ",";
        else if (s.equals("11101")) return "-";
        else if (s.equals("11110")) return ".";
        else if (s.equals("11111")) return "?";
        else                        return "default";
	}
	
	public Main() {
	}
	
	public static void main(String[] args) {
        Main m = new Main();
        m.loop();
	}
	
	public void loop() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String line = "";
        
        boolean done = false;
        
        while (true) {
        	while(scanner.hasNext()) {
        		line = scanner.nextLine();
        		if (line.equals("*")) {
        			System.out.println(processInput(input));
        			break;
        		}
        		if (line.equals("#")){
        			done = true;
        			break;
        		}
        		input += line;
        	}
			input = "";
			line = "";
			if (done) {
				break;
			}
        }
        
        scanner.close();
	}
}
