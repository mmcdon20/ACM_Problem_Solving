package MidCentralUSA.R2005.Netiquette;
/*

A message is suspicious if it contains any of the following:

	two adjacent uppercase letters,
	(because you might be SHOUTING)
	
	a digit adjacent to a letter,
	(because you might be l33t, d00d)
	
	an isolated character other than a, A, or I,
	(because u r probably abbreviating words; the spell checker doesn't catch this for some reason)
	
	two adjacent punctuation marks, unless one of them is a double quote (the character `"').
	(because you might be using an emoticon :-)

OUTPUT:
	OK
	suspicious

"This is a safe message," said 50 wise men.
DON'T b l8 for the Apple ][ user's group meeting.
I ate at "Al's Big Burritos" for lunch!
It's not OK to burp at your grandmother.
*BuT* YoU _CaN_ Do ThIs, YoU KnOw.
We 8 eight oranges.
#

 
*/


import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "#";
	int count = 0;
	
	public void readInput(String input) {
		boolean safe = true;
		
		for (int i = 0; i < input.toCharArray().length-1; i++) {
			char c1 =  input.toCharArray()[i];
			char c2 =  input.toCharArray()[i+1];
			if (isU(c1) && isU(c2)) { // two upper case letters
				safe = false;
			} else if (isD(c1) && isU(c2)) { // letter and digit
				safe = false;
			} else if (isU(c1) && isD(c2)) { // letter and digit
				safe = false;
			} else if (isD(c1) && isL(c2)) { // letter and digit
				safe = false;
			} else if (isL(c1) && isD(c2)) { // letter and digit
				safe = false;
			} else if (isP(c1) && isP(c2)) { // two punctuation marks
				safe = false;
			} 
		}
		
		input.replaceAll("\"", "");
		for(String s: input.split(" ")) {
			if (s.length() == 1) {
				if (!(s.equals("a") || s.equals("A") || s.equals("I"))) {
					safe = false;
				}
			}
		}
		
		System.out.println((safe) ? "OK" : "suspicious");
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
	
	public boolean isU(char ch) {
		return Character.isUpperCase(ch);
	}
	
	public boolean isL(char ch) {
		return Character.isLowerCase(ch);
	}
	
	public boolean isD(char ch) {
		return Character.isDigit(ch);
	}
	
	public boolean isP(char ch) {
		return ".,:;!?'-_*+=()[]{}<>/\\".contains(""+ch);
	}
}
