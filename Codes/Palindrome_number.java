import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner r = new Scanner(System.in);
        System.out.println("Enter a Number : ");
        int k = r.nextInt();
        
        System.out.println("Your Palindrome Digits : "+ Solution(k));

    }

    public static String Solution(int n)
    {
        String z;
        int rev=0;
        int num = n;
        while(n != 0)
        {
            int l = n%10;
            rev = rev*10 + l;
            n = n/10;    
        }
        if(rev == num)
            z = "true";
        else
            z = "false";
        return z;
    }
}
