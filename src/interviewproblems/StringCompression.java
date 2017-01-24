/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

/**
 * Implement a method to perform basic String compression using the counts of repeated characters.
 * 
 * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not
 * 
 * become smaller than the original string, your method should return the originsl string. You can assume
 * 
 * the string has only upper and lower case letters (a-z)
 *
 * @author George
 */
public class StringCompression {
    
    public static void main(String args[]){
        StringCompression s = new StringCompression();
        System.out.println("Compression: " + s.compress("aabcccccaaa"));
    }
    
    public String compress(String str){
        
        /*Check if compression would create a longer string */
        int size = countCompression(str);
        if(size >= str.length()){
            return str;
        }
        
        char[] array = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;
        
        for(int i=1; i < str.length(); i++){
            if(str.charAt(i) == last){  //found repeated character
                count++;
            }else{
                /* Update the repeated character count */
                index = setChar(array, last, index, count);
                last = str.charAt(i);
                count = 1;
            }
        }
        
        /* Update string with the last set of repeated characters*/
        index = setChar(array, last, index, count);
        return String.valueOf(array);
    }
    
    public int setChar(char[] array, char c, int index, int count){
        array[index] = c;
        index++;
        
        /*Convert the count to a string, then to an array of chars*/
        char[] cnt = String.valueOf(count).toCharArray();
        
        /*Copy characters from biggest digit to smallest*/
        for(char x: cnt){
            array[index] = x;
            index++;
        }
        
        return index;
    }
    
    public int countCompression(String str){
        if(str == null || str.isEmpty()) return 0;
        
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for(int i=1; i< str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }else{
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        
        size+= 1 + String.valueOf(count).length();
        return size;
    }
}
