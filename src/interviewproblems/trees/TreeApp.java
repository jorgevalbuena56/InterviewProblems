/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main Class to Test Tree Class
 * 
 * @author George
 */
public class TreeApp {
    
    public static void main(String[] args) throws IOException{
        int value;
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
        
        while(true){
            putText("Enter first letter of: ");
            putText("show, insert, find, delete, or traverse: ");
            int choice = getChar();
            
            switch(choice){
                case 's':
                    theTree.displayTree();
                break;
                case 'i':
                    putText("Enter value for insert: ");
                    value = getInt();
                    theTree.insert(value);
                break;
                case 'f':
                    putText("Enter value to Find: ");
                    value = getInt();
                    Node found = theTree.find(value);
                    if(found != null){
                        putText("Found: ");
                        found.displayNode();
                        putText("\n");
                    }else{
                        putText("Couldn't find " + value + '\n');
                    }
                break;
                case 'd':
                    putText("Enter value to delete");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if(didDelete){
                        putText("Deleted " + value + '\n');
                    }else{
                        putText("Could not delete " + value + '\n');
                    }
                break;
                case 't':
                    putText("Enter type 1, 2, 3 or 4: ");
                    value = getInt();
                    theTree.traverse(value);
                break;
                default:
                    putText("Invalid Entry\n");
            }
        }
    }
    
    public static void putText(String s){
        System.out.println(s);
        System.out.flush();
    }
    
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    
    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }
    
    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }
}
