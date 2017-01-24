/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author GeorgeLocal
 */
public class MazeWithMatrix10x10 {
    
    private static final int MAX_ROWS = 10;
    private static final int MAX_COLUMNS = 10;   
    private Position adjMatrix[][]; //adjacency matrix to modify 
    
    public static void main(String args[]){
        MazeWithMatrix10x10 maze = new MazeWithMatrix10x10();        
        maze.generateMatrix();
        System.out.println("------------------------------");
        System.out.println("Salida Encontrada: " + maze.findExitMaze());
    }
    
    public void generateMatrix(){
        
        adjMatrix = new Position[MAX_ROWS][MAX_COLUMNS];
        
        Random randomGenerator = new Random();

        for(int i=0; i<MAX_ROWS;i++){
            for(int j=0;j<MAX_COLUMNS;j++){
                adjMatrix[i][j] = new Position(i, j,'O');
            }
        }
           
        int nObtaculos = 0;
        int maxNumObtaculos = (int) (Math.round((MAX_ROWS * MAX_COLUMNS) * 0.20));
        Position pos = new Position(0, 0, 'O');
        while(nObtaculos < maxNumObtaculos){            
            getRandomPositionInMatrix(randomGenerator, pos);
            //elemento actual & izquierda & derecha & arriba & abajo
            if(valid(pos.row, pos.column) && valid(pos.row, pos.column -1) && valid(pos.row, pos.column + 1) //&&
               /*valid(pos.row -1, pos.column) && valid(pos.row + 1, pos.column)*/){
                
                adjMatrix[pos.row][pos.column] = new Position(pos.row, pos.column,'X');
                nObtaculos ++;
            }
        }
        
        for(int i=0; i<MAX_ROWS;i++){
            for(int j=0;j<MAX_COLUMNS;j++){
                System.out.print(adjMatrix[i][j]);
            }
            System.out.println("");
        }

    }
    
    public void getRandomPositionInMatrix(Random randomGenerator, Position pos){
        int row = randomGenerator.nextInt(10);
        int column = randomGenerator.nextInt(10);
        
        pos.row = row;
        pos.column = column;
        
        
    }
    public boolean findExitMaze(){
        
        boolean done = false;
        Stack<Position> pila = new Stack<Position>();                   
        pila.push(adjMatrix[0][0]);
        
        while(!pila.isEmpty()){
            
            //get an unvisited vertex adjacent to stack top
            Position current = pila.peek();
            
            if(valid(current.row, current.column)){                  

                adjMatrix[current.row][current.column].data = '1';
                //adjMatrix[current.row][current.column].numVisited++;
                if (current.row == adjMatrix.length-1 && current.column == adjMatrix[0].length-1){
                    done = true;  // maze is solved
                    adjMatrix[current.row][current.column].data = '#';
                    break;
                }else{                    
                    if(valid(current.row+1, current.column)){
                      pila.push(adjMatrix[current.row+1][current.column]);  // down
                      
                    }
                    if(valid(current.row, current.column+1)){
                      pila.push(adjMatrix[current.row][current.column+1]);  // right
                      
                    }
                    if(valid(current.row-1, current.column)){
                       pila.push(adjMatrix[current.row-1][current.column]);  // up                      
                    }
                    if(valid(current.row, current.column-1)){
                       pila.push(adjMatrix[current.row][current.column-1]);  // left
                    }                    
                    
                }
                    
            }else{
                //adjMatrix[current.row][current.column].data = 'T';
                Position posPop = pila.pop();
                adjMatrix[posPop.row][posPop.column].data = '#';

            }

        }
                        
        
        for(int i=0; i<MAX_ROWS;i++){
            for(int j=0;j<MAX_COLUMNS;j++){
                    System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }  
                
        return done;
    }
    
   //===========================================================
   //  Determines if a specific location is valid.
   //===========================================================
   private boolean valid (int row, int column) {

      boolean result = false;
 
      // check if cell is in the bounds of the matrix
      if (row >= 0 && row < adjMatrix.length &&
          column >= 0 && column < adjMatrix[0].length)

         //  check if cell is not blocked and not previously tried
         if (adjMatrix[row][column].data == 'O')
            result = true;
         

      return result;

   }  // method valid
    
    class Position {
        public char data;
        public int row;
        public int column;
        public int numVisited;
        
        Position(int row, int column, char data){
            this.row = row;
            this.column = column;            
            this.data = data;
        }    

        @Override
        public String toString() {
            return data + " ";
        }
        
        
    }
}
