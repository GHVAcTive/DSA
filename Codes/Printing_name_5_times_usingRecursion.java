import java.util.Scanner;

public class Main
{
    public static void main(String arg[])
    {
        System.out.println("Using Recursion Printing 5 times");
        Recursion(1, "Hello");
    }

    public static void Recursion(int i, String Name)
    {
        if(i > 5)
        {
            return;
        }
        System.out.println(Name);
        Recursion(i+1,Name);
    }
}