import java.util.Scanner;

/**
 * tower_of_annoy
 */
public class tower_of_hanoi {

    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=1;

        hanoi(n,"S","H","D",count);

    }

    public static void hanoi(int n, String s, String h, String d, int count)
    {
        if (n==1)
        {
            System.out.println("transfer disk "+n+" from "+s+" to "+d+" --> "+count);
            return ;
        }
        hanoi(n-1, s, d, h,count++);
        System.out.println("transfer disk "+n+" from "+s+" to "+d+" --> "+count);
        hanoi(n-1,h,s,d,count++);
    }
}