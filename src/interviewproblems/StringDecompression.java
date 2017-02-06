/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

import java.util.Stack;
/**
 * Write code to decode strings. 
 * 
 * For example, String str = "3[a2[bd]g4[ef]h]", 
 * the output should be "abdbdgefefefefhabdbdgefefefefhabdbdgefefefefh".
 * 
 * @author valgood
 */
public class StringDecompression {
    
    public static void main(String[] args) {
        StringDecompression sd = new StringDecompression();
        String encodedString = "3[a2[bd]g4[ef]h]";
        String decodedString = sd.decodeString(encodedString);        
        System.out.println("Decode string is : " + decodedString);
        
        String encodedString2 = "2[c3[ab]]";
        String decodedString2 = sd.decodeString(encodedString2);        
        System.out.println("Decode2 string is : " + decodedString2);

    }

    public String decodeString(String str) {
        Stack<String> s = new Stack<>();
        String ns = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // string that will be repeated
            if (Character.isLetter(c)) {
                ns += String.valueOf(c);
            }
            // encountered number
            if (!Character.isLetter(c) && !"[".equals(String.valueOf(c)) && !"]".equals(String.valueOf(c))) {
                // stack is empty this is our first encounter so push number to stack
                if (s.isEmpty()) {
                    s.push(String.valueOf(c));
                } else {
                    // second encounter we push the ns we have constructed so far
                    // then the new number
                    // then clear the string to continue creating the string that will need to be repeated
                    s.push(ns);
                    s.push(String.valueOf(c));
                    ns = "";
                }
            }
            if ("]".equals(String.valueOf(c)) && i < str.length() - 1) {
                // we reached our repeat case the ']' so get the number of times we need to repeat
                // repeat the string that has been constructed
                // pop the other string we have pushed to the stack and concat it to the repeated string
                int repeat = Integer.valueOf(s.pop());
                ns = repeatCopy(ns, repeat);
                ns = s.pop() + ns;
            }

        }

        if (!s.isEmpty()) {
            int repeat = Integer.valueOf(s.pop());
            ns = repeatCopy(ns, repeat);
        }
        return ns;
    }

    public static String repeatCopy(String str, int num) {
        if (num == 0) {
            return str;
        }
        String temp = "";
        for (int i = 0; i < num; i++) {
            temp += str;
        }
        return temp;
    }
}
