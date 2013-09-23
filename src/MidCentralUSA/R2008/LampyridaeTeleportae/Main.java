package MidCentralUSA.R2008.LampyridaeTeleportae;

import java.util.Scanner;

public class Main {
	
	Scanner scanner;
	String END = "0 0 0";
	int ff = 0;
	int ra = 0;
	int mx = 0;
	int my = 0;
	int fx = 0;
	int fy = 0;
	int cx = -1;
	int cy = -1;

	public void processInput(String input) {
		if (input.split(" ").length == 3) { // BEGINING LINE
			++ff;
			ra = Integer.parseInt(input.split(" ")[0]);
			mx = Integer.parseInt(input.split(" ")[1]);
			my = Integer.parseInt(input.split(" ")[2]);
			cx = -1;
			cy = -1;
		} else if (Integer.parseInt(input.split(" ")[0]) == -1 &&
				   Integer.parseInt(input.split(" ")[1]) == -1) { // END LINE
			if (cx == -1 || cy == -1) {
				System.out.println("Firefly " + ff + " not caught");
			} else {
				System.out.println("Firefly " + ff + " caught at (" + cx + "," + cy + ")");
			}
		} else { // DO WORK TO DETERMINE cx AND cy
			fx = Integer.parseInt(input.split(" ")[0]);
			fy = Integer.parseInt(input.split(" ")[1]);
			
			if (cx != -1 && cy != -1) { // already caught
				return;
			}
			
			if (Math.abs((mx + ra) - fx) < 1) { // within range
				mx = fx;
				cx = fx;
			} else if (Math.abs((mx - ra) - fx) < 1) { // within range
				mx = fx;
				cx = fx;
			} else if (fx > mx) { // add full range
				mx += ra;
			} else if (fx < mx) { // sub full range
				mx -= ra;
			}
			
			if (Math.abs((my + ra) - fy) < 1) { // within range
				my = fy;
				cy = fy;
			} else if (Math.abs((my - ra) - fy) < 1) { // within range
				my = fy;
				cy = fy;
			} else if (fy > my) { 
				my += ra;
			} else if (fy < my) {
				my -= ra;
			}
			
			if (cx == -1 || cy == -1) { // no false positives
				cx = -1;
				cy = -1;
			}
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
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
			input = scanner.nextLine();
			if (isEnd(input)) {
				break;
			}
			processInput(input);
        }
        scanner.close();
	}
	
	public boolean isEnd(String input) {
		return input.equals(END);
	}
}
