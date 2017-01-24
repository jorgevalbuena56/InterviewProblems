/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What of you can not use additional data structures?
 * 
 * ASK IF AN ASCII STRING OR UNICODE STRING. DUE TO SPACE: ASCII 128 CHARS, UNICODE LOT MOTE 16BIT
 * 
 * @author George
 */
public class UniqueCharsInString {
    
    public static void main(String args[]){
        
        UniqueCharsInString p = new UniqueCharsInString();
        String str = "abcdefg";
        System.out.println("isUniqueChar = " + p.isUniqueCharBoolean(str));
    }
    
    public boolean isUniqueCharBoolean(String str){
        
        if(str.length() > 128) return false;
        
        boolean[] m = new boolean[128];
                
        for(int i=0;i<str.length(); i++){
            int val = str.charAt(i);
            if(m[val]){
                return false;
            }
            m[val] = true;
        }
        
        return true;
    }
    public boolean isUniqueCharBit(String str){
        int checker = 0;
        for(int i = 0; i< str.length(); i++){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0 ){
                return false;
            }
            checker |= (1 << val);
        }
        
        return true;
    }
}
