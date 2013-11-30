package MidCentralUSA.R2013.SortMe;

import java.util.*;

public class Main {
    Scanner scanner;
    public static String END = "0";
    public String alpha = "";
    public int year = 0;
    public int count = 0;
    public ArrayList<Word> words = new ArrayList<Word>();

    public void readInput(String input) {
        if (count == 0) {
            alpha = input.split(" ")[1];
            count = Integer.parseInt(input.split(" ")[0]);
            words = new ArrayList<Word>();
        } else {
            words.add(new Word(input));
            --count;
        }

        if (count == 0) {
            Collections.sort(words);
            System.out.println("year " + (++year));
            for (Word word : words) {
                System.out.println(word);
            }
        }
    }

    public class Word implements Comparable<Word> {
        String text;

        Word(String text) {
            this.text = text;
        }

        public String toString() {
            return text;
        }

        public int compareTo(Word that) {
            int thisLen = this.text.length();
            int thatLen = that.text.length();
            int minLen = Math.min(thisLen,thatLen);
            for (int i = 0; i < minLen; i++) {
                int thisVal = alpha.indexOf(this.text.charAt(i));
                int thatVal = alpha.indexOf(that.text.charAt(i));
                if (thisVal < thatVal) {
                    return -1;
                } else if (thisVal > thatVal) {
                    return 1;
                }
            }
            if (thisLen < thatLen) {
                return -1;
            } else if (thisLen > thatLen) {
                return 1;
            } else {
                return 0;
            }
        }
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
