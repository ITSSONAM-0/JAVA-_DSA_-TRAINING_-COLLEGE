import java.io.*;

public class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void InsertFront(int data) {
        Node obj = new Node(data);
        obj.next = head;
        head = obj;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        LinkedList L = new LinkedList();
        L.InsertFront(12);
        L.InsertFront(11);
        L.InsertFront(10);
        L.InsertFront(9);
        L.print();
    }
}
