import java.util.*; 
import java.io.*;

public class Dutch_National_Flag {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int low = 0, mid = 0, high = n - 1;
        
        while (mid <= high) { // Fixing the condition
            if (arr.get(mid) == 0) {
                Collections.swap(arr, low, mid);
                low++;
                mid++;
            } 
            else if (arr.get(mid) == 1) {
                mid++;
            } 
            else { // arr[mid] == 2
                Collections.swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 0, 2, 1, 1, 0));
        int n = arr.size();

        sortArray(arr, n);

        System.out.println(arr); // Output: [0, 0, 1, 1, 2, 2]
    }
}
