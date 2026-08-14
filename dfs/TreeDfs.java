package dfs;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int data;
    TreeNode left,right;

    TreeNode(int data){
        this.data = data;
        left = right = null;
    }
}

public class TreeDfs {

    // 112. Path Sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return root.data == targetSum;
        }

        targetSum -= root.data;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    // 113. Path Sum II
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumUtil(result,path,root,targetSum);
        return result;
    }

    public void pathSumUtil(List<List<Integer>> result,List<Integer> path,TreeNode root,int targetSum){
        if(root == null){
            return ;
        }

        path.add(root.data);
        targetSum -= root.data;

        if(root.left == null && root.right == null){
            if(targetSum == 0){
                result.add(new ArrayList<>(path));
            }   
        }else{
            pathSumUtil(result, path, root.left, targetSum);
            pathSumUtil(result, path, root.right, targetSum);
        }
        path.remove(path.size()-1);
    }

    // 257. Binary Tree Paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        binaryTreePathsUtil(root,path,result);
        return result;
    }

    public void binaryTreePathsUtil(TreeNode root, StringBuilder path,List<String> result){
        if(root == null){
            return ;
        }

        int length = path.length();

        if(length> 0){
            path.append("->");
        }

        path.append(root.data);
        if(root.left == null && root.right == null){
            result.add(path.toString());
        }else{
            binaryTreePathsUtil(root.left, path, result);
            binaryTreePathsUtil(root.right, path, result);
        }
        path.setLength(length);
    }

    // 124. Binary Tree Maximum Path Sum
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        return maxPathSumUtil(root);
    }

    public int maxPathSumUtil(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = Math.max(0,maxPathSumUtil(root.left));
        int rightSum = Math.max(0,maxPathSumUtil(root.right));

        maxSum = Math.max(maxSum,leftSum+rightSum+root.data);
        return root.data+Math.max(leftSum,rightSum);
    }

    
    // 543. Diameter of Binary Tree
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right =maxDepth(root.right);

        diameter = Math.max(diameter, left + right);

        return 1+Math.max(left,right);
    }

    public static void main(String[] args) {
        
    }
}
