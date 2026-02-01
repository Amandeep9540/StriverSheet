package graph.problems;
import java.util.*;

public class CoursesSchedule207 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites ={{1,0},{0,1}};
        boolean canFinish = canFinishDFS(numCourses,prerequisites);
        System.out.println("can we finish -- "+canFinish);
    }

    public static boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            // b --- >a
            adjList.get(b).add(a);
            inDegree[a]++;
        }

        return canDoTopoBFS(adjList, numCourses, inDegree);
    }

    private static boolean canDoTopoBFS(List<List<Integer>> adjList, int N, int[] inDegree) {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adjList.get(u)) {
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                    count++;
                }
            }
        }

        return count == N;
    }

    public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adjList.get(b).add(a);
        }
        boolean[] isVisited = new boolean[numCourses];
        boolean[] inRecurssion = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(isCycleDFS(adjList,i, isVisited,inRecurssion))
                return false;
        }
        return true;
    }

    private static boolean isCycleDFS(List<List<Integer>> adjList, int u, boolean[] isVisited,boolean[] inRecurssion) {
        if(isVisited[u]) return false;
        isVisited[u] = true;inRecurssion[u] = true;
        for(int v : adjList.get(u)){
            if(isVisited[v] && inRecurssion[v])
                return true;

            if(isCycleDFS(adjList,v, isVisited,inRecurssion))
                return true;
        }
        inRecurssion[u] = false;
        return false;
    }
}
