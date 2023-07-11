import java.util.Scanner;
/**
 * SLL
 */
public class Simple_LinkList {
    public static void main(String[] args) {

        System.out.println("Please enter the following number to perform function");
        System.out.println("------------------------------------------------------");

        System.out.println("\s01 -> addLast\n\s02 -> addFirst\n\s03 -> insert_on_demand\n\s04 -> delete_First\n\s05 -> delete_Last\n\s06 -> delete_on_node_number\n\s07 -> delete_based_on_data\n\s08 -> number_of_nodes\n\s09 -> reverse\n\s00 -> display\n\s10 -> Terminate / exist");

        Scanner sc = new Scanner(System.in);
        LinkList ll = new LinkList();

        while(true)
        {
            int n=sc.nextInt();

            if(n==01)
            {
                System.out.print("what data you want to insert last?: ");
                ll.addLast(sc.nextInt());
                System.out.println("Next");
                System.out.println("----");
            }

            else if(n==02)
            {
                System.out.print("what data you want to insert first?: ");
                ll.addFirst(sc.nextInt());
                System.out.println("Next");
                System.out.println("----");            
            }

            else if(n==03)
            {
                System.out.print("Enter node number: ");
                int index=sc.nextInt();
                System.out.print(" Enter data you want to assign: ");
                int data = sc.nextInt();
                ll.insert_on_demand(index,data);
                System.out.println("Next");
                System.out.println("----");            
            }

            else if(n==04)
            {
                ll.deletFirst();
                System.out.println("Next");
                System.out.println("----");
            }

            else if(n==05)
            {
                ll.deletLast();
                System.out.println("Next");
                System.out.println("----");
            }

            else if(n==06)
            {
                System.out.print("Enter node number that you want to delete: ");
                ll.delet_on_node(sc.nextInt());
                System.out.println("Next");
                System.out.println("----");
            }

            else if(n==07)
            {
                System.out.print("Enter data that you want to delete: ");
                ll.delete_on_data(sc.nextInt());
                System.out.println("Next");
                System.out.println("----");
            }

            else if(n==8)
            {
                System.out.println("The number of nodes are: "+ll.sizeOf()); 
                System.out.println("Next");
                System.out.println("----");
            }

            else if(n==9)
            {
                ll.reverse();
                System.out.println("Reverse opration done successfully:");
                System.out.println("Next");
                System.out.println("----");
            }

            else if(n==00)
            {
                System.out.println("Your LinkList is: ");
                System.out.println("+-+-+-+-+-+-+-+");
                ll.display();
                System.out.println("Next");
                System.out.println("----");
            }

            else if(n==10)
            {
                System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
                System.out.println("THANKS");
                break;
            }

            else
            {
                System.out.println("Please enter the appropriate number");
            }

        }

        sc.close();
    }
    
}

class LinkList
{
        Node head = null;
        Node tail = null;
        Node temp = null;
        int size = 0;

    public void addLast(int data)
    {
                size++;

        Node newNode = new Node(data);
        
        if(head==null)
        {
            head = newNode;
            return;
        }

        tail = head;

        while(tail.next!=null)
        {
            tail = tail.next;
        }

        tail.next = newNode;
        // tail.next = newNode;
        // tail = newNode;
    }

    public void addFirst(int data)
    {
                size++;

        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
            return;
           // tail = newNode;
        }

        newNode.next = head;
        head = newNode;
    }

    public void insert_on_demand(int n, int data)
    {
        size++;

        if(n<1 || n>size)
        {
            System.out.println("can't insert");
            return;
        }

        Node newNode = new Node(data);

        tail = head;

        if(n==1)
        {
            head = newNode;
            head.next= tail;

            return;
        }

        while(n>2)
        {
            tail = tail.next;
            n--;
        }
        newNode.next = tail.next;
        tail.next = newNode;
    }

    public void deletFirst()
    {
        if (head == null)
        {
            System.out.println("list is empty");
        }

        head = head.next;

        size--;
    }

    public void deletLast()
    {
        if (head == null)
        {
            System.out.println("list is empty");
        }

        if (head.next == null)
        {
            head = null;
            return;
        }

        temp = head;
        tail = head.next;

        while(tail.next != null)
        {
            tail = tail.next;
            temp = temp.next;
        }

        temp.next = null;
        size--;
        
    }

    public void delet_on_node(int n)
    {
        if (n<1 || n>size)
        {
            System.out.println("can't delete");
            return;
        }

        else if (head == null)
        {
            System.out.println("sorry");
            return;
        }

        else if (head.next == null || n==1)
        {
            head = head.next;
            return;
        }

        else if (head.next.next == null && n==2)
        {
            head.next = null;
            return;
        }

       tail = head;
        while(n>2)
        {
            tail = tail.next;
            n--;
        }

        tail.next = tail.next.next;
                size--;

        return;

        
    }

    public void delete_on_data(int data)
    {
        if (head == null)
        {
            System.out.println("u can't");
            return;
        }

        if (data == head.data)
        {
            head = head.next;
            return;
        }

        tail = head.next;
        temp = head;

        boolean flag = false;

        while(temp.next!=null)
        {
            if(data == tail.data)
            {
              temp.next = tail.next;
              tail.next = null;
              flag = true;
              break;  
            }

            tail = tail.next;
            temp = temp.next;
        }

        if (flag == false)
        {
            System.out.println("can't find data");
        }
        size--;
    }

    public int sizeOf()
    {
        return size;
    }

    public void reverse()
    {
        
        if (head==null || head.next==null)
        {
            return;
        }

        else if(head.next.next == null)
        {
            temp = head.next;
            temp.next = head;
            head.next = null;
            head = temp;
            return;
        }

        
        Node current = head.next;
        Node previous = head;

        //previous.next=null;

        while(current!=null)
        {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            //next = next.next;
        }

        head.next = null;
        head = previous;
    }


    // public Node reverseRecursive(Node head)
    // {

    //     if(head == null || head.next == null)
    //     {
    //         return head;
    //     }


    //     Node newHead = reverseRecursive(head.next);
    //     head.next.next = head;
    //     head.next = null;

    //     return newHead;
    // }

    public void display()
    {
        Node current = head;

        if(head == null)
        {
            System.out.println("Empty");
            return;
        }

        while(current != null)
        {
        
            System.out.print(current.data+" -> ");
            current = current.next;
        }
       System.out.println("null");
    }

}

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}