package com.study.coding.ds;

//https://aaronice.gitbook.io/lintcode/linked_list/linked_list_cycle_ii

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LLPractise {


    public static void main(String[] args)

    {





    }

    static void detectRemoveLoop(Node head)
    {   Node slow= head,fast = head;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if(slow!=fast)
            return;
        slow=head;
        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
    }

    public Node getIntersectionNode(Node headA, Node headB) {
       Node a=headA;
       Node b=headB;

       while(a!=b)
       {
           a=(a!=null)?a.next:b;
           b=(b!=null)?b.next:a;
       }

       return a;
    }

    private static void removeNthNode() {
        Node root = prepareDataSet();
        traverseLinkedList(root);
        int k=2;

        Node fast=root;
        Node slow=root;
        Node traverse=root;

        for(int i=0;i<k;i++)
        {
            fast=fast.next;
        }

        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;
    }

    private static void isPalindrome() {
        Node current = prepareDataSet();
        Node leftNode=current;

        Node slow=current;
        Node fast=current;
        Node previous=null;

        int counter=0;
        while( fast!=null && fast.next!=null )
        {
            previous=slow;
            fast=fast.next.next;
            slow=slow.next;
            counter=counter+2;

        }

        // in case of odd
        if (fast != null) {
            slow=slow.next;
            counter++;
        }


        System.out.println(" mid --- "+slow.data);

        Node rightNode= reverseLinkedList(slow);

        while(rightNode!=null)
        {
            if(leftNode.data!=rightNode.data)
            {
                System.out.println("Not Palindrome");
            }
            rightNode=rightNode.next;
            leftNode=leftNode.next;
        }
    }


    public Node mergeTwoLists(Node l1, Node l2) {

        Node dummy = new Node(0);
        Node p = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                break;
            }
            if (l2 == null) {
                p.next = l1;
                break;
            }
            if (l1.data < l2.data) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        return dummy.next;

    }

    private static Node reverseLinkedList(Node current) {
       // Node current = prepareDataSet();

        Node previous=null;
        Node nextCurrent=null ;

        while(current!=null)
        {
           nextCurrent=current.next;
           current.next=previous;
           previous=current;
           current=nextCurrent;

        }

        return previous;
       // traverseLinkedList(previous);
    }

    private static void insertAtEnd() {
        Node root = prepareDataSet();

        Node startNode=root;


        Node newNode=new Node(99);

        while(root.next!=null)
        {
            root=root.next;
        }

        root.next=newNode;

        traverseLinkedList(startNode);
    }

    private static Node prepareDataSet() {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return n1;
    }

    private static void traverseLinkedList(Node n1) {
        Node root= n1;

        while(root!=null)
        {
            System.out.print(root.data+"---");
            root=root.next;

        }
    }


}
