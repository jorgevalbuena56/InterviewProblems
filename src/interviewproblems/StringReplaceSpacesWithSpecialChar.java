/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

/**
 * Write a method to replace all spaces in a string with %20%. You may assume that the string has sufficient
 * 
 * space at the end of the string to hold the additional characters, and that you are given the "true" length
 * 
 * of the string.(Note: if implementing in java, please use a character array so that you can perform this
 * 
 * operation in place
 * 
 * @author George
 */
public class StringReplaceSpacesWithSpecialChar {
    
    public static void main(String args[]){
        
        StringReplaceSpacesWithSpecialChar p = new StringReplaceSpacesWithSpecialChar();
        p.replaceSpaces("Hola Como estas      ".toCharArray(), 15);
    }
    
    /**
     * The algorithm works through a two scan approach. In the first scan, we count how many spaces
     * 
     * there are in the string. This is used to compute how long the final string should be.
     * 
     * in the second pass, which is done in reverse order, we actually edit the string. When we see
     * 
     * a space, we copy %20 into the next spots. if there is no space, then we copy the original character
     * 
     * @param str
     * @param length 
     */
    
    public void replaceSpaces(char[] str, int length){
        
        int spaceCount = 0;
        int newLength = 0;
        int i = 0;
        
        for(i = 0; i < length; i++){
            if(str[i] == ' '){
              spaceCount ++;
            }
        }
        
        //We already have one spot for the space, we need 2 more for the other char
        //that's why we multiply by 2
        newLength = length + spaceCount * 2; 
        
        str[length] = '\0';
        
        for(i = length - 1;i >=0;i-- ){
            if(str[i] == ' '){                
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }else{
                //makes some shift in the elements
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        
        for(int j=0;j<str.length;j++)
          System.out.print(str[j]);
    }
}
