package heightofabinarytree;

import java.util.Scanner;

/**
 * Link to problem on HackerRank: https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
 *
 * The height of a binary tree is the number of edges between the tree's root and its furthest leaf.
 * Class with simple calculate Height Binary Tree.
 *
 * @author msilvadev
 */
public class CalculateHeightBinaryTree {

    /**
     * 1 - The first line contains an integer , the number of nodes in the tree.
     * 2 - Next line contains space separated integer where th integer denotes node[i].data.
     *
     * Example 1:
     *  7
     *  3 5 2 1 4 6 7
     *  expected output: 3
     * Example 2:
     *  1
     *  15
     *  expected output: 0
     * Example 3:
     *  5
     *  3 1 7 5 4
     *  expected output: 3
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }

    /**
     * The Height of binary tree with single node is taken as zero.
     * @param root note
     * @return longestPath Height of a Binary Tree from root node
     */
    public static int height(Node root) {
        int longestPath = -1;

        if (root == null) {
            return longestPath;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight > rightHeight) {
            longestPath = leftHeight + 1;
        } else {
            longestPath = rightHeight + 1;
        }

        return longestPath;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}