package UNIT_4.ToplogocalSort;

import java.util.*;

public class ParallelCourses_I {
    public int minimumSemesters(int n, int[][] relations) {
        // Step 1: Build graph and indegree array
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());

        int[] indeg = new int[n];
        for (var r : relations) {
            int prev = r[0] - 1, nxt = r[1] - 1;
            g[prev].add(nxt);
            indeg[nxt]++;
        }

        // Step 2: Queue for BFS, add all courses with 0 prerequisites
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        int ans = 0; // number of semesters

        // Step 3: BFS level by level
        while (!q.isEmpty()) {
            int size = q.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int course = q.poll();
                n--; // one course completed

                for (int neighbor : g[course]) {
                    indeg[neighbor]--;
                    if (indeg[neighbor] == 0) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        return n == 0 ? ans : -1; // If not all courses are finished, there is a cycle
    }

    // Optional main method for testing
    public static void main(String[] args) {
        ParallelCourses_I obj = new ParallelCourses_I();
        int n = 3;
        int[][] relations = { {1, 3}, {2, 3} };
        System.out.println(obj.minimumSemesters(n, relations)); // Output: 2
        
    }
}
