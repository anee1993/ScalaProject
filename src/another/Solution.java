package another;

import java.util.*;
import java.util.stream.Collectors;

public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    // RETURN "null" IF NO ITEM ASSOCIATION IS GIVEN
    List<String> largestItemAssociation(List<PairString> itemAssociation)
    {
        // WRITE YOUR CODE HERE
        Map<String,String> wildMap = new HashMap<>();
        Map<String,String> valueMap = new HashMap<>();
        List<List<String>> wildList = new ArrayList<>(0);

        for (PairString pairString : itemAssociation) {     //1 2 // 3 4 // 4 5
            wildMap.put(pairString.first, pairString.second);
            valueMap.put(pairString.second, pairString.first);
        }
        Set<String> keys = wildMap.keySet();
        Collection<String> values = wildMap.values();
        for (String key : keys) {
            if(values.contains(key)){
                String fromWildMap = wildMap.get(key);
                String fromValueMap = valueMap.get(key);

                List<String> newList = new ArrayList<>(0);
                newList.add(fromWildMap);
                newList.add(key);
                newList.add(fromValueMap);
                wildList.add(newList);
            }
            else {
                List<String> normalList = new ArrayList<>(0);
                normalList.add(key);
                normalList.add(wildMap.get(key));
                wildList.add(normalList);
            }
        }
        int count = 0;
        List<List<String>> finale = new ArrayList<>();

        for (List<String> strings : wildList) {
            if(count == 0){
                count = strings.size();
                finale.add(strings);
            }
            else {
                if(strings.size() > count){
                    count = strings.size();
                    finale.clear();
                    finale.add(strings);
                }
            }
        }
        return finale.get(0).stream().sorted().collect(Collectors.toList());
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args){
        Solution sol = new Solution();
        List<PairString> aList = new ArrayList<>();
        aList.add(new PairString("Item1", "Item2"));
        aList.add(new PairString("Item3", "Item4"));
        aList.add(new PairString("Item4", "Item5"));
        List<String> result = sol.largestItemAssociation(aList);
        System.out.println(result);
    }
}

class PairString {
    String first;
    String second;

    PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}
