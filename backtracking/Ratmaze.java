package techniques.backtracking;

import java.util.*;

public class Ratmaze {
	public List<String> findPaths(int[][] maze) {
		List<String> paths = new ArrayList<>();
		int n = maze.length;
		StringBuilder path = new StringBuilder();
		findPathsUtil(maze, 0, 0, n, path, paths);
		return paths;
	}

	public static void findPathsUtil(int[][] maze, int row, int col, int n, StringBuilder path, List<String> paths) {
		if (row == n - 1 && col == n - 1) {
			paths.add(path.toString());
			return;
		}
		if (row < 0 || col < 0 || row >= n || col >= n || maze[row][col] == 0) {
			return;
		}
		maze[row][col] = 0;
		findPathsUtil(maze, row + 1, col, n, path.append("D"), paths);
		path.deleteCharAt(path.length() - 1);
		findPathsUtil(maze, row - 1, col, n, path.append("U"), paths);
		path.deleteCharAt(path.length() - 1);
		findPathsUtil(maze, row, col + 1, n, path.append("R"), paths);
		path.deleteCharAt(path.length() - 1);
		findPathsUtil(maze, row, col - 1, n, path.append("L"), paths);
		path.deleteCharAt(path.length() - 1);
		maze[row][col] = 1;
	}

	public static void main(String[] args) {
		Ratmaze r1 = new Ratmaze();
		int[][] maze = {
				{ 1, 0, 0, 0 },
				{ 1, 1, 0, 1 },
				{ 1, 1, 0, 0 },
				{ 0, 1, 1, 1 },
		};
		List<String> paths = r1.findPaths(maze);
		System.out.println("Possible paths");
		for (String path : paths) {
			System.out.println(path);
		}
	}
}
