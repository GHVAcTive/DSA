import java.util.Scanner;

public class Main
{
    public static void main(String arg[])
    {
        int arr[] = new int[100];

        Scanner r = new Scanner(System.in);

        System.out.println("Enter a String : ");
        String str = r.nextLine();
        System.out.print("Find the Number Occurance : ");
        char ch = r.next().charAt(0);
        
        int hash[] = new int[26];
        for(int i=0; i< str.length(); i++)
        {
            hash[str.charAt(i)-97] += 1;
        }

        System.out.println("Occurance : "+ hash[ch-97]);
    }

    
}