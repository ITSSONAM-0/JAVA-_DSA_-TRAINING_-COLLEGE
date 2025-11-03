class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }

    static Node deleteAtIndex(Node head, int pos) {
        if (head == null || pos <= 0) {
            return head;
        }

        if (pos == 1) {
            head = head.next;

            if (head != null) {
                head.prev = null;
            }
            return head;
        }

        Node curr = head;
        for (int i = 1; curr != null && i < pos; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            return head;
        }

        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }

        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }
        return head;
    }

    static void printList(Node obj) {
        while (obj != null) {
            System.out.print(obj.data + " ");
            obj = obj.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        System.out.println("List before deletion:");
        printList(head);

        System.out.println("List after deletion");
        head = deleteAtIndex(head, 2);
        printList(head);

    }
}
