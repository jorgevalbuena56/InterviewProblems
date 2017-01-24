/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.recursion;

/**
 * The Tower of Hanoi is a mathematical puzzle. It contains of three rods (or pegs or towers), and a number
 * 
 * of disks of different sizes which can slide onton any rod. The puzzle starts with the disks on one rod
 * 
 * in ascending order of size, the smallest at the top, thus making a conical shape. The objective of the
 * 
 * puzzle is to move the entire stack to another rod, satisfying the following rules:
 * 
 *   1) Only one disk may be moved at a time.
 *   2) Each move consists of taking the upper disk from one of the rods and sliding it onto another rod
 *      on top of the other disks that may already be present on that rod.
 *   3) No disk may be placed on top of a smaller disk
 * 
 *   Algorithm
 *  
 *   1) MOve the top n - 1 disks from Source to Auxiliary tower
 *   2) Move the nth disk from Source to Destination tower
 *   3) Move the n-1 disks from Auxiliary tower to Destination tower
 *   4) Transferring the top n-1 disks from Source to Auxiliary tower can again be thought as a fresh 
 *      problem and can be solved in the same manner. Once we solve Tower of Hanoi with three disks,
 *     we can solve it with any number of disks with the above algorithm.
 * 
 * @author George
 */
public class TowersOfHanoi {
    
    public static void main(String args[]){
        towersOfHanoi(5, 'A', 'C', 'B');
    }
    
    public static void towersOfHanoi(int n, char fromPeg, char toPeg, char auxPeg){
        
        /* if only 1 disk, make the move nd return */        
        if(n == 1){
            System.out.println("Move disk 1 from peg: " + fromPeg + " to peg: " + toPeg);
            return;
        }
        
        /*Move top n-1 disks from A to B, using C as auxiliary */
        towersOfHanoi(n-1, fromPeg, auxPeg, toPeg);
        
        /*Move remaining disks from A to C*/
        System.out.println("MOve disk " + n + " from peg: " + fromPeg + " to peg: " + toPeg);
        
        /*Move n-1 disks from B to C using A as auxiliary*/
        towersOfHanoi(n-1, auxPeg, toPeg, fromPeg);
        
    }
}
