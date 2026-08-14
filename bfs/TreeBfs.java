package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int data;
    TreeNode left,right;

    TreeNode(int data){
        this.data = data;
        left = right = null;
    }
}

public class TreeBfs {
    public List<Integer> levelOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            list.add(curr.data);
            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
        }
        return list;
    }

    // 102. Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> imd = new ArrayList<>();
            int n =queue.size();
            for(int i=0;i<n;i++){
                TreeNode curr = queue.poll();
                imd.add(curr.data);
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            list.add(imd);
        }
        return list;
    }

    // 199. Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
                if(i==size-1)result.add(node.data);

				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}
		}
		return result;
    }

    // 103. Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> imd = new ArrayList<>();
            int n =queue.size();
            for(int i=0;i<n;i++){
                TreeNode curr = queue.poll();
                if(leftToRight){
                    imd.add(curr.data);
                }else{
                    imd.add(0,curr.data);
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            list.add(imd);
            leftToRight = !leftToRight;
        }
        return list;
    }

    // 111. Minimum Depth of Binary Tree
    public int minimumDepth(TreeNode root){
        if(root == null)return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth =1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
            
                if(curr.left == null && curr.right == null){
                    return depth;
                }

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // 637. Average of Levels in Binary Tree
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                sum+= curr.data;

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            result.add((double)(sum/size));

        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeBfs bfs = new TreeBfs();
        List<Integer> result = bfs.levelOrder(root);
        System.out.println(result);

        List<List<Integer>> result1 = bfs.levelOrder1(root);
        System.out.println(result1);

        List<List<Integer>> result2 = bfs.zigzagOrder(root);
        System.out.println(result2);
    }
}
