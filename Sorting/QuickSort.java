import java.util.*;

public class QuickSort
{
    public static void main(String arg[])
    {
        Scanner r = new Scanner(System.in);

        System.out.println("Enter a Size : ");
        int size = r.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter a Array Elements (Using Space) : ");
        for(int i=0; i<=size-1; i++)
        {
            arr[i] = r.nextInt();
        }
        QuickSort(arr,0,arr.length-1);
        System.out.println("After Sort : ");
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
    }


    public static int Partition(int[] arr, int low, int high )
    {
        int i = low;
        int j= high;
        int pivot = arr[low];

        while(i < j)
        {
            while(arr[i] <= pivot && i <= high - 1)
            {
                i++;
            }
            while(arr[j] > pivot && j >= low + 1)
            {
                j--;
            }
            if(i < j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        
        return j;
    }


    public static void QuickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            System.out.println("Hi");
            int PIndex = Partition(arr, low, high);
            QuickSort(arr, low, PIndex-1);
            QuickSort(arr,PIndex+1, high);
            
        }
        
    }
}