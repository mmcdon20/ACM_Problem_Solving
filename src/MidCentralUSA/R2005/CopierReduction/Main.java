package MidCentralUSA.R2005.CopierReduction;

import java.util.Scanner;


public class Main {
	Scanner scanner;
	public static String END = "0 0 0 0";
	int ph;
	int pw;
	int ih;
	int iw;

	public String evalInput(String input) {
		input = input.trim();
		String[] inputs = input.split(" ");
		ih = Integer.parseInt(inputs[0]);
		iw = Integer.parseInt(inputs[1]);
		ph = Integer.parseInt(inputs[2]);
		pw = Integer.parseInt(inputs[3]);
		rotate();
		return reduce();
	}
	
	public void rotate() {
		if (ih < iw) {
			if (iw > pw) {
				int temp = ih;
				ih = iw;
				iw = temp;
			}
		}
	}
	
	public String reduce() {
		double numI = (ih > iw) ? ih : iw;
		double numP = (ph > pw) ? ph : pw;
		
		if (numI == numP) {
			return "RESULT: " + 100 + "%";
		} else if (numI < numP) {
			return "RESULT: " + 100 + "%";
		} else {
			double numI2 = (ih > iw) ? iw : ih;
			double numP2 = (ph > pw) ? pw : ph;
			double percent1 = (numP/numI);
			
			iw = (int)(((double)iw)*percent1);
			ih = (int)(((double)iw)*percent1);
			
			//System.out.println();
			//System.out.println("ih: " + ih + "\t iw: " + iw);
			//System.out.println("ph: " + ph + "\t pw: " + pw);
			
			if (ih > ph) {
				double numI3 = ih;
				double numP3 = ph;
				double percent2 = (numP3/numI3);
				return "RESULT: " + ((int)(percent2*100)) + "%";
			} else if (iw > pw) {
				double numI4 = ih;
				double numP4 = ph;
				double percent3 = (numP4/numI4);
				return "RESULT: " + ((int)(percent3*100)) + "%";
			} else {
				return "RESULT: " + ((int)(percent1*100)) + "%";
			}
			
			//System.out.println("P1: " + percent1);
			//double percent2 = (numP2/(numI2*percent1));
			//System.out.println("P2: " + percent2);
			
			//if (ih*percent1 <= ph && iw*percent1 <= pw){
			//	return "RESULT: " + percent1 + "%" + "\n\n";
			//} else {
			//	return "RESULT: " + percent1 + "%" + "\n\n";
			//}
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
        		System.out.println(evalInput(input));
        	}
        }
	}
	
	public boolean isEnd(String input) {
		return input.equals(END);
	}
}
