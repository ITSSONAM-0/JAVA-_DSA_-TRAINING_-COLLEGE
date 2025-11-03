class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtStart {
    private Node head = null;

    // Insert node at the start
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
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
        InsertAtStart list = new InsertAtStart();

        list.insertAtStart(1);
        list.insertAtStart(2);
        list.insertAtStart(3);
        list.insertAtStart(4);

        list.display();
    }
}
