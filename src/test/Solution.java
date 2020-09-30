package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> subStringsLessKDist(String inputString, int num)
    {
       List<String> subStringList = new ArrayList<>(0);

        for (char c : inputString.toCharArray()) {
            if(Character.isUpperCase(c)){
                throw new RuntimeException("Input String should have no upper case characters");
            }
        }

       if(num >= 0 && num <= 26) {
           for (int i = 0; i < inputString.length(); i++) {
               if (num <= inputString.length()) {
                   subStringList.add(inputString.substring(i, num));
                   num++;
               }
           }
       }
       else {
           throw new RuntimeException("num value " + num + " should be within 0 to 26");
       }

       return getSingleCharRepeatedWord(subStringList);
    }
    // METHOD SIGNATURE ENDS

    private List<String> getSingleCharRepeatedWord(List<String> stringList) {
        List<String> finalList = new ArrayList<>(0);

        for (String s : stringList) {
            if(isThisTheWordWithOnlyOneCharacterRepeatedOnce(s)){
                finalList.add(s);
            }
        }

        return finalList;
    }

    private boolean isThisTheWordWithOnlyOneCharacterRepeatedOnce(String word) {
        char[] array = word.toCharArray();
        int count  = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (char c : array) {
            if(map.containsKey(c)) {
                int value = map.get(c);
                value += 1;
                map.put(c,value);
            }
            else{
                map.put(c,1);
            }
        }

        for (Integer value : map.values()) {
            if(value == 2){
                count ++;
            }
        }

       return count == 1;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        List<String> aList = sol.subStringsLessKDist("wawaglknagagwunagkwkwagl", 4);
        System.out.println(aList);
    }
}