package com.subhash.hackerrank.practice.datastructures.trees;

import java.util.*;

public class SwapNodesAlgo {

    static class TreeNode {
        int value;
        int depth;
        TreeNode leftNode;
        TreeNode rightNode;
        TreeNode parentNode;
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int [] [] result = new int [queries.length][];

        List<Integer> [] queriesList = new List[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queriesList [i] = new ArrayList<>();
        }

        List<TreeNode> s = new LinkedList<>();

        TreeNode root = new TreeNode();
        root.value = 1;
        root.depth = 1;
        s.add(root);

        for (int i = 0; i < indexes.length; i++) {
            int left = indexes[i][0];
            int right = indexes[i][1];

            TreeNode node = ((LinkedList<TreeNode>) s).remove();
            if (left != -1) {
                TreeNode leftNode = new TreeNode();
                leftNode.value = left;
                leftNode.depth = node.depth + 1;
                node.leftNode = leftNode;
                s.add(leftNode);
            }
            if (right != -1) {
                TreeNode rightNode = new TreeNode();
                rightNode.value = right;
                rightNode.depth = node.depth + 1;
                node.rightNode = rightNode;
                s.add(rightNode);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            inorderTraverse(root, queries[i], queriesList[i]);
            result[i] = new int [queriesList[i].size()];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = queriesList[i].get(j);
            }
        }

        return result;
    }

    static void inorderTraverse(TreeNode treeNode, int swapDepth, List<Integer> result) {
        boolean swap = treeNode.depth % swapDepth == 0;
        if (swap) {
            TreeNode temp = treeNode.leftNode;
            treeNode.leftNode = treeNode.rightNode;
            treeNode.rightNode = temp;
        }

        if (treeNode.leftNode != null) {
            inorderTraverse(treeNode.leftNode, swapDepth, result);
        }
        result.add(treeNode.value);
        if (treeNode.rightNode != null) {
            inorderTraverse(treeNode.rightNode, swapDepth, result);
        }
    }

    public static void main(String[] args) {
        int[][] indexes = {
                {2, 3},
                {4, -1},
                {5, -1},
                {6, -1},
                {7, 8},
                {-1, 9},
                {-1, -1},
                {10, 11},
                {-1, -1},
                {-1, -1},
                {-1, -1}
        };
        int[] queries = {2, 4};
        int [][] r = swapNodes(indexes, queries);
        Arrays.stream(r).forEach(rr -> System.out.println(Arrays.toString(rr)));
    }

}
