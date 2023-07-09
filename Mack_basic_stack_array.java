import java.util.Scanner;

public class Mack_basic_stack_array {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Give the capacity of your stack");
        Stack st = new Stack(sc.nextInt());
        System.out.println("Enter the function number to perform \n 01\t push \n 02\t pop\n 03\t peep\n 04\t peek\n 05\t update_by_index\n 06\t update_by_data\n 07\t Sizeof\n 08\t isEmpty\n 09\t print\n 00\t terminate");

        while(true)
        {
         int n = sc.nextInt();

        if (n==1)
        {
            st.push(sc.nextInt());
            System.out.println("next");
        }

        else if(n==2)
        {
            st.pop();
            System.out.println("next");

        }

        else if(n==3)
        {
            st.peep(sc.nextInt());
            System.out.println("next");

        }

        else if(n==4)
        {
            st.peek();            
            System.out.println("next");
        }

        else if(n==5)
        {
            st.update_data_by_index(sc.nextInt(),sc.nextInt());
            System.out.println("next");

        }

        else if(n==6)
        {
           st.update_data_by_data(sc.nextInt(), sc.nextInt());
           System.out.println("next");
 
        }

        else if(n==7)
        {
             System.out.println(st.isEmpty());
             System.out.println("next");
        }

        else if(n==8)
        {
            st.isEmpty();
            System.out.println("next");
        }

        else if(n==9)
        {
            st.print();
            System.out.println("next");
        }

        else if(n==0)
        {
            break;
        }

        else
        {
            System.out.println("Give appropriate number");
            System.out.println("next or press 0 to terminate");
            
        }
    }


    }
}

class Stack
{
    int Size;
    int Top;
    int array[];
    int Capacity;

    Stack(int Capacity)
    {
        this.Capacity = Capacity;
        array = new int[Capacity];
        Top=-1;
        Size=0;
    }

    public void push(int element)
    {
                

        if(Size==Capacity)
        {
            System.out.println("Stack overflow");
            return;
        }
        
        Top++;

        array[Top] = element;
        Size++;
        return;
    }

    public int pop()
    {
        if (Top<0)
        {
            System.out.println("UnderFlow");
            return Top;
        }
        int n;
        n = array[Top];
        Top--;
        Size--;
        return n;
    }

    public int peep(int index)
    {
        if (Top-index+1<0)
        {
            System.out.println("Not ready for peep");
            return -1;
        }

        return array[Top-index+1];
    }

    public int peek()
    {
        if (Top<0)
        {
            System.out.println("Empty");
            return Top;
        }

        return array[Top];
    }

    public  void update_data_by_index(int index, int data)
    {
        if (index>Top)
        {
            System.out.println("Can't cahnge as its out of bound");
            return;
        }
        array[Top-index+1] = data;
        return;
    }

    public void update_data_by_data(int oldvalue, int newvalue)
    {
        for (int i=0; i<Top; i++)
        {
            if(array[i]==oldvalue)
            {
                array[i] = newvalue;
                return;
            }
        }
    }

    public void sizeOf()
    {
       System.out.println(Size);
    }

    public boolean isEmpty()
    {
        if (Size<=0)
        {
            return true;
        }

        return false;
    }

    public void print()
    {
        for (int i=Top; i>=0; i--)
        {
            System.out.print(array[i]+"\n");
        }
        System.out.println();
    }


}
