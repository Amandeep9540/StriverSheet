package graph.problems;
import java.util.*;

public class CoursesSchedule210 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites ={{1,0},{0,1}};
        int[] canFinish = findOrderDFS(numCourses,prerequisites);
        System.out.print("can we finish -- ");
        Arrays.stream(canFinish).forEach(System.out::println);
    }

    public static int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = getEmptyAdjList(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            //b --- > a
            adjList.get(b).add(a);
            indegree[a]++;
        }
        return courseOrderBFS(numCourses, adjList, indegree);
    }

    private static int[] courseOrderBFS(int N, List<List<Integer>> adjList, int[] indegree) {
        int[] order = new int[N];
        int orderInd = 0;
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        //adding zero indegree in queue
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                order[orderInd++] = i;
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adjList.get(u)) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                    order[orderInd++] = v;
                    count++;
                }
            }
        }
        if (count < N) {
            order = new int[0];
        }
        return order;
    }

    public static int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = getEmptyAdjList(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adjList.get(b).add(a);
        }
        boolean[] isVisited = new boolean[numCourses];
        boolean[] inRecurssion = new boolean[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(isVisited[i]) continue;
            if(isCycleDFS(adjList,i,isVisited,inRecurssion,stack)){
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for(int i=0;i<result.length;i++)
            result[i] = stack.pop();
        return result;
    }

    public static boolean isCycleDFS(List<List<Integer>> adjList,int u,boolean[] isVisited,boolean[] inRecurssion,Deque<Integer> stack){
        if(isVisited[u]) return false;
        isVisited[u] = true; inRecurssion[u] = true;
        for(int v : adjList.get(u)){
            if(isVisited[v] && inRecurssion[v]) return true;
            if(!isVisited[v] && isCycleDFS(adjList,v,isVisited,inRecurssion,stack)) return true;
        }
        stack.push(u);
        inRecurssion[u] = false;
        return false;
    }

    private static List<List<Integer>> getEmptyAdjList(int numCourses) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        return adjList;
    }
}
