import java.util.Scanner;

public class javaM
{
    public static void main(String[] args) 
{
    Scanner r = new Scanner(System.in);
    System.out.println("Enter a Number : ");
    int n = r.nextInt();

    Solution(n);
}

public static void Solution(int n)
{
    for(int i=0;i<2*n-1;i++)
    {
        for(int j=0;j<2*n-1;j++)
        {
            int top = i;
            int left = j;
            int right = (2*n-2) - j;
            int dwn = (2*n-2) - i;
            if( top <= dwn)
            {
                if( right <= top)
                {
                    System.out.print(n-right + " ");
                }
                else if(left <= top)
                {
                    System.out.print(n-left + " ");
                }
                else
                {
                    System.out.print(n-top + " ");
                }
            }
            else
            {
                {
                    if( right <= dwn)
                    {
                        System.out.print(n-right + " ");
                    }
                    else if(left <= dwn)
                    {
                        System.out.print(n-left + " ");
                    }
                    else
                    {
                        System.out.print(n-dwn + " ");
                    }
                }
            }

        }    
        System.out.println();      
    }   
    
    


}
}
