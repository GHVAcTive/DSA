import java.util.*;

public class BubbleSort
{
    public static void main(String arg[])
    {
        Scanner r = new Scanner(System.in);
        System.out.println("Enter a Size of Array : ");
        int size = r.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter a Array Elements (Use space) : ");
        for(int i=0; i<size; i++)
        {
            arr[i] = r.nextInt();
        }
        System.out.println("Sorted Implemented : ");
        for(int k : BubbleSort(arr))
        {
            System.out.print(k+ " ");
        }

    }

    public static int[] BubbleSort(int arr[])
    {
        for(int i=arr.length-1; i>=1 ;i--)
        {
            int DoSwap = 0;
            for(int j=0; j <=i-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    DoSwap = 1;
                }
            }
            if(DoSwap == 0)
            {
                System.out.println("Hii Array is Already Sorted");
                break;
            }
            System.out.println("RUNS");
        }

        return arr;
    }
}