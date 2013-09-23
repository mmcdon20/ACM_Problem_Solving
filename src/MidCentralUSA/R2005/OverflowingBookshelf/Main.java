package MidCentralUSA.R2005.OverflowingBookshelf;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	Scanner scanner;
	public static String END = "-1";
	int count = 0;
	int width = -1;
	BookShelf bs;
	TreeMap<Integer,Book> bmap;
	
	class BookShelf extends ArrayDeque<Book> {
		private static final long serialVersionUID = 6149896697152804068L;
		public int s;
		public int f;
		
		BookShelf(int s) {
			this.s = s;
			this.f = 0;
		}
		
		public boolean add(Book b) {
			super.add(b);
			this.f += b.s;
			if (f > s) {
				do {
					Book r = super.remove();
					f -= r.s;
				} while(f > s);
				return false;
			} else {
				return true;
			}
		}
		
		public boolean remove(Book b) {
			if (!super.contains(b)) {
				return false;
			} else {
				super.remove(b);
				f -= b.s;
				return true;
			}
		}
		
		public String toString() {
			String output = "";
			while (!this.isEmpty()) {
				output += " " + this.pollLast();
			}
			return output;
		}
	}
	
	class Book {
		public int s;
		public int n;
		Book(int n, int s) {
			this.s = s;
			this.n = n;
		}
		public String toString() {
			return ""+n;
		}
	}

	public void readInput(String input) {
		input = input.trim();
		String[] inputs = input.split(" ");
		if (inputs.length == 1) {
			if (inputs[0].equals("E")) {
				++count;
				System.out.println("PROBLEM " + count + ":" + bs.toString());
			} else {
				width = Integer.parseInt(input);
				bs = new BookShelf(width);
				bmap = new TreeMap<Integer,Book>();
			}
		} else {
			if (inputs[0].equals("A")) {
				int n = Integer.parseInt(inputs[1]);
				int s = Integer.parseInt(inputs[2]);
				Book b = new Book(n,s);
				bmap.put(n, b);
				bs.add(b);
			} else if (inputs[0].equals("R")) {
				int n = Integer.parseInt(inputs[1]);
				bs.remove(bmap.get(n));
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
