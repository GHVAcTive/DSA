import java.util.Scanner;

public class Main
{
    public static void main(String arg[])
    {
        System.out.println("Enter a Number for GCD (use Space) : ");
        Scanner r = new Scanner(System.in);
        int num1 = r.nextInt();
        int num2 = r.nextInt();
        System.out.println("GCD : "+ GCD(num1, num2));
    }

    public static int GCD(int num1, int num2)
    {
        int min = (num1 > num2) ?  num2 : num1;
        int val = 1;
        for(int i=1; i<=min; i++)
        {
            if(num1%i==0 && num2%i == 0)
            {
                val = i;
            }
            else
            {
                continue;
            }
        }
        return val;
    }
}
