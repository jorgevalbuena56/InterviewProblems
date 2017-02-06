/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class Representating the whole Tree
 * 
 * @author George
 */
public class Tree {
    
    private Node root;          //first node of the tree
    
    public Tree(){
        root = null;
    }
    
    public Node find(int key){
        //assumes non-empty tree
        Node current = root;
        
        while(current.iData != key){
          if(key < current.iData){
              current = current.leftChild;
          }else{
              current = current.rightChild;
          }    
        }
        return current;
    }
    
    public void insert(int id){
        Node newNode = new Node(id);
       
        if(root == null){
            root = newNode;
        }else{
            Node current = root;
            Node parent;
            
            while(true){
                parent = current;
                if(id < parent.iData){  //go to the left
                    current = current.leftChild;
                    if(current == null){ // if end of the line, insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                }else{      //go to the right
                    current = current.rightChild;
                    if(current == null){ //if end of the line, insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                }//end else go right
            }//end while
        }//end else not root
    }//end insert()
    
    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        
        while(current.iData != key){    //search for the node
             parent = current;
             if(key < current.iData){   //go left
                 isLeftChild = true;
                 current = current.leftChild;
             }else{
                 isLeftChild = false;
                 current = current.rightChild;
             }
             if(current == null){   //end of the line, didn't find it
                 return false;
             }
        }
        
        //found node to delete
        
        //if no children, simply delete it
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){    //if root
                root = null;        //tree is empty
            }else if(isLeftChild){
                parent.leftChild = null;    //disconnect
            }else{
                parent.rightChild = null;
            }
        }        
        //if no right child, replace with left subtree
        else if(current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
        }
        
        // if no left child, replace with right subtree
        else if(current.leftChild == null){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
        }
        
        // two children, so replace with inorder successor
        else{
            //get successor of node to delete (current)
            Node succesor = getSuccesor(current);
            
            //connect parent of current to succesor instead
            if(current == root){
                root = succesor;
            }else if(isLeftChild){
                parent.leftChild = succesor;
            }else{
                parent.rightChild = succesor;
            }
            
            // connect successor to current's left child
            succesor.leftChild = current.leftChild;
        } //end else two children
        // (succesor cannot have a left child)
        return true;
    } // end delete()
    
    // returns node with next-highest value after delNode goes to right child, then right child's left
    // descendents    
    private Node getSuccesor(Node delNode){
        
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;  //go to the right child until no more left children
        
        while(current != null){
            successorParent = delNode;
            successor = current;
            current = current.leftChild;   //go to left child
            
            //if successor not
            if(successor != delNode.rightChild){ //right child
                //make connections
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = delNode.rightChild;
            }
        }
        return successor;
    }
    
    public void traverse(int traverseType){
        switch(traverseType){
            case 1: System.out.println("\nPreorder traversal: ");
                    preOrder(root);
                    break;
            case 2: System.out.println("\nInOrder traversal: ");    
                    inOrder(root);
                    break;
            case 3: System.out.println("\nPostOrder traversal: ");    
                    postOrder(root);
                    break;
            case 4: System.out.println("\nLevel Order traversal: ");        
                    levelOrder(root);
                    int h = 0;
                    break;
        }
    }
    
    /**
     * ROOT - LEFT CHILD - RIGHT CHILD
     * @param localRoot 
     */
    private void preOrder(Node localRoot){
        if(localRoot != null){
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    
    /**
     * LEFT CHILD - ROOT - RIGHT CHILD
     * @param localRoot 
     */
    private void inOrder(Node localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);
            localRoot.displayNode();            
            inOrder(localRoot.rightChild);
        }
    }
    
    /**
     * LEFT CHILD - RIGHT CHILD - ROOT
     * @param localRoot 
     */
    private void postOrder(Node localRoot){
        if(localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            localRoot.displayNode();                        
        }
    }
    
    /**
     * PRINT THE ELEMENTS IN THEIR LEVEL ORDER
     * 
     * @param localRoot 
     */
    private void levelOrder(Node localRoot){
        
        Queue<Node> queue=new LinkedList<Node>();  
        queue.add(localRoot);  
        
        while(!queue.isEmpty())  
        {  
            Node tempNode = queue.poll();  
            System.out.printf("%d ",tempNode.iData);  
            if(tempNode.leftChild!=null)  
                queue.add(tempNode.leftChild);  
            if(tempNode.rightChild!=null)  
                queue.add(tempNode.rightChild);  
        }  
    }
    
    public void displayTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("..........................................");
        while(isRowEmpty == false){
            Stack localStack = new Stack();
            isRowEmpty = true;
            
            for(int j = 0; j<nBlanks; j++){
                System.out.print(' ');
            }
            
            while(globalStack.isEmpty() == false){
                Node temp = (Node) globalStack.pop();
                if(temp != null){
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    
                    if(temp.leftChild != null || temp.rightChild != null){
                        isRowEmpty = false;
                    }
                    
                }else{
                    System.out.print("..");
                    localStack.push(null);
                    localStack.push(null);
                }
                
                for(int j=0; j<nBlanks*2-2;j++){
                    System.out.print(' ');
                }
            }
            System.out.println("");
            nBlanks /= 2;
            while(localStack.isEmpty() == false){
                globalStack.push(localStack.pop());
            }
        }
        
        System.out.println("..........................................");
    }
    
    public Node getRoot(){
        return root;
    }
}
