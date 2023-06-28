public class Example4 {

    static final int ROW = 5, COLUMN = 5;

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println(countIslands(array));
    }

    public static int countIslands(int[][] array) {
        // Make a bool array to mark visited cells. Initially all cells are unvisited
        boolean[][] visited = new boolean[ROW][COLUMN];

        // Initialize count as 0 and traverse through the all cells of given matrix
        int count = 0;

        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COLUMN; ++j)
                if (array[i][j] == 1 && !visited[i][j]) {
                    DFS(array, i, j, visited);
                    ++count;
                }

        return count;
    }

    /**
     *  A function to check if a given cell (row, col) can be included in DFS
     */
    private static boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        // row number is in range, column number is in range and value is 1 and not yet visited
        return (row >= 0)
                && (row < ROW)
                && (col >= 0)
                && (col < COLUMN)
                && (M[row][col] == 1 && !visited[row][col]);
    }

    /**
     *     A utility function to do DFS for a 2D boolean matrix.
     *     It only considers the 8 neighbors as adjacent vertices
     */
    private static void DFS(int[][] M, int row, int col, boolean[][] visited) {
        // These arrays are used to get row and column numbers of 8 neighbors of a given cell
        int[] rowNeighbor = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNeighbor = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int i = 0; i < 8; i++) {
            if (isSafe(M, row + rowNeighbor[i], col + colNeighbor[i], visited)) {
                DFS(M, row + rowNeighbor[i], col + colNeighbor[i], visited);
            }
        }
    }

}
