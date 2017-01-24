/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

import java.util.LinkedList;
import java.util.List;
import javax.swing.text.StyleConstants;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * 
 * Given two strings, s1 and s2, write code to check of  s2 is a rotation of s1 using only 
 * 
 * one call to isSubstring (e.g "waterbottle" is a rotation of "erbottlewat"
 * 
 * @author GeorgeLocal
 */
public class StringRotationOfAnother {
   
    public static void main(String args[]){
        
    }
    
    public boolean isRotation(String s1, String s2){
        int len = s1.length();
        
        List l = new LinkedList();
        
        /*Check that s1 and s2 are equal length and not empty*/
        if(len == s2.length() && len > 0){
            /*concatenate s1 and s1 within the new buffer*/
            StringBuilder s1s1 = new StringBuilder(s1).append(s1);
            return isSubString(s1s1.toString(), s2);
        }
        
        return false;
    }
    
    public boolean isSubString(String s1, String s2){
        return true;
    }
}
