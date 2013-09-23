package MidCentralUSA.R2006.GoGoGorelians;
/*

5
1 0 0 0
2 0 0 1
3 0 0 2
4 0 0 3
5 0 0 4
5
1 0 0 0
2 1 1 0
3 3 2 0
4 2 1 0
5 3 0 0
10
21 71 76 4
97 32 5 69
70 33 19 35
3 79 81 8
31 91 17 67
52 31 48 75
48 90 14 4
41 73 2 21
83 74 41 69
26 32 30 24
0


 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	Scanner scanner;
	public ArrayList<Planet> planets = new ArrayList<Planet>();
	
	public boolean processInput(String input) {
		if (input.split(" ").length == 1) {
			int num = Integer.parseInt(input.split(" ")[0]);
			
			//this.link();
			//for (Planet p : planets) System.out.println(p + "\n");
			this.unLink();
			if (planets.size() == 1) {
				System.out.println(planets.get(0).n);
			} else if (planets.size() == 2) {
				int p1 = planets.get(0).n;
				int p2 = planets.get(1).n;
				if (p1 < p2) {
					System.out.println(p1 + " " + p2);
				} else {
					System.out.println(p2 + " " + p1);
				}
			}
			planets = new ArrayList<Planet>();
			return num != 0;
		} else {
			int n = Integer.parseInt(input.split(" ")[0]);
			int x = Integer.parseInt(input.split(" ")[1]);
			int y = Integer.parseInt(input.split(" ")[2]);
			int z = Integer.parseInt(input.split(" ")[3]);
			Planet p = new Planet(n,x,y,z);
			planets.add(p);
			this.link(p);
			return true;
		}
	}
	
	public void link() {
		if (planets.size() == 0)
			return;
		for (Planet p : planets) {
			double distance = 999999999;
			Planet b = null;
			for (Planet q : planets) {
				if (p == q) {
					continue;
				} else if (p.distance(q) < distance) {
					distance = p.distance(q);
					b = q;
				}
			}
			if (b != null) {
				p.add(b);
			}
		}
	}
	
	public void link(Planet p) {
		if (planets.size() == 0 || planets.size() == 1)
			return;
		
		double distance = 999999999;
		Planet b = null;
		
		for (Planet q : planets) {
			if (p == q) {
				continue;
			}
			else if (p.distance(q) < distance) {
				distance = p.distance(q);
				b = q;
			}
		}
		
		if (b != null) {
			p.add(b);
		}
	}
	
	public void unLink() {
		while (planets.size() > 2) {
			Stack<Planet> leaves = new Stack<Planet>();
			for (Planet p : planets) {
				if (p.isLeaf()) {
					leaves.push(p);
				}
			}
			while (!leaves.isEmpty()) {
				Planet p = leaves.pop();
				p.remove();
				planets.remove(p);
			}
			
			//for (Planet p : planets) 
			//	System.out.println(p + "\n");
			
			//System.out.println("unlinking");
		}
	}
	
	class Planet {
		public int n, x, y, z;
		public ArrayList<Planet> links;
		Planet(int n, int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.n = n;
			links = new ArrayList<Planet>();
		}
		public double distance(Planet that) {
			double dx = this.x - that.x;
			double dy = this.y - that.y;
			double dz = this.z - that.z;
			return Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2) + Math.pow(dz,2));
		}
		public boolean isLeaf() {
			return this.links.size() == 1;
		}
		public void remove() {
			for (Planet p : links) {
				p.links.remove(this);
			}
		}
		public void add(Planet that) {
			if (!links.contains(that)) {
				this.links.add(that);
				that.links.add(this);
			}
		}
		public String toString() {
			String s = "Planet: " + n + " X: " + x + " Y: " + y + " Z: " + z + "\n";
			s += "Links to: ";
			for (Planet p: links) {
				s+= "" + p.n + " ";
			}
			return s;
		}
		public boolean equals(Planet that) {
			return this.n == that.n;
		}
	}
	
	public Main() throws Exception {
		scanner = new Scanner(System.in);
	}
	
	public static void main(String[] args0)  throws Exception {
        Main m = new Main();
        m.loop();
	}
	
	public void loop() throws Exception {
        while (true) {
        	String input = scanner.nextLine();
			if (!processInput(input))
				break;
        }
	}
}
