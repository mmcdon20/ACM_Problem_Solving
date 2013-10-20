package MidCentralUSA.Practice1.SelfNumbers;

public class Main {
    public static boolean isSelf(int n) {
        for(int i = 1; i < n; i++) {
            if (d(i) == n) {
                return false;
            }
        }
        return true;
    }

    public static long d(Integer i) {
        char[] is = i.toString().toCharArray();
        long sum = i;
        for (char c : is) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {
            if (isSelf(i)) {
                System.out.println(i);
            }
        }
    }
}

