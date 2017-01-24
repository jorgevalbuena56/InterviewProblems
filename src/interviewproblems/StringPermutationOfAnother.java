/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

/**
 *  Given two strings, write a method to decide if one is a permutation of the other
 * 
 *  ASK IF PERMUTATION COMPARISON IS CASE SENSITIVE = God = dog?
 * @author GeorgeLocal
 */
public class StringPermutationOfAnother {
    
    public static void main(String[] args){
        
        StringPermutationOfAnother p = new StringPermutationOfAnother();
        System.out.println("isPermitation: " + p.permutation("axdfv", "dfvax"));
        System.out.println("isPermitation: " + p.permutation("axdfv", "werfs"));
    }
    
    /**
     * Check if the two strings have identical character counts
     * 
     * @param s
     * @param t
     * @return 
     */
    public boolean permutation(String s, String t){
       
        if(s.length() != t.length()){
            return false;
        }
        
        int[] letters = new int[128]; //Assuming is ascii 128 CHARS TOP
        
        char[] s_array = s.toCharArray();
        
        for(char c: s_array){   //count the number of each char in s
            letters[c]++;
        }
        
        for(int i = 0; i < t.length(); i++){
            int c = (int) t.charAt(i);
            if(--letters[c] < 0){
                return false;
            }
        }
        
        return true;
    }
}
