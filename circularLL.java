class circularLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head = null;
    Node tail = null;

    
    public void Insert(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
            tail.next = head;
        } else {
            tail.next = newnode;
            tail = newnode;
            tail.next = head;
        }
    }


    public void InsertAtSpecific(int key, int data) {
        if (head == null) {
            return;
        }
        Node current = head;
        do {
            if (current.data == key) {
                Node newnode = new Node(data);
                newnode.next = current.next;
                current.next = newnode;
                if (current == tail) {
                    tail = newnode;
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }

    
    public void display() {
        if (head == null) {
            System.err.println("empty list");
            return;
        }
        Node current = head;
        do {

            System.out.println(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        circularLL list = new circularLL();
        list.Insert(10);
        list.Insert(20);
        list.Insert(30);
        list.Insert(40);
        System.out.println("Before");
        list.display();
        System.out.println("After");
        list.InsertAtSpecific(20, 34);
        list.display();
    }
}
