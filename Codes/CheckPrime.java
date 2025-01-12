import java.util.Scanner;

public class Main
{
    public static void main(String arg[])
    {
        System.out.println("Enter a Number : ");
        Scanner r = new Scanner(System.in);
        int num = r.nextInt();
        System.out.println("Prime : "+ CheckPrime(num));
    }

    public static boolean CheckPrime(int n)
    {
        if(n == 1)
        {
            return false;
        }
        else if( n== 2)
        {
            return true;
        }
        else 
        {
            for(int i=3; i<=n/2; i++)
            {
                if(n%i == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
