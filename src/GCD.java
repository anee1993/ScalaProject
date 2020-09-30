class GCD
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE
        int GCD = 1;
        if(arr.length == 0)
            return GCD;
        for(int i=0;i<num;i++){
            if(isGCD(arr[i],arr)){
                GCD = arr[i];
                break;
            }
        }
        return GCD;
    }

    private boolean isGCD(int number, int[] arr){
        int[][] array = new int[4][4];

        int count = 0;
        for (int i : arr) {
            if (i % number == 0) {
                count++;
            }
        }
        return count == arr.length;
    }
    // METHOD SIGNATURE ENDS
}