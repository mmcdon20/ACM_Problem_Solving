package MidCentralUSA.R2007.ElectronicDocumentSecurity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	Scanner scanner;
	public static String END = "#";
    int count = 0;
	
    // + add right
    // - remove right
    // = set rights
    
	public String processInput(String input) {
		ArrayList<ArrayList<String>> ACL = new ArrayList<ArrayList<String>>();
		
		String right = "";
		String lastRight = "";
		String operation = "";
		
		for (Character c : input.toCharArray()) {
			
			if (Character.isUpperCase(c)) {
				right += c;
				
			} else if (Character.isLowerCase(c)) {

				if (operation.equals("=")) {
					
					// perform = op

				} else if (operation.equals("+")) {
					for (ArrayList<String> a : ACL) {
						if (a.get(0).equals(lastRight)) {
							a.add(c.toString());
						}
					}
				} else if (operation.equals("-")) {
					for (ArrayList<String> a : ACL) {
						if (a.get(0).equals(lastRight)) {
							a.remove(c.toString());
						}
					}
				}
				
			} else if (c.equals(new Character('+'))) {
				lastRight = right;
				right = "";
				ArrayList<String> r = new ArrayList<String>();
				r.add(lastRight);
				ACL.add(r);
				operation = "+";
			} else if (c.equals(new Character('-'))) {
				lastRight = right;
				right = "";
				ArrayList<String> r = new ArrayList<String>();
				r.add(lastRight);
				ACL.add(r);
				operation = "-";
			} else if (c.equals(new Character('='))) {
				lastRight = right;
				right = "";
				ArrayList<String> r = new ArrayList<String>();
				r.add(lastRight);
				ACL.add(r);
				operation = "=";
			}
		}
		
		return "" + (++count) + ":" + out(ACL);
	}
	
	public String out (ArrayList<ArrayList<String>> ACL) {
	
		for (ArrayList<String> a : ACL) {
			char[] chars = a.get(0).toCharArray();
			Arrays.sort(chars);
			String perm = new String(chars);
			a.set(0, perm);
		}
		
		
		Comparator<ArrayList<String>> order = new Comparator<ArrayList<String>>() {
			@Override
			public int compare(ArrayList<String> o1,
					ArrayList<String> o2) {
				return (o1.get(0).compareTo(o2.get(0)));
			}
		};
		
	    Collections.sort(ACL, order);
		
		for (ArrayList<String> a : ACL)
			Collections.sort(a);
		
		for (ArrayList<String> a : ACL) {
			boolean lower = false;
			
			for (String s : a) {
				if (Character.isLowerCase(s.charAt(0))) {
					lower = true;
				}
			}
			
			if (!lower) {
				ACL.remove(a);
			}
		}
		
		String out = "";
		
		for (ArrayList<String> a : ACL) {
			for (String s : a) {
				out += s;
			}
		}
		
		return out;
	}
	
	public Main() {
		scanner = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
        Main m = new Main();
        m.loop();
	}
	
	public void loop() {
        Scanner scanner = new Scanner(System.in);
        String input;
        
        while (true) {
			input = scanner.nextLine();
			if (isEnd(input))
				break;
			System.out.println(processInput(input));
        }
        
        scanner.close();
	}
	
	public boolean isEnd(String input) {
		return input.equals(END);
	}
}
