package MidCentralUSA.R2000.EasierDoneThanSaid;
/*


INPUT
a
tv
ptoui
bontres
zoggax
wiinq
eep
houctuh
end

OUTPUT
<a> is acceptable.
<tv> is not acceptable.
<ptoui> is not acceptable.
<bontres> is not acceptable.
<zoggax> is not acceptable.
<wiinq> is not acceptable.
<eep> is acceptable.
<houctuh> is acceptable.



1. It must contain at least one vowel.
2. It cannot contain three consecutive vowels or three consecutive consonants.
3. It cannot contain two consecutive occurrences of the same letter, except for 'ee' or 'oo'.



*/

import java.util.*;

public class Main {
	Scanner scanner;
	public static String END = "end";
	
	public void readInput(String input) {
		print(test(input),input);
	}
	
	public void print(boolean cond, String input) {
		if (cond) {
			System.out.println("<" + input + ">" + " is acceptable.");
		} else {
			System.out.println("<" + input + ">" + " is not acceptable.");
		}
	}
	
	public boolean test(String input) {
		//1. It must contain at least one vowel.
		//2. It cannot contain three consecutive vowels or three consecutive consonants.
		//3. It cannot contain two consecutive occurrences of the same letter, except for 'ee' or 'oo'.
		
		boolean hasVowel = false;
		boolean noThree = true;
		boolean noTwo = true;
		
		if (input.length() == 1) {
			if (isVowel(input.charAt(0))) {
				return true;
			} else {
				return false;
			}
		}
		
		if (input.length() == 2) {
			if (input.charAt(0) == input.charAt(1)) {
				if (input.charAt(0) != 'e' || input.charAt(0) != 'o') {
					return false;
				}
			}
			
			if (isVowel(input.charAt(0)) || isVowel(input.charAt(0))) {
				return true;
			} else {
				return false;
			}
		}
		
		if (input.length() > 2) {
			char[] chars = input.toCharArray();
			
			for (int i = 0; i < chars.length-2; i++) {
				char c1 = chars[i+0];
				char c2 = chars[i+1];
				char c3 = chars[i+2];
				
				if (isVowel(c1) && isVowel(c2) && isVowel(c3)) {
					noThree = false; // no three
				}
				
				if (!isVowel(c1) && !isVowel(c2) && !isVowel(c3)) {
					noThree = false; // no three
				}
				
				if (c1 == c2 && !(c1 == 'e' || c1 == 'o')) {
					noTwo = false; // no two
				}
				
				if (c3 == c2 && !(c3 == 'e' || c3 == 'o')) {
					noTwo = false; // no two
				}
				
				if (isVowel(c1) || isVowel(c2) || isVowel(c3)) {
					hasVowel = true;
				}
			}
		}
		
		return hasVowel && noThree && noTwo;
	}

	public boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	public Main() throws Exception {
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) throws Exception {
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

