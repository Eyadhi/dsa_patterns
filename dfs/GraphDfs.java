package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphDfs {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> l1 = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            l1.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            l1.get(edge[0]).add(edge[1]);
            l1.get(edge[1]).add(edge[0]);
        }

        stack.push(source);
        visited[source]=true;

        while(!stack.isEmpty()){
            int current = stack.pop();
            if(current == destination){
                return true;
            }
            for(int neighbour : l1.get(current)){
                if(!visited[neighbour]){
                    stack.push(neighbour);
                    visited[neighbour]=true;
                }
            }
        }
        return false;
    }

    // 200. Number of Islands
    public int numIslands(char[][] grid) {
        int islands =0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid,int row,int col){
        if(row<0 || col<0 || row>=grid.length || col>= grid[0].length || grid[row][col] == '0'){
            return ;
        }

        grid[row][col] ='0';

        dfs(grid,row+1,col);
        dfs(grid,row-1,col);

        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }

    public static void main(String[] args) {
        
    }
}
