/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.trees.problems;

import interviewproblems.trees.Node;
import interviewproblems.trees.Tree;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Give an algorithm for finding maximum element in a binary tree
 * 
 * @author GeorgeLocal
 */
public class FindMaximunElementBinaryTree {
    
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
        
        System.out.println("Maximum Element: " + maxInBinaryTreeNoRecursive(theTree.getRoot()));
    }
    
    /**
     * Find the maximum element in left subtree, find maximum element in right subtree, compare them
     * 
     * with root data and select the one which is giving the maximum value
     * 
     * @param root
     * @return 
     */
    public static int maxInBinaryTree(Node root){
        int maxValue = Integer.MIN_VALUE;
        
        if(root != null){
            int leftMax = maxInBinaryTree(root.leftChild);
            int rightMax = maxInBinaryTree(root.rightChild);
            
            if(leftMax > rightMax){
                maxValue = leftMax;
            }else{
                maxValue = rightMax;
            }
            
            if(root.iData > maxValue){
                maxValue = root.iData;
            }
        }
        
        return maxValue;
    }
    
    /**
     * Woth Recursion we use a Queue
     * 
     * @param root
     * @return 
     */
    public static int maxInBinaryTreeNoRecursive(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        
        int max = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(tmp.iData > max){
                max = tmp.iData;
            }            
            if(tmp != null){
                if(tmp.leftChild != null){
                    q.offer(tmp.leftChild);
                }
                if(tmp.rightChild != null){
                    q.offer(tmp.rightChild);
                }
            }
        }
        return max;
    }
}
