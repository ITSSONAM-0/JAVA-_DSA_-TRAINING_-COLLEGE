
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    // Insert node at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // circular connection
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // maintain circular link
        }
    }

    // Delete node from start
    public void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }

        // Agar list me sirf ek hi node hai
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        head = head.next; // head ko next node par shift karo
        tail.next = head; // last node ka next new head pe point kare
    }

    // Display circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insertAtEnd(10);
        cll.insertAtEnd(20);
        cll.insertAtEnd(30);
        cll.insertAtEnd(40);

        System.out.println("Original Circular Linked List:");
        cll.display();

        cll.deleteAtStart();
        System.out.println("After deleting first node:");
        cll.display();

        cll.deleteAtStart();
        System.out.println("After deleting first node again:");
        cll.display();
    }
}
