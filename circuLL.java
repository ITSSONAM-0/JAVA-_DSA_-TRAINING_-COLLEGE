class circuLL {
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

    public void DeleteByElement(int key) {
        if (head == null) {
            return;
        }
        Node current = head;
        Node prev = null;
        do {
            if (current.data == key) {
                if (prev != null) {
                    // list 10->20->30->40 isme ager 30 ko delete karni h to prev= 20 and curr= 30
                    // nd next 40 hai to 30 ko delete karni h to prev.next= curr.next = 40 ho
                    // jaiyege or isme key= 30 hai
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                        tail.next = head;
                    }
                    return;
                }
            }
            prev = current;
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
        circuLL list = new circuLL();

        list.Insert(10);
        list.Insert(20);
        list.Insert(30);
        list.Insert(40);
        System.out.println("Before");
        list.display();
        System.out.println("After");
        list.DeleteByElement(30);
        list.display();
    }
}
