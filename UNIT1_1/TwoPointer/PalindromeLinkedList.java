package UNIT1_1.TwoPointer;

import java.util.Scanner;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    Node head = null;
    Node tail = null;
    public void add(int data){
        Node newnode = new Node(data);
        if(head==null){
            head = newnode;
            tail = newnode;
        }
        else{
            tail.next = newnode;
            tail = newnode;
        }
    }
    public Node getmid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(Node head){
        if(head.next==null) return true;
        Node middle = getmid(head);
        Node temp = middle.next;
        middle.next = reverse(temp);
        Node head1 = head;
        Node head2 = middle.next;
        while (head2!=null) {
            if(head1.data!=head2.data) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        temp = middle.next;
        middle.next = reverse(temp);
        return true;
    }
}
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        LinkedList l = new LinkedList();
        for(int i = 0;i<n;i++){
            l.add(s.nextInt());
        }
        System.out.println(l.isPalindrome(l.head));
        s.close();
    }
}
