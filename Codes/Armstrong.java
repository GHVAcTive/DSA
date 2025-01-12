import java.util.Scanner;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner r = new Scanner(System.in);
        System.out.println("Enter a Number : ");
        int k = r.nextInt();
        
        System.out.println("Your Armstrong Digits : "+ Solution(k));

    }

    public static boolean Solution(int n)
    {
        int val=0, size=0;
        int num=n,num2 = n;
        while(n != 0)
        {
            size++;
            n = n/10;
        }
        while(num != 0)
        {
            val += Math.pow(num%10,size);
            num = num/10;
        }
        if(val == num2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
