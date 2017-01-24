/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.graph;

import java.util.Stack;

/**
 * MinimumSpanningTree Class. 
 * 
 * A graph with the minimum number of edges necessary to connect the vertices
 * 
 * @author GeorgeLocal
 */
public class MinimumSpanningTree {
    private final int MAX_VERTEX = 20;
    
    private final Vertex vertexList[]; //array of vertices
    private final int adjMat[][]; //adjacency matrix
    private int nVerts; //current number of vertices
    private final Stack stack;
    
    public static void main(String args[]){
        MinimumSpanningTree graph = new MinimumSpanningTree();
        graph.addVertex(3);
        graph.addVertex(5);
        graph.addVertex(8);
        graph.addVertex(1);
        graph.addVertex(2);
        
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        System.out.print("Minimum Spanning Tree: ");
        graph.mst();
        System.out.println("");
        
    }
    
    public MinimumSpanningTree(){
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
    
    public void mst(){
        vertexList[0].wasVisited = true;        
        stack.push(0);
        
        while(!stack.isEmpty()){
           
            int currentVertex = (int)stack.peek();
            //get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(currentVertex);
            //if no such vertex
            if(v == -1){
                stack.pop();
            }else{
                vertexList[v].wasVisited = true;
                stack.push(v);
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");                
            }
        }
        //stack is empty, so we're done
        for(int j=0;j<nVerts;j++){  //reset flags
            vertexList[j].wasVisited = false;
        }                
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
