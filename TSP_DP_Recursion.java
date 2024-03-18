import java.util.Arrays;
public class TSP_DP_Recursion{



    public static int tsp(int[][] graph, int mask, int current, int n, int[][] dp) {

        // Base case: If all cities have been visited

        if (mask == (1 << n) - 1) {

            return graph[current][0];

        }



        // Check if the result is already computed

        if (dp[mask][current] != -1) {

            return dp[mask][current];

        }



        int minCost = Integer.MAX_VALUE;



        // Try visiting unvisited cities

        for (int city = 0; city < n; city++) {

            if ((mask & (1 << city)) == 0) {

                int newMask = mask | (1 << city);

                int cost = graph[current][city] + tsp(graph, newMask, city, n, dp);



                minCost = Math.min(minCost, cost);

            }

        }



        // Save the result in the dp table

        dp[mask][current] = minCost;



        return minCost;

    }



    public static int solveTSP(int[][] graph) {

        int n = graph.length;

        int[][] dp = new int[1 << n][n];

        for (int[] row : dp) {

            Arrays.fill(row, -1);

        }



        // Start the TSP from city 0

        return tsp(graph, 1, 0, n, dp);

    }



    public static void main(String[] args) {

        int[][] graph = {

                {0, 4, 1, 3},

                {4, 0, 2, 1},

                {1, 2, 0, 5},

                {3, 1, 5, 0}

        };



        int minCost = solveTSP(graph);



        System.out.println("Minimum cost of TSP: " + minCost);

    }

}

