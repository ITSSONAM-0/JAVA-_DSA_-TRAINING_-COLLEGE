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

    // insert kar rahe hai list ,yaha dakh rahe h ki list null v hai kya ager list
    // null hoga to ye if condition chega nhi else chlega
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

    // method bana rahe hai
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

    // display method ,ye sabhi code likhte h kyuki sabhi ko display karnvana hota h
    // to ye yad kar lo
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
