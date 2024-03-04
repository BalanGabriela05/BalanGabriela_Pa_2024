public class BonusEx1 {
//    Create the adjacency matrix of a wheel graph Wn.
//    Display on the screen a textual representation of the matrix.

    public int n;
    public int[][] m;

    public BonusEx1(int n)
    {
        this.n = n;
        m = new int[n][n];
    }

    public void WheelGraph() {
        for (int i = 0; i <= n - 1; i++) {
             if ((i < n - 1) ) {
                    m[i][i + 1] = 1;
                    m[i + 1][i] = 1;
             }
             for(int j=0; j <= n-1; j++){
                  if (((i == n - 1) || (j == n - 1)) && i!=j) {
                    m[i][j] = 1; // pentru nodul din centru
                  }
             }

        }
        m[0][n - 2] = 1;
        m[n - 2][0] = 1;

        System.out.print("  ");
        for (int i = 0; i < n; i++) {
             System.out.print(i + " ");
        }
        System.out.println();
        System.out.print(" ");
        for (int i = 0; i < n; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

//       Write an algorithm that finds all the cycles of a wheel graph. Verify that their number is n^2 - 3n + 3.

//        int expectedCycles = n * n - 3 * n + 3;
//        int foundCycles = 0;
//        int[] visited = new int[n];
//        for (int i = 0; i < n; i++) {
//            foundCycles += Dfs(i, i, 0, new int[n], visited);
//            System.out.println("->"+foundCycles);
//
//        }
//        System.out.println("Number of cycles: " + foundCycles);
//        if (foundCycles == expectedCycles) {
//            System.out.println("Number of cycles matches the expected value.");
//        } else {
//            System.out.println("Number of cycles does not match the expected value.");
//        }
    }

//    private int Dfs(int start, int node, int length, int[] path, int[] visited) {
//
//        visited[node] = 1;
//        int count = 0;
//        if (length >= 2 && node == start) {
//            System.out.print("Cycle found: ");
//            for (int i = 0; i <= length; i++) {
//                System.out.print(path[i] + " ");
//            }
//            System.out.println(start);
//            count++;
//            visited[node] = 0;
//
//            return count;
//        }
//        for (int k = 0; k < n; k++) {
//            if (m[node][k] == 1 && visited[k] == 0) {
//                path[length] = node;
//                count += Dfs(start, k, length + 1, path, visited);
//            }
//        }
//        visited[node] = 0;
//
//        return count;
//    }

}
