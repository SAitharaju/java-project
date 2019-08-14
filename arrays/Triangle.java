import java.util.*;

// Check if sides of a traingle exist in an array

class Traingle {
    public int traingleExists(int[] arr) {
        Arrays.sort(arr);
        long first = 0;
        long second = 0;
        long third = 0;
        for(int i=0;i<arr.length-2;i++){
            if(arr[i] < 0) continue;
            first = arr[i];
            second = arr[i+1];
            third = arr[i+2];
            if (first + second > third) return 1;
        }
        return 0;
    }
}