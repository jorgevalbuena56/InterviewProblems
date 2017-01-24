/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewproblems.recursion;

/**
 *
 * @author 984325
 */
public class LCSMemoizeBruteForce {

    /**
     * @param args the command line arguments
     */
    int cntCalls = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        LCSMemoizeBruteForce al = new LCSMemoizeBruteForce();
        int m = 11;
        int n = 9;
        int t[][] = new int[m+1][n+1];
        
        System.out.println("Maximum Lenght: " + al.LCS(t, "CGATAATTGAGA", "GTTCCTAATA", m, n));
        System.out.println("Recursive calls made: " + al.cntCalls);
        
        for(int i=0; i<m;i++){
            for (int j=0; j<n;j++){
                System.out.print("|" + t[i][j] + "|");
            }
            System.out.println("");
        }
    }
    
    public int LCS(int t[][], String s1, String s2, int m, int n) {
        cntCalls ++;
        if(t[m][n] > 0){
            return t[m][n];
        }
        if (n == 0) {
             t[m][0] = 0;
        }else if(m == 0){
            t[0][n] = 0;
        }else if(s1.charAt(m) == s1.charAt(n)) {
            t[m][n] = LCS(t, s1, s2, m-1, n-1) + 1;
        }else{
            t[m][n] = Math.max(LCS(t, s1, s2, m, n-1) , LCS(t, s1, s2, m-1, n)); 
        }
    
        return t[m][n];
    }
}
