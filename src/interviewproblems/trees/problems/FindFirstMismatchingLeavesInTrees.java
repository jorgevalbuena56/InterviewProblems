/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.trees.problems;

import interviewproblems.trees.Node;

/**
 * Given two pre-order traversal arrays of two binary search tree respectively, 
 * find first pair of non-matching leaves.
 * 
 * Follow Up: If they are general binary trees instead of BSTs, 
 * could you solve it? give out your reason.
 *
 * @author valgood
 */
public class FindFirstMismatchingLeavesInTrees {

    Node root1, root2;

    public void mismatchingLeaves(Node root1, Node root2) {
        if (root1.iData != root2.iData && 
            root1.leftChild == null && root1.rightChild == null &&
            root2.leftChild == null && root2.rightChild == null) {
            System.out.println("Mismatching pairs are " + root1.iData + " , "
                    + root2.iData);
        }

        if (root1.leftChild != null && root2.leftChild != null) {
            mismatchingLeaves(root1.leftChild, root2.leftChild);
        }
        if (root1.rightChild != null && root2.rightChild != null) {
            mismatchingLeaves(root1.rightChild, root2.rightChild);
        }

    }

    public static void main(String[] args) {
        FindFirstMismatchingLeavesInTrees tree = new FindFirstMismatchingLeavesInTrees();

        tree.root1 = new Node(5);
        tree.root1.leftChild = new Node(4);
        tree.root1.rightChild = new Node(8);
        tree.root1.leftChild.leftChild = new Node(2);
        tree.root1.leftChild.rightChild = new Node(4);
        tree.root1.rightChild.leftChild = new Node(6);
        tree.root1.rightChild.rightChild = new Node(9);

        tree.root2 = new Node(5);
        tree.root2.leftChild = new Node(3);
        tree.root2.rightChild = new Node(8);
        tree.root2.leftChild.leftChild = new Node(2);
        tree.root2.leftChild.rightChild = new Node(4);
        tree.root2.rightChild.leftChild = new Node(7);
        tree.root2.rightChild.rightChild = new Node(9);

        tree.mismatchingLeaves(tree.root1, tree.root2);
    }
}
