import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner r = new Scanner(System.in);
        System.out.println("Enter a Number : ");
        int k = r.nextInt();
        
        System.out.println("Your Reverse Digits : "+ Solution(k));

    }

    public static int Solution(int n)
    {
        int k=0;
        while(n != 0)
        {
            int l = n%10;
            k = k*10 + l;
            n = n/10;    
        }

        return k;
    }
}
