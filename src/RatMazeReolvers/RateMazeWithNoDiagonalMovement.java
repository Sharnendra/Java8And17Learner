package RatMazeReolvers;

public class RateMazeWithNoDiagonalMovement {
    // Size of the maze
    private static final int N = 8;

    // The maze matrix
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

    // Helper function to print the solution path
    private static void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Helper function to check if the given cell is valid to move
    private static boolean isValidMove(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 0);
    }

    // Recursive function to solve the rat maze problem
    private static boolean solveMaze(int x, int y, int[][] solution) {
        // Base case: If the mouse reaches the destination
        if (x == N - 1 && y == N - 1) {
            solution[x][y] = 1;
            return true;
        }

        // Check if the current cell is a valid move
        if (isValidMove(x, y)) {
            // Mark the current cell as part of the solution path
            solution[x][y] = 1;

            // Move down (x+1) in the maze and recursively solve
            if (solveMaze(x + 1, y, solution)) {
                return true;
            }

            // Move right (y+1) in the maze and recursively solve
            if (solveMaze(x, y + 1, solution)) {
                return true;
            }

            // If none of the above movements lead to a solution, backtrack
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
