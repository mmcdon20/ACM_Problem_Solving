package MidCentralUSA.R2004.TriangleCuts;/*

60 70 50 30 100 50 75 70 35 75 60 45 45 65 70
40 75 65 60 40 80 20 120 40 45 85 50 25 55 100
60 60 60 30 60 90 30 60 90 90 60 30 90 60 30
30 60 90 30 120 30 30 120 30 30 120 30 30 120 30
60 70 50 30 100 50 75 70 35 75 60 45 70 65 45
0 0 180

 */

import java.util.*;

public class Main {
	Scanner scanner;
	public static String END = "0 0 180";

	public void readInput(String input) {
		String[] num = input.split(" ");
		Triangle t0 = new Triangle(num[ 0], num[ 1], num[ 2]);
		Triangle t1 = new Triangle(num[ 3], num[ 4], num[ 5]);
		Triangle t2 = new Triangle(num[ 6], num[ 7], num[ 8]);
		Triangle t3 = new Triangle(num[ 9], num[10], num[11]);
		Triangle t4 = new Triangle(num[12], num[13], num[14]);
		print(tryAll(t0,t1,t2,t3,t4));
	}

	public void print(boolean answer) {
		if (answer) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
	
	public boolean tryAll(Triangle t0, Triangle t1, Triangle t2, Triangle t3, Triangle t4) {
		return tryOne(t0, t1, t2, t3, t4) || tryOne(t0, t2, t1, t3, t4) ||
			   tryOne(t0, t3, t1, t2, t4) || tryOne(t0, t4, t1, t2, t3) ||
			   tryOne(t0, t1, t2, t4, t3) || tryOne(t0, t2, t1, t4, t3) ||
			   tryOne(t0, t3, t1, t4, t2) || tryOne(t0, t4, t1, t3, t2) ||
			   tryOne(t0, t1, t3, t2, t4) || tryOne(t0, t2, t3, t1, t4) ||
			   tryOne(t0, t3, t2, t1, t4) || tryOne(t0, t4, t2, t1, t3) ||
			   tryOne(t0, t1, t3, t2, t4) || tryOne(t0, t2, t3, t4, t1) ||
			   tryOne(t0, t3, t2, t4, t1) || tryOne(t0, t4, t2, t3, t1) ||
			   tryOne(t0, t1, t4, t2, t3) || tryOne(t0, t2, t4, t1, t3) ||
			   tryOne(t0, t3, t4, t1, t2) || tryOne(t0, t4, t3, t1, t2) ||
			   tryOne(t0, t1, t4, t3, t2) || tryOne(t0, t2, t4, t3, t1) ||
			   tryOne(t0, t3, t4, t2, t1) || tryOne(t0, t4, t3, t2, t1)  ;
	}

	public boolean tryOne(Triangle t0, Triangle t1, Triangle t2, Triangle t3, Triangle t4) {
		for (int i = 0; i < 3; i++) {
			t1 = t1.rotate();
			for (int j = 0; j < 3; j++) {
				t2 = t2.rotate();
				for (int k = 0; k < 3; k++) {
					t3 = t3.rotate();
					for (int l = 0; l < 3; l++) {
						t4 = t4.rotate();
						if (test(t0,t1,t2,t3,t4)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean test(Triangle t0, Triangle t1, Triangle t2, Triangle t3, Triangle t4) {
		ArrayList<Triangle> as = new ArrayList<Triangle>();
		ArrayList<Triangle> bs = new ArrayList<Triangle>();
		ArrayList<Triangle> cs = new ArrayList<Triangle>();
		ArrayList<Triangle> ds = new ArrayList<Triangle>();
		cs.addAll(Triangle.combinations(t1, t2));
		ds.addAll(Triangle.combinations(t3, t4));
		as.addAll(Triangle.combinations(cs, ds));
		bs.addAll(Triangle.combinations(cs, t3));
		as.addAll(Triangle.combinations(bs, t4));
		check1(as,t1,t2,t3,t4);
		check2(as,t1,t2,t3,t4);
		return check3(as,t0);
	}
	
	public void check1(ArrayList<Triangle> as, Triangle t1, Triangle t2, Triangle t3, Triangle t4) {
		if ((t2._1 + t4._1         == 180) && 
			(t3._2 + t4._2         == 180) && 
			(t1._0 + t2._0 + t3._0 == 180)) {
			as.add(new Triangle(t4._0, t1._1 + t2._2, t1._2 + t3._1));
		}
	}
	
	public void check2(ArrayList<Triangle> as, Triangle t1, Triangle t2, Triangle t3, Triangle t4) {
		if ((t1._1 + t2._2 + t4._1 == 180) && 
			(t2._1 + t3._2 + t4._2 == 180) && 
			(t3._1 + t1._2 + t4._0 == 180)) {
			as.add(new Triangle(t1._0, t2._0, t3._0));
		}
	}
	
	public boolean check3(ArrayList<Triangle> as, Triangle t0) {
		for (int i = 0; i < 3; i++) {
			t0 = new Triangle(t0._1, t0._2, t0._0);
			for (int j = as.size() - 1; j >= 0; j--) {
				Triangle v = as.get(j);
				if (v._0 == t0._0 && v._1 == t0._1 && v._2 == t0._2)
					return true;
			}
		}
		return false;
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

class Triangle {
	final int _0, _1, _2;
	Triangle(String a, String b, String c) {
		this._0 = Integer.parseInt(a);
		this._1 = Integer.parseInt(b);
		this._2 = Integer.parseInt(c);
	}
	Triangle(int a, int b, int c) {
		this._0 = a;
		this._1 = b;
		this._2 = c;
	}
	public Triangle rotate() {
		return new Triangle(_1,_2,_0);
	}
	public ArrayList<Triangle> rotations() {
		ArrayList<Triangle> rotes = new ArrayList<Triangle>();
		Triangle a = this.rotate();
		Triangle b = a.rotate();
		Triangle c = b.rotate();
		rotes.add(a);
		rotes.add(b);
		rotes.add(c);
		return rotes;
	}
	public static ArrayList<Triangle> combinations(Triangle a, Triangle b) {
		ArrayList<Triangle> combos = new ArrayList<Triangle>();
		if (a._2 + b._0 == 180) {
			combos.addAll(new Triangle(a._0, a._1 + b._1, b._2).rotations());
			combos.addAll(new Triangle(a._1, b._1, a._0 + b._2).rotations());
		}
		return combos;
	}
	public static ArrayList<Triangle> combinations(ArrayList<Triangle> a, Triangle b) {
		ArrayList<Triangle> combos = new ArrayList<Triangle>();
		for (int i = a.size() - 1; i >= 0; i--) {
			combos.addAll(combinations(a.get(i), b));
		}
		return combos;
	}
	public static ArrayList<Triangle> combinations(ArrayList<Triangle> a, ArrayList<Triangle> b) {
		ArrayList<Triangle> combos = new ArrayList<Triangle>();
		for (int i = b.size() - 1; i >= 0; i--) {
			combos.addAll(combinations(a, b.get(i))); 
		}
		return combos;
	}
}