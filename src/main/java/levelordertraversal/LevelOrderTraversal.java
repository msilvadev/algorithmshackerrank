package levelordertraversal;

import java.util.Scanner;

/**
 * Link to problem on HackerRank: https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
 *
 * Given a pointer to the root of a binary tree, you need to print the level order traversal of this tree.
 * In level-order traversal, nodes are visited level by level from left to right.
 *
 * Level Order Binary Tree Traversal
 * @author msilvadev
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }

    public static void levelOrder(Node root) {
        int h = height(root);
        int i;
        for (i=0; i<=h; i++){
            printGivenLevel(root, i);
        }
    }

    private static void printGivenLevel(Node root ,int level) {
        if (root == null) {
            return;
        }
        if (level == 1){
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if (leftHeight > rightHeight){
                return(leftHeight + 1);
            } else{
                return(rightHeight + 1);
            }
        }
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
