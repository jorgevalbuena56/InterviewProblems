/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.graph;

/**
 * Representation of a Vertex
 * 
 * @author GeorgeLocal
 */
public class Vertex {
    
   public int number;
   public boolean wasVisited;
   
   public Vertex(int n){
       number = n;
       wasVisited = false;
   }
}
