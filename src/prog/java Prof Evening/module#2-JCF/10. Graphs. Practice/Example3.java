import java.util.Scanner;

public class Example3 {
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt(); // rows
        int m = scanner.nextInt(); // columns
        
        int[][] array = new int[n][m];

        for (int i = 0; i < array.length; i++) {

            int a = scanner.nextInt();  // number of row
            int b = scanner.nextInt();  // number of column

            array[a][b] = array[b][a] = 1; // fill it by one
        }

        System.out.println(isCompletedGraph(array, n, m));
    }

    private static boolean isCompletedGraph(int[][] array, int n, int m) {
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                if (array[i][j] == 0)
                    return false;
            }
        }

        return true;
    }
}

