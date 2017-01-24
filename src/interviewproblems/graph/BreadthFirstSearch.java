/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth-first search Class. It also calcule the minimun element in the graph
 * 
 * Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures. 
 * It starts at the tree root (or some arbitrary node of a graph) and explores the neighbor nodes first, 
 * before moving to the next level neighbors.
 * 
 * USEFUL FOR FINDING SHORTEST PATH
 * 
 * The time complexity can be expressed as O(|V|+|E|)
 * 
 * since every vertex and every edge will be explored in the worst case.
 * 
 * @author GeorgeLocal
 */
public class BreadthFirstSearch {
    private final int MAX_VERTEX = 20;
    
    private final Vertex vertexList[]; //array of vertices
    private final int adjMat[][]; //adjacency matrix
    private int nVerts; //current number of vertices
    private final Queue queue;
    
    public static void main(String args[]){
        BreadthFirstSearch graph = new BreadthFirstSearch();
        graph.addVertex(3);
        graph.addVertex(5);
        graph.addVertex(8);
        graph.addVertex(1);
        graph.addVertex(2);
        
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(3,2);
        graph.addEdge(4,2);
        graph.addEdge(2,3);
        System.out.print("Visits: ");
        System.out.println("\nMinimum: " + graph.dfs());
        System.out.println("");
        
    }
    
    public BreadthFirstSearch(){
        vertexList = new Vertex[MAX_VERTEX];
        adjMat = new int[MAX_VERTEX][MAX_VERTEX];
        nVerts = 0;
        
        //set adjacency matrix to 0
        for(int i=0; i<MAX_VERTEX;i++){
            for(int j=0; j<MAX_VERTEX;j++){
                adjMat[i][j] = 0;
            }
        }
        
        queue = new LinkedList();
    }
    
    public void addVertex(int num){
        vertexList[nVerts++] = new Vertex(num);
    }
    
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    
    public void displayVertex(int v){
        System.out.print(vertexList[v].number + " ");
    }
    
    public int dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;
        int min = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            
            //get an unvisited vertex adjacent to stack top
            int v1 = (int)queue.remove();            
            while((v2 = getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);       
                
                if(v2 < min){
                    min = v2;
                }
            }
        }
        //queue is empty, so we're done
        for(int j=0;j<nVerts;j++){  //reset flags
            vertexList[j].wasVisited = false;
        }
        
        return min;
    }
    
    public int getAdjUnvisitedVertex(int v){
        for(int j=0; j<nVerts;j++){
            if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false){
                return j;
            }
        }
        return -1;
    }
}
