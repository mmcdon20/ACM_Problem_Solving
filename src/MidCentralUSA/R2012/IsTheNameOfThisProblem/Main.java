package MidCentralUSA.R2012.IsTheNameOfThisProblem;

import java.util.Scanner;

/*

"HELLO WORLD" HELLO WORLD
"IS A SENTENCE FRAGMENT" IS A SENTENCE FRAGMENT
"IS THE NAME OF THIS PROBLEM" IS THE NAME OF THIS PROBLEM
"YIELDS FALSEHOOD WHEN QUINED" YIELDS FALSEHOOD WHEN QUINED
"HELLO" I SAID
WHAT ABOUT "WHAT ABOUT"
" NO EXTRA SPACES " NO EXTRA SPACES
"NO"QUOTES" NO"QUOTES
""
END

*/

public class Main {
    Scanner scanner;
    public static String END = "END";

    public void readInput(String input) {
        if (input.charAt(0) != '\"' || input.length() < 5) {
            notQuine();
        } else {
            try {
                input = input.substring(1,input.length());
                String text1 = input.substring(0,input.indexOf('\"'));
                String text2 = input.substring(input.indexOf("\" ")+2, input.length());
                if (text1.equals(text2)) {
                    quine(text1);
                } else {
                    notQuine();
                }
            } catch (Exception e) {
                notQuine();
            }
        }
    }

    public void quine(String text) {
        System.out.println("Quine(" + text + ")");
    }

    public void notQuine() {
        System.out.println("not a quine");
    }

    public void setup() {

    }

    public Main() throws Exception {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.setup();
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
