package _2023_05_26;

public class TASK {

    /**
     * 123 --- 321
     * 210 --- 12
     * -456 --- -654
     */

    private static int reverseNumber(int x) {
        return 0;
    }

    /**
     * [5 4 9 2 9 0 1 1 0 4 5]
     * out 2
     */

    //[1 2 3 2 1]
    //0 0 0 0 0 0 0 1
    //0 0 0 0 0 0 1 0
    //0 0 0 0 0 0 1 1
    //0 0 0 0 0 0 1 0
    //0 0 0 0 0 0 0 1

    //0 0 0 0 0 0 1 1

    //13 and 23
    //0 0 0 0 1 1 0 1
    //0 0 0 1 0 1 1 1
    //0 0 0 1 1 0 1 0


    //0 0 0 1 1 0 1 1 1 //55
    //0 0 0 1 0 1 1 0 0 //44
    //0 0 0 0 1 1 0 1 1 //16+8+2+1
    private static int duplicated(int[] array) {
        int xor = 0;
        for (int x : array) {
            xor ^= x;
        }
        return xor;
    }

    public static void main(String[] args) {
        System.out.println(55^44);
    }


}
