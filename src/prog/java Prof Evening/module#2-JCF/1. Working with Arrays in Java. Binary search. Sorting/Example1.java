public class Example1 {

    public static void main(String[] args) {
//        one();
        two();
    }

    public static void one() {
        // declaring and initializing 2D array
        int arr[][] = { { 5, 7, 19 }, { 13, 4, 1 }, { 17, 44, 22 } };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(arr[i][j] + " ");

            System.out.println();
        }
    }

    public static void two() {

        /*
        метод распечатает 33? -> no
        как сделать, чтобы распечаталось? -> use in second time for-each
         */
        int arr[][] = { { 5, 7, 19 }, { 13, 4, 1 }, { 17, 44, 22, 33 } };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(arr[i][j] + " ");

            System.out.println();
        }
    }

}
