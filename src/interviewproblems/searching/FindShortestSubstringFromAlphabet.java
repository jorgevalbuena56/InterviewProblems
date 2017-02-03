package interviewproblems.searching;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an input string "aabbccba", find the shortest substring from the
 * alphabet "abc".  *
 * In the above example, there are these substrings "aabbc", "aabbcc", "ccba"
 * and "cba". However the shortest substring that contains all the characters in
 * the alphabet is "cba", so "cba" must be the output.  *
 * Output doesnt need to maintain the ordering as in the alphabet.  *
 * Other examples: input = "abbcac", alphabet="abc" Output : shortest substring
 * = "bca".
*
 */
class FindShortestSubstringFromAlphabet {

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        //String input = "aabbccba";
        //String alphabet = "abc";
        String input = "abbcac";
        String alphabet = "abc";
        System.out.println("Shortest Substring is: " + findShortest(input, alphabet));
    }

    public static String findShortest(String input, String alphabet) {
        if (input == null || input.length() < alphabet.length()) {
            return "";
        }
        //Need a map to store how many times do I have to find a letter from alphabet in the input
        Map<Character, Integer> needToFind = new HashMap();
        //Need a map to store how many times I've found a specific alphabet's letter in the input
        Map<Character, Integer> foundSoFar = new HashMap();

        //Initialize the needToFind map, checking first if the char was contained or not to avoid NPE
        for (int i = 0; i < alphabet.length(); i++) {
            Integer value = needToFind.get(alphabet.charAt(i));
            if (value == null) {
                needToFind.put(alphabet.charAt(i), 1);
            } else {

                needToFind.put(alphabet.charAt(i), ++value);
            }
        }

        //Initialize with 0 all the characters in the map foundSoFar
        for (int i = 0; i < input.length(); i++) {
            foundSoFar.put(input.charAt(i), 0);
        }

        //accumulate how many times all the letters are complete
        int countAllLettersNeeded = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int minWindowBegin = 0;
        int minWindowEnd = 0;

        for (int windowBegin = 0, windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char currentChar = input.charAt(windowEnd);
            //skip letters that are not in the alphabet
            if (needToFind.get(currentChar) == null) {
                continue;
            }
            //add 1 to our letter found in the map
            Integer countSoFarLetter = foundSoFar.get(currentChar);
            foundSoFar.put(currentChar, ++countSoFarLetter);
            //compare if we have the total needed for this letter or not
            if (countSoFarLetter <= needToFind.get(currentChar)) {
                countAllLettersNeeded++;
            }

            //if I have found the all the number of letter, verify the window constraint
            if (countAllLettersNeeded == alphabet.length()) {
                // advance begin index as far right as possible,
                // stop when advancing breaks window constraint.
                char beginChar = input.charAt(windowBegin);
                while (needToFind.get(beginChar) == 0
                        || foundSoFar.get(beginChar) > needToFind.get(beginChar)) {
                    if (foundSoFar.get(beginChar) > needToFind.get(beginChar)) {
                        Integer longCharValue = foundSoFar.get(beginChar);
                        foundSoFar.put(beginChar, --longCharValue);
                    }
                    beginChar = input.charAt(++windowBegin);
                }
                // update minWindowSize if a minimum length is met
                int windowSize = (windowEnd - windowBegin) + 1;

                if (windowSize < minWindowSize) {
                    minWindowBegin = windowBegin;
                    minWindowEnd = windowEnd;
                    minWindowSize = windowSize;
                }
            }
        }

        return input.substring(minWindowBegin, minWindowEnd + 1);
    }

}
