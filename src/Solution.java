import java.util.ArrayList;
import java.util.List;

public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days) {
        // WRITE YOUR CODE HERE
        if(!checkSanityOfArray(states))
            throw new RuntimeException("Array is not a binary array");
        if (days == 0) {
            return arrayToList(states);
        } else {
            int[] orgStates = states.clone();
            int[] array = computeState(states, orgStates);
            cellCompete(array, days - 1);
        }
        return arrayToList(states);
        // METHOD SIGNATURE ENDS
    }

    private List<Integer> arrayToList(int[] array) {
        final List<Integer> arrayList = new ArrayList<>(array.length);
        for (int i : array) {
            arrayList.add(i);
        }
        return arrayList;
    }

    private int[] listToArray(List<Integer> aList) {
        final int[] arr = new int[aList.size()];
        for (int i = 0; i < aList.size(); i++) {
            arr[i] = aList.get(i);
        }
        return arr;
    }

    private int[] computeState(int[] array, int[] originalArray) { //org arr = 1,0,0,0,0,1,0,0
        for (int j = 0; j < array.length; j++) {                                          //   = 0,1,0,0,1,0,1,0
            if (j == 0 && originalArray[j + 1] == 0) {                                   //    = 0,1,0,0,0,1,0,0
                array[j] = 0;                                                           //     = 0,1,0,0,0,1,0,0
            }
            else if (j == array.length - 1) {
                if (originalArray[j - 1] == 0) {
                    array[array.length - 1] = 0;
                }
                return array;
            } else if ((j != 0 && originalArray[j - 1] == 0 && originalArray[j + 1] == 0) || (j != 0 && originalArray[j - 1] == 1 && originalArray[j + 1] == 1)) {
                array[j] = 0;
            } else {
                array[j] = 1;
            }
        }
        return array;
    }

    private boolean checkSanityOfArray(int[] array) {
        int count = 0;
        for(int j = 0; j<array.length;j++){
            if(array[j] == 0 || array[j] == 1){
                count ++;
            }
        }
        return count == array.length;
    }
}