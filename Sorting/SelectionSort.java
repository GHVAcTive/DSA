import java.util.Scanner;

public class SelectionSort
{
    public static void main(String arg[])
    {
        Scanner r = new Scanner(System.in);
        System.out.println("Enter the Numbers Size : ");
        int size = r.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the Array Elements : ");
        for(int i=0; i<size; i++)
        {
            arr[i] = r.nextInt();
        }
        System.out.println("Your Sorted Array : " );

        for (int k : SelectionSort(arr))
        {
            System.out.print(k + " ");
        }

    }

    public static int[] SelectionSort(int[] arr) 
    {
        int min,j;
        for(int i=0; i<arr.length;i++)
        {
            min = i;
            for( j=i; j<arr.length; j++)
            {
                if(arr[min] > arr[j])
                {
                    min = j; 
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;
    }
}