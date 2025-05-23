import java.util.*;

public class MergeSort
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
        MergeSort(arr,0,arr.length-1);
        System.out.println("After Sort : ");
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
    }


    public static void Merge(int[] arr, int low, int mid, int high )
    {
        int left, right;
        left = low;
        right = mid +1;
        int[] temp = new int[arr.length];
        int count=0;
        while(left <= mid && right <= high)
        {
            if(arr[left] <= arr[right])
            {
                temp[count] = arr[left];
                left++;
                count++;
            }
            else
            {
                temp[count] = arr[right];
                right++;
                count++;
            }
        }

        while(left <= mid)
        {
            temp[count] = arr[left];
            left++;
            count++;
        }
        while(right <= high)
        {
            temp[count] = arr[right];
            right++;
            count++;
        }

        for(int i=low; i<= high; i++)
        {
            arr[i] = temp[i-low];
        }

    }


    public static void MergeSort(int[] arr, int low, int high)
    {
        if (low >= high)
        {
            return;
        }
        int mid = (low + high)/2;
        MergeSort(arr, low, mid);
        MergeSort(arr,mid+1, high);
        Merge(arr, low, mid, high);
    }
}