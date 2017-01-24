/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.graph;

import java.util.Stack;

/**
 * DepthFirstSearch Class. It also calcule the minimun element in the graph
 * Depth-first search (DFS) is an algorithm for traversing or searching tree or graph data structures. 
 * One starts at the root (selecting some arbitrary node as the root in the case of a graph) 
 * and explores as far as possible along each branch before backtracking.
 * 
 * Uses a Stack to remember where it should go when it reaches a dead end.
 * 
 * Likes to get as far away from the starting point as quickly as possible,
 * and return only when it reaches
 * 
 * a dead End
 * 
 * ANALOGY: MAZE, FIND A PATH BETWEEN TO EDGES, DETECTING CYCLES
 * 
 * @author GeorgeLocal
 */
public class DepthFirstSearch {
    private final int MAX_VERTEX = 20;
    
    private final Vertex vertexList[]; //array of vertices
    private final int adjMat[][]; //adjacency matrix
    private int nVerts; //current number of vertices
    private final Stack stack;
    
    public static void main(String args[]){
        DepthFirstSearch graph = new DepthFirstSearch();
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
    
    public DepthFirstSearch(){
        vertexList = new Vertex[MAX_VERTEX];
        adjMat = new int[MAX_VERTEX][MAX_VERTEX];
        nVerts = 0;
        
        //set adjacency matrix to 0
        for(int i=0; i<MAX_VERTEX;i++){
            for(int j=0; j<MAX_VERTEX;j++){
                adjMat[i][j] = 0;
            }
        }
        
        stack = new Stack();
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
        stack.push(0);
        int min = Integer.MAX_VALUE;
        
        while(!stack.isEmpty()){
            
            //get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex((int)stack.peek());
            //if no such vertex
            if(v == -1){
                stack.pop();
            }else{
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
                
                //code to get the minimun element in the graph
                if(vertexList[v].number < min){
                    min = vertexList[v].number;
                }
            }
        }
        //stack is empty, so we're done
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
