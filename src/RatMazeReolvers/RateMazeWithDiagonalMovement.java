package RatMazeReolvers;

public class RateMazeWithDiagonalMovement {
    private static final int N = 8;
    private static int[][] maze = {
            {0, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {1, 1, 0, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0}
    };

    private static void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 0);
    }

    private static boolean solveMaze(int x, int y, int[][] solution) {
        if (x == N - 1 && y == N - 1) {
            solution[x][y] = 1;
            return true;
        }

        if (isValidMove(x, y)) {
            solution[x][y] = 1;

            // Define the eight possible movements
            int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
            int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};

            for (int i = 0; i < 8; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (solveMaze(nextX, nextY, solution)) {
                    return true;
                }
            }

            solution[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] solution = new int[N][N];

        if (solveMaze(0, 0, solution)) {
            System.out.println("Solution found:");
            printSolution(solution);
        } else {
            System.out.println("No path exists to reach the destination.");
        }
    }
}
