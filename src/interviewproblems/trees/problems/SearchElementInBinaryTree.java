/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.trees.problems;

import interviewproblems.trees.Node;
import interviewproblems.trees.Tree;

/**
 * Give an algorithm for searching an element in binary tree
 * 
 * @author George
 */
public class SearchElementInBinaryTree {
    
    public static void main(String[] args){
        
        Tree theTree = new Tree();
        
        theTree.insert(50);
        theTree.insert(25);
        theTree.insert(75);
        theTree.insert(12);
        theTree.insert(37);
        theTree.insert(43);
        theTree.insert(30);
        theTree.insert(33);
        theTree.insert(87);
        theTree.insert(93);
        theTree.insert(97);
        
        System.out.println("Found: " + findInBT(theTree.getRoot(), 47));
    }
    
    
    /**
     * Given a binary tree, return true if a node with data is found in the tree. Recurse down the tree
     * 
     * choose the left or right branch by comparing data with each nodes data
     * 
     * @param root
     * @param data
     * @return 
     */
    public static boolean findInBT(Node root, int data){
        if(root == null){
            return false;
        }
        
        if(root.iData == data){
            return true;
        }
        
        return findInBT(root.leftChild, data) || findInBT(root.rightChild, data);
    }
}
