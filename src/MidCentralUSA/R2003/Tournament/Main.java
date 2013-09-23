package MidCentralUSA.R2003.Tournament;/*

Sample input

11
BIG DIGS
WIG ZIG
BIG FIGURES
TIGGER WIG
FIGURES TIGGER
TIGGER
5
LARGE RAGE
ZEN RAGE
RAGE
31
ANT BOA
COW DUCK
EEL FROG
GOOSE HEN
IGUANA JACKEL
KITE LLAMA
MOUSE NIT
OCTOPUS PIG
BOA COW
FROG GOOSE
IGUANA KITE
MOUSE OCTOPUS
COW GOOSE
IGUANA OCTOPUS
GOOSE OCTOPUS
OCTOPUS
-1

Sample output

Tournament 1
_BIG__
      \_BIG_____
_DIGS_/         \
                 \_FIGURES_
                 /         \
       _FIGURES_/           \
                             \
                              \_TIGGER_
                              /
       _TIGGER__             /
                \           /
                 \_TIGGER__/
_WIG__           /
      \_WIG_____/
_ZIG__/
Tournament 2
        _ZEN__
              \
               \_RAGE_
_LARGE_        /
       \_RAGE_/
_RAGE__/
Tournament 3
_ANT_____
         \_BOA_____
_BOA_____/         \
                    \_COW_____
_COW_____           /         \
         \_COW_____/           \
_DUCK____/                      \
                                 \_GOOSE___
_EEL_____                        /         \
         \_FROG____             /           \
_FROG____/         \           /             \
                    \_GOOSE___/               \
_GOOSE___           /                          \
         \_GOOSE___/                            \
_HEN_____/                                       \
                                                  \_OCTOPUS_
_IGUANA__                                         /
         \_IGUANA__                              /
_JACKEL__/         \                            /
                    \_IGUANA__                 /
_KITE____           /         \               /
         \_KITE____/           \             /
_LLAMA___/                      \           /
                                 \_OCTOPUS_/
_MOUSE___                        /
         \_MOUSE___             /
_NIT_____/         \           /
                    \_OCTOPUS_/
_OCTOPUS_           /
         \_OCTOPUS_/
_PIG_____/


*/

// 16 - 31 - farthest bracket
//  8 - 15 - second farthest from left
//  4 -  7 - 3rd round
//  2 -  3 - semifinalists
//  1      - winner

import java.util.*;
import java.io.*;

// priority queue
// tree stored in a heap/array
/*

          A
         / \
        B   C
       / \ / \
      D  E F  G
     /    \
    H      I

 child to pops i/2
 pops to kid 2*i

  A B C D E F G H 
0 1 2 3 4 5 6 7 8 9 ...

read each line into a stack
then pop into an array into proper space
last row needs more work

*/


public class Main {
	Scanner scanner;
	public static String END = "-1";
	int tourny = 0;
	int count = -1;
	int num = 0;
	Stack<String> contenders = new Stack<String>();
	String[] participants = new String[32];
	String[] underscores = new String[32];
	int lvl1 = 0;
	int lvl2 = 0;
	int lvl3 = 0;
	int lvl4 = 0;
	int lvl5 = 0;
	char[][] grid = new char[32][75];
	
	TreeMap<Integer,Integer> row = new TreeMap<Integer,Integer>();
	
	public void setMap() {
		row.put( 1, 16);
		row.put( 2, 24);
		row.put( 3,  8);
		row.put( 4, 28);
		row.put( 5, 20);
		row.put( 6, 12);
		row.put( 7,  4);
		row.put( 8, 30);
		row.put( 9, 26);
		row.put(10, 22);
		row.put(11, 18);
		row.put(12, 14);
		row.put(13, 10);
		row.put(14,  6);
		row.put(15,  2);
		row.put(16, 31);
		row.put(17, 29);
		row.put(18, 27);
		row.put(19, 25);
		row.put(20, 23);
		row.put(21, 21);
		row.put(22, 19);
		row.put(23, 17);
		row.put(24, 15);
		row.put(25, 13);
		row.put(26, 11);
		row.put(27,  9);
		row.put(28,  7);
		row.put(29,  5);
		row.put(30,  3);
		row.put(31,  1);
	}
	
	public int findDivisor() {
		if (num == 1) {
			return 16;
		} else if (num <= 3) {
			return 8;
		} else if (num <= 7) {
			return 4;
		} else if (num <= 15) {
			return 2;
		} else if (num <= 31) {
			return 1;
		}
		return 0;
	}
	
	public void fillSpace() {
		for (int i = 0; i <= 31; i++) {
			for (int j = 0; j <= 74; j++) {
				grid[i][j] = ' ';
			}
		}
	}
	
	public void print() {
		String text = "";
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (endl(r,c)) {
					if (grid[r][c] != ' ')
						text += grid[r][c];
					if (c == 0) {
						break;
					} else {
						text += "\n";
						break;
					}
				} else {
					text += grid[r][c];
				}
			}
		}
		text = text.substring(0, text.length()-1);
		System.out.println(text);
	}
	
	public boolean endl(int r, int c) {
		for (int i = c; i < 75; i++) {
			if (grid[r][i] != ' ')
				return false;
		}
		return true;
	}
	
	public void write(int row, int indent, String text) {
		if (text == null)
			return;
		char[] cs = text.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			grid[row][indent + i] = cs[i];
		}
	}
	
	public void addWords() {
		int div = findDivisor();
		for (int i = 1; i < underscores.length; i++) {
			write(row.get(i)/div,findIndent(i),underscores[i]);
		}
		for (int i = 1; i < underscores.length; i++) {
			findDiag(i);
		}
	}
	
	public int findIndent(int i) {
		if (findDivisor() == 8) {
			if (i == 1) {
				return lvl2 + 3;
			}
		} else if (findDivisor() == 4) {
			if (i == 2 || i == 3) {// semifinals
				return lvl3 + 3;
			} if (i == 1) {           // victor
				return lvl2 + lvl3 + 7;
			}
		} else if (findDivisor() == 2) {
			if (i == 4 || i == 5 || i == 6 || i == 7) { // round 2
				return lvl4 + 3;
			} if (i == 2 || i == 3) { // semi
				return lvl4 + lvl3 + 7;
			} if (i == 1) {            // finals
				return lvl4 + lvl3 + lvl2 + 13;
			}
		} else if (findDivisor() == 1) {
			if (i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15) {
				return lvl5 + 3;
			} if (i == 4 || i == 5 || i == 6 || i == 7) {
				return lvl5 + lvl4 + 7;
			} if (i == 2 || i == 3) {
				return lvl5 + lvl4 + lvl3 + 13;
			} if (i == 1) {
				return lvl5 + lvl4 + lvl3 + lvl2 + 23;
			}
		}
		return 0;
	}
	
	public void findDiag(int i) {
		int r = row.get(i)/findDivisor();
		if (findDivisor() == 8) {
			if (i == 1) {
				int c = lvl2 + 3;
				diag(r,c,1);
			}
		} else if (findDivisor() == 4) {
			if (i == 2 || i == 3) {// semifinals
				int c = lvl3 + 3;
				if (grid[r-1][0] == '_')
					diag(r,c,1);
			} if (i == 1) {           // victor
				int c = lvl2 + lvl3 + 7;
				diag(r,c,2);
			}
		} else if (findDivisor() == 2) {
			if (i == 4 || i == 5 || i == 6 || i == 7) { // round 2
				int c = lvl4 + 3;
				if (grid[r-1][0] == '_')
					diag(r,c,1);
			} if (i == 2 || i == 3) { // semi
				int c = lvl4 + lvl3 + 7;
				diag(r,c,2);
			} if (i == 1) {            // finals
				int c = lvl4 + lvl3 + lvl2 + 13;
				diag(r,c,4);
			}
		} else if (findDivisor() == 1) {
			if (i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15) {
				int c = lvl5 + 3;
				if (grid[r-1][0] == '_')
					diag(r,c,1);
			} if (i == 4 || i == 5 || i == 6 || i == 7) {
				int c = lvl5 + lvl4 + 7;
				diag(r,c,2);
			} if (i == 2 || i == 3) {
				int c = lvl5 + lvl4 + lvl3 + 13;
				diag(r,c,4);
			} if (i == 1) {
				int c = lvl5 + lvl4 + lvl3 + lvl2 + 23;
				diag(r,c,8);
			}
		}
	}
	
	void diag(int row, int col, int n) {
		for (int i = 0; i < n; i++) {
			grid[row - i][col - i - 1] = '\\';
			grid[row + i + 1][col - i - 1] = '/';
		}
	}

	public void readInput(String input) {
		if (count <= 0) {
			fillSpace();
			write(0,0,"Tournament " + ++tourny);
			contenders = new Stack<String>();
			count = Integer.parseInt(input);
			num = count;
			participants = new String[32];
			underscores = new String[32];
		} else {
			count -= 2;
			if (input.split(" ").length == 1) {
				contenders.push(input);
			} else {
				contenders.push(input.split(" ")[0]);
				contenders.push(input.split(" ")[1]);
			}
			//System.out.println(input);
		}
		
		if (count <= 0 && !contenders.isEmpty()) {
			// fill tree
			int p = 1;
			
			while (!contenders.isEmpty()) {
				String guy = contenders.pop();
				participants[p] = guy;
				++p;
			}
			
			if (num != 31 || num != 15 || num != 7 || num != 3 || num != 2 || num != 1) {
				if (num < 7) {
					// fix entries 
					// 5 && 4
					String s4 = participants[4];
					String s5 = participants[5];
					participants[4] = null;
					participants[5] = null;
					fix(s4,s5,4,5);
				} else if (num < 15) {
					// fix entries
					// 8  && 9
					// 10 && 11
				    // 12 && 13
					String s8 = participants[8];
					String s9 = participants[9];
					String s10 = participants[10];
					String s11 = participants[11];
					String s12 = participants[12];
					String s13 = participants[13];
					participants[8] = null;
					participants[9] = null;
					participants[10] = null;
					participants[11] = null;
					participants[12] = null;
					participants[13] = null;
					fix(s8,s9,8,9);
					fix(s10,s11,10,11);
					fix(s12,s13,12,13);
				} else if (num < 31) {
					// fix entries
					// 16 - 29
					String s16 = participants[16];
					String s17 = participants[17];
					String s18 = participants[18];
					String s19 = participants[19];
					String s20 = participants[20];
					String s21 = participants[21];
					String s22 = participants[22];
					String s23 = participants[23];
					String s24 = participants[24];
					String s25 = participants[25];
					String s26 = participants[26];
					String s27 = participants[27];
					String s28 = participants[28];
					String s29 = participants[29];
					participants[16] = null;
					participants[17] = null;
					participants[18] = null;
					participants[19] = null;
					participants[20] = null;
					participants[21] = null;
					participants[22] = null;
					participants[23] = null;
					participants[24] = null;
					participants[25] = null;
					participants[26] = null;
					participants[27] = null;
					participants[28] = null;
					participants[29] = null;
					fix(s16,s17,16,17);
					fix(s18,s19,18,19);
					fix(s20,s21,20,21);
					fix(s22,s23,22,23);
					fix(s24,s25,24,25);
					fix(s26,s27,26,27);
					fix(s28,s29,28,29);
				}
			}
			
			//for (int i = 1; i < 32; i++) {
				//System.out.println(i + " " + names.get(i));
				//System.out.println(i + " " + participants[i]);
			//}
			//System.out.println();
			widthByRow();
			addUnderScores();
			addWords();
			print();
		}
	}
	
	public void fix(String a, String b, int c, int d) {
		if (a == null || b == null)
			return;
		for (int i = c; i >= 1; i--) {
			if (participants[i] == null)
				continue;
			if (participants[i].equals(a) || participants[i].equals(b)) {
				participants[i*2]     = a;
				participants[(i*2)+1] = b;
				return;
			}
		}
	}
	
	public void addUnderScores() {
		for (int i = 1; i < 32; i++) {
			if (participants[i] == null)
				continue;
			
			String guy = "_" + participants[i];
		    
			if (i == 1) {
		    	guy += "_";
		    } else if (i <= 3) {
				while (guy.length() - 2 < lvl2)
					guy += "_";
			} else if (i <= 7) {
				while (guy.length() - 2 < lvl3)
					guy += "_";
			} else if (i <= 15) {
				while (guy.length() - 2 < lvl4)
					guy += "_";
			} else if (i <= 31) {
				while (guy.length() - 2 < lvl5)
					guy += "_";
			}
		    
			underscores[i] = guy;
		}
	}
	
	public void widthByRow() {
		lvl1 = 0;
		lvl2 = 0;
		lvl3 = 0;
		lvl4 = 0;
		lvl5 = 0;
		
		lvl1 = participants[1].length();
		
		for (int i = 2; i <= 3; i++) {
			if (participants[i] == null)
				continue;
			if (lvl2 < participants[i].length())
				lvl2 = participants[i].length();
		}
		
		for (int i = 4; i <= 7; i++) {
			if (participants[i] == null)
				continue;
			if (lvl3 < participants[i].length())
				lvl3 = participants[i].length();
		}
		
		for (int i = 8; i <= 15; i++) {
			if (participants[i] == null)
				continue;
			if (lvl4 < participants[i].length())
				lvl4 = participants[i].length();
		}
		
		for (int i = 16; i <= 31; i++) {
			if (participants[i] == null)
				continue;
			if (lvl5 < participants[i].length())
				lvl5 = participants[i].length();
		}
	}

	public Main() throws Exception {
		scanner = new Scanner(System.in);
	}
	
	public static void main(String[] args) throws Exception  {
        Main m = new Main();
        m.setMap();  
        m.loop();
	}
	
	public void loop() {
        while (true) {
        	String input = scanner.nextLine();
        	if (isEnd(input)) {
				return;
        	} else {
        		readInput(input);
        	}
        }
	}
	
	public boolean isEnd(String input) {
		return input.equals(END);
	}
}
