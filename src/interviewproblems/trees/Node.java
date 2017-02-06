/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.trees;

/**
 * Class Node for every element in the Tree
 * 
 * @author George
 */
public class Node {
    
    public int iData;
    public Node leftChild;
    public Node rightChild;
    
    public void displayNode(){
        System.out.print("{" + iData + "}");        
    }
    
    public Node(int data) {
        iData = data;
    }
}
