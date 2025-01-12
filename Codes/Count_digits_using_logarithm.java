/*
Summary:
Use Math.log() for natural logs (base e).
Use Math.log10() for base-10 logs.
Use Math.log(value) / Math.log(base) for custom bases.
*/

import java.util.Scanner;

public class Main
{
    public static void main(String arg[])
    {
        System.out.println("Enter a Number for GCD (use Space) : ");
        Scanner r = new Scanner(System.in);
        int num = r.nextInt();
        
        System.out.println("Digits : "+ GCD(num));
    }

    public static int GCD(int num)
    {
        double val= Math.log10(num) + 1;

        int k = (int)(val);
        return k;
    }
}
