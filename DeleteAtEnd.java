class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteAtEnd {
    private Node head = null;

    // Insert node at the end (helper function)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Delete node from the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }

        if (head.next == null) {
            // Sirf ek hi node hai
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) { // second last node tak jao
            current = current.next;
        }
        current.next = null; // last node ko remove kar do
    }

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DeleteAtEnd list = new DeleteAtEnd();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original List:");
        list.display();

        list.deleteAtEnd();
        System.out.println("After deleting last node:");
        list.display();

        list.deleteAtEnd();
        System.out.println("After deleting last node again:");
        list.display();
    }
}
