import java.util.Scanner;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner r = new Scanner(System.in);
        System.out.println("Enter a Number : ");
        int k = r.nextInt();
        int[] divisors =  Solution(k);
        System.out.println("Your Divisors Digits : ");
        for( int m : divisors)
        {
            System.out.print(m+" ");
        }
    }

    public static int[] Solution(int n)
    {
        int grp[] = new int[n/2 + 1];
        grp[0]= 1;
        int j=1;
        for(int i=2; i<=n/2;i++)
        {
            if(n%i == 0)
            {
                grp[j] = i;
                j++;
            }
        }
        grp[j]=n;
        int[] result = new int[j+1];
        for(int i=0; i<= j; i++)
        {
            result[i] = grp[i];
        }
        return result;
    }
}
