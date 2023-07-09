import java.util.ArrayList;
import java.util.Scanner;

/**
 * Mack_stack_with_arrayList
 */
public class Mack_stack_with_arrayList {

    public static void main(String[] args) {
      
     Scanner sc = new Scanner(System.in);
       // System.out.println("Give the capacity of your stack");
        Stack st = new Stack();
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
            st.update_through_index(sc.nextInt(),sc.nextInt());
            System.out.println("next");

        }

        else if(n==6)
        {
           st.update_through_numbers(sc.nextInt(), sc.nextInt());
           System.out.println("next");
 
        }

        else if(n==7)
        {
             System.out.println(st.isEmpty());
             System.out.println("next");
        }

        else if(n==8)
        {
            System.out.println(st.isEmpty()); 
            System.out.println("next");
        }

        else if(n==9)
        {
            st.display();
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


class Stack <T>
{
    private ArrayList <T> st;

    public Stack()
    {
        st = new ArrayList<>();
    }

    public void push(T item)
    {
        st.add(item);
    }

    public T pop()
    {
        if(!st.isEmpty())
            {
                return st.remove(st.size()-1);
            }
            else
            {
                return null;
            }
    }

    public T peek()
    {
            if(!st.isEmpty())
            {
                return st.get(st.size()-1);
            }

            else
            {
                return null;
            }
        }

         public int size()
        {
            return st.size();
        }

        public boolean isEmpty()
        {
            return st.isEmpty();
        }

        public T peep(int index)
        {
            if(index<st.size())
            {
                return st.get(index);
            }

            else
            {
                return null;
            }
        }

    public T update_through_numbers(T oldvalue , T newvalue)
        {
            if (!st.isEmpty())
            {
                int i = st.indexOf(oldvalue);
                
                return st.set(i,newvalue);
            }

            else
            {
                return null;
            }
        }

        public T update_through_index(int i , T newvalue)
        {
            if(!st.isEmpty())
            {
                return st.set(i, newvalue);
            }

            else
            {
                return null;
            }
        }

        public void display()
        {
            for(int i=(st.size()-1);i>=0;i--)
            {
                System.out.print(st.get(i));
            }
            System.out.println();
        }

}