package _2023_06_26;

import java.util.Stack;

public class Test {
    public static boolean isEqual(String s1, String s2) {
        return fixedS(s1).equals(fixedS(s2));
    }

    private static String fixedS(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (i > 0) {
                    s = s.substring(0, i - 1) + s.substring(i + 1);
                    i--;
                } else s = s.substring(i + 1);
                i--;
            }
        }
        return s;
    }
    
    private static boolean stringCompare(String S, String T) {
        int Spointer = S.length() - 1;
        int Tpointer = T.length() - 1;

        int Sskip = 0;
        int Tskip = 0;

        while (Spointer >= 0 || Tpointer >= 0) {
            while (Spointer >= 0) {
                if (S.charAt(Spointer) == '#') {
                    Sskip += 1;
                    Spointer -= 1;
                } else if (Sskip > 0) {
                    Spointer -= 1;
                    Sskip -= 1;
                } else {
                    break;
                }
            }

            if(Spointer >= 0 && Tpointer >= 0 && S.charAt(Spointer) != T.charAt(Tpointer)) {
                return false;
            }

            if((Spointer >= 0) != (Tpointer >= 0)) {
                return false;
            }
        }

        return true;
    }

    private static String processStringStack(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static boolean checkEquivalence(String s, String e) {
        String processedS = processStringStack(s);
        String processedE = processStringStack(e);

        return processedS.equals(processedE);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 11, 61, 7, 8, 9};
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                evenSum += arr[i];
            } else {
                oddSum += arr[i];
            }
        }

        System.out.println("Сумма элементов с четными индексами: " + evenSum);
        System.out.println("Сумма элементов с нечетными индексами: " + oddSum);
    }
}
