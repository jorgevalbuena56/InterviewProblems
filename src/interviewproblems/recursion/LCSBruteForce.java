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
public class LCSBruteForce {

    /**
     * @param args the command line arguments
     */
    int cntCalls = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        LCSBruteForce al = new LCSBruteForce();
        System.out.println("Maximum Lenght: " + al.LCS("cababc", "abdcb", 5, 4));
        System.out.println("Recursive calls made: " + al.cntCalls);
    }
    
    public int LCS(String s1, String s2, int m, int n) {
        cntCalls ++;
        if(n == 0){
            return 0;
        }else if (m == 0) {
             return 0;     
        }else if(s1.charAt(m) == s1.charAt(n)) {
            return LCS(s1, s2, m-1, n-1) + 1;
        }else
            return Math.max(LCS(s1, s2, m, n-1) , LCS(s1, s2, m-1, n)); 
    }
}
