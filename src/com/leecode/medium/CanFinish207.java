package com.leecode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 *
 * 提示：
 *
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 *
 */
public class CanFinish207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0;i < numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0;i < numCourses;i++){
            if (findCircle(i,visited,graph)){
                return false;
            }
        }
        return true;
    }

    private boolean findCircle(int node, int[] visited, List<List<Integer>> graph) {
        if (visited[node] == 1){
            return true;
        }
        visited[node] = 1;
        for (Integer next : graph.get(node)){
            if (findCircle(next,visited,graph)){
                return true;
            }
        }
        visited[node] = 0;
        return false;
    }

    public static void main(String[] args) {
        CanFinish207 canFinish = new CanFinish207();
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println("canFinish.canFinish(2,prerequisites) = " + canFinish.canFinish(2, prerequisites));
    }
}
