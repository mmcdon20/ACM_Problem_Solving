package MidCentralUSA.R2006.FrugalSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	Scanner scanner;
	public static String END = "#";
	ArrayList<String> words = new ArrayList<String>();
	public boolean morewords = true;

	public void processInput(String input) {
		input = input.trim();
		
		if (input.equals("*")) {
			Collections.sort(words);
			morewords = false;
			return;
		} else if (input.equals("**")) {
			System.out.println("$");
			words = new ArrayList<String>();
			morewords = true;
			return;
		}
		
		if (morewords) {
			words.add(input);
		} else {
			System.out.println(query(words, input));
		}
	}
	
	public String query(ArrayList<String> words, String query) {
		
		Search s = new Search(query);
		
		for(String word : words) {
			for (Term t : s.terms) {
				boolean passu = false;
				boolean passp = true;
				boolean passn = true;
				
				for (Character c : t.unsigned) {
					if (word.contains(""+c)) {
						passu = true;
						break;
					}
				}
				for (Character c : t.positive) {
					if (!word.contains(""+c)) {
						passp = false;
						break;
					}
				}
				for (Character c : t.negative) {
					if (word.contains(""+c)) {
						passu = false;
						break;
					}
				}
				
				if (passu && passp && passn){
					return word;
				}
			}
		}
		
		return "NONE";
	}

	class Search {
		public ArrayList<Term> terms;
		int type = 0;
		
		public String toString() {
			String ts = "";
			for (Term t : terms)
				ts += t.toString() + "\n";
			return ts;
		}
		
		public Search(String query) {
			terms = new ArrayList<Term>();
			String[] termstrings = query.split("\\|");
			for (String term : termstrings) {
				Term temp = new Term();
				type = 0;
				for (char c : term.toCharArray()) {

					if (c == '+') {
						type = 1;
						continue;
					} else if (c == '-') {
						type = 2;
						continue;
					}
					
					if (type == 0) {
						temp.unsigned.add(c);
					} else if (type == 1) {
						temp.positive.add(c);
					} else if (type == 2) {
						temp.negative.add(c);
					}
					
					terms.add(temp);
				}
			}
		}
	}
	
	class Term {
		public ArrayList<Character> unsigned;
		public ArrayList<Character> positive;
		public ArrayList<Character> negative;
		public Term() {
			unsigned = new ArrayList<Character>();
			positive = new ArrayList<Character>();
			negative = new ArrayList<Character>();
		}
		public String toString() {
			String us = "";
			String ps = "";
			String ns = "";
			for (char u : unsigned) us+=u;
			for (char p : positive) ps+=p;
			for (char n : negative) ns+=n;
			return "\n U: " + us + " \t P: " + ps + " \t N: " + ns;
		}
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
			processInput(input);
        }
	}
	
	public boolean isEnd(String input) {
		return input.equals(END);
	}
}
