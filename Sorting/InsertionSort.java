import java.util.*;

public class InsertionSort
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
        for(int k : InsertionSort(arr))
        {
            System.out.print(k+ " ");
        }
        System.out.println();
        for(int k : InsertionSort(arr))
        {
            System.out.print(k+ " ");
        }
    }

    public static int[] InsertionSort(int arr[])
    {
        for(int i=1; i<=arr.length-1 ;i++)
        {
            for(int j=i; j >0; j--)
            {
                if(arr[j] < arr[j-1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else
                {
                    break;
                }
            }   
        }

        return arr;
    }

    public static int[] InsertionSort1(int[] arr)
    {
        for(int i=1; i<=arr.length-1 ;i++)
        {
            int j=i;
            while( j >0 && (arr[j] < arr[j-1]))
            {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    j--;
            }   
        }

        return arr;
    }
}