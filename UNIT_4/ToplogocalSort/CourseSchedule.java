package UNIT_4.ToplogocalSort;

import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Adjacency matrix representation
        int[][] adjList = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];

        // Build the graph and in-degree array
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];
            adjList[v][u] = 1;
            inDegree[u]++;
        }

        // Queue for topological sort (courses with 0 in-degree)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        int[] order = new int[numCourses];
        int index = 0;

        // Topological sort using Kahn's algorithm
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            order[index++] = u;

            for (int v = 0; v < numCourses; v++) {
                if (adjList[u][v] == 1 && --inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (count == numCourses) {
            // Valid course order exists
            System.out.print("Course order: ");
            for (int i = 0; i < count; i++) {
                System.out.print(order[i] + " ");
            }
            System.out.println();
            return true;
        } else {
            // Cycle exists, cannot finish all courses
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int nc = s.nextInt();
        System.out.print("Enter number of prerequisite pairs: ");
        int c = s.nextInt();

        int[][] prereq = new int[c][2];
        System.out.println("Enter prerequisites (each as: course prerequisite): ");
        for (int i = 0; i < c; i++) {
            prereq[i][0] = s.nextInt();
            prereq[i][1] = s.nextInt();
        }

        boolean result = canFinish(nc, prereq);
        System.out.println("Can all courses be finished? " + result);

        s.close();
    }
}

