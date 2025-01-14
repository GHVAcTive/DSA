import java.util.Scanner;

public class Main
{
    public static void main(String arg[])
    {
        System.out.println("Total : "+ Fibonacci(10));
        
    }

    public static int Fibonacci(int i)
    {
        if(i == 0)
        {
            return 0;
        }
        if(i == 1)
        {
            return 1;
        }
        
        return Fibonacci(i-1) + Fibonacci(i-2);
    }
}