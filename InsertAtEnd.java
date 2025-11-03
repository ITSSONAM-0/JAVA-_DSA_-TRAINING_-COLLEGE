class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtEnd {
    private Node head = null;

    // Insert node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode; // agar list empty hai to head newNode ho jayega
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // last tak jao
            }
            current.next = newNode; // last node ke next me newNode daal do
        }
    }

    // Display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        InsertAtEnd list = new InsertAtEnd();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.display();
    }
}
